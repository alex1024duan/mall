package org.djh.mall.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.djh.mall.common.Constant;

import java.security.MessageDigest;

/**
 * @author alex1024duan
 */
public class Md5Utils {

    public static String getMd5Str(String strValue) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            return Base64.encodeBase64String(md5.digest((strValue + Constant.SALT).getBytes()));
        }catch(Exception e) {
            e.printStackTrace();
            return strValue;
        }
    }

}
