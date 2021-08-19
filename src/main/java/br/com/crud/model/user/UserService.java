package br.com.crud.model.user;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Singleton
public class UserService {

    @Inject
    private UserRepository userService;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Optional<User> findById(String id){
        return userService.findById(id);
    }
    public User save(User entity){
        return userService.save(new User(entity.getUsername(), passwordEncoder.encode(entity.getPassword())));
    }
}
