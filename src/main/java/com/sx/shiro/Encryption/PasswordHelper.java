package com.sx.shiro.Encryption;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.sx.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * moayi
 *加密信息处理
 * @create 2018-06-11 13:55
 **/
public class PasswordHelper {
    private RandomNumberGenerator randomNumberGenerator =
            new SecureRandomNumberGenerator();
    private String algorithmName = "md5";
    private final int hashIterations = 1024;
    public void encryptPassword(User user) {
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassWord(),
                ByteSource.Util.bytes(user.getUserName()+user.getSalt()),
                hashIterations).toHex();
        user.setPassWord(newPassword);
    }
}