package Evolute.io.ManagerEmployee.service;

import Evolute.io.ManagerEmployee.model.Employee;
import Evolute.io.ManagerEmployee.model.EmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class EmployeeService {
    //Service class which is going to be used by the controller

    private final EmployeeRepo repo;
    //Dependency injection has been done on such

    @Autowired
    public EmployeeService(EmployeeRepo repo) {
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
        return repo.findEmployeeByID(id).
                orElseThrow(() ->
                        new EmployeeException("User with " +
                                id + "Not found"));
    }


    public void deleteEmployee(Long id) {
        Optional<Employee> employee = repo.findEmployeeByID(id);
        if (employee.isPresent()) {
            repo.deleteEmployeeByID(id);
        }
    }

    public Employee updateEmployee(Employee employee) {
        return repo.save(employee);
    }
}
