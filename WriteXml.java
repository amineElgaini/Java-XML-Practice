import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import java.io.File;

public class WriteXml {
    public static void main(String[] args) throws Exception {
        // 1. Create an empty document
        Document doc = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .newDocument();

        // 2. Create the root element
        Element library = doc.createElement("library");
        doc.appendChild(library);

        // 3. Create a book
        Element book = doc.createElement("book");
        book.setAttribute("id", "3");
        library.appendChild(book);

        Element title = doc.createElement("title");
        title.setTextContent("Head First Java");
        book.appendChild(title);

        Element author = doc.createElement("author");
        author.setTextContent("Kathy Sierra");
        book.appendChild(author);

        // 4. Write the tree to a file
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(doc), new StreamResult(new File("newbooks.xml")));

        System.out.println("File created: newbooks.xml");
    }
}
