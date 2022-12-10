package sample;

import java.time.OffsetDateTime;
import java.util.UUID;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class AuthTokenProducer {

    private String secretKey;

    public AuthTokenProducer(String key) {
        this.secretKey = key;
    }

    public String generateToken(User user) {
        Algorithm alg = Algorithm.HMAC256(secretKey);
        String token = JWT.create()
                .withIssuer("AuthTokenProducer")
                .withSubject(user.id())
                .withExpiresAt(OffsetDateTime.now().plusMinutes(60).toInstant())
                .withIssuedAt(OffsetDateTime.now().toInstant())
                .withJWTId(UUID.randomUUID().toString())
                .withClaim("name", user.name())
                .sign(alg);
        return token;
    }
}
