package school;

import day_two.school.ClassStudent;
import day_two.school.SchoolsStudent;
import day_two.school.Student;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassStudentTest {

    @Test
    public void setClassStudentTest(){

        //given
        String pesel = "89022601053";
        String name = "Piotr";
        String lastName = "Bulwka";
        String school = "III Elementary School in Krasnystaw";
        int classofStudent = 5;

        Student student = new Student(name, lastName, pesel);

        ClassStudent classStudent = new ClassStudent(
                new SchoolsStudent(student, school)
                ,classofStudent);


        //when
        classStudent.setPesel(pesel);
        classStudent.setName(name);
        classStudent.setLastName(lastName);
        classStudent.setSchool(school);
        classStudent.setClassOfStudent(classofStudent);

        //then
        assertEquals("89022601053", classStudent.getPesel());
        assertEquals("Piotr", classStudent.getName());
        assertEquals("Bulwka", classStudent.getLastName());
        assertEquals("III Elementary School in Krasnystaw", classStudent.getSchool());
        assertEquals(5, classStudent.getClassOfStudent());

    }

    @Test
    public void ClassStudentConstructorTest(){

        //given
        String pesel = "89022601053";
        String name = "Piotr";
        String lastName = "Bulwka";
        String school = "III Elementary School in Krasnystaw";
        int classofStudent = 5;

        Student student = new Student(name, lastName, pesel);

        ClassStudent classStudent = new ClassStudent(
                new SchoolsStudent(student, school)
                ,classofStudent);

        //then
        assertEquals("Piotr", classStudent.getName());
        assertEquals("Bulwka", classStudent.getLastName());
        assertEquals("89022601053", classStudent.getPesel());
        assertEquals("III Elementary School in Krasnystaw", classStudent.getSchool());
    }

    @Test(expected = IllegalArgumentException.class)
    public void ClassStudentConstructorTest2(){

        //given
        String pesel = "89022676";
        String name = "Piotr";
        String lastName = "Bulwka";
        String school = "III Elementary School in Krasnystaw";
        int classofStudent = 5;

        Student student = new Student(name, lastName, pesel);

        ClassStudent classStudent = new ClassStudent(
                new SchoolsStudent(student, school)
                ,classofStudent);

        //then
        assertFalse(true);
    }

}