package phone_book;

import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    public static void main(String[] args) {
        Map<PhoneNumber, Entry> phoneBook = new TreeMap();

        Person person1 = new Person("Joanna",
                "Gryzioł",
                "Koniuszki 4, 45-876 Kardzewo",
                new PhoneNumber("54","5647687"));

        Person person2 = new Person("Damian",
                "Smardzewski",
                "Koniuszki 5, 45-876 Kardzewo",
                new PhoneNumber("54","5647686"));

        Person person3 = new Person("Piotr",
                "Kordaszewiczewski",
                "Polana 34, 54-006 Supliki",
                new PhoneNumber("32","6667654"));

        phoneBook.put(person1.getPhoneNumber(), person1);
        phoneBook.put(person2.getPhoneNumber(), person2);
        phoneBook.put(person3.getPhoneNumber(), person3);

        Company company1 = new Company("PolDariuszEx",
                "Wysokie 3, 24-899 Maciejowice",
                new PhoneNumber("82", "5550987"));

        Company company2 = new Company("PPHU Grażyna i Florian Graca",
                "Wysokie 89, 24-899 Maciejowice",
                new PhoneNumber("83", "5768990"));

        phoneBook.put(company1.getPhoneNumber(), company1);
        phoneBook.put(company2.getPhoneNumber(), company2);

        phoneBook.entrySet().forEach(a -> {
            System.out.print(a.getKey());
            System.out.print(a.getValue()+"\n");
        });
    }
}
