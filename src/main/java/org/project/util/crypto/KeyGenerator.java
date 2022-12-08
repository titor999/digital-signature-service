package org.project.util.crypto;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import lombok.SneakyThrows;

public class KeyGenerator {
    /**
     * @param algo -> crypto algorythm
     * @return KeyPair
     * @throws NoSuchAlgorithmException
     */
    @SneakyThrows
    public static KeyPair getKeyPairKey(String algo) {
        KeyPairGenerator generator = KeyPairGenerator.getInstance(algo);
        generator.generateKeyPair();
        return generator.generateKeyPair();
    }

    /**
     * getPublicKey generate public key
     * 
     * @return PublicKey
     * @throws NoSuchAlgorithmException
     */
    public static PublicKey getPublicKey(KeyPair keyPair) {
        return keyPair.getPublic();
    }

    /**
     * getPrivateKey generate private Key
     * 
     * @return PrivateKey
     * @throws NoSuchAlgorithmException
     */
    public static PrivateKey getPrivateKey(KeyPair keyPair) {
        return keyPair.getPrivate();
    }
}
