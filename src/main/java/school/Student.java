package school;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pesel.PeselValidator;

@Setter
@Getter
@NoArgsConstructor
public class Student {

    private String name;
    private String lastName;
    private String pesel;

    public void setPesel(String pesel) {
        PeselValidator peselValidator = new PeselValidator();
        if (peselValidator.validate(pesel)) {
            this.pesel = pesel;
        } else {
            throw new IllegalArgumentException("Not valid pesel number");
        }


    }

    public Student(String name, String lastName, String pesel){
        this.name=name;
        this.lastName=lastName;
        //korzystamy z settera, aby zapewnić walidację peselu
        this.setPesel(pesel);
    }


}
