package com.andrer54.login_with_google;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
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
	String privateRoute(@AuthenticationPrincipal OidcUser principal){
		return String.format("""
			<h1>Rota privada</h1>
			<h1>Olá %s</h1>
			<span>%s</span>
			<p>Dados da conta google: %s</p>
			<h4>Permissões: %s</h4>
			<h4>autorização JWT: %s</h4>
			<a href="https://www.google.com/accounts/Logout?continue=https://appengine.google.com/_ah/logout?continue=http://localhost:8080/sair">deslogar</a>
			""", principal.getAttribute("name"), principal.getAttribute("email"), principal, principal.getAuthorities(), principal.getIdToken().getTokenValue());
	}


}