package school;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void peselTestValid() {

        //given
        String pesel = "89022601053";
        String name = "Piotr";
        String lastName = "Bulwka";
        Student student = new Student(name, lastName, pesel);


        //when
        student.setName(name);
        student.setLastName(lastName);
        student.setPesel(pesel);

        //then
        assertNotNull(student.getPesel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void peselTestNotValid() {

        //given
        String pesel = "890226010";
        String name = "Piotr";
        String lastName = "Bulwka";
        Student student = new Student(name, lastName, pesel);


        //when
        student.setName(name);
        student.setLastName(lastName);
        student.setPesel(pesel);

        //then

        assertFalse(true);
        // asercja tutaj nie będzie uruchomiona
        // bo wcześniej dostanie oczekiwany wyjątek IllegalArgumentException
        //jednak zabezpieczamy się, że jeśli mimo wszystko dojdzie do tej linii
        //wykrzaczy test
    }

    @Test
    public void ConstructorTestValidPesel() {

        //given
        String pesel = "89022601053";
        String name = "Piotr";
        String lastName = "Bulwka";

        //when
        Student student = new Student(name, lastName, pesel);

        //then
        assertEquals("Piotr", student.getName());
        assertEquals("Bulwka", student.getLastName());
        assertEquals("89022601053", student.getPesel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ConstructorTestNotValidPesel() {

        //given
        String pesel = "89022";
        String name = "Piotr";
        String lastName = "Bulwka";

        //when
        Student student = new Student(name, lastName, pesel);

        //then
        assertFalse(true);
    }

}