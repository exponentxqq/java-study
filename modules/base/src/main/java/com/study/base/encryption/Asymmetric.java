package com.study.base.encryption;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/** 非对称加密 */
public class Asymmetric {
  public static void main(String[] args)
      throws UnsupportedEncodingException, GeneralSecurityException {
    // 明文:
    byte[] message = "Hello, encrypt use RSA".getBytes("UTF-8");
    // 创建公钥/私钥对
    final RSA rsa = new RSA();
    // 用公钥加密
    final byte[] publicKey = rsa.getPublicKey();
    System.out.printf("public key: %x%n", new BigInteger(1, publicKey));
    final byte[] encrypt = rsa.encrypt(message);
    System.out.printf("RSA encrypt: %x%n", new BigInteger(1, encrypt));
    // 用私钥解密
    final byte[] privateKey = rsa.getPrivateKey();
    System.out.printf("private key: %x%n", new BigInteger(1, privateKey));
    final byte[] decrypt = rsa.decrypt(encrypt);
    System.out.printf("RSA decrypt: %s%n", new String(decrypt));
  }

  private static void restoreKey() throws GeneralSecurityException {
    final RSA rsa = new RSA();
    KeyFactory kf = KeyFactory.getInstance("RSA");
    // 恢复公钥:
    X509EncodedKeySpec pkSpec = new X509EncodedKeySpec(rsa.getPublicKey());
    PublicKey pk = kf.generatePublic(pkSpec);
    // 恢复私钥:
    PKCS8EncodedKeySpec skSpec = new PKCS8EncodedKeySpec(rsa.getPrivateKey());
    PrivateKey sk = kf.generatePrivate(skSpec);
  }
}

class RSA {
  PrivateKey privateKey;
  PublicKey publicKey;

  public RSA() throws GeneralSecurityException {
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    keyPairGenerator.initialize(1024);
    final KeyPair keyPair = keyPairGenerator.generateKeyPair();
    privateKey = keyPair.getPrivate();
    publicKey = keyPair.getPublic();
  }

  public byte[] getPrivateKey() {
    return privateKey.getEncoded();
  }

  public byte[] getPublicKey() {
    return publicKey.getEncoded();
  }

  public byte[] encrypt(byte[] message) throws GeneralSecurityException {
    Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(Cipher.ENCRYPT_MODE, publicKey);
    return cipher.doFinal(message);
  }

  public byte[] decrypt(byte[] input) throws GeneralSecurityException {
    final Cipher cipher = Cipher.getInstance("RSA");
    cipher.init(Cipher.DECRYPT_MODE, privateKey);
    return cipher.doFinal(input);
  }
}
