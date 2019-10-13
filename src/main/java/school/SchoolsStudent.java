package school;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SchoolsStudent extends Student {

    private String school;

    public SchoolsStudent(Student student, String school) {
        super(student.getName(), student.getLastName(), student.getPesel());
        this.setSchool(school);

    }


}
