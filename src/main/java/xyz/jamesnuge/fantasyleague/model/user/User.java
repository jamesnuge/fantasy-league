package xyz.jamesnuge.fantasyleague.model.user;

import xyz.jamesnuge.fantasyleague.model.BaseModel;
import xyz.jamesnuge.fantasyleague.model.user.password.HasPassword;
import xyz.jamesnuge.fantasyleague.model.user.password.PasswordException;
import xyz.jamesnuge.fantasyleague.model.user.password.PasswordGenerator;
import xyz.jamesnuge.fantasyleague.model.user.password.SunPBKDF2PasswordGenerator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.UUID;

public class User extends BaseModel<UUID, UserId> implements HasPassword {

    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;

    private static final PasswordGenerator PASSWORD_GENERATOR = new SunPBKDF2PasswordGenerator();

    public User(@NotNull UserId id, @NotNull String firstName, @Null String lastName, @NotNull String email, @NotNull String password) throws PasswordException {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = PASSWORD_GENERATOR.getSaltedPassword(passwordHash);
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
