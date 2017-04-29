package xyz.jamesnuge.fantasyleague.model.user;

import xyz.jamesnuge.fantasyleague.model.BaseModel;
import xyz.jamesnuge.fantasyleague.model.user.password.HasPassword;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.UUID;

/**
 * Created by james on 9/04/17.
 */
public class User extends BaseModel<UUID, UserId> implements HasPassword {

    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;

    public User(@NotNull UserId id, @NotNull String firstName, @Null String lastName, @NotNull String email, @NotNull String password) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public void setPassword(String password) {
        this.passwordHash = password;
    }

    public String getPasswordHash() {
        return this.passwordHash;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!firstName.equals(user.firstName)) return false;
        if (!lastName.equals(user.lastName)) return false;
        if (!email.equals(user.email)) return false;
        return passwordHash.equals(user.passwordHash);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + passwordHash.hashCode();
        return result;
    }
}
