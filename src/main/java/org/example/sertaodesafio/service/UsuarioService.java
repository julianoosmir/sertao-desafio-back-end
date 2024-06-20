package org.example.sertaodesafio.service;

import org.example.sertaodesafio.config.jwt.JwtRequest;
import org.example.sertaodesafio.config.jwt.JwtTokenUtil;
import org.example.sertaodesafio.entity.Usuario;
import org.example.sertaodesafio.interfaces.IUsuarioService;
import org.example.sertaodesafio.model.Role;
import org.example.sertaodesafio.model.UserSecurity;
import org.example.sertaodesafio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserDetails userDetails = loadUserSegurityByUsername(username);
        return userDetails;
    }

    private UserDetails loadUserSegurityByUsername(String username) {
        Usuario usuario = usuarioRepository.findByNome(username);

        Role role = Role.builder().name(usuario.getPerfil().getName()).build();

        return UserSecurity.builder()
                .role(role)
                .ativo(usuario.getAtivo())
                .username(usuario.getNome())
                .password(usuario.getSenha())
                .build();
    }

    public ResponseEntity<?> signin(JwtRequest authenticationRequest) {

        try {
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

            final UserDetails userSegurity = loadUserSegurityByUsername(authenticationRequest.getUsername());

            final String token = jwtTokenUtil.generateToken(userSegurity);

            // final AuthDto authDto = new AuthDto((userSegurity.getRoles()), true, token);

            return ResponseEntity.ok(token);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(e.getMessage());
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USUARIO DESABILITADO", e);
        } catch (BadCredentialsException e) {
            throw new Exception("CREDENCIAIS INVALIDAS", e);
        } catch (InternalAuthenticationServiceException e) {
            throw new Exception("USUARIO NÃO CADASTRADO", e);
        }
    }

    private String enconderPassword(String senha) {
        return new BCryptPasswordEncoder().encode(senha);
    }
}
