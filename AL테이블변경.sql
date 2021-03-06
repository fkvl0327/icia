/* 데이터 타입 변경 위해 기존 데이터 삭제 */
DELETE FROM AL;
COMMIT;

/* AL_TYPE 컬럼 데이터를 NUMBER(1,0)으로 변경(사유: SUM을 하려면 숫자 타입으로 하자) */
ALTER TABLE ACCESSLOG MODIFY AL_TYPE NUMBER(1,0);

/* AL테이블의 PK가 ID로만 되어 있어서 회원이 로그인 후 로그아웃하려면 PK 위반됨,
-> ID와 TIME을 COMPOSITE PK로 설정 변경 */
ALTER TABLE ACCESSLOG DROP CONSTRAINT AL_USID_PK;
ALTER TABLE ACCESSLOG ADD CONSTRAINT AL_USID_TIME_PK PRIMARY KEY(AL_USID, AL_TIME);

/* 테스트 데이터 INSERT */
INSERT INTO AL(AL_USID, AL_TIME, AL_TYPE) VALUES('3000012345', SYSDATE, 1);
INSERT INTO AL(AL_USID, AL_TIME, AL_TYPE) VALUES('3000012345', SYSDATE, -1);
INSERT INTO AL(AL_USID, AL_TIME, AL_TYPE) VALUES('3000012345', SYSDATE, 1);
INSERT INTO AL(AL_USID, AL_TIME, AL_TYPE) VALUES('3000012346', SYSDATE, 1);
INSERT INTO AL(AL_USID, AL_TIME, AL_TYPE) VALUES('3000012346', SYSDATE, -1);
COMMIT;

/* 로그인 여부 체크 쿼리문 */
SELECT SUM(AL_TYPE) FROM AL WHERE AL_USID = '3000012346';
