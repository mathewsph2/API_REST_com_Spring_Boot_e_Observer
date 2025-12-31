
package br.com.observerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com")

public class ObserverApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObserverApiApplication.class, args);
    }
}
