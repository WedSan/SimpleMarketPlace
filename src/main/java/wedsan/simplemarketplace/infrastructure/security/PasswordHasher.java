package wedsan.simplemarketplace.infrastructure.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {

    private final String algorithm;

    public PasswordHasher(String algorithm) {
        this.algorithm = algorithm;
    }

    public String hashPassword(String password){
        MessageDigest md;

        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        md.update(password.getBytes());
        byte[] hashedBytes = md.digest();
        StringBuilder sb = new StringBuilder();

        for(byte b: hashedBytes){
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
