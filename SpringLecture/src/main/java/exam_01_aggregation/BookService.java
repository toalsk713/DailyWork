package exam_01_aggregation;

import java.util.ArrayList;

public class BookService {

	private DAO dao;
	
	public BookService(DAO dao){
		this.dao = dao;
	}
	//Business Logic을 처리하는 method
	public ArrayList<BookEntity> getListByKeyword(String keyword){
		
		
		ArrayList<BookEntity> list = dao.selectAll(keyword);
		return list;
		
		
	}
}
