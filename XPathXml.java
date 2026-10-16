import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.*;
import java.io.File;

public class XPathXml {
    public static void main(String[] args) throws Exception {
        Document doc = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(new File("books.xml"));

        XPath xpath = XPathFactory.newInstance().newXPath();

        // 1. Get one text value
        String title = (String) xpath.evaluate("//book[@id='2']/title", doc, XPathConstants.STRING);
        System.out.println("Book 2 title: " + title);

        // 2. Get many elements
        NodeList authors = (NodeList) xpath.evaluate("//author", doc, XPathConstants.NODESET);
        for (int i = 0; i < authors.getLength(); i++) {
            System.out.println("Author: " + authors.item(i).getTextContent());
        }

        // 3. Count elements
        Double count = (Double) xpath.evaluate("count(//book)", doc, XPathConstants.NUMBER);
        System.out.println("Total books: " + count.intValue());
    }
}
