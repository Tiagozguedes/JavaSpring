package br.com.fiap.apirest.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        return httpSecurity
                .csrf(csrf -> csrf.disable()) // Desativa a proteção CSRF, comum em APIs REST porque elas usam JWT no lugar
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //.requestMatchers(HttpMethod.POST, "/produtos").hasRole("ADMIN")
                .authorizeHttpRequests( auth ->
                        auth
                                .requestMatchers(HttpMethod.POST, "/produtos").hasRole("ADMIN") //Só usuário com role ADMIN pode criar produto.
                                .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                                .requestMatchers(HttpMethod.POST, "/auth/login").permitAll() //Qualquer pessoa pode se registrar e fazer login, sem token.
                                .anyRequest().authenticated() //Qualquer outra rota precisa estar autenticado.
                )
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws  Exception {
        //disponibiliza o gerenciador de autenticação do Spring para ser usado em outras classes, como no login.
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        //define que as senhas serão criptografadas com BCrypt antes de salvar no banco.
        return new BCryptPasswordEncoder();
    }

}