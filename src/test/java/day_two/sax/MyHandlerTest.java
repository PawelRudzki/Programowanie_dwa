package day_two.sax;

import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class MyHandlerTest {

    @Test
    public void myHandlerTest() throws ParserConfigurationException, SAXException, IOException {

        //given
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        MyHandler myHandler = new MyHandler();


        //when
        saxParser.parse(new File("InterviewTask.xml"), myHandler);
        List<Account> accountList = myHandler.getAccountList();

        for (Account account : accountList) {
            System.out.println(account);
        }


        //then
        assertNotNull(accountList.get(0));
        assertEquals(7, accountList.size());

    }

}