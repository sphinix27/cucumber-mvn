package jala.auto.bootcamp.core.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Env
 */
public class Env {

    private static Env instance = new Env();
    private Properties envProperties;

    private Env() {
        try (FileInputStream fileInputStream = new FileInputStream("./src/main/resources/.env")) {
            envProperties = new Properties();
            envProperties.load(fileInputStream);
        } catch (IOException e) {
            // TODO: throw new MyCustomRuntimeException(message, e);
        }
    }

    public static Env getInstance() {
        return instance;
    }

    private String getEnv(final String env) {
        String property = System.getProperty(env);
        if (property == null) {
            return envProperties.getProperty(env);
        }
        return property;
    }

    public String getApiUrl() {
        return getEnv("api-url");
    }

    public String getApiKey() {
        return getEnv("key");
    }

    public String getApiToken() {
        return getEnv("token");
    }
}
