package br.com.alura.chalenge.conversor.config;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApiKeyLoader {
    public static String getApiKey() {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("config.properties"));
            return props.getProperty("API_KEY");
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar a API KEY", e);
        }
    }
}

