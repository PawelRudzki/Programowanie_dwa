package day_two.sax;

import lombok.Getter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyHandler extends DefaultHandler {

    @Getter
    List<Account> accountList = null;
    Account tmpAccount = null;

    boolean bname = false;
    boolean bcurrency = false;
    boolean bbalance = false;
    boolean bclosingDate = false;

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {


        if ("account".equals(qName)) {
            String iban = attributes.getValue("iban");
            tmpAccount = new Account();
            tmpAccount.setIban(iban);
            tmpAccount.setName(" ");
        }

        if (accountList == null) {
            accountList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("name")) {
            bname = true;
        } else if (qName.equalsIgnoreCase("currency")) {
            bcurrency = true;
        } else if (qName.equalsIgnoreCase("balance")) {
            bbalance = true;
        } else if (qName.equalsIgnoreCase("closingDate")) {
            bclosingDate = true;
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("account")) {
            accountList.add(tmpAccount);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {

        if (bname) {
            tmpAccount.setName(String.valueOf(ch, start, length));
            bname = false;
        }
        if (bcurrency) {
            tmpAccount.setCurrency(String.valueOf(ch, start, length));
            bcurrency = false;
        }
        if (bbalance) {
            tmpAccount.setBalance(String.valueOf(ch, start, length));
            bbalance = false;
        }
        if (bclosingDate) {
            tmpAccount.setClosingDate(String.valueOf(ch, start, length));
            bclosingDate = false;
        }
    }
}
