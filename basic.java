
public class basic {

	private String name;
	private int score;
	private String data;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	

	public basic(String name, int score2, String data) {
		super();
		this.name = name;
		this.score = score2;
		this.data = data;
	}
	@Override
	public String toString() {
		return "姓名: " + name + ", 分数:" + score + ", 日期:" + data ;
	}
	
	

}
