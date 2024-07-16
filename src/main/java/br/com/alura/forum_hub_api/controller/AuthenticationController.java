package br.com.alura.forum_hub_api.controller;

import br.com.alura.forum_hub_api.domain.user.LoginAuthenticationData;
import br.com.alura.forum_hub_api.domain.user.User;
import br.com.alura.forum_hub_api.infra.security.JwtTokenData;
import br.com.alura.forum_hub_api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid LoginAuthenticationData loginAuthentication) {

        var authenticationToken = new UsernamePasswordAuthenticationToken(loginAuthentication.email(), loginAuthentication.password());

        var authenticate = authenticationManager.authenticate(authenticationToken);

        var jwtToken = tokenService.generateToken((User) authenticate.getPrincipal());

        return ResponseEntity.ok(new JwtTokenData(jwtToken));

    }
}
