package dailyWork1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class BookDAO {

	//Database 처리만 나옴
	public ArrayList<BookEntity> selectAll(String keyword) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BookEntity> list = null;
		
		try {
			//1. Driver Loading
			Class.forName("com.mysql.jdbc.Driver");
			//2. 데이터베이스 접속
			String url = "jdbc:mysql://localhost:3306/library";
			String id = "jQuery";
			String pw = "jQuery";
			con = DriverManager.getConnection(url,id,pw);
			//3. PreparedStatement 생성 (SQL을 가지고 있음)
			String sql = "select bisbn, btitle, bauthor from book where btitle like ?"; //키워드로 책 불러오기
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			//4. Query 실행
			rs = pstmt.executeQuery();// 데이타를 얻어옴
			//5. 결과 처리
			//Database에서 들고온 데이터를 ArrayList<BookEntity> 형태로 생성
			list = new ArrayList<BookEntity>();
			while(rs.next()){
				BookEntity entity = new BookEntity();
				entity.setBisbn(rs.getString("bisbn"));
				entity.setBtitle(rs.getString("btitle"));
				entity.setBauthor(rs.getString("bauthor"));
				//entity.setRcontent(rs.getString("r.rcontent"));
				
				list.add(entity);	
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			//6. 사용한 resource 해제
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
		
			}
			
		}
		return list;
	}

	public ArrayList<CommentEntity> selectComment(String keyword) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<CommentEntity> list = null;
		
		try {
			//1. Driver Loading
			Class.forName("com.mysql.jdbc.Driver");
			//2. 데이터베이스 접속
			String url = "jdbc:mysql://localhost:3306/library";
			String id = "jQuery";
			String pw = "jQuery";
			con = DriverManager.getConnection(url,id,pw);
			//3. PreparedStatement 생성 (SQL을 가지고 있음)
			String sql = "select rcontent from review where bisbn like ?"; //키워드로 책 불러오기
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			//4. Query 실행
			rs = pstmt.executeQuery();// 데이타를 얻어옴
			//5. 결과 처리
			//Database에서 들고온 데이터를 ArrayList<BookEntity> 형태로 생성
			list = new ArrayList<CommentEntity>();
			while(rs.next()){
				CommentEntity entity = new CommentEntity();
				
				entity.setRcontent(rs.getString("rcontent"));
				
				list.add(entity);	
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			//6. 사용한 resource 해제
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e2) {
		
			}
			
		}
		return list;
		
	}

}
