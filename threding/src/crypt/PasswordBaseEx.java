package crypt;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

import com.mysql.cj.util.Base64Decoder;


public class PasswordBaseEx {
    static final String ALGO="ABC";

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        //1 .Base fpr pass
        //2. Create key base on keyspec

        String pass="abc";
        SecretKeyFactory factory=SecretKeyFactory.getInstance(ALGO);
        PBEKeySpec ksp= new PBEKeySpec(pass.toCharArray());
        SecretKey secretKey=factory.generateSecret(ksp);
        SecureRandom random=SecureRandom.getInstance("SHA1PRNG");
        byte[] salte= random.generateSeed(8);
        PBEParameterSpec spec=new PBEParameterSpec(salte,8);
        Cipher cipher=Cipher.getInstance(ALGO);

        // Encrypt
        cipher.init(cipher.ENCRYPT_MODE,secretKey,random);
        String clear="encrypt for java";
        byte[] encryted=cipher.doFinal(clear.getBytes());

    }
}
