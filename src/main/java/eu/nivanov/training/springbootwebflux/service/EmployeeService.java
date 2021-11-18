package eu.nivanov.training.springbootwebflux.service;

import eu.nivanov.training.springbootwebflux.model.Employee;
import eu.nivanov.training.springbootwebflux.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Nikolay Ivanov on 2021-11-09.
 */
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Flux<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Mono<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public Mono<Employee> save(Employee employee) {
        return employeeRepository
                .save(employee)                                             // For some reason the value for the employee's position is not returned
                .flatMap(emp -> employeeRepository.findById(emp.getId()));  // To work around it, pipe a fetch operation after the save
    }

    public Mono<Employee> promote(long employeeId) {
        return findById(employeeId).flatMap(employee -> {
            employee.setPosition(employee.getPosition().getHigherPosition());
            return employeeRepository.save(employee);
        });
    }
}
