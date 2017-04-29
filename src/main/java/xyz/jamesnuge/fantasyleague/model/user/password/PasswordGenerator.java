package xyz.jamesnuge.fantasyleague.model.user.password;

import java.security.NoSuchAlgorithmException;

/**
 * Created by james on 29/04/17.
 */
public interface PasswordGenerator {
    String getSaltedPassword(String password) throws PasswordException;
    Boolean comparePasswords(String password, String stored) throws PasswordException;
}
