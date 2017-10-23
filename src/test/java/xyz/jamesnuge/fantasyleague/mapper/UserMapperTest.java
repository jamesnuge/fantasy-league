package xyz.jamesnuge.fantasyleague.mapper;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;
import xyz.jamesnuge.fantasyleague.model.user.User;
import xyz.jamesnuge.fantasyleague.model.user.UserId;
import xyz.jamesnuge.fantasyleague.model.user.password.PasswordException;

import javax.inject.Inject;

import java.util.UUID;

import static org.testng.Assert.assertTrue;

/**
 * Created by james on 10/04/17.
 */
@Guice(modules = {TestGuiceBinder.class})
public class UserMapperTest {

    @Inject
    public UserMapper userMapper;

    @Test
    public void initTest() throws Exception {
        assertTrue(userMapper != null);
    }

    @Test
    public void insertTest() throws Exception {
        User user = generateTestUser();
        userMapper.insert(user);
    }

    @Test
    public void testGetById() throws Exception {
        User user = generateTestUser();
        userMapper.insert(user);
        User retrievedUser = userMapper.getById(user.getId());
        assertTrue(user.equals(retrievedUser));
    }

    public static User generateTestUser() throws PasswordException {
        return new User(new UserId(UUID.randomUUID()), "firstName", "lastName", "email@email.com", "testPassword");
    }
}
