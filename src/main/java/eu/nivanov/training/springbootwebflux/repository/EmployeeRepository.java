package eu.nivanov.training.springbootwebflux.repository;

import eu.nivanov.training.springbootwebflux.model.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * Created by Nikolay Ivanov on 2021-11-09.
 */

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {
}
