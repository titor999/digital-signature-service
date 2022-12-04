package org.project.service.impl;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import lombok.SneakyThrows;

public class KeyGenerator {
    @SneakyThrows
    public static KeyPair getKeyPairKey(String algo) {
        KeyPairGenerator generator = KeyPairGenerator.getInstance(algo);
        generator.generateKeyPair();
        return generator.generateKeyPair();
    }

    /**
     * getKeyPair generate public and private key
     * 
     * @return PublicKey
     * @throws NoSuchAlgorithmException
     */
    public static PublicKey getPublicKey(KeyPair keyPair) {
        return keyPair.getPublic();
    }

    /**
     * getKeyPair generate public and private key
     * 
     * @return PrivateKey
     * @throws NoSuchAlgorithmException
     */
    public static PrivateKey getPrivateKey(KeyPair keyPair) {
        return keyPair.getPrivate();
    }
}
