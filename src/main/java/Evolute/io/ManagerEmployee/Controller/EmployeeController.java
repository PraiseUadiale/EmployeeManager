package Evolute.io.ManagerEmployee.Controller;

import Evolute.io.ManagerEmployee.Model.Employee;
import Evolute.io.ManagerEmployee.Service.Service;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    //This is the controller class that is accessing the service
    //Request are coming through the controller and passing response to client
    //Exposed to the API
    private final Service employeeService;

    @Autowired
    public EmployeeController(Service employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.allEmployees();
    }

    @GetMapping("/all/{id}")
    public void findEmployee(
            @PathVariable("id") Long id
    ) {
        employeeService.findEmployeeByID(id);

    }

    @DeleteMapping("/del/{id}")
    public void deleteEmployeeByID(
            @PathVariable("id") Long id
    ) {
        employeeService.deleteEmployee(id);

    }

    @PostMapping("/")
    public Employee addEmployee(@JsonProperty Employee employee) {
        return employeeService.addEmployees(employee);
    }
}
