package com.pl.df;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static com.pl.df.SsePathVariable.SSE_LENGTH;

@Configuration
@RequiredArgsConstructor
public class SseRoute {

    private final SseHandler sseHandler;

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return RouterFunctions
                .route()
                .GET("/api/sse/" + SSE_LENGTH + "/{" + SSE_LENGTH + "}", sseHandler::handler)
                .build();
    }

}
