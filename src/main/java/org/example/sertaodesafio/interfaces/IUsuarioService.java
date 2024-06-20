package org.example.sertaodesafio.interfaces;

import org.example.sertaodesafio.config.jwt.JwtRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUsuarioService extends UserDetailsService {

    ResponseEntity<?> signin(JwtRequest authenticationRequest);
}
