package xyz.jamesnuge.fantasyleague.mapper;

import xyz.jamesnuge.fantasyleague.config.environment.FileEnvironmentVariableLoader;
import xyz.jamesnuge.fantasyleague.guice.FantasyMybatisBinder;

/**
 * Created by james on 19/04/17.
 */
public class TestGuiceBinder extends FantasyMybatisBinder {

    private static String TEST_ENV_FILENAME = "test.env";
    private static String DRIVER_TYPE = "org.postgresql.Driver";


    public TestGuiceBinder() throws Exception {
        super(new FileEnvironmentVariableLoader(Thread.currentThread().getContextClassLoader().getResource(TEST_ENV_FILENAME).getPath()));
    }
}
