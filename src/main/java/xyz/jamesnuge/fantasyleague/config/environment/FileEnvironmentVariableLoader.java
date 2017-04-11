package xyz.jamesnuge.fantasyleague.config.environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by james on 11/04/17.
 */
//This class can take a property file with properties that will take precedence over the system environment variables
public class FileEnvironmentVariableLoader extends SystemEnvironmentVariableLoader {

    private final Properties properties;

    public FileEnvironmentVariableLoader(String fileName) {
        properties = new Properties();
        File file = new File(fileName);
        if (file.exists()) {
            try {
                 FileInputStream envFile = new FileInputStream(file);
                 properties.load(envFile);
            } catch (IOException ex) {

            }
        }
    }

    @Override
    public String getEnvironmentVariable(String name) {
        return properties.getProperty(name) != null ? properties.getProperty(name) : super.getEnvironmentVariable(name);
    }

    @Override
    public Boolean environmentVariableisPresent(String name) {
        return properties.getProperty(name) != null ? true : super.environmentVariableisPresent(name);
    }

}
