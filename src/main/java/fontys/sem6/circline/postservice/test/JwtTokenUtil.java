package fontys.sem6.circline.postservice.test;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

public class JwtTokenUtil {
    private static final String SECRET_KEY = "A91E158E4C6656F68B1B5D1C316766DE98D2AD6EF3BFB44F78E9CFCDF9";

    public static String generateMockToken(Long id, String email, String role) {
        Instant now = Instant.now();
        return Jwts.builder()
                .setSubject(email)  // "sub": email
                .claim("id", id)    // "id": id
                .claim("roles", role)  // "roles": role
                .setIssuedAt(Date.from(now))  // "iat": issued at
                .setExpiration(Date.from(now.plus(30, ChronoUnit.MINUTES)))  // "exp": expiration time
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static Map<String, Object> parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
