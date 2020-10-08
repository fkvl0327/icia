import java.sql.*;
import java.util.Scanner;
//선생님 api 샘플2: 이클립스 실행
public class maria_api2 {
	
	static final String driverClass = "org.mariadb.jdbc.Driver";
	static final String dbURL = "jdbc:mariadb://localhost:3306/univ2";
	static final String id = "dev";
	static final String pw = "devpass";

	public static void main(String[] args) {
	
		System.out.println("DML? DDL?");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("선택>");
		String option = sc.next();
		if(option.equals("DML")) {
			do {
				System.out.println("DML을 실행합니다.");
				
				Scanner sc2 = new Scanner(System.in); 
				int sel = sc2.nextInt();
				if(sel==1) {
					System.out.println("1. table 전체조회");
					//조회할 함수
				} else if(sel==2) {
					System.out.println("2. table 내용삭제");
					//조회할 함수
				} else if(sel==3){
					System.out.println("3. table 항목입력");
					//조회할 함수
				} else if(sel==9) {
					System.out.println("메뉴를 종료합니다.");
					break;//break 없으면 다시 '실행합니다' 문구로 돌아감
				} else {
					System.out.println("해당메뉴가 없습니다 메뉴를 다시 확인하세요");
				}
			}while(true);
		}else if(option.equals("DDL")) {
			do {
				System.out.println("DDL을 실행합니다.");
				
				Scanner sc2 = new Scanner(System.in); 
				int sel = sc2.nextInt();
				if(sel==1) {
					System.out.println("1. database 생성");
				} else if(sel==2) {
					System.out.println("2. database 삭제");
				} else if(sel==3){
					System.out.println("3. table 생성");
				} else if(sel==4){
					System.out.println("4. table 삭제");
				} else if(sel==9) {
					System.out.println("메뉴를 종료합니다.");
					break;
				} else {
					System.out.println("해당메뉴가 없습니다 메뉴를 다시 확인하세요");
				}
			}while(true);
		}else {
			System.out.println("입력을 확인하시고 다시 실행해주세요.");
		}

	}

}
