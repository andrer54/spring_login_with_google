package com.andrer54.login_with_google;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LoginWithGoogleApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginWithGoogleApplication.class, args);
	}

}

@RestController
class HttpController {
	@GetMapping("/public")
	String publicRoute(){
		return "<h1>Rota publica</h1>";
	}

	@GetMapping("/private")
	String privateRoute(){
		return "<h1>Rota privada</h1>";
	}
}