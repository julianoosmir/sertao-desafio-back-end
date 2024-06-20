package org.example.sertaodesafio;

import jakarta.annotation.PostConstruct;
import org.example.sertaodesafio.entity.Perfil;
import org.example.sertaodesafio.entity.Usuario;
import org.example.sertaodesafio.repository.PerfilRepository;
import org.example.sertaodesafio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class Initializer {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostConstruct
    public void init() {
//        Perfil  perfil = Perfil.builder().name("admin").build();
//        perfil = this.perfilRepository.save(perfil);
//
//        Usuario usuario = Usuario.builder()
//                .nome("sertao")
//                .ativo(true)
//                .perfil(perfil)
//                .senha(new BCryptPasswordEncoder().encode("123456"))
//                .build();
//        usuario = this.usuarioRepository.save(usuario);
    }

}
