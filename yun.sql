-- 2020.12.08. TUE

/* CONSTRAINTS :: 제약조건
    - 데이터의 입출력 시 무결성을 유지하기 위한 조건
    - ADD 또는 DROP 가능 --> PK, UK, CHECK, FK
    - MODIFY --> NOT NULL, DEFAULT --> 제약조건이지만 COLUMN의 속성으로 취급
    - DML :: INSERT UPDATE DELETE
    
    1. PK = UNIQUE + NOT NULL
    ㄴ PK 설정 시 자동으로 CLUSTERED INDEX 생성 -> 데이터 자체에 대응
    ㄴ PK값은 접속 시 그 INDEX를 바로 확인(접속 속도가 유저마다 달라지지 않도록)
    *하나의 테이블은 하나의 PK만 지원한다
    *PK가 아닌 값으로 검색을 자주 한다면 그 값에 대해서는 INDEX를 만들어야 한다
    *사용자가 PK로 검색할 수 있게 만드는 개발자가 좋은 개발자다 = 검색 속도 개선
    
    2. UK = 특정 테이블에 레코드 입력 시, 특정 컬럼의 값에 중복 허용 X
    ㄴ UK 설정 시 NON-CLUSTERED INDEX 생성 -> PK에 대응, 따라서 UK보다 PK 검색이 빠름
    
    3. NOT NULL = 특정 테이블에 레코드 입력 시, 특정 컬럼의 값에 NULL 허용 X
    
    4. DEFAULT = 특정 테이블에 레코드 입력 시, 특정 컬럼의 지정값으로 대체
    
    5. FOREIGN KEY = 특정 테이블에 레코드 입력 시, 특정 컬럼의 값이 지정된 테이블에 존재해야 입력 가능
    
    6. CHECK : 있지만 잘 사용하지 않습니다
*/

/*

제약조건의 추가 및 제거

1)PRIMARY KEY, UNIQUE, CHECK, FOREIGN KEY
ALTER TABLE [SCHEMA].[TAB_NAME]
[ADD | DROP] CONSTRAINT [CONS_NAME] [PRIMARY KEY | UNIQUE | CHECK | FOREIGN KEY] [OPTIONS : REFERENCE]

2)NOT NULL, DEFAULT
1. CREATE TABLE [TAB_NAME] (
   [COL_NAME] [DATA_TYPE} NOT NULL
   );

2. ALTER TABLE [TAB_NAME]
   MODIFY [COL_NAME] [DATA_TYPE] NOT NULL;
*/

-- DBA: UNIQUE
ALTER TABLE DBA5.MEMBERS
ADD CONSTRAINT MM_ID_UK UNIQUE(MM_ID);
-- PK, UK 에러 메시지가 동일하므로 CONSTRAINT의 이름으로 구분할 수 있게 해주어야 한다

-- DEV
INSERT INTO DBA5.MEMBERS(MM_ID, MM_NAME, MM_PW, MM_BIRTH) VALUES(NULL, 'YUN', '1234', '1993-03-27');
COMMIT;
ROLLBACK;

-- DBA: ADD COLUMNS
/*ADD는 COLUMNS 또는 CONSTRAINTS 둘 중 하나만 쓸 수 있다
위에서 CONSTRAINTS를 명시했으므로 COLUMNS를 명시하지 않아도 된다*/

ALTER TABLE DBA5.MEMBERS
ADD MM_MOBILE NCHAR(11);
-- 실제로는 10자리 번호가 있지만 11자리만 있다고 가정하고 실습합시다

-- MM_ID: PK / MM_MOBILE: UK 
-- ID 없이는 회원가입 불가, 휴대폰은 없어도 회원가입 가능, 단 다른 번호와 중복 불가

-- 같은 종류의 명령은 연속해서 쓸 수 있습니다. ADD와 DROP은 따로 써야 합니다
ALTER TABLE DBA5.MEMBERS
ADD CONSTRAINT MM_ID_PK PRIMARY KEY(MM_ID)
ADD CONSTRAINT MM_MOBILE UNIQUE(MM_MOBILE);

INSERT INTO DBA5.MEMBERS(MM_ID, MM_NAME, MM_PW, MM_BIRTH, MM_MOBILE)
VALUES('HOON', '짱', '4321', '1990-11-06', NULL);
-- 칼럼이 5개 있는데 4개만 쓰지 맙시다
-- (4개만 써도 쌍 맞추면 입력되지만, 공부하는 입장이니까 습관적으로 명시하도록 합시다)

-- DBA: NOT NULL
ALTER TABLE DBA5.MEMBERS
MODIFY MM_NAME NOT NULL
MODIFY MM_PW NOT NULL;

SELECT * FROM USER_CONSTRAINTS;
-- MODIFY로 입력된 NOT NULL은 CONSTRAINT_NAME이 시스템 자동 입력된다
-- SEARCH_CONDITION에서 해당 CONSTRAINT의 내용을 볼 수 있다

SELECT * FROM DBA5.MEMBERS;
-- NULLABLE 칼럼에서 NOT NULL 여부(N으로 표시) 알 수 있음

-- DEFAULT
ALTER TABLE DBA5.MEMBERS
MODIFY MM_MOBILE DEFAULT 'NO DATA';
-- 입력값이 없을 때 'NO DATA'라는 문자열 입력
-- NCHAR(11) 조건 안에 입력되게끔 아무 값이나 넣읍시다
-- 실무에서는 꼭 이렇게 하지는 않습니다 예시예요~
-- DEFAULT는 USER_CONSTRAINTS에 안 나옵니다

SELECT * FROM USER_TAB_COLS;
-- DATA_DEFAULT 칼럼에서 DEFAULT로 정해준 값이 나옵니다

-- 입력은 이렇게
INSERT INTO DBA5.MEMBERS(MM_ID, MM_NAME, MM_PW, MM_BIRTH, MM_MOBILE)
VALUES('HOON9', '짱', '4321', '1990-11-06', DEFAULT);

-- DEFAULT로 명시하지 않고 NULL을 넣으면 NULL이 입력됨
INSERT INTO DBA5.MEMBERS(MM_ID, MM_NAME, MM_PW, MM_BIRTH, MM_MOBILE)
VALUES('HOON9', '짱', '4321', '1990-11-06', NULL);

-- 이렇게도 NULL 입력 가능하지만 공부할 때는 이렇게 넣지 마세요
-- DEFAULT를 정해줬을 때는 DEFAULT가 입력됨
-- 근데 위에서 전화번호를 UK로 정해줬으니까 중복됐다고 입력이 안돼...
-- 실제로는 PK나 UK 말고 중복 가능한 칼럼에 DEFAULT 속성을 줍니다 
INSERT INTO DBA5.MEMBERS(MM_ID, MM_NAME, MM_PW, MM_BIRTH)
VALUES('HOON9', '짱', '4321', '1990-11-06');

-- DEFAULT 제거
ALTER TABLE DBA5.MEMBERS
MODIFY MM_MOBILE DEFAULT NULL;
-- 이 상태에서 DEFAULT를 넣으면 NULL로 입력됩니다(DEFAULT는 완전 제거는 안 돼요)

-- FOREIGN KEY
ALTER TABLE [TAB_NAME]
ADD CONSTRAINT [CONS_NAME] FOREIGN KEY(COL_NAME)
REFRENCES [TAB_NAME]([COL_NAME]);

-- (FOREIGN KEY 설정 안 한 상태에 INSERT를 한다면)
INSERT INTO DBA5.AUTH(AU_ID, AU_TIME, AU_TYPE) VALUES('HOON5', '2020-12-08', 1);
-- 아직 어떤 제약 조건도 주지 않았기 때문에 HOON5라는 멤버가 없지만 정상입력됨

-- 우리가 AUTH 테이블을 사용하는 목적은 MEMBERS의 로그인/로그아웃 기록
-- 따라서 MEMBERS에 없는 ID가 입력되지 않도록 해야 함
--> FOREIGN KEY 제약조건을 줍니다

ALTER TABLE DBA5.AUTH
ADD CONSTRAINT AU_ID_FK FOREIGN KEY (AU_ID) REFERENCES DBA5.MEMBERS(MM_ID);
-- DBA5.AUTH테이블에 AU_ID_FK라는 제약조건을 입력합니다
-- 이 제약 조건은 FOREIGN KEY라는 제약조건으로, AU_ID를 입력할 때 작동합니다
-- DBA5.MEMBERS 테이블의 MM_ID와 같은 것만 입력받게 할 거예요

-- 이렇게 테이블을 바꾸려고 할 때, 이전에 틀린 조건으로 입력된 데이터가 있으면 에러가 발생해요
-- 에러가 발생하면 DELETE FROM AUTH; 실행 후 제약조건을 입력합시다

SELECT SYSDATE FROM DUAL;

INSERT INTO DBA5.AUTH(AU_ID, AU_TIME, AU_TYPE) VALUES('HOON', SYSDATE, 1); -- 정상입력
INSERT INTO DBA5.AUTH(AU_ID, AU_TIME, AU_TYPE) VALUES('HOON5', SYSDATE, 1); -- FK위배
INSERT INTO DBA5.AUTH(AU_ID, AU_TIME, AU_TYPE) VALUES('HOON', SYSDATE, -1);

-- 뱀발
-- FOREIGN KEY가 있어서 1:N의 관계를 맺는 건 아니에요~
-- 어떤 테이블에 입력된 데이터끼리 1:N의 관계를 맺는다면 부모-자식 관계라고 합니다

/*

FK 제약조건이 설정된 컬럼을 소유한 테이블(=AUTH)에서의 PK는 COMPOSITE INDEX를 사용한다
*sequence같이 의미없는 걸로 PK 절대절대 만들지 마세요*

COMPOSITE=여러 칼럼을 엮어서 PK를 만든다
- 중복 로그인을 허용하지 않는다면: ID+TYPE으로 PK
- 중복 로그인을 허용한다면: ID+TYPE+기기(새로 칼럼을 만들어야 함)으로 PK

*/

ALTER TABLE DBA5.AUTH
ADD CONSTRAINT AU_ID_TIME_PK PRIMARY KEY(AU_ID, AU_TIME);
-- 오라클에서는 16개까지 COMPOSITE을 허용합니다

INSERT INTO DBA5.AUTH(AU_ID, AU_TIME, AU_TYPE) VALUES('HOON', SYSDATE, 1);
INSERT INTO DBA5.AUTH(AU_ID, AU_TIME, AU_TYPE) VALUES('HOON', SYSDATE, 1);
-- 두 개를 동시 실행하면 둘 중 하나만 실행, 하나는 에러 발생

-- 데이터 삭제
DELETE FROM DBA5.AUTH;
DELETE FROM DBA5.MEMBERS;
COMMIT;
DROP TABLE DBA5.AUTH;
DROP TABLE DBA5.MEMBERS;

/* DCL, DDL, COMPOSITE INDEX 실습

테이블을 만든 오너가 권한을 GRANT

1. 회원 테이블 - 부모 // members // mm
DBA(SELECT), MEMBER2(SELECT, INSERT)
PK 아이디 nvarchar2(10) --> MM_ID
NN 패스워드 nvarchar2(10) --> MM_PW
NN 이름 nvarchar2(5) --> MM_NAME
UK 전화번호 nchar(11) --> MM_MOBILE
>> 레코드 5

2. 접속로그 테이블 - 자식 // AUTH // ac
DBA, MEMBER1(SELECT, INSERT)
PK FK 아이디 nvarchar2(10) --> AC_ID
PK DF 접속시간 date --> AC_TIME
NN 접속종류 nvarchar2(10) --> AC_TYPE
--> 나중에 질문할 수도 있다
>> 레코드 10

3. 상품 테이블 // product // pr
DBA(SELECT), MEMBER4(SELECT, INSERT)
PK 상품코드 nchar(4) --> PR_CODE
NN 상품명 nvarchar2(10) --> PR_NAME
DF 판매가격 number(7,0) --> PR_PRICE
DF 재고수량 number(3,0) --> PR_AMOUNT
>> 레코드 20

>> 3번까지는 선생님이 테이블의 제약조건을 표시해주심
>> 되도록 NULL은 회피하도록
>> 시작하기 전에 MEMBER1234, 테이블이름, 약어, 칼럼명을 정하고 시작합시다
>> 이왕이면 넣을 레코드도 직접 정하세요

4. 장바구니 테이블 // basket // ba
MEMBER3, MEMBER5(SELECT, INSERT)
아이디 --> nvarchar2(10) 아마도 FK // BA_ID >> REF: AC_ID
상품코드 --> nchar(4) 아마도 FK // BA_CODE >> REF: PR_CODE
--> 아이디랑 상품코드를 엮어서(COMPOSITE INDEX) PK
NN 수량 number(3,0) // BA_AMOUNT
--> 질문: 재고가 0인 것을 장바구니에 insert하지 못하게 하려면 어떻게 해야 할까요?
--> 재고가 0이더라도 장바구니에는 넣고, 주문만 못 하게
레코드 FREE

5. 주문 테이블 = DBA >> 영수증 - 부모 // order // or
모든 멤버(SELECT, INSERT)
PK 아이디 --> nvarchar2(10) // OR_ID
PK 주문일자 --> date(YYYY-MM-DD)(insert할 때 sysdate) // OR_DATE
주문상태 -> ncahr(1) --> 주문완료/미완료 --> Y/N // OR_STATUS
레코드 5

6. 주문상세 테이블 = DBA >> 영수증에 찍힌 상품 리스트 - 자식 // order_detail // det
모든 멤버(SELECT, INSERT)

FK -- OR_ID 아이디 --> nvarchar2(10) // DET_ID
FK -- OR_DATE 주문일자 --> date // DET_DATE --> 주문에서만 받아오는 걸로...
상품코드 nchar(4) --> 아마도 FK(3번에서 받아오는 걸로) // DET_CODE
주문수량 number(3,0) = 주문테이블 레코드 수 // DET_AMOUNT
판매상태 nchar(1) --> 아마도 판매중(재고있음)/판매불가(재고없음) --> Y/N // DET_STATUS

엔지니어=조장이 끝났는지 판단
4시에 완료 후 메인으로 돌아옵니다
질문이 있으면 선생님이 소회의실 들어오셔서 설명합니다
*/

CREATE TABLE MEMBERS(
MM_ID nvarchar2(10),
MM_PW nvarchar2(10) NOT NULL,
MM_NAME nvarchar2(5) NOT NULL,
MM_MOBILE nchar(11)
);

SELECT * FROM MEMBERS;

ADD
PK 상품코드 nchar(4) --> PR_CODE

MODIFY
NN 상품명 nvarchar2(10) --> PR_NAME
DF 판매가격 number(7,0) --> PR_PRICE
DF 재고수량 number(3,0) --> PR_AMOUNT
>> 레코드 20

ALTER TABLE YUN.MEMBERS
ADD CONSTRAINT MM_ID_PK PRIMARY KEY(MM_ID)
ADD CONSTRAINT MM_MOBILE_UK UNIQUE(MM_MOBILE);

ALTER TABLE HYEONHA.PRODUCT
ADD CONSTRAINT PR_CODE_PK PRIMARY KEY(PR_CODE);

SELECT * FROM USER_CONSTRAINTS;

GRANT ALL ON YUN.MEMBERS TO SOL;
GRANT SELECT, INSERT ON HYEONHA.PRODUCT TO HONG;

INSERT INTO YUN.MEMBERS(MM_ID, MM_PW, MM_NAME, MM_MOBILE)
VALUES('YUN', '1234', 'OHYUN', '01012345678');
INSERT INTO YUN.MEMBERS(MM_ID, MM_PW, MM_NAME, MM_MOBILE)
VALUES('HONG', '1234', 'HIJ', '01012345679');
INSERT INTO YUN.MEMBERS(MM_ID, MM_PW, MM_NAME, MM_MOBILE)
VALUES('SOL', '1234', 'JSJ', '01012345670');
INSERT INTO YUN.MEMBERS(MM_ID, MM_PW, MM_NAME, MM_MOBILE)
VALUES('HYUN', '1234', 'NHH', '01012345671');
INSERT INTO YUN.MEMBERS(MM_ID, MM_PW, MM_NAME, MM_MOBILE)
VALUES('OK', '1234', 'PHO', '01012345672');
COMMIT;

DBA(SELECT), MEMBER4(SELECT, INSERT)
PK 상품코드 nchar(4) --> PR_CODE
NN 상품명 nvarchar2(10) --> PR_NAME
DF 판매가격 number(7,0) --> PR_PRICE
DF 재고수량 number(3,0) --> PR_AMOUNT
>> 레코드 20

INSERT INTO HYEONHA.PRODUCT(PR_CODE, PR_NAME, PR_PRICE, PR_AMOUNT)
VALUES('A123', 'DRESS', 10000, 5); 

SELECT * FROM DBA5.ORDER1;
INSERT INTO DBA5.ORDER1(OR_ID, OR_DATE, OR_STATUS)
VALUES('YUN', SYSDATE, 'Y');

SELECT * FROM SOL.AUTH;

SELECT * FROM HONG.BASKET;

INSERT INTO HONG.BASKET(BA_ID, BA_CODE, BA_AMOUNT)
VALUES('YUN', 'A123', 1);
COMMIT;

ALTER TABLE HONG.BASKET
ADD CONSTRAINT BA_ID_FK FOREIGN KEY (BA_ID) REFERENCES YUN.MEMBERS(MM_ID);
-- 장바구니는 로그아웃 상태에서도 보관되어야 하는 데이터이므로
-- 로그인 정보(AUTH)가 아닌 회원 정보(MEMBERS)를 참조해야 합니다
-- 이때, 참조되는 값은 PK 또는 UNIQUE여야 합니다

ALTER TABLE HONG.BASKET
ADD CONSTRAINT BA_CODE_FK FOREIGN KEY (BA_CODE) REFERENCES HYEONHA.PRODUCT(PR_CODE);

GRANT ALL ON YUN.MEMBERS TO DBA5;

