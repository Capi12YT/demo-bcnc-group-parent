package demo.bcnc;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {
        "demo.bcnc"
})
public class MainDemoBcnc {

    public static void main(String[] args) {
        SpringApplication.run(MainDemoBcnc.class, args);
    }
}