package com.study.base.encryption;

import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/** 对称加密 */
public class Symmetric {
  public static void main(String[] args) throws GeneralSecurityException {
    String message = "Hello, world!";
    // 256位密钥 = 32 bytes Key:
    String key = "1234567890abcdef1234567890abcdef";
    final byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
    final byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);

    final AES_ECB aes_ecb = new AES_ECB();
    final byte[] encrypt = aes_ecb.encrypt(keyBytes, bytes);
    final String encryptString = Base64.getEncoder().encodeToString(encrypt);
    final byte[] decrypt = aes_ecb.decrypt(keyBytes, encrypt);
    final String decryptString = new String(decrypt);
    System.out.println("AES ECB encrypt: " + encryptString);
    System.out.println("AES ECB decrypt: " + decryptString);

    final AES_CBC aes_cbc = new AES_CBC();
    final byte[] encrypt1 = aes_cbc.encrypt(keyBytes, bytes);
    final String encryptString1 = Base64.getEncoder().encodeToString(encrypt1);
    final byte[] decrypt1 = aes_cbc.decrypt(keyBytes, encrypt1);
    final String decryptString1 = new String(decrypt1);
    System.out.println("AES CBC encrypt: " + encryptString1);
    System.out.println("AES CBC decrypt: " + decryptString1);
  }
}

/** ECB模式是最简单的AES加密模式，它只需要一个固定长度的密钥，固定的明文会生成固定的密文 */
class AES_ECB {
  public byte[] encrypt(final byte[] key, final byte[] input) throws GeneralSecurityException {
    final Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    final SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
    cipher.init(Cipher.ENCRYPT_MODE, keySpec);
    return cipher.doFinal(input);
  }

  public byte[] decrypt(final byte[] key, final byte[] input) throws GeneralSecurityException {
    final Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    final SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
    cipher.init(Cipher.DECRYPT_MODE, keySpec);
    return cipher.doFinal(input);
  }
}

/** CBC模式需要一个随机数作为IV参数，这样对于同一份明文，每次生成的密文都不同，比ECB模式更安全 */
class AES_CBC {
  public byte[] encrypt(final byte[] key, final byte[] input) throws GeneralSecurityException {
    final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    final SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
    // CBC模式需要生成一个16 bytes的initialization vector
    final SecureRandom secureRandom = SecureRandom.getInstanceStrong();
    final byte[] iv = secureRandom.generateSeed(16);
    final IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
    cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);
    final byte[] data = cipher.doFinal(input);
    // IV不需要保密，把IV和密文一起返回: iv和密文的顺序要和解密时拆解的顺序一致
    return join(iv, data);
  }

  public byte[] decrypt(final byte[] key, final byte[] input) throws GeneralSecurityException {
    // 把input分割成iv和data
    final byte[] iv = new byte[16];
    final byte[] data = new byte[input.length - 16];
    System.arraycopy(input, 0, iv, 0, 16);
    System.arraycopy(input, 16, data, 0, data.length);
    // 解密
    final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    final SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
    final IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
    cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);
    return cipher.doFinal(data);
  }

  private byte[] join(final byte[] bs1, final byte[] bs2) {
    final byte[] bytes = new byte[bs1.length + bs2.length];
    System.arraycopy(bs1, 0, bytes, 0, bs1.length);
    System.arraycopy(bs2, 0, bytes, bs1.length, bs2.length);
    return bytes;
  }
}
