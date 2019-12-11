package com.demo.model.universal;

import org.springframework.util.ResourceUtils;

import javax.crypto.Cipher;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.security.Key;

public class DESUtil {

    public static String passwordEncrypt(String pass){
        Key keys = DESUtil.getKey();
        return DESUtil.encrypt(keys,pass);
    }


    public static Key getKey(){
        try{
//            发布使用
            FileInputStream f = new FileInputStream("C:\\Program Files (x86)\\Spot-Visualization\\code\\key.txt");
//            FileInputStream f = new FileInputStream("src\\main\\resources\\key.txt");
            ObjectInputStream ips = new ObjectInputStream(f);

            Key k = (Key) ips.readObject();

            return k;
        }catch (Exception e) {
            // TODO: handle exception
//            logger.warning(e.getMessage());
        }
        return null;

    }


    public static String encrypt(Key k, String code) {
        try{
            Cipher cp = Cipher.getInstance("DESede");
            cp.init(Cipher.ENCRYPT_MODE, k);
            byte codebyte[] = code.getBytes("UTF8");
            byte encode[] = cp.doFinal(codebyte);
            return parseByte2HexStr(encode);
        }catch (Exception e) {
//            logger.warning(e.getMessage());
        }
        return null;

    }


    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();

    }
                }


