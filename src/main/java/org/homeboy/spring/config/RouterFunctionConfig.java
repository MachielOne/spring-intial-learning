package org.homeboy.spring.config;

import org.homeboy.spring.repository.UserRepository;
import org.homeboy.spring.domains.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import java.util.Collection;

/**
 * @author Tintin-Mask
 */
@Configuration
public class RouterFunctionConfig {

    @Bean
    public RouterFunction<ServerResponse> findAll(UserRepository userRepository)
    {
        return RouterFunctions.route(RequestPredicates.GET("/user/find/all"),
                serverRequest -> {
                    Collection<User> userCollection = userRepository.findAll();
                    Flux<User> userFlux = Flux.fromIterable(userCollection);
                    return ServerResponse.ok().body(userFlux,User.class);
                });
    }
}
