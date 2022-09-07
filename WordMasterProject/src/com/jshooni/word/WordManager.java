package com.jshooni.word;

import java.util.Scanner;

//WordCRUD를 이용해서 구현하는 CRUD기능을 구현하는 전체적인 관리역할. 
public class WordManager {
	//멤버변수 정의하자 -> import 해야지 에러가 안남.
	Scanner s = new Scanner(System.in);
	WordCRUD wordCRUD;
	//WordCRUD 따로 있기 때문에 멤버 변수를 하나 생성해줘야함. 
	WordManager(){
		wordCRUD = new WordCRUD(s); //Scanner의 파라미터 s 넣어주기.
	}
	public int selectMenu() {
		System.out.print("*** 영단어 마스터 ***\n"
				+ "******************\n"
				+ "1. 모든 단어 보기\n"
				+ "2. 수준별 단어 보기\n"
				+ "3. 단어 검색\n"
				+ "4. 단어 추가\n"
				+ "5. 단어 수정\n"
				+ "6. 단어 삭제\n" 
				+ "7. 파일 저장\n"
				+ "******************\n"
				+ "=> 원하는 메뉴는? " );
		
		return s.nextInt();
	}
	public void start() {
		while(true) {
			int menu = selectMenu();
			if(menu == 0) {
				System.out.println("\n프로그램 종료! 다음에 만나요~");
				break; 
			}
			if(menu == 4) {
				//create
				wordCRUD.addWord();
			}
			else if(menu == 1){
				//list
				wordCRUD.listAll();
			}
		}
	}
}
