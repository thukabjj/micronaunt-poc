package br.com.crud.configuration.security.jwt;

import br.com.crud.model.user.UserService;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import io.reactivex.Flowable;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.val;
import org.reactivestreams.Publisher;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Singleton
public class UserPasswordAuthenticationProvider implements AuthenticationProvider {

    @Inject
    private UserService userService;

    @Inject
    private PasswordEncoder passwordEncoder;

    @Override
    public Publisher<AuthenticationResponse> authenticate(HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> authenticationRequest) {
        final val user = userService.findById(authenticationRequest.getIdentity().toString());
        if (user.isPresent()) {
            if (passwordEncoder.matches(authenticationRequest.getSecret().toString(),user.get().getPassword())){

            return Flowable.just(AuthenticationResponse.success(user.get().getUsername(), List.of()));
            }
        }
        return Flowable.error(new AuthenticationException(AuthenticationResponse.failure(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH)));
    }

}
