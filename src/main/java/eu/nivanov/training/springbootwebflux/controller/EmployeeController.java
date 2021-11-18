package eu.nivanov.training.springbootwebflux.controller;

import eu.nivanov.training.springbootwebflux.model.Employee;
import eu.nivanov.training.springbootwebflux.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by Nikolay Ivanov on 2021-11-09.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public Flux<Employee> fetchAllEmployees() {
        return employeeService.findAll();
    }

    @PostMapping
    public Mono<Employee> createNew(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping("/{id}")
    public Mono<Employee> fetchOneById(@PathVariable("id") long id) {
        return employeeService.findById(id);
    }

    @PostMapping("/{id}/promote")
    public Mono<Employee> promote(@PathVariable("id") long id) {
        return employeeService.promote(id);
    }
}
