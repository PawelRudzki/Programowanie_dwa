package school;

import day_two.school.SchoolsStudent;
import day_two.school.Student;
import org.junit.Test;

import static org.junit.Assert.*;

public class SchoolsStudentTest {

    @Test
    public void setSchoolsStudentTest() {

        //given

        String pesel = "89022601053";
        String name = "Piotr";
        String lastName = "Bulwka";
        String school = "III Elementary School in Krasnystaw";


        SchoolsStudent schoolsStudent = new SchoolsStudent(new Student(name, lastName, pesel), school);

        //when
        schoolsStudent.setPesel(pesel);
        schoolsStudent.setName(name);
        schoolsStudent.setLastName(lastName);
        schoolsStudent.setSchool(school);


        //then
        assertEquals("89022601053", schoolsStudent.getPesel());
        assertEquals("Piotr", schoolsStudent.getName());
        assertEquals("Bulwka", schoolsStudent.getLastName());
        assertEquals("III Elementary School in Krasnystaw", schoolsStudent.getSchool());
    }

    @Test
    public void SchoolStudentConstructorTest(){

        //given
        String pesel = "89022601053";
        String name = "Piotr";
        String lastName = "Bulwka";
        String school = "III Elementary School in Krasnystaw";

        Student student = new Student(name, lastName, pesel);

        SchoolsStudent schoolsStudent = new SchoolsStudent(student, school);

        //then
        assertEquals("Piotr", schoolsStudent.getName());
        assertEquals("Bulwka", schoolsStudent.getLastName());
        assertEquals("89022601053", schoolsStudent.getPesel());
        assertEquals("III Elementary School in Krasnystaw", schoolsStudent.getSchool());
    }

    @Test(expected = IllegalArgumentException.class)
    public void SchoolsStudentConstructorTest2(){

        //given
        String pesel = "89022676";
        String name = "Piotr";
        String lastName = "Bulwka";
        String school = "III Elementary School in Krasnystaw";

        Student student = new Student(name, lastName, pesel);


        SchoolsStudent schoolsStudent = new SchoolsStudent(student, school);


        //then
        assertFalse(true);
    }
}