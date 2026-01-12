package com.jinouk.lostark.simulator.service;

import com.jinouk.lostark.service.armoriesAPIService;
import com.jinouk.lostark.simulator.dto.skillsResponse;
import com.jinouk.lostark.simulator.postProcess.skillPostProcess;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
@RequiredArgsConstructor
public class simulatorService {

    private final armoriesAPIService armoriesAPIService;

    public Mono<List<skillPostProcess>> doProcess(String name){
        return armoriesAPIService.getArmoriesCharacterCombatSkills(name)
                .map(list -> list.stream()

                        //level이 1보다 큰 것만 호출
                        .filter(item -> item.getLevel() != null && item.getLevel() > 1)

                        //착용된 rune을 호출 null일 수도 있으니 함께 처리
                        .map(item ->{
                            var rune = item.getRune() == null ? null : skillPostProcess.RuneDto.builder()
                                    .name(item.getRune().getName())
                                    .grade(item.getRune().getGrade())
                                    .icon(item.getRune().getIcon())
                                    .build();

                            //활성화된 트포만 호출
                            var selectedTripods = item.getTripods() == null ? List.<skillPostProcess.TripodDto>of()
                                    : item.getTripods().stream()
                                    //T/F값으로 Filter를 걸어 활성화 됨을 확인
                                    .filter(t -> Boolean.TRUE.equals(t.getIsSelected()))
                                    .map(t -> skillPostProcess.TripodDto.builder()
                                            .tier(t.getTier())
                                            .slot(t.getSlot())
                                            .name(t.getName())
                                            .icon(t.getIcon())
                                            .build())
                                    .toList();

                            return skillPostProcess.builder()
                                    .name(item.getName())
                                    .level(item.getLevel())
                                    .type(item.getType())
                                    .icon(item.getIcon())
                                    .rune(rune)
                                    .selectedTripods(selectedTripods)
                                    .build();
                        }).toList());
    }

}
