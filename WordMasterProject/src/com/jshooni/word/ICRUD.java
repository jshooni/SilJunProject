package com.jshooni.word;

public interface ICRUD {
	public Object add(); 		// 데이터 추가
	//--> 단어를 추가했을 때, 해당 추가된 객체를 리턴하기 위해서 Object 타입을 넣어줌. 
	public int update(Object obj); // 데이터 수정.
	public int delete(Object obj); // 데이터 삭제.
	public void selectOne(int id); // 데이터 1개 조회할 때 사용.
	
	
}
