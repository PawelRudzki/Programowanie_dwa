package day_two.school;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClassStudent extends SchoolsStudent {

     private int classOfStudent;

     public ClassStudent(SchoolsStudent schoolsStudent, int classOfStudent){
         super();
         this.setName(schoolsStudent.getName());
         this.setLastName(schoolsStudent.getLastName());
         this.setPesel(schoolsStudent.getPesel());
         this.setSchool(schoolsStudent.getSchool());
     }
}
