package dailyWork1;

import java.util.ArrayList;

public class BookService {

	
	private BookDAO dao;
		

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


	public ArrayList<BookEntity> getListByKeyword(String keyword) {
		
		//DAO method 호출 => 결과 받아서 return
		return dao.selectAll(keyword);
	}

	public ArrayList<CommentEntity> getCommentList(String keyword) {
		
		return dao.selectComment(keyword);
	}

	
}
