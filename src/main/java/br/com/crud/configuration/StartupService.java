package br.com.crud.configuration;

import br.com.crud.model.user.User;
import br.com.crud.model.user.UserService;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

@Singleton
@Slf4j
public class StartupService {

    @Inject
    private UserService userService;

    @EventListener
    public void onStartupEvent(StartupEvent event) {
        final val user = userService.save(new User("12345678905", "123456789"));
        log.info("Usuario adicionado: {} ",user);
    }
}
