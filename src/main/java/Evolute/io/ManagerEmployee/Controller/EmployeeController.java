package Evolute.io.ManagerEmployee.Controller;

import Evolute.io.ManagerEmployee.service.EmployeeService;
import Evolute.io.ManagerEmployee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    //This is the controller class that is accessing the service
    //Request are coming through the controller and passing response to client
    //Exposed to the API
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.allEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(
            @PathVariable("id") Long id
    ) {
        Employee employee = employeeService.findEmployeeByID(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);

    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);

    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<?> deleteEmployeeByID(
            @PathVariable("id") Long id
    ) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee addEmployee = employeeService.addEmployees(employee);
        return new ResponseEntity<>(addEmployee, HttpStatus.CREATED);
    }
}