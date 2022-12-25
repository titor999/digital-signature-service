package org.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.project.entity.Storage;
import org.project.entity.User;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.StringWriter;
import java.util.*;

public class DigitalServiceApplication {

    static Storage storage = Storage.getInstance () ;
    @SneakyThrows
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            System.out.println("input your name >>> ");
            String nameUser = sc.nextLine();
            System.out.println("input your email >>> ");
            String emailUser = sc.nextLine();
            System.out.println("input your password >>>");
            String passwordUser = sc.nextLine();
            storage.addNewUser(new User(uuidAsString, nameUser, emailUser, passwordUser, null, null));
            System.out.printf(storage.findAllUsers().toString());
        }
    }
}
