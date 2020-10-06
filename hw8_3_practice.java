//출처 https://machine-geon.tistory.com/7?category=835350

import java.util.*;
//참고 https://www.w3schools.com/java/java_arraylist.asp
//ArrayList는 java.util package에 내장되어 있는 기능이다
//코드 안에 배열을 만들 때는 사이즈(ex. [5][5])와 타입(ex. int, String, ...)까지 다 정해줘야 하지만
//ArrayList는 배열을 언제든지 더하고 지울 수 있다는 장점이 있다

public class hw8_3_practice {
    private Student st;
    private List<Student> list; // 설명: List 저장되는 값이 Student, Student 클래스를 list라 칭한다
                                //
 
    public hw8_3_practice() {
        list = new ArrayList<Student>(); // 설명: ArrayList에 student클래스를 넣은것을 list에 넣는다
    } // <> 어떤 데이터 타입(객체)을 저장할지
 
    public void Insert(String name, int score, int score1, int score2) {     //생성 기능
        st = new Student();                    //배열 생성
        st.setName(name);                    //이름 입력
        st.setScore(score, 0);                //점수 입력
        st.setScore(score1, 1);
        st.setScore(score2, 2);
        st.Sum();                            //sum 호출
        st.Avg();                            //avg 호출
        list.add(st);                        //list에 입력
    }
 
    public void Select(String name) {        //조회 기능
        boolean logical = false;            //잘못된값 조회를 대비한 논리값
        for (int i = 0; i < list.size(); i++) {        //size만큼 반복
            if (list.get(i).getName().equals(name)) { // list.get(i) == student 객체
                st = list.get(i);                //st에 list값 입력
                logical = true;                    // 논리타입 트루 if문으로 진행
                break;
            }
        }
        if (logical) {
            System.out.println("이름 : " + st.getName() + "\t");
            System.out.println("국어 : " + st.getScore(0) + "\t");
            System.out.println("영어 : " + st.getScore(1) + "\t");
            System.out.println("수학 : " + st.getScore(2) + "\t");
            System.out.println("총점 : " + st.getSum() + "\t");
            System.out.println("평균 : " + st.getAvg() + "\t");
        } else {                                //조회값이 없을시
            System.out.println("이름이 없습니다");
        }
    }
 
    public void SelectAll() {                //전체조회
        for (Student stN : list) {            //list 만큼의 반복
            System.out.println("이름 : " + stN.getName() + "\t");
            System.out.println("국어 : " + stN.getScore(0) + "\t");
            System.out.println("영어 : " + stN.getScore(1) + "\t");
            System.out.println("수학 : " + stN.getScore(2) + "\t");
            System.out.println("총점 : " + stN.getSum() + "\t");
            System.out.println("평균 : " + stN.getAvg() + "\t");
        }
        return;    //반복문 밖이라 return으로 메서드 탈출
    }
 
    public void Delete(String name) {                //삭제 메소드
        for (int i = 0; i < list.size(); i++) {        
            if (list.get(i).getName().equals(name)) { // list.get(i) == student 객체
                list.remove(i);            //삭제 키워드 remove
                break;
            }
        }
    }
 
    public void Update(String name1,String name, int score, int score1, int score2) {        //수정 메소드
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name1)) { // list.get(i) == student 객체
                list.get(i).setName(name);
                list.get(i).setScore(score, 0);
                list.get(i).setScore(score1, 1);
                list.get(i).setScore(score2, 2);
                list.get(i).Sum();
                list.get(i).Avg();
                st.Sum();
                st.Avg();
                break;
            }
        }
 
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);            // sc 생성
        hw8_3_practice stu = new hw8_3_practice();                // stu 생성
 
        while (true) {                //1을 넣어서 무한루프
            System.out.println("1.조회  2.생성  3.삭제  4.수정  5.전체 조회  6.종료");
            System.out.println("원하는 기능을 선택하시오  : ");
            int num = sc.nextInt();
            switch (num){                    //메뉴 선택을 위한 스위치문
            case 1:
                System.out.println("조회를 원하는 이름을 입력하세요 : ");
                stu.Select(sc.next());
                break;
 
            case 2:
                System.out.println("이름,국어성적,영어성적,수학성적을 차례로 입력하세요 : ");
                stu.Insert(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                break;
 
            case 3:
                System.out.println("삭제를 원하는 이름을 입력하세요 : ");
                stu.Delete(sc.next());
                break;
 
            case 4:
                System.out.println("수정를 원하는 이름을 입력하세요 : ");
                String name1 = sc.next();
                stu.Select(name1);
                System.out.println("수정할 이름,국어성적,영어성적,수학성적을 차례로 입력하세요 : ");
                stu.Update(name1,sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                break;
 
            case 5:
                stu.SelectAll();        
                break;
 
            case 6:
                System.exit(0);            //무한반복문이라 강제종료
 
            }
        }
 
    }
 
}