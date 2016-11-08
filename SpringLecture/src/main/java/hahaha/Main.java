package hahaha;

public class Main {

	public static void main(String[] args) {
		
		//IS-A관계 (is-a relationship)
		//정의 : subclass is a superclass 
		//역관계는 성립하지 않음. superclass is a subclass(X)
		//포유류 - 고래
		//subclass의 type을 써야 하는 곳에 superclass의 type을 쓸 수 있음
		
		Student a = new Student();
		Person b = new Student();
		Object c = new Student();
		
	}

}
