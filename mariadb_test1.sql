# 데이터베이스 생성 연습용 db
CREATE univ;

# ----------------------------
# 테이블 student 생성 연습용
USE univ;
create table student(

hakbun int not null, 

name varchar(5), 

year int, 

dept varchar(10),

addr varchar(50),

primary key(hakbun) 

); 

# 선택실행: 스크롤한 상태에서
# ctrl+F9
# 우클릭으로 '현재 쿼리 실행'해도 됩니다



# 첫 줄만 명령어랑 같이 붙여놓고 다음 값부터 엔터치는 게 보기 편하다
insert into student values(1001, "name1", 2001, "java", "incheon1" ), 
(1002, "name2", 2001, "java", "incheon2" ), 
(1003, "name1", 2003, "java", "incheon3" );



# 테이블을 선택해서 튜플 값들을 모두 보여주세요
select * from student;


# 테이블 삭제
DROP TABLE student;

# 에디터는 엔터 친 것도 한 문장으로 인식해서 복붙하기 편하다><

create table student(

# field 생성
hakbun int not null, 
name varchar(5), 
year int, 
dept varchar(10),
addr varchar(50),

# field 중 primary key 지정
# primary key를 지정했으면 새로 value 입력 시에 그 field의 값을 반드시 입력해야 함
primary key(hakbun) 

); 


DESC student;

#처음 create했던 순서대로 값을 입력해야 함
insert into student values(1001, "name1", 2101, "java", "incheon1" ), 
(1002, "name2", 2011, "java", "incheon2" ), 
(1003, "name1", 2233, "java", "incheon3" ),
(1004, "name4", 2253, "java", "incheon4" ),
(1005, "name5", 2563, "java", "incheon5" );

#field 제시해놓고 순서대로 입력도 가능
insert into student(hakbun, name, year, dept, addr) 
VALUES(2005, "name5", 2005, "java", "incheon5");

#null값이 허용된 field는 입력하지 않아도 되고 입력되지 않은 field는 null로 채워짐
INSERT INTO student(hakbun, NAME, dept)
VALUES(3001, "jenny", "c");

#table create했던 상태로 돌아감
#cf. drop: create table 하기 전 상태, table자체가 삭제됨
#delete에 where절이 없으면 경고팝업 발생(전체삭제가 맞는지 재확인하는 기능)
DELETE FROM student;

#------------------------------------------
DELETE FROM student WHERE NAME LIKE '%4';
DELETE FROM student WHERE YEAR LIKE '2%1';
#-------------------------------------------

#-------------------------------------------
#student의 수
SELECT COUNT(*) FROM student;

#이름이 다른 student의 수
SELECT COUNT(DISTINCT NAME) FROM student;

#select에도 where조건문을 쓸 수 있어요
SELECT COUNT(*) FROM student WHERE YEAR LIKE '%3';

#year가 3으로 끝나는 student의 hakbun과 name 불러오기
SELECT hakbun, NAME FROM student WHERE YEAR LIKE '%3';

#year가 3으로 끝나는 student의 모든 정보 불러오기
SELECT * FROM student WHERE YEAR LIKE '%3';

#순서를 바꿔도 돼요
# *는 create 순서대로 보여주고, select 명령 시 순서 지정했으면 지정한 대로 보여줌
SELECT NAME, addr, hakbun, dept, year FROM student WHERE YEAR LIKE '%3';

#특정 field값 순서대로 정렬
SELECT * FROM student ORDER BY YEAR; #default = asc
SELECT * FROM student order by YEAR ASC; #오름차순
SELECT * FROM student ORDER BY YEAR DESC; #내림차순

SELECT hakbun, NAME student WHERE YEAR LIKE '%3' ORDER BY NAME;
SELECT hakbun, NAME student WHERE YEAR LIKE '%3' ORDER BY NAME desc;
#-------------------------------------------

#-------------------------------------------
UPDATE student SET dept = 'sql' WHERE YEAR LIKE '%3';
#create 할 때 year를 int type으로 생성했기 때문에 데이터 전체입력은 숫자형으로
#3으로 끝나는 수, 3으로 시작하는 수 등의 표현은 문자열처럼 '%3' / '3%'
UPDATE student SET YEAR = 2008 WHERE hakbun=1003;


#year가 3으로 끝나는 학생의 이름/주소
SELECT NAME, addr FROM student WHERE YEAR LIKE '%3';
#year가 3으로 끝나는 학생의 수
SELECT COUNT(*) FROM student WHERE YEAR LIKE '%3';
#전체학생의 수
SELECT COUNT(*) FROM student;
#incheon4 주소지 학생의 수
SELECT COUNT(*) FROM student WHERE addr='incheon4';
#incheon7 학생의 dept를 sql로 변경
UPDATE student SET dept = 'sql' WHERE addr='incheon7';
#dept가 sql인 학생의 수
SELECT COUNT(*) FROM student WHERE dept='sql';
#dept가 sql인 학생의 이름/학번/year(단, 이름 순서로 정렬)
SELECT NAME, hakbun, YEAR FROM student WHERE dept='sql' ORDER BY NAME;
#전체 학생의 명단을 year 역순으로 정렬해서 이름, dept, 학번, 주소, year 출력
SELECT NAME, dept, hakbun, addr, YEAR FROM student ORDER BY YEAR DESC;

SELECT * from student;

ALTER TABLE student MODIFY hakbun INT(11) NOT NULL AUTO_INCREMENT;

SELECT * FROM student;

INSERT INTO student VALUES(2015, 'ga', 1992, 'java', 'seoul');

INSERT INTO student VALUES(null, 'na', 1992, 'java', 'seoul');
INSERT INTO student VALUES(null, 'da', 1992, 'java', 'seoul');
INSERT INTO student VALUES(null, 'ra', 1992, 'java', 'seoul');
INSERT INTO student VALUES(null, 'ma', 1992, 'java', 'seoul');

INSERT INTO student(NAME, YEAR, dept, addr) VALUES('ba', 1993, 'c', 'jeju');

ALTER TABLE student MODIFY NAME VARCHAR(20);


#(heidisql 함수)마지막으로 입력된 primary key 확인
SELECT LAST_INSERT_ID();

#학번을 내림차순으로 한 값을 찾으라는 명령문=마지막 값 입력
SELECT hakbun FROM student ORDER BY hakbun DESC LIMIT 1;

create TABLE staff (
sawonbunho int not NULL AUTO_INCREMENT, 
name VARCHAR(20), 
year int, 
dept varchar(10),
addr varchar(50),
primary key(sawonbunho) 
); 

SELECT * FROM baksa;

INSERT INTO staff VALUES(12345678, 'staff1', 1992, 'hr', 'pusan');
INSERT INTO staff VALUES(null, 'staff2', 1993, 'pr', 'pusan');

show tables from univ2;