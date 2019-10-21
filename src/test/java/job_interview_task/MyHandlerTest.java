package job_interview_task;

import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;

import java.io.File;
import java.io.IOException;

import java.util.List;

import static org.junit.Assert.*;

public class MyHandlerTest {

    @Test
    public void myHandlerTest() throws ParserConfigurationException,
            SAXException, IOException {

        //given
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        MyHandler myHandler = new MyHandler();

        //when
        saxParser.parse(new File("InterviewTask.xml"), myHandler);
        List<Account> accountList = myHandler.getAccountList();

        //then
        assertNotNull(accountList.get(0));
        assertEquals(7, accountList.size());

    }

    @Test
    public void myHandlerTaskTest() throws ParserConfigurationException,
            SAXException, IOException, XMLStreamException {

        //given
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        MyHandler myHandler = new MyHandler();
        saxParser.parse(new File("InterviewTask.xml"), myHandler);
        MyStreamWriter myWriter = new MyStreamWriter();

        //when
        List<Account> accountList = myHandler.getAccountList();
        myWriter.write(accountList);

        //display list, to be sure what it contains
        for (Account account : accountList) {
            System.out.println(account);
        }

        //then
        assertNotNull(accountList.get(0));
        assertEquals(7, accountList.size());
    }
}