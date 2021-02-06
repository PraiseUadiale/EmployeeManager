package Evolute.io.ManagerEmployee.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
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
    @Column(nullable = false, updatable = false)
    private Long ID;
    private String fullName;
    private String email;
    private String jobTitle;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String employeeCode;

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
