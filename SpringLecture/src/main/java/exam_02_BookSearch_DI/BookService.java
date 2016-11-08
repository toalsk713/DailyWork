package exam_02_BookSearch_DI;

import java.util.ArrayList;

public class BookService {

	
	private BookDAO dao;
	private String keyword;
		

	public BookService(){
		//default constructor는 무조건 만들어 주는게 좋음
		
	}
	
	public BookService(BookDAO dao){
		this.dao = dao;
	}
	
	/////////////////////////////////////////////////
	
	public BookDAO getDao() {
		return dao;
	}
	
	public void setDao(BookDAO dao) {
		this.dao = dao;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public ArrayList<BookEntity> getListByKeyword() {
		
		//DAO method 호출 => 결과 받아서 return
		return dao.selectAll(keyword);
	}

	
}
