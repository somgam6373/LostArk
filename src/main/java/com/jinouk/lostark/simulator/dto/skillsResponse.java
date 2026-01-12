package com.jinouk.lostark.simulator.dto;

import lombok.Data;

import java.util.List;

@Data
public class skillsResponse {
    private String Name;
    private String Icon;
    private Integer Level;
    private String Type;
    private Integer SkillType;

    private List<TripodResponse> Tripods;
    private RuneResponse Rune;

    private String Tooltip;

    @Data
    public static class TripodResponse {
        private Integer Tier;
        private Integer Slot;
        private String Name;
        private String Icon;
        private Boolean IsSelected;
        private String Tooltip;
    }

    @Data
    public static class RuneResponse {
        private String Name;
        private String Icon;
        private String Grade;
        private String Tooltip;
    }
}
