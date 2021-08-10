package guardlbt.common.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


public class RSAEncrypt {

    //加密
    public static String public_key="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBANUuYEvkkY6mFSvydHzRetTwerhITco6XBjXAiJ0a/ZtjNdOCS676S+Zh5PdVHU9QMKi3DZtS5PRUcATYFegFtUCAwEAAQ==";
    //解密
    public static String private_key="MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEA1S5gS+SRjqYVK/J0fNF61PB6uEhNyjpcGNcCInRr9m2M104JLrvpL5mHk91UdT1AwqLcNm1Lk9FRwBNgV6AW1QIDAQABAkAanV2cW/7oJkgCYpS0eJqzNwq7MxuzIbIZz84OayaHb0+PNZt8AVcT8/uPPAV6z2hR8/RdrVGsymu/2H9/BojJAiEA6aibCFwNAaOWtzuBatFBlrJ1m/Pe0NogQvL5lqTsnw8CIQDpkIg96N89/K2JmINQPWSByLS4Cu+eQ+t8vVLgzbur2wIhAKV47jIBXoSmoXmp/oDzKIvcXkXPcyBdGTPQdskkix4pAiAfAlZkSc+hzjNIClycwZnfdUMxEBqiG4hfRk+DkyzwcwIgF897GtpGTXmRJPgSYEAjyw65Wz8PVgmdXPzk4ZnBnWM=";


    public static void main(String[] args) throws Exception {

        //加密字符串，公钥加密，私钥解密
        String message = "123456789012345";
        String messageEn = encrypt(message,public_key);
        System.out.println(message + "\t加密后的字符串为:" + messageEn);
        String text5="OIgevxPRB3RJN0UPWMNsS+yI6ZcJ6jUa7Jprq+fE0HIzsaAbNzNPY/GOCIcCyiH8wRt6ltFav8rqStkJtyz65w==";
        String messageDe = decrypt(text5,private_key);
        System.out.println("还原后的字符串为:" + messageDe);
    }


    /**
     * RSA公钥加密
     * @param str  加密字符串
     * @param publicKey  公钥
     * @return 密文
     * @throws Exception  加密过程中的异常信息
     */
    public static String encrypt( String str, String publicKey ) throws Exception{
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * RSA私钥解密
     * @param str  加密字符串
     * @param privateKey   私钥
     * @return 铭文
     * @throws Exception   解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws Exception{
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));
        //base64编码的私钥
        byte[] decoded = Base64.decodeBase64(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }

}
