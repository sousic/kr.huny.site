package kr.huny.site.common.crypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * Created by sousic on 2017-05-24.
 */
public class AESImpl implements ICrypto {
    public static final String ALGORITHM = "AES";

    private static final int KEY_SIZE_IN_BITS = 128;
    private final String key;

    public AESImpl(String key) {
        this.key = key;
    }

    @Override
    public byte[] encrypt(byte[] data) {
        return new byte[0];
    }

    @Override
    public byte[] decrypt(byte[] data) {
        return new byte[0];
    }

    private byte[] crypt(byte[] data, int encryptMode)
    {
        try {
            SecretKey secretKey = generateSecretKey();
            byte[] secretKeyByteRepresentation = secretKey.getEncoded();

            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyByteRepresentation, ALGORITHM);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(encryptMode, secretKeySpec);

            return cipher.doFinal(data);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    private SecretKey generateSecretKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(ALGORITHM);
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(key.getBytes());
            keyGenerator.init(KEY_SIZE_IN_BITS, secureRandom);

            return keyGenerator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
