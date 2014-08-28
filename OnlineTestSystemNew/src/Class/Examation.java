package Class;

public class Examation {
	private int Id;
	private String Difficulty;
	private int xTime;
	private String Content;
	private String Answer;
	private int Score;
	private int Type;
	public int getXTime() {
		return xTime;
	}
	public void setXTime(int time) {
		xTime = time;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDifficulty() {
		return Difficulty;
	}
	public void setDifficulty(String difficulty) {
		Difficulty = difficulty;
	}

	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	
}
 