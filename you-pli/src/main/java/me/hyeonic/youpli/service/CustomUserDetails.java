package me.hyeonic.youpli.service;

import lombok.Getter;
import lombok.Setter;
import me.hyeonic.youpli.domain.Role;
import me.hyeonic.youpli.domain.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
public class CustomUserDetails implements UserDetails {

    Collection<SimpleGrantedAuthority> authorities;

    final String username; // email
    final String name;
    final Role role;

    public CustomUserDetails(User user) {

        authorities = new ArrayList<>();

        if (user.getRole() == Role.USER) {
            authorities.add(new SimpleGrantedAuthority(Role.USER.getKey()));
        } else if (user.getRole() == Role.ADMIN) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getKey()));
        }

        this.username = user.getUsername();
        this.name = user.getName();
        this.role = user.getRole();
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
