import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class EncryptPassword {
    /**
     * Método que criptografa senhas utilizando salted hashing.
     * o Salt é a técnica de incrementar uma camada de aleatoriedade
     * sobre um senha criptografada com hash.
     *
     * @param password senha
     * @return senha criptografada
     * @throws NoSuchAlgorithmException
     */

    public String createSaltedHash(String password) throws NoSuchAlgorithmException {
        System.out.println("SENHA: " + password);

        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        // Gera um salt aleatório
        byte[] salt = generateSalt();
        System.out.println("SALT: " + byteToString(salt));

        digest.reset();
        // Agrega o salt a senha criptografada
        digest.update(salt);

        // Gera o salted hash, agregando a senha e fazendo a criptografia
        byte[] hashedPassword = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        return byteToString(hashedPassword);
    }

    private byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    private String byteToString(byte[] hashedPassword) {
        StringBuilder builder = new StringBuilder();
        for (byte b : hashedPassword) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

}
