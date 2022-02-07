package tech.getarrays.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employee.model.Employee;

import java.util.Optional;

public interface EmployRepo extends JpaRepository<Employee,Long> {

    void deleteEmployeeById(Long id);
    Optional<Employee> findEmployeeById(Long id);
}
