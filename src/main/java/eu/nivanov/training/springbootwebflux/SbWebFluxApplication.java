package eu.nivanov.training.springbootwebflux;

import io.r2dbc.spi.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication
@EnableR2dbcRepositories
public class SbWebFluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbWebFluxApplication.class, args);
    }

    /**
     * Initialises the H2 repository.
     */
    @Bean
    @Primary
    public R2dbcEntityTemplate r2dbcEntityTemplate(ConnectionFactory connectionFactory) {
        R2dbcEntityTemplate template = new R2dbcEntityTemplate(connectionFactory);
        template.getDatabaseClient().sql("CREATE TABLE employee" +
                        "(id LONG PRIMARY KEY AUTO_INCREMENT," +
                        "name VARCHAR(255)," +
                        "position VARCHAR(255))")
                .fetch()
                .first()
                .subscribe();

        return template;
    }
}
