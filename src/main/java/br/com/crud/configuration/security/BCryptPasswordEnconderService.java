package br.com.crud.configuration.security;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Singleton
public class BCryptPasswordEnconderService implements PasswordEncoder {

    private PasswordEncoder bCryptEncoder;
    public BCryptPasswordEnconderService(){
        this.bCryptEncoder = new BCryptPasswordEncoder();
    }
    @Override
    public String encode(CharSequence rawPassword) {

        return bCryptEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return bCryptEncoder.matches(rawPassword,encodedPassword);
    }
}
