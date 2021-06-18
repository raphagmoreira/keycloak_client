package br.com.oauth2;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class Oauth2Client {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2Client.class, args);
    }

    @Component
    class Runner implements ApplicationRunner {

        private WebClient webClient;

        Runner(WebClient webClient) {
            this.webClient = webClient;
        }

        @Override
        public void run(ApplicationArguments args) throws Exception {
            webClient
                    .get()
                    .uri("http://localhost:9000/api/authentication")
                    .retrieve()
                    .bodyToMono(String.class)
                    .subscribe(System.out::println);
        }
    }

}
