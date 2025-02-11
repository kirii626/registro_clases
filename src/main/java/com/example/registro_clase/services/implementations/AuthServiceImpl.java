package com.example.registro_clase.services.implementations;

import com.example.registro_clase.config.JwtUtils;
import com.example.registro_clase.dtos.usuario.UsuarioInputDto;
import com.example.registro_clase.dtos.usuario.UsuarioOutputDto;
import com.example.registro_clase.exceptions.InvalidCredentialsExc;
import com.example.registro_clase.services.AuthService;
import com.example.registro_clase.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public UsuarioOutputDto registerNewUser(UsuarioInputDto usuarioInputDto) {
        return usuarioService.crearUsuario(usuarioInputDto);
    }

    @Override
    public String authenticateAndGenerateToken(String email, String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String username = authentication.getName();

            String role = authentication.getAuthorities()
                    .stream()
                    .findFirst()
                    .map(authority -> authority.getAuthority())
                    .orElse("PROFESOR");  // Valor predeterminado si no hay roles

            return jwtUtils.generateToken(username);
        } catch (BadCredentialsException e) {
            throw new InvalidCredentialsExc("Invalid email or password");
        }
    }
}
