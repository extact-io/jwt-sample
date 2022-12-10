package sample;

import java.util.stream.Collectors;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class HmacJwtConsumer {

    private String secretKey;

    public HmacJwtConsumer(String key) {
        this.secretKey = key;
    }

    public DecodedJWT verifyToken(String token) {
        Algorithm alg = Algorithm.HMAC256(secretKey);
        JWTVerifier verifier = JWT.require(alg)
                .withIssuer("HmacJwtProducer")
                .acceptExpiresAt(5)
                .build();
        try {
            return verifier.verify(token);
        } catch (JWTVerificationException e) {
            System.out.println("JWT verification failed..");
            throw e;
        }
    }

    public static void main(String[] args) {
        String secretkey = System.getenv("SECRET_KEY");

        DecodedJWT jwt = new HmacJwtConsumer(secretkey).verifyToken(args[0]);

        System.out.println("----- DecodedJWT -----");
        System.out.println("alg:" + jwt.getAlgorithm());
        System.out.println("typ:" + jwt.getType());
        System.out.println("issuer:" + jwt.getIssuer());
        System.out.println("subject:" + jwt.getSubject());
        System.out.println("expiresAt:" + jwt.getExpiresAt());
        System.out.println("issuerAt:" + jwt.getIssuedAt());
        System.out.println("JWT-ID:" + jwt.getId());
        System.out.println("email:" + jwt.getClaim("email").asString());
        System.out.println("groups:" + jwt.getClaim("groups")
                    .asList(String.class).stream()
                    .collect(Collectors.joining(",")));
    }
}
