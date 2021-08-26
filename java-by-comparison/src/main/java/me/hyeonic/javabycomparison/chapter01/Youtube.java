package me.hyeonic.javabycomparison.chapter01;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Youtube {

    private boolean premium;

    public boolean isNotPremium() {
        if (!premium) {
            return true;
        } else {
            return false;
        }
    }
}