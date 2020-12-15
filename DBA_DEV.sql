select * from all_tables; /*모든 테이블*/
select * from user_tables; /*현재 로그인한 유저가 만든 테이블*/

select * from dba5.members;
 
drop table hyeonha.product;
drop table hong.order_detail; 
drop table yun.members;
commit;
drop table sol.auth;
drop table newwww;
delete from yun.members;
delete from sol.auth;
 
-- DEV가 DBA 소유의 특정 OBJECT를 조회하기 위한 권한 부여
-- GRANT SELECT ON 테이블이름 TO 유저이름;

revoke create table from yun; --create table이라는 privilege는 준 적이 없으므로 권한 제거 불가

-- role에서 create table을 뺍시다
revoke create table from unity5;
-- 계정마다 revoke 할 필요가 없어서 권한을 role로 주는 게 더 편합니다

CREATE TABLE DBA5.MEMBERS (
 MM_ID      NVARCHAR2(5),
 MM_NAME    NVARCHAR2(5),
 MM_PW      NVARCHAR2(5),
 MM_BIRTH  DATE
 )TABLESPACE UNITY;
 
 CREATE TABLE DBA5.AUTH (
 AU_ID      NVARCHAR2(5),
 AU_TIME    DATE,
 AU_TYPE    NUMBER(1,0)
 )TABLESPACE UNITY;
 
GRANT SELECT ON DBA5.MEMBERS TO unity5;
GRANT SELECT ON DBA5.AUTH TO unity5;

GRANT INSERT ON DBA5.MEMBERS TO unity5;
GRANT INSERT ON DBA5.AUTH TO unity5;
grant create table to unity5;

--DBA: PRIMARY KEY 제약 설정: 테이블 오너만 가능
ALTER TABLE DBA5.MEMBERS ADD CONSTRAINT MM_ID_PK PRIMARY KEY(MM_ID);
ALTER TABLE DBA5.MEMBERS RENAME COLUMN MEM_BIRTH TO MM_BIRTH;

SELECT * FROM USER_CONSTRAINTS; --PK 확인

select * from all_tables;
select * from user
commit;

--DBA: 제약조건 삭제
ALTER TABLE DBA5.MEMBERS DROP CONSTRAINT MM_ID_PK;

--DBA: 모든 데이터 삭제
DELETE FROM DBA5.order1;
delete from sol.order1;
delete from yun.members;
delete from hong.order_detail;
commit;

--DEV
SELECT * FROM DBA5.MEMBERS;
SELECT * FROM DBA5.AUTH;

DELETE FROM MEMBERS WHERE MM_ID = 'D';

INSERT INTO DBA5.MEMBERS(MM_ID,MM_NAME,MM_PW,MM_BIRTH)VALUES('HOON','훈','1234','1970-11-06');
INSERT INTO DBA5.MEMBERS(MM_ID,MM_NAME,MM_PW,MM_BIRTH)VALUES('HOON1','훈','1234','1970-11-06');
rollback;

INSERT INTO DBA5.MEMBERS(MM_ID,MM_NAME,MM_PW,MM_BIRTH)VALUES('A','이름A','1234','1970-11-06');
INSERT INTO DBA5.MEMBERS(MM_ID,MM_NAME,MM_PW,MM_BIRTH)VALUES('B','이름A','1234','1970-11-06');
INSERT INTO DBA5.MEMBERS(MM_ID,MM_NAME,MM_PW,MM_BIRTH)VALUES('C','이름A','1234','1970-11-06');



/*일부러 에러를 내보자 : PK 실습 시나리오
1. MEMBER1 --> INSERT : A + COMMIT;

2. MEMBER2 --> INSERT : A
   MEMBER3 --> INSERT : B

3. DBA --> PRIMARY KEY --> X
ㄴ사유1) 중복이 있음
ㄴ사유2) MEMBER2,3이 COMMIT을 안 했음

4. DBA --> MEMBER2에게 롤백 요청, MEMBER3에게 커밋 요청

5. DBA --> PRIMARY KEY --> O

6. MEMBER4 --> INSERT : B --> X
   DBA --> MEMBER4에게 C를 INSERT하도록 요청 --> O
   
7. DBA --> SELECT --> C는 보이지 않음,
       --> INSERT C --> WAIT
       --> MEMBER4에게 롤백 요청 / MEMBER4가 롤백하는 순간 DBA의 C가 입력됨
       
8. 모든 DEV가 INSERT C 시도 --> WAIT
             DBA에게 롤백 요청 / DBA가 롤백하면 DEV 중 하나의 C가 입력됨 / 나머지는 계속 WAIT
*/
---------------------------------
select * from user_users; --테이블 스페이스(unity) 확인
select * from user_role_privs; --롤(unity5) 확인
select * from dba5.members; --dba5(DBA)계정에 있는 members 테이블의 내용(column) 조회


--------------------------------------
멤버 하나당 주문 하나씩 추가
commit이나 rollback은 맨 마지막에 한 번만
중간에 commit하면 꼬여요
---------------------------------------------------
    -- 로그인여부 확인
     SELECT SUM(AL_TYPE) FROM AL WHERE AL_MMID = 'YUN';
   /* 주문 등록  : 3개 상품 주문 : OR 레코드 생성 --> OD 레코드 3개 생성 --> OR 업데이트
    OR : OR_MMID, OR_DATE, OR_STATE    
            +     SYSDATE     'I'
    OD : OD_ORMMID, OD_ORDATE, OD_GOCODE, OD_SASECODE, OD_QUANTITY, OD_STATE 
              +          +         + ++        + ++        + ++        'I'          
   */
    -- ORDERS
    INSERT INTO "OR"(OR_MMID, OR_DATE, OR_STATE) VALUES('YUN', SYSDATE, 'I');
    -- ORDERDETAIL
    SELECT MAX(OR_DATE) FROM "OR" WHERE OR_MMID = 'YUN';
    SELECT * FROM SA;
    SELECT * FROM OD;
    INSERT INTO OD(OD_ORMMID, OD_ORDATE, OD_SAGOCODE, OD_SASECODE, OD_QUANTITY, OD_STATE)
    VALUES('YUN', '20201211090422', '0005', '1001412345', 2, 'I');
    INSERT INTO OD(OD_ORMMID, OD_ORDATE, OD_SAGOCODE, OD_SASECODE, OD_QUANTITY, OD_STATE)
    VALUES('YUN', '20201211090422', '0004', '1001412345', 1, 'I');
    INSERT INTO OD(OD_ORMMID, OD_ORDATE, OD_SAGOCODE, OD_SASECODE, OD_QUANTITY, OD_STATE)
    VALUES('YUN', '20201211090422', '1002', '1000112346', 3, 'I');
    
    
    -- 결제 완료
    UPDATE "OR" SET OR_STATE = 'C' WHERE OR_MMID = 'YUN' AND OR_DATE = '20201208170753';
    UPDATE OD SET OD_STATE = 'C' WHERE OD_ORMMID = 'YUN' AND OD_ORDATE = '20201208170753';
    COMMIT;
    SELECT * FROM "OR" WHERE OR_MMID = 'nhh1112';
    SELECT * FROM OD WHERE OD_ORMMID = 'YUN';
    
    -- 결제 취소
    ROLLBACK;
    
    /* 전체 반품 
   ORDERS : OR_STATE UPD :: 주문진행중-'I' 주문완료-'C' 전체반품-'R' 부분반품-'B'
*/
  -- 로그인 여부
  SELECT SUM(AL_TYPE) FROM AL WHERE AL_MMID = 'YUN';
  -- 주문리스트 확인
  SELECT * FROM "OR" WHERE OR_MMID = 'YUN';
  -- 전체반품처리
  -- OD는 C 유지, OR만 R 처리하는 설계
  -- OR만 바꾸면 반품된 상품 리스트도 SELECT로 알 수 있기 때문(SUBCOL // 아직 공부 안 한 내용이고 다음 주 내내 공부합니다)
  UPDATE "OR" SET OR_STATE = 'R' WHERE OR_MMID = 'YUN' AND OR_DATE = '20201210170712';
  --+ 반품 진행 완료
  COMMIT;
  --+ 반품 진행 철회
  ROLLBACK;
  
  SELECT * FROM "OR" WHERE OR_MMID = 'nhh1112';
    
    
    /* 부분 반품 */
SELECT * FROM "OR";
SELECT * FROM OD;
  -- 구매자 로그인 여부 
  SELECT SUM(AL_TYPE) FROM AL WHERE AL_ID = 'MINA';
  -- 부분반품처리
    -- 주문 리스트 확인
    SELECT * FROM "OR" WHERE OR_MMID = 'YUN';
    -- 주문 상세 내역 확인
    SELECT * FROM OD WHERE OD_ORMMID = 'YUN' AND OD_ORDATE = '20201211090422';
    -- 부분 반품
    UPDATE OD SET OD_STATE = 'R' 
    WHERE   (OD_ORMMID = 'YUN' AND  OD_ORDATE = '20201211090422') AND
            (OD_SAGOCODE = '0004' AND OD_SASECODE = '1001412345');
            
    UPDATE OD SET OD_STATE = 'R' 
    WHERE   (OD_ORMMID = 'YUN' AND  OD_ORDATE = '20201211090422') AND
            (OD_SAGOCODE = '1002' AND OD_SASECODE = '1000112346');
    
    --+ 부분반품 완료
    UPDATE "OR" SET OR_STATE = 'B' WHERE OR_MMID = 'YUN' AND OR_DATE = '20201211090422';
    COMMIT;
    --+ 부분반품 철회
    ROLLBACK;

    **프로세스 플랫폼마다 달라요 cf.쿠팡: 주문상세를 먼저 보여주고 다 선택하면 전체, 일부 선택하면 부분 -> 이렇게 하면 완전히 다른 구조
    
--------------------------------------------------------------------------------    
[1]판매자 등록 + 수정 + 상품 등록 (상품코드: 알파벳 1자리 + 숫자 3자리)
 
 1. 판매자 등록
 SELECT * FROM SE;
 INSERT INTO SE(SE_CODE, SE_NAME, SE_PW) VALUES('1231212345', 'JADED', 'JADE');
 COMMIT;
 
 2. 판매자 수정
 2.1. 로그인 확인
 SELECT SUM(AL_TYPE) FROM AL WHERE AL_MMID = '1231212345';
 -- 조회된 값이 NULL이면 로그인/로그아웃 기록이 없다는 뜻이므로 AL INSERT
 SELECT * FROM AL; -- AL의 COLUMN명 조회
 INSERT INTO AL(AL_MMID, AL_TIME, AL_TYPE) VALUES('1231212345', SYSDATE, 1);
 COMMIT;
 -- 입력 잘 됐는지 확인
 SELECT SUM(AL_TYPE) FROM AL WHERE AL_MMID = '1231212345';
 -- 조회된 값이 1이면 로그인 상태이므로 다음 단계 진행
 -- 조회된 값이 1이 아니면 AL INSERT 1 또는 -1
 
 2.2. 기존 비밀번호 일치 확인
 SELECT COUNT(*) FROM SE WHERE SE_CODE = '1231212345' AND SE_PW = 'JADE';
 -- 조회된 값이 1이면 일치하므로 다음 단계 진행
 -- 조회된 값이 0이면 일치하지 않으므로
 -- 비밀번호 재확인 후 재시도, 또는 다른 인증수단으로 본인인증 후 재설정 필요(웹사이트의 경우 휴대폰/이메일?)
 
 2.3. 비밀번호 변경
 UPDATE SE SET SE_PW = 'NUMB' WHERE SE_CODE = '1231212345';
 COMMIT;
 -- 변경 확인
 SELECT * FROM SE WHERE SE_CODE = '1231212345';
 
 3. 상품 등록
 3.1. 판매자 로그인 확인 -- 앞에서 했으니까 지금은 생략
 3.2. 기존 상품코드 확인
 SELECT * FROM SA;
 3.2.1. 기존 상품코드가 있는 상품 등록
 INSERT INTO SA(SA_GOCODE, SA_SECODE, SA_PRICE, SA_STOCK)
 VALUES('1001', '1231212345', 5000, 10);
 INSERT INTO SA(SA_GOCODE, SA_SECODE, SA_PRICE, SA_STOCK)
 VALUES('0001', '1231212345', 5000, 10);
 COMMIT;
 -- CHECK
 SELECT * FROM SA WHERE SA_SECODE = '1231212345' AND SA_GOCODE = '1001';
 SELECT * FROM SA WHERE SA_SECODE = '1231212345' AND SA_GOCODE = '0001';
 3.2.2. 기존 상품코드가 없는 상품 등록: O123, O456
 -- 1. GO INSERT
 INSERT INTO GO(GO_CODE, GO_NAME) VALUES('O123', '안경');
 INSERT INTO GO(GO_CODE, GO_NAME) VALUES('O456', '렌즈');
 SELECT * FROM GO;
 COMMIT;
 -- 2. SA INSERT
 INSERT INTO SA(SA_GOCODE, SA_SECODE, SA_PRICE, SA_STOCK)
 VALUES('O123', '1231212345', 5000, 10);
 INSERT INTO SA(SA_GOCODE, SA_SECODE, SA_PRICE, SA_STOCK)
 VALUES('O456', '1231212345', 500, 10);
 SELECT * FROM SA WHERE SA_SECODE = '1231212345' AND SA_GOCODE = 'O123';
 SELECT * FROM SA WHERE SA_SECODE = '1231212345' AND SA_GOCODE = 'O456';
 COMMIT;
--------------------------------------------------------------------------------
 [2]방금 만든 상품코드 관련 주문 생성 (+ 시간 되면 반품도)
 -- 회원이 없으면 회원 생성 후 진행: NONE은 탈퇴회원 정보를 저장하는 값이므로 사용하지 않음
 INSERT INTO MM (MM_ID, MM_PASSWORD, MM_NAME, MM_PHONE)
 VALUES('JADE', 'JADEDJADE', 'JADE', '01012345678');
 COMMIT;
 SELECT * FROM MM;
 -- 1. OR INSERT
 INSERT INTO "OR" (OR_MMID, OR_DATE, OR_STATE)
 VALUES('JADE', SYSDATE, 'I');
 SELECT * FROM "OR" WHERE OR_MMID='JADE';
 -- 2. OD INSERT
 INSERT INTO OD (OD_ORMMID, OD_ORDATE, OD_QUANTITY, OD_STATE, OD_SAGOCODE, OD_SASECODE)
 VALUES('JADE', '20201211161741', 5, 'I', 'O123', '1231212345');
 SELECT * FROM OD;
 COMMIT;
 -- 3. OR UPDATE
 UPDATE "OR" SET OR_STATE = 'C' WHERE OR_MMID = 'JADE' AND OR_DATE = '20201211161741';
 -- 4. OD UPDATE
 UPDATE OD SET OD_STATE = 'C' WHERE OD_ORMMID = 'JADE' AND OD_ORDATE = '20201211161741';
 -- 5. COMMIT; OR ROLLBACK;
 COMMIT;
 
 [3]방금 만든 판매자 탈퇴
 /* DEV */
 -- 1. SE에 INSERT
 INSERT INTO SE(SE_CODE, SE_NAME, SE_PW) VALUES('NONE', '탈퇴판매자', '1234');
 -- 2. SA에 INSERT SELECT
 INSERT INTO SA
 SELECT SA_GOCODE, 'NONE', SA_PRICE, SA_STOCK FROM SA WHERE SA_SECODE = '1231212345' AND SA_GOCODE = '0001';
 INSERT INTO SA
 SELECT SA_GOCODE, 'NONE', SA_PRICE, SA_STOCK FROM SA WHERE SA_SECODE = '1231212345' AND SA_GOCODE = '1001';
 INSERT INTO SA
 SELECT SA_GOCODE, 'NONE', SA_PRICE, SA_STOCK FROM SA WHERE SA_SECODE = '1231212345' AND SA_GOCODE = 'O123';
 INSERT INTO SA
 SELECT SA_GOCODE, 'NONE', SA_PRICE, SA_STOCK FROM SA WHERE SA_SECODE = '1231212345' AND SA_GOCODE = 'O456';
 -- 3. OD에 UPDATE
 UPDATE OD SET OD_SASECODE = 'NONE'
 WHERE (OD_SASECODE = '1231212345' AND OD_SAGOCODE = '0001')
 AND (OD_ORMMID = 'JADE' AND OD_ORDATE = '20201211161741');
 -- 4. COMMIT;
 -- +. DBA에게 삭제할 SE_CODE 알려주기
 /* DBA */
 -- 1. AL DELETE
 -- 2. SA DELETE
 -- 3. SE DELETE
 -- 4. COMMIT;
 
 --1)
DELETE FROM AL WHERE AL_MMID = '1063850608';
DELETE FROM SA WHERE SA_SECODE = '1063850608';
DELETE FROM AL WHERE AL_MMID = '1063850608';

DELETE FROM AL WHERE AL_MMID = '1001412345';
DELETE FROM SA WHERE SA_SECODE = '1001412345';

--2)
DELETE FROM SE WHERE SE_CODE = '1001412345';
--3)
COMMIT;
--CHECK)
SELECT * FROM AL WHERE AL_MMID = '1063850608';
SELECT * FROM SE WHERE SE_CODE = '1063850608';
SELECT * FROM SA WHERE SA_SECODE = '1063850608';

SELECT * FROM AL WHERE AL_MMID = '1001412345';
SELECT * FROM SE WHERE SE_CODE = '1001412345';
SELECT * FROM SA WHERE SA_SECODE = '1001412345';
 
 SELECT * FROM SE;
 
 SELECT * FROM "OR";
 SELECT * FROM "OD";
 SELECT * FROM OD WHERE OD_SASECODE = '1001412345';
 SELECT * FROM SA;
 
 ----------------------------------
 12월 14일 월요일.
 
 판매자 탈퇴 실습
 DEV
 1) SE에 NONE INSERT
 2) SA에 INSERT SELECT
INSERT INTO SA
 SELECT SA_GOCODE, 'NONE0608', SA_PRICE, SA_STOCK
 FROM SA WHERE SA_SECODE = '1001412345' AND SA_GOCODE = '0004';
 INSERT INTO SA
 SELECT SA_GOCODE, 'NONE0608', SA_PRICE, SA_STOCK
 FROM SA WHERE SA_SECODE = '1001412345' AND SA_GOCODE = '0001';
 INSERT INTO SA
 SELECT SA_GOCODE, 'NONE0608', SA_PRICE, SA_STOCK
 FROM SA WHERE SA_SECODE = '1001412345' AND SA_GOCODE = '0002';
 INSERT INTO SA
 SELECT SA_GOCODE, 'NONE0608', SA_PRICE, SA_STOCK
 FROM SA WHERE SA_SECODE = '1001412345' AND SA_GOCODE = '0005';
 INSERT INTO SA
 SELECT SA_GOCODE, 'NONE0608', SA_PRICE, SA_STOCK
 FROM SA WHERE SA_SECODE = '1001412345' AND SA_GOCODE = '0006';
 INSERT INTO SA
 SELECT SA_GOCODE, 'NONE0608', SA_PRICE, SA_STOCK
 FROM SA WHERE SA_SECODE = '1001412345' AND SA_GOCODE = '0007';
 commit;
 SELECT * FROM SA WHERE SA_SECODE = 'NONE0608';
 
 3) OD에 UPDATE
 
 UPDATE OD SET OD_SASECODE = 'NONE0608'
 WHERE OD_SASECODE = '1001412345';
 
 
 commit;
 select * from od where OD_SASECODE = '1001412345';
 rollback;
 -------------------------------------------------------------------------
 /* 20201220 QUERY 
    select  [COL] AS [ALIAS], ..., [COL] AS [ALIAS]   --> AS [ALIAS]
    from    [TAB | VIEW | INLINE-VIEW | SUB-QUERY]  [TAB_ALIAS]
    where   [CONDITION]    --> PK, FK, UK COLUMN 을 사용하면 검색이 빠르다
    GROUP BY [COL], ..., [COL]
    HAVING  [GROUP-CONDITION]
    ORDER BY [ALIGN]
 */
 /*where 절에서 사용되어 지는 operator
    비교연산자 : =, !=, >, >=, <, <=
    조건결합연산자 : [c1] AND [c2]  --> c1과 c2가 모두 TRUE를 리턴할 때 TRUE
                [c1] OR  [c2]  --> c1과 c2가 모두 FALSE를 리턴할 때 FALSE
    LIST 연산  : IN(LIST), NOT IN(LIST)   :: 서브쿼리에 의해 동적으로 생성되어지는 
                    데이터 리스트를 =와 OR로 연결하여  WHERE절에 사용       
 */
 -- 특정 판매자가 판매하는 상품명 조회
 SELECT * FROM GO;
 SELECT SA_GOCODE FROM SA WHERE SA_SECODE = '';
 
 SELECT GO_NAME
 FROM GO
 WHERE GO_CODE = '' OR GO_CODE = '' OR GO_CODE = '' OR GO_CODE = '';
 -- SUB_QUERY
 SELECT GO_NAME
 FROM GO
 WHERE GO_CODE IN(SELECT SA_GOCODE FROM SA WHERE SA_SEVODE = '');
             --IN('1001', '1002', '1003', '7001');
    
 SELECT GO_NAME
 FROM GO
 WHERE GO_CODE NOT IN(SELECT SA_GOCODE FROM SA WHERE SA_SEVODE = '');
             --IN('1001', '1002', '1003', '7001');

 -- 특정 상품을 판매하는 판매자코드와 판매자명 조회
   --  SA : CONDITION :: SUB        SE : MAIN
    SELECT SE_CODE, SE_NAME
    FROM SE
    WHERE SE_CODE = '1000112345';
    SELECT SA_SECODE FROM SA WHERE SA_GOCODE = '1002';
   
   
    SELECT SE_CODE, SE_NAME
    FROM SE
    WHERE SE_CODE IN(SELECT SA_SECODE FROM SA WHERE SA_GOCODE ='1001');
    
 
 -- 특정 회원의 장바구니에 들어있는 상품명 조회
    SELECT GO_NAME
    FROM GO
    WHERE GO_CODE IN(SELECT BA_GOCODE FROM BA WHERE BA_MMID='JADE');
 
/* 1. 특정 상품을 구매한 구매자 코드와 구매자 이름 조회
            OD            OD MM         MM
    *** DISTINCT :: SELECT 절에서 중복값 제거
                 :: SELECT 절에서 하나의 컬럼에 대해서만 사용 가능
  */   
    SELECT * FROM MM;
    SELECT * FROM "OR";
    SELECT * FROM OD;
    SELECT mm_id , mm_name
    FROM MM
    WHERE MM_ID IN(SELECT OD_ORMMID FROM OD WHERE OD_SAGOCODE='1001');
    
    /*
        --ORIGIN
      SELECT MM_ID, MM_NAME
      FROM MM
      WHERE IN(SELECT OD_ORMMID FROM OD WHERE OD_SAGOCODE = '1001');
      
        -- DISTINCT 
        SELECT MM_ID, MM_NAME
      FROM MM
      WHERE IN(SELECT DISTINCT OD_ORMMID FROM OD WHERE OD_SAGOCODE = '1001');
      
      SELECT *
      FROM OD WHERE OD_SAGOCODE
    */
    /** DISTINCT ::
    SELECT OD_ORMMID FROM OD WHERE OD_SAGOCODE = '1001' -->15번 비교
    */
/* 2. 특정 상품을 판매한 판매자 코드와 판매자 이름 조회 
              OD              SE        SE
*/
            
    SELECT * FROM SE;
    SELECT se_name , se_code
    FROM SE
    WHERE SE_CODE IN(SELECT OD_SASECODE FROM OD WHERE OD_SAGOCODE='1001');
    
  /*  
    SELECT SE_CODE, SE_NAME 
    FROM SE
    WHERE SE_CODEIN(SELECT OD_SASECODE FROM OD WHERE OD_SAGOCODE = '1001');
  */  
  
  -- 특정 상품(상품명)을 구매한 구매자 코드와 구매자 이름 조회
  SELECT MM_ID, MM_NAME
  FROM MM
  WHERE IN(SELECT DISTINCT OD_ORMMID 
            FROM OD WHERE OD_SAGOCODE IN(SELECT GO_CODE
                                         FROM GO 
                                         WHERE GO_NAME = '파스타'));
  
  
  SELECT * FROM GO WHERE GO_NAME = '파스타';
  
  
  
  
  
  
  
  
  
/* 3. 로그인 되어 있는 회원의 코드와 이름 조회
    INSERT INTO AL(AL_MMID , AL_TIME , AL_TYPE) VALUES ('SOL' , SYSDATE , -1);
    commit;
    SELECT * FROM AL;
    
    SELECT MM_ID, MM_NAME
    FROM MM
    WHERE MM_ID NOT IN(SELECT AL_MMID FROM AL WHERE AL_TYPE=-1);
    
    SELECT MM_ID, MM_NAME
    FROM MM
    WHERE MM_ID IN(SELECT AL_MMID FROM AL GROUP BY AL_MMID HAVING SUM(AL_TYPE) = 1);
    -> 로그인한 사람 중에서 회원인 사람
  */   
  
  ----------------------------------------------------
  12월 15일 화요일
  
  /* NUMERIC FUNCTION
  - ABS(NUM) : 절대값으로 변환하는 함수
  - CEIL(NUM) : NUM에서 가장 가까운 정수값 중 큰 값
  - FLOOR(NUM) : NUM에서 가장 가까운 정수값 중 작은 값
  - MOD(m, n) : m을 n으로 나눈 나머지 값
  - ROUND(n, [m]) : 반올림
  - TRUNC(n, [m]) : 절삭
  */
  
  SELECT ABS(-10) FROM DUAL; -- 절대값(양수표현)
  SELECT CEIL(10.345), CEIL(-10.345) FROM DUAL; -- 주어진 수와 가장 가까운 정수 중 큰 값
  SELECT FLOOR(10.345), FLOOR(-10.345) FROM DUAL; -- 주어진 수와 가장 가까운 정수 중 작은 값
  SELECT MOD(4, 3) FROM DUAL; -- 4를 3으로 나눈 나머지 값 = 1
  SELECT ROUND(12345.3), ROUND(12345.5) FROM DUAL; -- 12345.5을 반올림
  SELECT TRUNC(12345.3), TRUNC(12345.12345, 3) FROM DUAL;
  
  /* CHARACTER FUNCTION
  
   - CONCAT(C, C) : 두 개의 문자열 결합 -- 외국DB에서는 결혼으로 LAST NAME이 바뀌기 때문에 많이 사용
   - INITCAP(C) : 첫 글자만 대문자로 변환 -- 이것도 영어권 DB에서 많이 사용
  
   - LOWER(C) : 전부 소문자로 리턴 UPPER(C) : 전부 대문자로 리턴
   // LOWER, UPPER는 과거에 많이 사용했지만 DB부하가 많이 걸려서 현재는 어플단에서 처리
   // 자바에서는 STRING.TOUPEERCASE() STRING.TOLOWERCASE()
  
   **아래부터는 사용은 좀 되지만 사실 DBA가 쓰고 개발자가 쓰지 않습니다**
   - SUBSTR(C, m, [n]) : 문자열에서 m번째 문자부터 추출 시작
   // n 기재 시 m에서부터 count한 n번째 문자까지 추출(cf. 자바는 전체 문자열의 n-1번째까지 추출)
  
   - LENGTH(C)
  
   - REPLACE(C, STR1, STR2) : C에서 STR1을 STR2로 대체
   // 이것도 자바단에서 합니다 DB에서 하지 않아요
   
   - INSTR(C, STR, [m], [n]) : C에서 STR의 위치를 리턴
   m: m번째 위치부터 찾기 시작 *좌측에서부터 세면 양수, 우측에서부터 세면 음수
   n: 나오는 값 중에 n번째 나오는 값의 위치
    
  */
  
  SELECT '대한' || '민국' || '만세' FROM DUAL;
  SELECT CONCAT('대한', CONCAT('민국', '만세')) FROM DUAL;
  -- 편한 걸 골라 쓰면 됩니다(그냥 || 쓰는 걸 추천합니다)
  SELECT SUBSTR('햇빛이 나뭇잎을 선명하게 핥고 있었다', 8, 10) FROM DUAL;
  -- 오라클은 첫 글자가 1, 자바는 첫 글자가 0인 것이 차이
  SELECT LENGTH('햇빛') FROM DUAL;
  SELECT REPLACE('햇빛이 나뭇잎을', '나뭇잎', '달빛') FROM DUAL;
  SELECT INSTR('안녕', '좋은 아침'), INSTR('좋은 아침', '안녕'),
  INSTR('좋은 아침', '아침'), INSTR('아침햇살', '아침'),
  INSTR('CORPORATE', 'OR'), INSTR('CORPORATE FLOOR','OR',6),
  INSTR('CORPORATE FLOOR','OR',2,2), INSTR('CORPORATE FLOOR','OR',-3,2) FROM DUAL;
  
  /*
  DATATIME FUNCTION
  - SYSDATE
  - DATETIME +(-) INTEGER
  - ADD_MONTHS(D,i)
  - MONTH_BETWEEN(D1, D2)
  - LAST_DAY(D) : 현재 달의 마지막 날
  - NEXT_DAY(D, n) : 돌아올 n번째 요일(index는 1=일요일부터) // 금융권에서는 많이 씁니다
  */
  
  SELECT SYSDATE, SYSDATE+1 FROM DUAL;
  SELECT ADD_MONTHS(SYSDATE, 2), ADD_MONTHS(SYSDATE, -2) FROM DUAL;
  SELECT MONTHS_BETWEEN(SYSDATE, TO_DATE('20210317000000', 'YYYYMMDDHH24MISS')) FROM DUAL; 
  SELECT TO_CHAR(LAST_DAY(SYSDATE), 'YYYYMMDD') FROM DUAL;
  SELECT TO_DATE(TO_CHAR(LAST_DAY(SYSDATE)+1, 'YYYYMMDD')) FROM DUAL; 
  
  /*
  CONVERT FUNCTION
  - TO_CHAR: 숫자 --> 문자, 날짜 --> 문자 <-- 형식지정(YYYMMDDHH24MISS)
  - TO_DATE: 문자 --> 날짜 <-- 형식지정(YYYMMDDHH24MISS)
  - TO_NUMBER: 문자 --> 숫자
  ㄴ 숫자를 날짜로 변환 시키려면 숫자->문자->날짜
  
  YYYY : 4자리 년도
  YY : 2자리 년도
  MM : 월
  HH : 12시간제 시간
  HH24 : 24시간제 시간
  MI : 분
  SS : 초
  DAY : 요일
  DDD : DAY OF YEAR --- 1월1일을 1일차로 해서 현재 날짜가 며칠째인지 표시
  WW : WEAK OF YEAR --- 1월1주를 1주차로 해서 현재 날짜가 몇주차인지 표시 -- 자동차 타이어에 생산년도 표기를 이렇게 합니다
  
  */
  
  SELECT 10, TO_CHAR(10), 10 || '' FROM DUAL;
  -- 숫자+문자=문자
  -- 빠르기는 '' 결합이 빠름 >> 사용은 이걸 많이 사용함
  -- TO_CHAR() 쓰면 가독성이 오름
  
  SELECT TO_DATE(TO_CHAR(20210101), 'YYYYMMDD') FROM DUAL;
  
  /*
  OTHERS
  -- NULL 처리 함수
  - NVL([COL_NAME], '없음') -> 특정칼럼의 데이터 중 NULL값이 있으면 문자열 '없음'으로 표시
  ㄴ 해당 칼럼의 속성을 바꿀 수는 없음(칼럼 속성이 숫자였다면 숫자로 반환될 수 없는 문자 입력 불가)
  - NVL2(V, NULL이 아닐 때 표시값, NULL일 때 표시값) // 비추
  
  - COALESCE(표현식1, (표현식1이 NULL일 경우) 대체식/대체값, (표현식2도 NULL일 경우) 대체식/대체값, (표현식3도 NULL일 경우) 대체식/대체값), ...) // 추천, 국제표준
  
  - NULLIF(V1, V2) / DECODE ... <- 쓰지 마
  
  */
  
  SELECT NVL2(MM_PHONE, '번호제공', '번호미제공') FROM MM;
  
  -- HR 계정활성화
  ALTER USER HR IDENTIFIED BY 1234 ACCOUNT UNLOCK;
  GRANT SELECT ON HR.EMPLOYEES TO UNITY5;
  SELECT * FROM EMP;
  CREATE PUBLIC SYNONYM EMP FOR HR.EMPLOYEES;
  
  -- 연봉계산: (SALARY * 12) + ((SALARY * 12) * COMMISSION_PCT)
  SELECT EMPLOYEE_ID AS "CODE",
        SALARY,
        COMMISSION_PCT AS "CPCT",
        COALESCE((SALARY * 12) + ((SALARY * 12) * COMMISSION_PCT), (SALARY*12), 0) AS "YEARPAY" FROM EMP;
  
  /* 함수 실습 */
  1. 아래의 예시처럼 사원정보를 조회하시오.
  --------------------------------------------------
   사원번호  사원이름  입사일  직무  급여  인센티브  연봉
  --------------------------------------------------
  SELECT EMPLOYEE_ID AS 사원번호,
         FIRST_NAME || LAST_NAME AS 사원이름, 
         TO_CHAR(HIRE_DATE, 'YYYY-MM-DD') AS 입사일,
         JOB_ID AS 직무,
         SALARY AS 급여,
         COALESCE((SALARY * 12) * COMMISSION_PCT, 0) AS 인센티브,
         COALESCE((SALARY * 12) * (1 + COMMISSION_PCT), (SALARY * 12)) AS 연봉 FROM EMP;
  
  2. 이번 달 말일을 기준으로 아래의 예시처럼 사원정보를 조회하시오.
  -----------------------------------------------------------------------
      사원번호    사원이름      입사일     직무  근속년수  근속일수   근속개월수               
  -----------------------------------------------------------------------
  SELECT EMPLOYEE_ID AS 사원번호,
         FIRST_NAME || LAST_NAME AS 사원이름,
         TO_CHAR(HIRE_DATE, 'YYYY-MM-DD') AS 입사일,
         JOB_ID AS 직무,
         (TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY'))-TO_NUMBER(TO_CHAR(HIRE_DATE, 'YYYY')) + 1) AS 근속년수,
         TRUNC((SYSDATE-HIRE_DATE)+1) AS 근속일수,
         TRUNC(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) AS 근속개월수 FROM EMP;
         
  3. 이번 달 말일을 기준으로 근속년수가 15년 이상인 직원에 대해
          아래의 예시처럼 사원정보를 조회하시오.
  -----------------------------------------------------------------------
      사원번호    사원이름      입사일     직무  근속년수  근속일수   근속개월수
  -----------------------------------------------------------------------
    SELECT EMPLOYEE_ID AS 사원번호,
         FIRST_NAME || LAST_NAME AS 사원이름,
         TO_CHAR(HIRE_DATE, 'YYYY-MM-DD') AS 입사일,
         JOB_ID AS 직무,
         (TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY'))-TO_NUMBER(TO_CHAR(HIRE_DATE, 'YYYY')) + 1) AS 근속년수,
         TRUNC((SYSDATE-HIRE_DATE)+1) AS 근속일수,
         TRUNC(MONTHS_BETWEEN(SYSDATE, HIRE_DATE)) AS 근속개월수
         FROM EMP
         WHERE (TO_NUMBER(TO_CHAR(SYSDATE, 'YYYY'))-TO_NUMBER(TO_CHAR(HIRE_DATE, 'YYYY')) + 1) >= 15;
         
  4. 1년간 총 지급액이 200,000달러 이상인 직원의 정보를 아래의 예시처럼 
          조회하시오.
    -----------------------------------------------------------------------
      사원번호    사원이름      입사일   직무  근속일수   급여  인센티브  연봉
    -----------------------------------------------------------------------
     SELECT EMPLOYEE_ID AS 사원번호,
         FIRST_NAME || LAST_NAME AS 사원이름, 
         TO_CHAR(HIRE_DATE, 'YYYY-MM-DD') AS 입사일,
         JOB_ID AS 직무,
         TRUNC((SYSDATE-HIRE_DATE)+1) AS 근속일수,
         SALARY AS 급여,
         COALESCE((SALARY * 12) * COMMISSION_PCT, 0) AS 인센티브,
         COALESCE((SALARY * 12) * (1 + COMMISSION_PCT), (SALARY * 12)) AS 연봉
         FROM EMP
         WHERE COALESCE((SALARY * 12) * (1 + COMMISSION_PCT), (SALARY * 12)) >= 200000;
         
  5. 1년간 총 지급액이 200,000달러 이상인 영업부 직원의 정보를 아래의 예시처럼 
          조회하시오.
          SELECT * FROM EMP WHERE JOB_ID = 'SA_MAN';    
    -----------------------------------------------------------------------
      사원번호    사원이름      입사일   직무  근속일수   급여  인센티브  연봉
    -----------------------------------------------------------------------