package org.project.service.impl;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import org.project.service.DigitalSignatureService;

import lombok.SneakyThrows;

public class DigitalSignatureServiceImpl implements DigitalSignatureService {
  @SneakyThrows
  @Override
  public byte[] getSignature(PrivateKey privateKey, byte[] fileHash, String algo) {
    SecureRandom secureRandom = new SecureRandom();
    Signature signature = Signature.getInstance(algo);
    signature.initSign(privateKey, secureRandom);
    signature.update(fileHash);
    return signature.sign();
  }

  @SneakyThrows
  @Override
  public boolean verify(PublicKey publicKey, byte[] fileHash, byte[] digitalSignature, String algo) {
    Signature signature = Signature.getInstance(algo);
    signature.initVerify(publicKey);
    signature.update(fileHash);
    return signature.verify(digitalSignature);
  }
}
