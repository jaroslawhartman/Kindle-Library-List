/**
 * 
 */
package kindle.jhartman.pl;

/**
 * @author jhartman
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Amazon book list extractor");
		
		if(args.length == 0) {
			System.out.println("Missing input filename");
			System.out.println("java -jar Kindle.jar <amazon html filename>");
			System.exit(0);
		}
		
		String filename = args[0];

		AmazonParser parser = new AmazonParser(filename);
		
		System.out.println("Elements found:" + parser.size());
		
		Writer writer = new Writer(parser);
		
		writer.asHTML(filename);
		writer.asCSV(filename);
		writer.asXML(filename);
		
		System.out.println("Done!");
	}
}
