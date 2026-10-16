import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class ValidateXml {
    public static void main(String[] args) throws Exception {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new File("books.xsd"));
        Validator validator = schema.newValidator();

        try {
            validator.validate(new StreamSource(new File("books.xml")));
            System.out.println("books.xml is VALID");
        } catch (Exception e) {
            System.out.println("books.xml is NOT valid: " + e.getMessage());
        }
    }
}
