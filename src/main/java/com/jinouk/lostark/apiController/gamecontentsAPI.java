package com.jinouk.lostark.apiController;

import com.jinouk.lostark.service.gamecontentsAPIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class gamecontentsAPI {

    private final gamecontentsAPIService service;

    @GetMapping("/calendar")
    public Mono<String> calendar() { return service.getGamecontentsCalendar(); }
}
