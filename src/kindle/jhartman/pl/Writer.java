package kindle.jhartman.pl;

import java.io.FileNotFoundException;
import java.io.PrintWriter; 

public class Writer {
	private AmazonParser parser;
	private PrintWriter file;
	
	private void Open(String filename, String extension) {
		
		if(filename.contains(".")) {
			filename = filename.substring(0, filename.lastIndexOf('.'));
		}
		filename = filename + "." + extension;
		
		System.out.println("Saving " + filename);
		
		try {
			file = new PrintWriter(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private void Close() {
		file.close();
	}
	
	public Writer(AmazonParser parser) {
		this.parser = parser;
	}
	
	public void asXML(String filename) {
		Open(filename, "xml");
		
		if((file == null) || (parser == null)) {
			System.out.println("File not open or source not parsed");
		}
		
		for(int i=0; i<parser.size(); i++) {
			file.println("<book>");			
			file.println("    <title>" + parser.getTitle(i) + "</title>");
			file.println("    <author>" + parser.getAuthor(i) + "</author>");	
			file.println("    <date>" + parser.getDate(i) + "</date>");	
			file.println("</book>");				
		}
		
		Close();
	}
	
	public void asCSV(String filename) {
		Open(filename, "txt");
		
		if((file == null) || (parser == null)) {
			System.out.println("File not open or source not parsed");
		}
		
		for(int i=0; i<parser.size(); i++) {
			file.println(parser.getTitle(i) + "\t" + parser.getAuthor(i) + "\t" +parser.getDate(i));
		}
		
		Close();
	}	
	
	public void asHTML(String filename) {
		Open(filename, "html");
		
		if((file == null) || (parser == null)) {
			System.out.println("File not open or source not parsed");
		}
		
		file.println("");
		file.println("<!DOCTYPE html>");
		file.println("<html>");
		file.println("    <head>");
		file.println("        <meta http-equiv=\"Content-Type\" content=\"text/html;charset=UTF-8\"/>");
		file.println("        <title>Amazon books</title>");
		file.println("        <style>");
		file.println("table {");
		file.println("    border-collapse: collapse;");
		file.println("}");
		file.println("table, th, td {");
		file.println("    border: 1px solid black;");
		file.println("}");
		file.println("</style>");
		file.println("    </head>");
		file.println("");
		file.println("    <body>");
		file.println("        <table>");
		file.println("            <tr>");
		file.println("                <th>Title</th>");
		file.println("                <th>Author</v>");
		file.println("                <th>Date</v>");
		file.println("            </tr>");
		
		
		for(int i=0; i<parser.size(); i++) {
			
			file.println("            <tr>");
			file.println("                <td>" + parser.getTitle(i) + "</td>");
			file.println("                <td>" + parser.getAuthor(i) + "</td>");
			file.println("                <td>" + parser.getDate(i) + "</td>");
			file.println("            </tr>");
		}
		
		file.println("        </table>");
		file.println("    </body>");
		file.println("</html>");
		
		Close();
	}		
	
}
