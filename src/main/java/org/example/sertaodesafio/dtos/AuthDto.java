package org.example.sertaodesafio.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sertaodesafio.model.Role;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthDto {
    private Role role;
    private boolean sign;
    private String token;
}