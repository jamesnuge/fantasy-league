package xyz.jamesnuge.fantasyleague.model.user;

/**
 * Created by james on 9/04/17.
 */
public interface HasPassword {
    public void setPassword(String password);
    public String getPasswordHash();
}
