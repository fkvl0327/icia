/* 2020-12-10 DML & QUERY 
    DML :: DATA MANIPULATION LNAGUAGE
        :: INSERT UPDATE DELETE
    RECORD - INSERT
      SYN___
      INSERT INTO [TAB_NAME]([COL_NAME], ..., [COL_NAME])
                      VALUES([COL_VALUE],..., [COL_NAME]);
      *** INSERT와 SELECT를 활용한 데이터 복사  
      
    RANGE  - UPDATE
      SYN___
      UPDATE [TAB_NAME] SET [COL_NAME] = [VALUE], ..., [COL_NAME] = [VALUE]
      WHERE [COL_NAME] [비교연산] [VALUE];
         --*** 비교 컬럼이 PK, FK, UK로 설정된 컬럼 사용 권장
    
    RANGE  - DELELTE
      SYN___
      DELETE FROM [TAB_NAME]
      WHERE [COL_NAME] [비교연산] [VALUE];
         --*** 비교 컬럼이 PK, FK, UK로 설정된 컬럼 사용 권장
*/

/* JOB에 따른 DML */
-- MEMBERS 
  -- 1. 회원가입 :: INSERT :: BUYER  1234  구매자 01045689234
    -- VAR :: ID = USERDATA1;
    -- VAR :: PWD = USERDATE2;
    -- VAR :: NAME = USERDATE3;
    -- VAR :: PHONE = (USERDATE4 == "")? NULL: USERDATE4;
    /* INSERT INTO MM(MM_ID, MM_PASSWORD, MM_NAME, MM_PHONE)
        VALUES(ID, PWD, NAME, PHONE); */
  INSERT INTO MM(MM_ID, MM_PASSWORD, MM_NAME, MM_PHONE)
  VALUES('BUYER', '1234', '구매자', '01045689234');
    -- INSERT :: BUYER2  1234  구매자 
    --           PHONE --> NULL 
    /* INSERT INTO MM(MM_ID, MM_PASSWORD, MM_NAME)
        VALUES('BUYER2', '1234', '구매자');  --> 비추 */

  -- 2. 회원정보수정 :: UPDATE
  
  -- 3. 회원탈퇴 :: DELETE








