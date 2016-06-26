package edu.whu.irlab.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;

/**
 * Created by Roger on 2016/5/24.
 */
public class PasswordHelper {

    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    public static String entryptPassword(String plainPassword){
        // String salt = "barcelona";
        //产生盐
        // String salt = randomNumberGenerator.nextBytes().toHex();
        String salt = "3a6486a99e1ca5f07cc19fb05ce867de";
        String hashPassword = new Md5Hash(plainPassword, salt).toString();
        //SHA-1, SHA-256, SHA512
        // String hashPassword = new SimpleHash("SHA-1", plainPassword, SALT).toString();

        // System.out.println(salt);
        return hashPassword;
    }

    public static String entryptPasswordDefault(String password){
        //产生盐
        String salt = randomNumberGenerator.nextBytes().toHex();
        // 默认算法SHA-512
        DefaultHashService hashService = new DefaultHashService();
        hashService.setHashAlgorithmName("SHA-512");
        // 私盐, 默认无, 其在散列时自动与用户传入的公盐混合产生一个新盐
        hashService.setPrivateSalt(new SimpleByteSource(salt));
        // 用于生成公盐, 默认就这个, 可以通过 generatePublicSalt 属性在用户没有传入公盐的情况下是否生成公盐
        hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());
        // 生成Hash值得迭代次数
        hashService.setHashIterations(1);
        // 需要构建一个 HashRequest，传入算法、数据、公盐、迭代次数
        HashRequest request = new HashRequest.Builder()
                .setAlgorithmName("SHA-1").setSource(ByteSource.Util.bytes(password))
                .setSalt(ByteSource.Util.bytes(salt))
                .setIterations(2).build();
        String hex = hashService.computeHash(request).toHex();

        return hex;
    }

    public static void main(String[] args) {
        System.out.println(entryptPassword("admin"));
    }
}
