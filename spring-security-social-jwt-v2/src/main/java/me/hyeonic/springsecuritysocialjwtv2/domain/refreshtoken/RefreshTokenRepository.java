package me.hyeonic.springsecuritysocialjwtv2.domain.refreshtoken;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    @Query("select r " +
            "from RefreshToken r " +
            "where r.user.email = :email")
    Optional<RefreshToken> findByUserEmail(@Param("email") String email);
}