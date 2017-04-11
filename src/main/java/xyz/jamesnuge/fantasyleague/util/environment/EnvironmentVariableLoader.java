package xyz.jamesnuge.fantasyleague.util.environment;

/**
 * Created by james on 11/04/17.
 */
public interface EnvironmentVariableLoader {

    String getEnvironmentVariable(String name);
    Boolean environmentVariableisPresent(String name);
    default String getEnvironmentVariableOrDefault(String name, String defaultValue) {
        return environmentVariableisPresent(name) ? getEnvironmentVariable(name) : defaultValue;
    }

}
