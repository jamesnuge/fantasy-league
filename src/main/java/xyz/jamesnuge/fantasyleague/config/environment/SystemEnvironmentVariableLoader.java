package xyz.jamesnuge.fantasyleague.config.environment;

/**
 * Created by james on 11/04/17.
 */
public class SystemEnvironmentVariableLoader implements EnvironmentVariableLoader {
    public String getEnvironmentVariable(String name) {
        return System.getenv(name);
    }

    public Boolean environmentVariableisPresent(String name) {
        return System.getenv(name) != null;
    }

}
