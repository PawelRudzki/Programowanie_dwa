//package sax;
//
//import javax.xml.stream.XMLOutputFactory;
//import javax.xml.stream.XMLStreamException;
//import javax.xml.stream.XMLStreamWriter;
//import java.io.File;
//import java.io.IOException;
//import java.io.OutputStream;
//import java.io.OutputStreamWriter;
//
//public class XmlWriter {
//
//    XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
//    XMLStreamWriter streamWriter;
//
//    public XmlWriter() throws XMLStreamException {
//        streamWriter = outputFactory.createXMLStreamWriter(new OutputStream() {
//            @Override
//            public void write(int b) throws IOException {
//            }
//        });
//
//
//        streamWriter.writeStartDocument("utf-8", "1.0");
//        streamWriter.writeStartElement("accounts");
//
//        streamWriter.writeEndElement();
//
//    }
//
//}
