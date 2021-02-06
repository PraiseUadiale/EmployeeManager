package Evolute.io.ManagerEmployee.service;

import Evolute.io.ManagerEmployee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    /*Database repository for querying database
    JPA does a lot of the abstraction needeed*/

    /*Spring is going to created a query to match the name of this method
     * saves us having to write out the query*/

    void deleteEmployeeByID(Long id);

    Optional<Employee> findEmployeeByID(Long id);
}