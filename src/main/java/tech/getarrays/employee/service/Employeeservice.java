package tech.getarrays.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employee.exception.UserNotFoundException;
import tech.getarrays.employee.model.Employee;
import tech.getarrays.employee.repo.EmployRepo;

import java.util.List;
import java.util.UUID;

@Service
public class Employeeservice {
    private final EmployRepo employRepo;


    @Autowired
    public Employeeservice(EmployRepo employRepo) {
        this.employRepo = employRepo;
    }
    public Employee addEmployee(Employee employee){
        //employee.setEmployeeCode(UUID.randomUUID().toString());
        return  employRepo.save(employee);

    }
    public List<Employee> findAllEmployees() {
        return employRepo.findAll();

    }
    public Employee updateEmployee(){
        return (Employee) employRepo.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return employRepo.save(employee);

    }
    public Employee findEmployeeById (Long id) {
        return employRepo.findById(id).orElseThrow(()-> new UserNotFoundException("User by id"+id+"was not found"));
    }
    public void deleteEmployee(Long id){
        employRepo.deleteEmployeeById(id);

    }
}
