package com.jinouk.lostark.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class equipmentWeaponEstherDto {

    private final int enhancementLevel;
    private final String grade;
    private final int quality;
    private final int attackPower;
    private final double additionalDamagePercent;
    private final String estherName;

    public equipmentWeaponEstherDto(int enhancementLevel, String grade, int quality, int attackPower, double additionalDamagePercent, String estherName) {
        this.enhancementLevel = enhancementLevel;
        this.grade = grade;
        this.quality = quality;
        this.attackPower = attackPower;
        this.additionalDamagePercent = additionalDamagePercent;
        this.estherName = estherName;
    }
}

