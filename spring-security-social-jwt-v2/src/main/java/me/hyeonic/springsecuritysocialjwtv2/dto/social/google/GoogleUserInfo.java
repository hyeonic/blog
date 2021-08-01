package me.hyeonic.springsecuritysocialjwtv2.dto.social.google;

import lombok.Data;
import me.hyeonic.springsecuritysocialjwtv2.dto.user.UserSaveOrUpdateRequestDto;

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

    public UserSaveOrUpdateRequestDto toUserSaveOrUpdateRequestDto() {
        return UserSaveOrUpdateRequestDto.builder()
                .email(this.email)
                .name(this.name)
                .build();
    }
}