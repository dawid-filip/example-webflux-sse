package com.pl.df;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static com.pl.df.SsePathVariable.SSE_LENGTH;

@Service
@Log4j2
public class SseHandler {

    public Mono<ServerResponse> handler(ServerRequest serverRequest) {
        var length = Integer.parseInt(serverRequest.pathVariable(SSE_LENGTH.toString()));
        length = length > 1 ? length : 1;

        Flux<String> publisher = Flux.range(1, length)
                .map(i -> "sse message " + i)
                .delayElements(Duration.ofMillis(10));

        log.info("Generating " + length + " SSE messages.");

        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(publisher, String.class);
    }

}
