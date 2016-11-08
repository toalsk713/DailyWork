	package exam_02_beans_xml_tag;
	
	import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
	import org.springframework.context.support.GenericXmlApplicationContext;
	
	public class Main {
	
		public static void main(String[] args) {
			
			String config = "classpath:applicationCtx_beans_xml_tag.xml";
			
			//위 xml로 spring container(IOC container) 생성
			AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
			
			BookShelf shelf = ctx.getBean("bookshelf", BookShelf.class);
			
			System.out.println("책장이름 : " + shelf.getShelfName());
			System.out.println("책장가격 : " + shelf.getShelfPrice());
			for(BookEntity entity : shelf.getList()){
				System.out.println(entity.getBtitle() + " : " + entity.getBauthor());
			}
			
			Set<Integer> keyset = shelf.getMap().keySet(); //책자안의 hash맵의 키값안 뽑아서 set에 저장
			for(Integer i : keyset){
				System.out.println(shelf.getMap().get(i).getBtitle());
			}
			
			
		}
	
	}
