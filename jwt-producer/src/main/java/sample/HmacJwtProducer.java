package sample;

import java.time.OffsetDateTime;
import java.util.UUID;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class HmacJwtProducer {

    private String secretKey;

    public HmacJwtProducer(String key) {
        this.secretKey = key;
    }

    public String generateToken() {
        Algorithm alg = Algorithm.HMAC256(secretKey);
        String token = JWT.create()
                .withIssuer("HmacJwtProducer")
                .withSubject("ID12345")
                .withExpiresAt(OffsetDateTime.now().plusMinutes(60).toInstant())
                .withIssuedAt(OffsetDateTime.now().toInstant())
                .withJWTId(UUID.randomUUID().toString())
                .withClaim("email", "id123459@exact.io")
                .withArrayClaim("groups", new String[] { "member", "admin" })
                .sign(alg);
        return token;
    }

    public static void main(String[] args) {
        String secretkey = System.getenv("SECRET_KEY");
        System.out.println(new HmacJwtProducer(secretkey).generateToken());
    }
}
