package xyz.jamesnuge.fantasyleague.model.user.password;

/**
 * Created by james on 9/04/17.
 */
public interface HasPassword {
    public void setPassword(String password) throws PasswordException;
    public String getPasswordHash();
}
