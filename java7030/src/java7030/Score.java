package java7030;

public class Score {

	private int num;
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public int getSum() {
		
		return kor+eng+math;
	}
	
	public double getAvg() {
		
		return getSum() / 3.0;
	}
	
	public Score(int num, String name, int kor, int eng, int math) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	@Override
	public String toString() {
		return "Score [num=" + num + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum=" + getSum() + ", avg=" + getAvg() + "]";
	}
	
	
	
}
