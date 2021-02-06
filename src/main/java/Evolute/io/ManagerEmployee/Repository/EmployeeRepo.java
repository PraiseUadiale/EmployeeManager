package Evolute.io.ManagerEmployee.Repository;

import Evolute.io.ManagerEmployee.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    /*Database repository for querying database
    JPA does a lot of the abstraction needeed*/
    /*Spring is going to created a query to match the name of this method
     * saves us having to write out the query*/
    void deleteEmployeeByID(Long id);


    Optional<Employee> findByEmployeeById(Long aLong);
}
