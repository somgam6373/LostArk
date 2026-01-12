package com.jinouk.lostark.apiController;

import com.jinouk.lostark.service.newsAPIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class newsAPI {

    private final newsAPIService service;

    @GetMapping("/notices")
    public Mono<String> notices() { return service.getNewsNotices(); }

    @GetMapping("/events")
    public Mono<String> events() { return service.getNewsEvents(); }

    @GetMapping("/alarms")
    public Mono<String> alarms() { return service.getNewsAlarms(); }
}
