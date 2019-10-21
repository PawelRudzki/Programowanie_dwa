package job_interview_task;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class MyDomWriter {

    public void write(List<Account> accountList) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        Element root = document.createElement("accounts");
        document.appendChild(root);

        for (Account currentAccount : accountList) {
            Element account = document.createElement("account");
            root.appendChild(account);

            Attr attr = document.createAttribute("iban");
            attr.setValue(currentAccount.getIban());
            account.setAttributeNode(attr);

            Element name = document.createElement("name");
            name.appendChild(document.createTextNode(currentAccount.getName()));
            account.appendChild(name);

            Element currency = document.createElement("currency");
            currency.appendChild(document.createTextNode(currentAccount.getCurrency()));
            account.appendChild(currency);

            Element balance = document.createElement("balance");
            balance.appendChild(document.createTextNode(currentAccount.getBalance()));
            account.appendChild(balance);

            Element closingDate = document.createElement("closingDate");
            closingDate.appendChild(document.createTextNode(currentAccount.getClosingDate()));
            account.appendChild(closingDate);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("xml_dom_output.xml"));

        transformer.transform(domSource, streamResult);
    }
}
