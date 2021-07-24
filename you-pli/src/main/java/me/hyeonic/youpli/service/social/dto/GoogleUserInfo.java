package me.hyeonic.youpli.service.social.dto;

import lombok.Data;
import me.hyeonic.youpli.dto.UserMainRequestDto;

@Data
public class GoogleUserInfo {

    private String sub;
    private String name;
    private String given_name;
    private String family_name;
    private String picture;
    private String email;
    private boolean email_verified;
    private String locale;

    public UserMainRequestDto toUserMainRequestDto() {
        return UserMainRequestDto.builder()
                .name(this.name)
                .email(this.email)
                .build();
    }
}