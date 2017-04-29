package xyz.jamesnuge.fantasyleague.model.user.password;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class SunPBKDF2PasswordGenerator implements PasswordGenerator {

    private static final int ITERATIONS = 20000;
    private static final int SALT_LENGTH = 32;
    private static final int KEY_LENGTH = 256;
    private static final String SHA_1_PRNG = "SHA1PRNG";
    private static final String PBKDF_2_WITH_HMAC_SHA_1 = "PBKDF2WithHmacSHA1";
    private static final String SPLIT_REGEX = "\\$";

    @Override
    public String getSaltedPassword(String password) throws PasswordException {
        try {
            byte[] salt = SecureRandom.getInstance(SHA_1_PRNG).generateSeed(SALT_LENGTH);
            return Base64.getEncoder().encodeToString(salt) + "$" + hash(password, salt);
        } catch (NoSuchAlgorithmException | IllegalArgumentException | InvalidKeySpecException e) {
            throw new PasswordException(e.getMessage());
        }
    }

    @Override
    public Boolean comparePasswords(String password, String stored) throws PasswordException {
        if (passwordIsEmpty(password))
            return false;
        String[] saltAndPass = stored.split(SPLIT_REGEX);
        if (saltAndPass.length != 2) {
            throw new IllegalStateException();
        }
        try {
            String hashOfInput = hash(password, Base64.getEncoder().encodeToString(saltAndPass[0].getBytes()).getBytes());
            return hashOfInput.equals(saltAndPass[1]);
        } catch (Exception e) {
            throw new PasswordException(e.getMessage());
        }
    }

    private static String hash(String password, byte[] salt) throws IllegalArgumentException, InvalidKeySpecException, NoSuchAlgorithmException {
        if (password == null || password.length() == 0)
            throw new IllegalArgumentException("Empty passwords are not supported.");
        SecretKeyFactory f = SecretKeyFactory.getInstance(PBKDF_2_WITH_HMAC_SHA_1);
        SecretKey key = f.generateSecret(new PBEKeySpec(
                password.toCharArray(), salt, ITERATIONS, KEY_LENGTH)
        );
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    private static boolean passwordIsEmpty(String password) {
        return password == null || password.length() == 0;
    }
}
