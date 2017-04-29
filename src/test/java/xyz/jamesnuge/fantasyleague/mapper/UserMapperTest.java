package xyz.jamesnuge.fantasyleague.mapper;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import javax.inject.Inject;

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
}
