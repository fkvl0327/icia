package lambda;

import lombok.Data;
// 0. Lombok jar 파일 다운로드
// 1. 다운로드한 파일 더블클릭 실행(install화면이 팝업되고 경로를 자동검색하지만
// 	  경로를 찾지 못한 경우에 eclipse.exe 파일이 있는 경로를 직접 찾아서 설치)
// 2. Lombok 라이브러리 add external jar
// 3. Referenced Libararies에서 설치 확인
// 4. class 앞에 @Data 입력 후 import
// 5. Outline에서 생성된 getter, setter, is, equals, hashCode, toString 확인

public @Data class LombokTest {
	private String a;
	private int b;
	private boolean c;
	
	public static void main(String[] args) {
		//눈에 보이지 않지만 
		LombokTest lomboktest = new LombokTest();
		System.out.println(lomboktest.getA());
		System.out.println(lomboktest.getB());
		System.out.println(lomboktest.isC());
	}
}
