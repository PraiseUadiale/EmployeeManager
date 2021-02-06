package Evolute.io.ManagerEmployee.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Employee {
    /*Employee Class
     * Class would model to database*/
    @Id

    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence")
    private Long ID;
    private String fullName;
    private String email;
    private String jobTitle;
    private String imageUrl;

    public Employee(String fullName,
                    String email,
                    String jobTitle,
                    String imageUrl) {
        this.fullName = fullName;
        this.email = email;
        this.jobTitle = jobTitle;
        this.imageUrl = imageUrl;
    }
}
