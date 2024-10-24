package stevens.project.springoauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SpringOAuth2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringOAuth2Application.class, args);
    }

}
