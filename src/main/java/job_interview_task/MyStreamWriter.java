package job_interview_task;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.List;

public class MyStreamWriter {

    public void write(List<Account> accountList) throws XMLStreamException, FileNotFoundException {

        OutputStream os = new FileOutputStream(new File("xml_writer_output.xml"));
        XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
        XMLStreamWriter streamWriter = outputFactory.createXMLStreamWriter(os, "utf-8");


        streamWriter.writeStartDocument("1.0");
        streamWriter.writeStartElement("accounts");

        for (Account account : accountList) {

            streamWriter.writeStartElement("account");
            streamWriter.writeAttribute("iban", account.getIban());

            streamWriter.writeStartElement("name");
            streamWriter.writeCharacters(account.getName());
            streamWriter.writeEndElement();

            streamWriter.writeStartElement("currency");
            streamWriter.writeCharacters(account.getCurrency());
            streamWriter.writeEndElement();

            streamWriter.writeStartElement("balance");
            streamWriter.writeCharacters(account.getBalance());
            streamWriter.writeEndElement();

            streamWriter.writeStartElement("closingDate");
            streamWriter.writeCharacters(account.getClosingDate());
            streamWriter.writeEndElement();

            streamWriter.writeEndElement();
        }

        streamWriter.writeEndElement();
        streamWriter.writeEndDocument();

        streamWriter.close();
    }

    public MyStreamWriter() throws FileNotFoundException, XMLStreamException {
    }

}
