package dailyWork1;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		
		//입력받은 keyword를 이용해서 책의 제목과 저자를 출력하는데
		//만약 comment가 존재하면 같이 출력
		
		System.out.print("키워드를 입력하세요 ==> ");
		Scanner s = new Scanner(System.in);
		String keyword = s.nextLine(); //공백포함해서 한 라인을 받음  next()는 공백에서 끊김(단어)
		
		//config 파일에 대한 경로를 문자열로 저장
		String config = "classpath:applicationCtx_dailyWork1.xml";
		
		//spring container
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
		
		BookService service = ctx.getBean("bookService", BookService.class);
		ArrayList<BookEntity> blist = service.getListByKeyword(keyword);
		ArrayList<CommentEntity> clist = null;
		
		
		for(BookEntity entity : blist){
			System.out.println(entity.getBtitle() + " : " + entity.getBauthor());
			clist = service.getCommentList(entity.getBisbn());
			
			for(CommentEntity entity2 : clist){
				System.out.println("===> " + entity2.getRcontent());
			}
			
			System.out.print("\n");
		}
		
		ctx.close();
		s.close();
		
	}

}
