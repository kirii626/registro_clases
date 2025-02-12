package com.example.registro_clase;

import com.example.registro_clase.models.Usuario;
import com.example.registro_clase.models.enums.Rol;
import com.example.registro_clase.repositories.UsuarioRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class RegistroClaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroClaseApplication.class, args);
	}

	@Bean
	public CommandLineRunner initAdminUser(UsuarioRespository usuarioRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			String adminEmail = "admin@colegio.com";
			String adminPassword = "admin123";  // 🔹 Cambia esto después de la prueba

			Optional<Usuario> existingAdmin = usuarioRepository.findByEmail(adminEmail);

			if (existingAdmin.isEmpty()) {
				Usuario admin = new Usuario();
				admin.setNombre("Admin");
				admin.setApellido("Principal");
				admin.setEmail(adminEmail);
				admin.setContrasena(passwordEncoder.encode(adminPassword));
				admin.setRol(Rol.ROLE_ADMINISTRACION);

				usuarioRepository.save(admin);
				System.out.println("✅ Usuario Administrador creado: " + adminEmail);
			} else {
				System.out.println("⚠️ Usuario Administrador ya existe: " + adminEmail);
			}
		};
	}
}
