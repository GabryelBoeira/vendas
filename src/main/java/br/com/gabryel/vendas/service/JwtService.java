package br.com.gabryel.vendas.service;

import br.com.gabryel.vendas.entity.UserSystem;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    @Value("${jwt.key.signature}")
    private String keySignature;

    @Value("${jwt.expiration.time}")
    private String expiresIn;

    /**
     * Generates a JWT token based on the user information provided.
     *
     * @param  userSystem  the user information used to generate the token
     * @return             the generated JWT token
     */
    public String generateTokenJWT(UserSystem userSystem) throws UnsupportedEncodingException {
        long expiresParse = Long.parseLong(expiresIn);
        LocalDateTime time = LocalDateTime.now().plusMinutes(expiresParse);

        Instant instant = time.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        //Custom Information to JWT
        Map<String, Object> claims = new HashMap<>();
        claims.put("user", userSystem.getUsername());
        claims.put("isAdmin", userSystem.getAdmin());

        return Jwts.builder()
                .subject(userSystem.getUsername())
                .expiration(date)
                .claims(claims)
                .signWith(SignatureAlgorithm.HS512, keySignature.getBytes(StandardCharsets.UTF_8))
                .compact();
    }

    /**
     * Decodes the JWT token and retrieves the payload.
     *
     * @param  token the JWT token to decode
     * @return       the payload of the decoded JWT token
     */
    public Claims getClaims(String token) throws ExpiredJwtException {
        SignatureAlgorithm sa = SignatureAlgorithm.HS256;

        return Jwts.parser()
                .verifyWith(new SecretKeySpec(keySignature.getBytes(), sa.getJcaName()))
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /**
     * Validates a JWT token.
     *
     * @param  token the JWT token to validate
     * @return       true if the token is valid, false otherwise
     */
    public boolean validateToken(String token) {
        try {
            Claims claims = getClaims(token);
            LocalDateTime time = claims.getExpiration().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

            return !LocalDateTime.now().isAfter(time);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Retrieves the username from the JWT token.
     *
     * @param  token   the JWT token
     * @return         the username from the token
     * @throws ExpiredJwtException if the token has expired
     */
    public String getUsername(String token) throws ExpiredJwtException {
        return (String) getClaims(token).getSubject();
    }


}
