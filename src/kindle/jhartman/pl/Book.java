package kindle.jhartman.pl;

public class Book {
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getDate() {
		return date;
	}

	private String title;
	private String author;
	private String date;
	
	public Book(String t, String a, String d) {
		this.title = t;
		this.author = a;
		this.date = d;
	}
}
