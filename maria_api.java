import java.sql.*;
import java.util.Scanner;
//선생님 api 샘플1: class 파일 폴더에서 cmd 실행

//main함수에 입력된 String[] args 를 통해 args 라는 이름의 배열이 있음을 알 수 있다
//cmd에서 파일이름 다음에 스페이스 치고 입력한 내용이 args[0]이 된다

//콘솔 사용법: args[0]을 String으로 받기로 했으니
//dml이면 dml, ddl이면 ddl, 다른 내용이면 사용법이 뜨도록 만든 코드이다
//args[0]에 해당하는 내용을 입력하지 않고 파일이름만 입력하면 정상실행되지 않고 오류발생한다


public class maria_api {
	
	static final String driverClass = "org.mariadb.jdbc.Driver";
	static final String dbURL = "jdbc:mariadb://localhost:3306/univ2";
	static final String id = "dev";
	static final String pw = "devpass";

	public static void main(String[] args) {
		System.out.println("param count: " + args.length);
		for(int i=0; i<args.length; i++) {
			System.out.println(args[i]);
		} 
		int m = 0;
		String option = args[0];
		if(option.equals("dml")) {
			do {
				System.out.println("dml을 실행합니다.");
				
				Scanner sc = new Scanner(System.in); 
				int sel = sc.nextInt();
				if(sel==1) {
					System.out.println("1. table 전체조회");
				} else if(sel==2) {
					System.out.println("2. table 내용삭제");
				} else if(sel==3){
					System.out.println("3. table 항목입력");
				} else if(sel==9) {
					System.out.println("메뉴를 종료합니다.");
					break;
				} else {
					System.out.println("해당메뉴가 없습니다 메뉴를 다시 확인하세요");
				}
			}while(true);
		}else if(option.equals("ddl")) {
			do {
				System.out.println("ddl을 실행합니다.");
				
				Scanner sc = new Scanner(System.in); 
				int sel = sc.nextInt();
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
			System.out.println("=================");
			System.out.println("* howto: ");
			System.out.println("java -cp .;jdbc-driver.jar maria_api [option]");
			System.out.println("option: ddl, dml");
			System.out.println("example: ");
			System.out.println("> java -cp .;c:/programs/mariadb-java-client-2.7.0.jar maria_api [option]");
			System.out.println("=================");
		}

	}

}
