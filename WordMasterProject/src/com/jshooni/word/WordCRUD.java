package com.jshooni.word;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//주석을 아무거나 쳐보자. 
import java.util.ArrayList;
import java.util.Scanner;

//ICRUD를 구현하는 구현체
public class WordCRUD implements ICRUD{

	// 여러 단어를 관리해야하기 때문에, 동적인 데이터를 관리할 수 있는 class가 필욯다. --> 여기서는 array list를 사용. 
	ArrayList<Word> list; 
	Scanner s; //사용자에게 입력받기 위해! 
	
	
	/*
	 * => 난이도(1,2,3) & 새 단어 입력 : 1 driveway
	 * 뜻 입력 : 차고 진입로
	 * 새 단어가 단어장에 추가되었습니다.
	 */
	
	final String fname = "Dictionary.txt";
	
	//ArrayList의 새로운 배열은 WordCRUD라는 생성자를 만들 때 객체화 하도록 만들자. 
	WordCRUD(Scanner s){
		list = new ArrayList<>();
		this.s = s;//생성자의 입력 파라미터를 통해서 가져올 수 있도록. 
	}
	
	
	@Override
	//사용자에게 입력받는 부분을 구현.
	public Object add() {
		System.out.print("=> 난이도(1,2,3) & 새 단어 입력 : ");
		int level = s.nextInt();
		String word = s.nextLine();
		
		//1 driveway
		System.out.print("뜻 입력 : ");
		String meaning = s.nextLine();
		//차고 진입
		return new Word(0, level, word, meaning);
	}

	public void addItem() {//입력받은 데이터를 리스트에 추가하는 부분.
		Word one = (Word)add(); //리스트에 추가하기 위해서 Word 라는 클래스에 객체를 하나 생성해주고. 
		//add라는 함수를 통해서 만들어주고, add가 리턴타입의 오브젝트이기 때문에, Word로 케스팅해줘야한다. 
		list.add(one);
		System.out.println("새 단어가 단어장에 추가되었습니다. \n");
	}
	
	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void selectOne(int id) {
		// TODO Auto-generated method stub
		
	}
	/*
	 * => 원하는 메뉴는? 1
	 * ------------------------------
	 * 1 *** superintendent   관리자, 감독관
	 * 2 *         electric   전기의, 전기를 생산하는
	 * 3 **       equipment   장비, 용품
	 * 
	 * */
	public void listAll() {
		System.out.println("--------------------------");
		for(int i=0; i<list.size(); i++) {
			System.out.print((i+1) + " ");
			System.out.println(list.get(i).toString());
			
		}
		System.out.println("--------------------------");
	}
	
	public ArrayList<Integer> listAll(String keyword) {
		
		ArrayList<Integer> idlist = new ArrayList<>();
		int j=0; 
				
		System.out.println("--------------------------");
		for(int i=0; i<list.size(); i++) {
			String word = list.get(i).getWord();
			if(!word.contains(keyword)) continue;
			System.out.print((j+1) + " ");
			System.out.println(list.get(i).toString());
			idlist.add(i);
			j++;
			
		}
		System.out.println("--------------------------");
		return idlist;
	}
	


	public void updateItem() {
		// TODO Auto-generated method stub
		System.out.print("=> 수정할 단어 검색 : ");
		String keyword = s.next();
		ArrayList<Integer> idlist = this.listAll(keyword);
		System.out.print("=> 수정할 번호 선택 : ");
		int id = s.nextInt();
		s.nextLine();
		
		System.out.print("=> 뜻 입력 : ");
		String meaning = s.nextLine();
		Word word = list.get(idlist.get(id-1));
		word.setMeaning(meaning);
		System.out.println("단어가 수정되었습니다. ");
		
		
	}


	public void deleteItem() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.print("=> 삭제할 단어 검색 : ");
		String keyword = s.next();
		ArrayList<Integer> idlist = this.listAll(keyword);
		System.out.print("=> 삭제할 번호 선택 : ");
		int id = s.nextInt();
		s.nextLine();
		
		System.out.print("=> 정말로 삭제하실래요? (Y/n)");
		String ans = s.next();
		if(ans.equalsIgnoreCase("y")) {
			list.remove((int)idlist.get(id-1));
			//remove라는 함수 객체를 넣든지. 파라미터로. 정수로 몇번째 인덱스의 객체를 삭제할 것인지 넣어주게되어있음.
			//그래서 정수형으로 인덱스를 바꿔줘야함. 
			System.out.println("단어가 삭제되었습니다. ");
		}
		else 
			System.out.println("취소되었습니다. ");
		

	}
	
	public void loadFile() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("fname"));
			String line; 
			int count =0; 
			
			while(true) {
				line =  br.readLine();
				if(line == null) break; 
				
				String data[] = line.split("\\|");
				int level = Integer.parseInt(data[0]);
				String word = data[1];
				String meaning = data[2]; 
				list.add(new Word(0, level, word, meaning));
				
			}
			
			br.close(); 
			System.out.println("==>" + count + "개 로딩 완료!!!");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
 
	
}
