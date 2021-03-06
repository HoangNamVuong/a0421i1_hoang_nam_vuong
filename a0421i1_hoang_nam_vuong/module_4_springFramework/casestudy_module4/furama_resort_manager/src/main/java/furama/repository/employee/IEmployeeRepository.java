package furama.repository.employee;

import furama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Override
    Page< Employee > findAll(Pageable pageable);
    // Search by name
    @Query(value = "select* from employee where name like concat('%',:name, '%')", nativeQuery = true)
    Page<Employee> searchByName(@Param("name") String name, Pageable pageable);
}
