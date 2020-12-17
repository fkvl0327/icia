/* 전체 상품중 현재 판매자가 없어 판매되지 않는 상품 정보 조회 
   A : SELECT * FROM GO;  --> 판매할 수 있는 전체 상품
   B : SELECT * FROM SA;  --> 판매 중 인 상품
    --------------------------------------------------------
      상품코드   상품명
         GO       GO 
    --------------------------------------------------------
    UNION  UNION ALL  --> 합집합   ALL: 중복값도 출력
    INTERSECT   MINUS
*/
SELECT GO_CODE FROM GO
UNION
SELECT SA_GOCODE FROM SA;
SELECT GO_CODE FROM GO
UNION ALL
SELECT SA_GOCODE FROM SA;
SELECT GO_CODE FROM GO
INTERSECT
SELECT SA_GOCODE FROM SA;
SELECT GO_CODE FROM GO
MINUS
SELECT SA_GOCODE FROM SA;

-- 판매되지않는 상품정보
SELECT GO_CODE, GO_NAME
FROM GO
WHERE GO_CODE IN(SELECT GO_CODE FROM GO MINUS SELECT SA_GOCODE FROM SA);

/* 전체 상품의 판매자 정보 조회 
    --------------------------------------------------------
      상품코드   상품명   판매자코드  판매자명    판매가격 재고수량
    --------------------------------------------------------
    INSERT INTO A (1) VALUES(N'1')
*/
SELECT  COALESCE(SA.SA_GOCODE, GO.GO_CODE) AS "GCODE",
        GO.GO_NAME AS "GNAME",
        COALESCE(SA.SA_SECODE, N'NONE') AS "SCODE",
        COALESCE(SE.SE_NAME, N'NONE') AS "SNAME",
        COALESCE(SA.SA_PRICE, 0) AS "GPRICE",
        COALESCE(SA.SA_STOCK, 0) AS "STOCK"
FROM SA INNER JOIN SE ON SA.SA_SECODE = SE.SE_CODE
        RIGHT OUTER JOIN GO ON SA.SA_GOCODE = GO.GO_CODE;

/* QUERY 실습 
  HOONZZANG@ICIA.OR.KR
*/

 /* 1. 특정 판매자의 판매정보 리스트 조회 
    PLANNER : 
    DEVELOPER : 
 */
 /* 2. 특정 판매자의 특정 판매정보 조회 */
 /* 3. 특정 상품의 판매정보 조회 */
 /* 4. 판매자의 판매정보 조회 */
 /* 5. 판매실적이 없는 판매자 정보 조회 */
 /* 6. 판매실적이 있는 판매자 정보 조회 */
 /* 7. 특정 구매자의 구매 정보 조회 */
 /* 8. 특정 구매자의 특정 구매 상세 정보 조회 */
 /* 9. 특정 구매자의 반품정보 정보 조회 */
 /* 10. 특정 구매자의 특정 반품 상세 정보 조회 */