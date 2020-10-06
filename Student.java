

	public class Student {
		 
	    private String name;        //필드 변수
	    private int[] score;
	    private float avg;
	    private float sum;
	 
	    public Student() {            //생성자 초기화
	        score = new int[3];
	        name = null;
	        avg = 0;
	        sum = 0;
	        
	        
	    }
	 
	    public void Sum() {            //sum함수
	        sum=0;
	        for(int i=0; i<score.length; i++){
	        sum += score[i];        
	        }
	    }
	    
	    public void Avg() {            //avg함수
	        avg = sum/3;
	    }
	    
	    //setter&getter
	    public String getName() {
	        return name;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	 
	    public int getScore(int i) {
	        return score[i];
	    }
	 
	    public void setScore(int score,int i) {
	        this.score[i] = score;
	    }
	    
	    public float getAvg() {
	        return avg;
	    }
	    
	    public float getSum() {
	        return sum;
	    }
	 
	}
