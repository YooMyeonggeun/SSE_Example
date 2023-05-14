package com.example.sse_example_project.contorller;


import com.example.sse_example_project.dto.ServerSentEvent;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

@RestController
@RequestMapping("/events")
public class ServerEvnetsController {

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> getEevnts() throws IOException {

        Stream<String> lines = Files.lines(Path.of("C:/SSE_Example/SSE_Example_project/build.gradle"));

        Flux.fromStream(lines)
                .filter(line -> !line.isBlank())
                .map(line -> {
                    ServerSentEvent.builder()
                            .id(String.valueOf(counter.getAndIncrement()))
                            .data()
                })
        return null;
    }
}
