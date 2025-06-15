package demo.bcnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = {
        "demo.avoris"
})
public class MainDemoBcnc {

    public static void main(String[] args) {
        SpringApplication.run(MainDemoBcnc.class, args);
    }
}