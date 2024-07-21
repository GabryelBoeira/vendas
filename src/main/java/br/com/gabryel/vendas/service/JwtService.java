package br.com.gabryel.vendas.service;

import br.com.gabryel.vendas.entity.UserSystem;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.key.signature}")
    private String keySignature;

    @Value("${jwt.expiration.time}")
    private String expiresIn;

    public String generateTokenJWT(UserSystem userSystem) {
        Long expiresParse = Long.parseLong(expiresIn);
        LocalDateTime time = LocalDateTime.now().plusMinutes(expiresParse);

        Instant instant = time.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        return Jwts.builder()
                .subject(userSystem.getUsername())
                .expiration(date)
                .signWith(SignatureAlgorithm.HS512, keySignature)
                .compact();
    }

    

}
