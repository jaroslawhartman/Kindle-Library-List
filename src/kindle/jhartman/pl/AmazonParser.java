/**
 * 
 */
package kindle.jhartman.pl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.*;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;



/**
 * @author jhartman
 *
 */
public class AmazonParser {
	private ArrayList<Book> list = new ArrayList<Book>(); 
	
	public String getTitle(int index) {
		return list.get(index).getTitle();
	}
	
	public String getAuthor(int index) {
		return list.get(index).getAuthor();
	}
	
	public String getDate(int index) {
		return list.get(index).getDate();
	}
	
	public int size() {
		return list.size();
	}
	
	public AmazonParser(String fileName) {
		
		File input = new File(fileName);
		
		Document doc = null;
		
		try {
			doc = Jsoup.parse(input, "UTF-8", "http://amazon.com");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Elements titles = doc.select("#title4");
		
		Elements titles  = doc.select("div[id^=title]");
		Elements authors = doc.select("div[id^=author]");
		Elements dates   = doc.select("div[id^=date]");
		
		for(int i=0; i<titles.size(); i++) {
			Book Book = new Book(titles.get(i).text(), 
								 authors.get(i).text(),
								 dates.get(i).text());
			
			list.add(Book);
		}
	}
}
