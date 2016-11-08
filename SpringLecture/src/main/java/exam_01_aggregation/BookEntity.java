package exam_01_aggregation;

//DTO (데이터 전달 객체)를 만들 수 있는 class
//Database를 근간으로 해서 만들어용
public class BookEntity {
	
	private String bisbn;
	private String btitle;
	private String bauthor;
	private int price;

	public BookEntity(){
		
	}

	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
