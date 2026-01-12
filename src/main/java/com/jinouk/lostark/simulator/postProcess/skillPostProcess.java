package com.jinouk.lostark.simulator.postProcess;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class skillPostProcess {
    private String name;
    private Integer level;
    private String type;
    private String icon;

    private RuneDto rune;
    private List<TripodDto> selectedTripods;

    @Data
    @Builder
    public static class RuneDto {
        private String name;
        private String grade;
        private String icon;
    }

    @Data
    @Builder
    public static class TripodDto {
        private Integer tier;
        private Integer slot;
        private String name;
        private String icon;
    }
}
