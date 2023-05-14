package com.example.sse_example_project.contorller;


import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.Writer;

@RestController
@RequestMapping("/events")
public class ServerEvnetsController {

//    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<ServerSentEvent<String>> getEevnts() throws IOException {
//
//        Stream<String> lines = Files.lines(Path.of("C:/SSE_Example/SSE_Example_project/build.gradle"));
//
//        Flux.fromStream(lines)
//                .filter(line -> !line.isBlank())
//                .map(line -> {
//                    ServerSentEvent.builder()
//                            .id(String.valueOf(counter.getAndIncrement()))
//                            .data()
//                })
//        return null;
//    }

    @GetMapping("/go")
    public void sse(final HttpServletResponse response) throws IOException, InterruptedException {
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");

        Writer writer = response.getWriter();

        for (int i = 0; i < 5; i++) {
            writer.write("data: " + System.currentTimeMillis() + "\n\n");
            writer.flush(); // 꼭 flush 해주어야 한다.
            Thread.sleep(1000);
        }

        writer.close();
    }
}
