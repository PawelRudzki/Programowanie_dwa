package day_three;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;

public class SAXParserExercise extends DefaultHandler {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        DefaultHandler handler = new DefaultHandler() {
            //            boolean baccount = false;
            boolean bname = false;
            boolean bcurrency = false;
            boolean bbalance = false;
            boolean bclosingdate = false;

            public void startElement(String uri, String localName, String qName,
                                     Attributes attributes) throws SAXException {


                int attributeLength = attributes.getLength();
                if ("account".equals(qName)) {
                    for (int i = 0; i < attributeLength; i++) {
                        // Get attribute names and values
                        String attrName = attributes.getQName(i);
                        String attrVal = attributes.getValue(i);
                        System.out.println(attrName + " = " + attrVal);
                    }
                }

                if (qName.equalsIgnoreCase("name")) {
                    bname = true;
                }
                if (qName.equalsIgnoreCase("currency")) {
                    bcurrency = true;
                }
                if (qName.equalsIgnoreCase("balance")) {
                    bbalance = true;
                }
                if (qName.equalsIgnoreCase("closingDate")) {
                    bclosingdate = true;
                }
            }

            public void endElement(String uri, String localName, String qName,
                                   Attributes attributes) throws SAXException {

            }

            public void characters(char ch[], int start, int length) throws SAXException {


                if (bname) {
                    System.out.println("name: " + new String(ch, start, length));
                    bname = false;
                }
                if (bcurrency) {
                    System.out.println("currency: " + new String(ch, start, length));
                    bcurrency = false;
                }
                if (bbalance) {
                    System.out.println("balance: " + new String(ch, start, length));
                    bbalance = false;
                }
                if (bclosingdate) {
                    System.out.println("closingDate: " + new String(ch, start, length));
                    bclosingdate = false;
                }
//                if(baccount) {
//                    System.out.println("iban :"+ new String(a));
//                }


            }
        };

        saxParser.parse("interviewTask.xml", handler);


    }
}
