package Evolute.io.ManagerEmployee.Service;

import Evolute.io.ManagerEmployee.Model.Employee;
import Evolute.io.ManagerEmployee.Model.EmployeeException;
import Evolute.io.ManagerEmployee.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@org.springframework.stereotype.Service
public class Service {
    //Service class which is going to be used by the controller

    private final EmployeeRepo repo;
    //Dependency injection has been done on such

    @Autowired
    public Service(EmployeeRepo repo) {
        this.repo = repo;
    }

    /*CRUD*/

    public Employee addEmployees(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return repo.save(employee);
    }

    public List<Employee> allEmployees() {
        return repo.findAll();
    }

    public Employee findEmployeeByID(Long id) {
        return repo.findByEmployeeById(id).
                orElseThrow(() ->
                        new EmployeeException("User with " +
                                id + "Not found"));
    }


    public void deleteEmployee(Long id) {
        Optional<Employee> employee = repo.findByEmployeeById(id);
        if (employee.isPresent()) {
            repo.deleteEmployeeByID(id);
        }
    }

    public Employee updateEmployee(Employee employee) {
        return repo.save(employee);
    }
}
