package sample;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class AuthTokenVerifier {

    private JWTVerifier verifier;

    public AuthTokenVerifier(String secretKey) {
        Algorithm alg = Algorithm.HMAC256(secretKey);
        this.verifier = JWT.require(alg)
                .withIssuer("AuthTokenProducer")
                .acceptExpiresAt(5)
                .build();
    }

    public DecodedJWT verifyToken(String token) {
        try {
            return verifier.verify(token);
        } catch (JWTVerificationException e) {
            System.out.println("JWT verification failed..");
            throw e;
        }
    }
}
