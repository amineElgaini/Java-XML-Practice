import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import java.io.File;

public class ReadXml {
    public static void main(String[] args) throws Exception {
        Document doc = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(new File("books.xml"));

        NodeList books = doc.getElementsByTagName("book");

        for (int i = 0; i < books.getLength(); i++) {
            Element book = (Element) books.item(i);
            String id = book.getAttribute("id");
            String title = book.getElementsByTagName("title").item(0).getTextContent();
            String author = book.getElementsByTagName("author").item(0).getTextContent();
            System.out.println(id + " - " + title + " by " + author);
        }
    }
}
