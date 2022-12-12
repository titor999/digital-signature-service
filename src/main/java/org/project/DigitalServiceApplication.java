package org.project;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Scanner;

import org.project.service.DigitalSignatureService;
import org.project.service.impl.DigitalSignatureServiceImpl;
import org.project.util.crypto.KeyGenerator;

import lombok.SneakyThrows;

public class DigitalServiceApplication {
    @SneakyThrows
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String nextLine = sc.nextLine();
            File file = new File(nextLine);
            byte[] bytes = Files.readAllBytes(Path.of(file.getPath()));
            System.out.println(Arrays.toString(bytes));
            KeyPair keyPairKey = KeyGenerator.getKeyPairKey("Ed25519");
            PrivateKey privateKey = keyPairKey.getPrivate();
            PublicKey publicKey = keyPairKey.getPublic();
            DigitalSignatureService digitalSignatureService = new DigitalSignatureServiceImpl();
            byte[] digitalSignature = digitalSignatureService.getSignature(privateKey, bytes, "Ed25519");
            if (digitalSignatureService.verify(publicKey, bytes, digitalSignature, "Ed25519")) {
                System.out.println("Verifying is complete");
            } else {
                System.out.println("Error");
            }
        }
    }
}
