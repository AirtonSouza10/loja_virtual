package com.loja_virtual;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@SpringBootApplication
@EntityScan(basePackages = "com.loja_virtual.model")
@ComponentScan(basePackages = {"com.*"})
@EnableJpaRepositories(basePackages = {"com.loja_virtual.repository"})
@EnableTransactionManagement
public class LojaVirtualApplication {
	
	private static final long EXPIRATION_TIME = 864000000; // 10 dias
	private static final String SECRET = "teste";
	private static final String PREFIX_TOKEN = "Bearer";
	private static final String HEADER_STRING = "Authorization";

	public static void main(String[] args) {
		System.out.print(new BCryptPasswordEncoder().encode("123"));
		SpringApplication.run(LojaVirtualApplication.class, args);
		
		
        // Geração da senha criptografada
        System.out.println("Senha criptografada: " + new BCryptPasswordEncoder().encode("123"));

        // Geração do token JWT
        String username = "admin"; // troque para o usuário desejado
        String jwt = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        String token = PREFIX_TOKEN + " " + jwt;
        System.out.println("Token JWT gerado:");
        System.out.println(HEADER_STRING + ": " + token);
		
	}
}
