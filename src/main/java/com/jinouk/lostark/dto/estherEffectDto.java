package com.jinouk.lostark.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class estherEffectDto {
    private String name;
    private String grade;
    private int quality;
    private statsDto stats;
    private estherDto esther;

    @Getter @Setter
    public static class statsDto {
        private int attackPower;
        private double additionalDamagePercent;
    }

    @Getter @Setter
    public static class estherDto {
        private String name;
        private List<linkEffectDto> effects; // 결속 효과 리스트
    }
    
    @Getter @Setter
    public static class linkEffectDto {
        private String name;
        private int durationSeconds;

        // 결속 1단계 관련 필드
        private statIncreaseDto statIncrease;

        // 결속 2단계 관련 필드
        private Integer partyRangeMeter;
        private Integer partyAttackPowerIncrease;
    }

    @Getter @Setter
    public static class statIncreaseDto {
        private int strength;
        private int dexterity;
        private int intelligence;
    }
}