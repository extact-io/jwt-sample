package sample;

import com.auth0.jwt.interfaces.DecodedJWT;

public class AddCalculator {

    private AuthTokenVerifier verifier;
    private AddOperator addOperator;


    public AddCalculator(AuthTokenVerifier authTokenVerifier, AddOperator addOperator) {
        this.verifier = authTokenVerifier;
        this.addOperator = addOperator;
    }

    public void calculate(int left, int right, String token) {
        DecodedJWT jwt = verifier.verifyToken(token);
        int result = addOperator.operate(left, right);
        System.out.println(jwt.getClaim("name").asString() + "さんからの依頼の"
                + "計算結果は" + result + "です");
    }

    public static void main(String[] args) {
        String secretkey = System.getenv("SECRET_KEY");

        int left = Integer.parseInt(args[0]);
        int right = Integer.parseInt(args[1]);
        String token = args[2];

        AddCalculator idProvider = new AddCalculator(
                new AuthTokenVerifier(secretkey),
                new AddOperator());

        idProvider.calculate(left, right, token);
    }
}
