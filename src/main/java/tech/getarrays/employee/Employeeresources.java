package tech.getarrays.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employee.model.Employee;
import tech.getarrays.employee.service.Employeeservice;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class Employeeresources {
    private final Employeeservice employeeservice;

    @Autowired
    public Employeeresources(Employeeservice employeeservice) {
        this.employeeservice = employeeservice;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee (){
        List<Employee> employees = employeeservice.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping ("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable ("id") Long id){
        Employee employee = employeeservice.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);

    }


    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeservice.addEmployee(employee);
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }



    @PutMapping("/update")
    public  ResponseEntity<Employee>updateEmployee(@RequestBody Employee employee){
        Employee  updateemployee = employeeservice.updateEmployee(employee);
        return new ResponseEntity<>(updateemployee, HttpStatus.OK);


    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteEmployee(@PathVariable ("id") Long id){
        employeeservice.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);


    }

}
