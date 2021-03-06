package job_interview_task;

import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class MyStreamWriterTest {

    @Test
    public void myWriterTest() throws ParserConfigurationException,
            SAXException, IOException, XMLStreamException, TransformerException {

        //given
        MyHandler myHandler = new MyHandler();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        saxParser.parse(new File("InterviewTask.xml"), myHandler);

        MyStreamWriter myWriter = new MyStreamWriter();

        List<Account> accountList = myHandler.getAccountList();
        TaskExecutioner taskExecutioner = new TaskExecutioner();


        //when
        myWriter.write(taskExecutioner.doTheTask(accountList));

        //then
        assertNotNull(accountList.get(0));
        assertEquals(3, taskExecutioner.doTheTask(accountList).size());
    }

}