package eu.nivanov.training.springbootwebflux.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Created by Nikolay Ivanov on 2021-11-09.
 */
@Data
@Table("employee")
public class Employee {

    @Id
    private final Long id;

    private final String name;

    private CompanyPosition position;
}
