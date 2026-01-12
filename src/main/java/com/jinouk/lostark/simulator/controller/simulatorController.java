package com.jinouk.lostark.simulator.controller;


import com.jinouk.lostark.simulator.postProcess.skillPostProcess;
import com.jinouk.lostark.simulator.service.simulatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
public class simulatorController {

    private final simulatorService service;

    @GetMapping("/do")
    public Mono<List<skillPostProcess>> doProcess() {
        return service.doProcess("치킨");
    }


}
