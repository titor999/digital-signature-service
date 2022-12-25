package org.project.entity;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.util.List;

public class Storage {
    private static Storage ourInstance;
    private final List<User> users;
    private static final File DATABASE_FILE = new File("./dbJson.json");
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public synchronized static Storage getInstance() {
        if (!DATABASE_FILE.exists()) {
            boolean isCreated = DATABASE_FILE.createNewFile();
            if (!isCreated) {
                throw new RuntimeException();
            }
            Files.writeString(DATABASE_FILE.toPath(), "[]");
        }
        if (ourInstance == null) {
            ourInstance = new Storage();
        }
        return ourInstance;
    }
    private Storage() {
        users = findAllUsers();
    }

    @SneakyThrows
    public synchronized User findUserById (String id) {
        List<User> users = objectMapper.readValue(DATABASE_FILE, new TypeReference<>() {
        });
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @SneakyThrows
    public synchronized User findUserByName(String name) {
        List<User> users = objectMapper.readValue(DATABASE_FILE, new TypeReference<>() {
        });
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @SneakyThrows
    public synchronized User findUserByEmail(String email) {
        List<User> users = objectMapper.readValue(DATABASE_FILE, new TypeReference<>() {
        });
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @SneakyThrows
    public synchronized List<User> findAllUsers() {
        List<User> users = objectMapper.readValue(DATABASE_FILE, new TypeReference<>() {
        });
        return users;
    }

    @SneakyThrows
    public synchronized void addNewUser(User user) {
        List<User> users = objectMapper.readValue(DATABASE_FILE, new TypeReference<>() {
        });
        user.setPassword(BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray()));
        users.add(user);
        objectMapper.writeValue(DATABASE_FILE, users);
    }
}
