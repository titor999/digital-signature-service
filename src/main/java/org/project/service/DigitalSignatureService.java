package org.project.service;

import java.security.PrivateKey;
import java.security.PublicKey;

public interface DigitalSignatureService {
    byte[] getSignature(PrivateKey privateKey, byte[] fileHash, String algo);

    boolean verify(PublicKey publicKey, byte[] fileHash, byte[] digitalSignature, String algo);
}
