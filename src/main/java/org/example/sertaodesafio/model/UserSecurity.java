package org.example.sertaodesafio.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
public class UserSecurity implements UserDetails {

    private String username;

    private String password;

    private Boolean ativo;

    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(getRole());
    }

    @Override
    public boolean isAccountNonExpired() {
        return getAtivo();
    }

    @Override
    public boolean isAccountNonLocked() {
        return getAtivo();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return getAtivo();
    }

    @Override
    public boolean isEnabled() {
        return getAtivo();
    }
}