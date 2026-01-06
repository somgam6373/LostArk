package com.jinouk.lostark.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class charactersAPIService {

    private final WebClient lostArkWebClient;

    //사용자가 소유한 모든 캐릭터 목록 조회
    public Mono<String> getCharacterSiblings(String name) {
        return lostArkWebClient
                .get()
                .uri("/characters/{name}/siblings", name)
                .retrieve()
                .bodyToMono(String.class);
    }
}
