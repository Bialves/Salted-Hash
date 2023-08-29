import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {
        EncryptPassword password = new EncryptPassword();
        try {
            System.out.println("SALTED HASH: " + password.createSaltedHash("Bianca"));
        } catch (NoSuchAlgorithmException e) {
            System.err.format("ERRO: %s%n", e);
        }
    }
}