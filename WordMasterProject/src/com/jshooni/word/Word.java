package com.jshooni.word;
//데이타 클레스. 
//단어를 다루기 위해서 사용하는 변수들을 구성하면되는거임. 
public class Word {
	private int id; //멤버 변수를 직접 접근지 않게 하기 위해서 private 하는거임.  
	private int level;
	private String word; 
	private String meaning; 
	
	//데이터클래스르 만들 때 필요에 따라서 생성자를 만들게 되는데, 기본형은 자동으로 만들어지지 않기 때문에, 
	//비어있는 기본형을 만들어줘야한다. 
	Word(){}
	Word(int id, int level, String word, String meaning){
		this.id = id;
		this.level = level;
		this.word = word;
		this.meaning = meaning; 
	}
	

	
	
	//외부에서 변경할 수 있도록 게터랑 세터를 추가해야함. 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	@Override
	public String toString() {
		
		String slevel = "";
		for(int i=0; i<level; i++) slevel += "*";
		String str = String.format("%-3s", slevel)
				+ String.format("%15s", word) + "  " + meaning; //-3 왼 정렬.
		return str; 
	}
}
