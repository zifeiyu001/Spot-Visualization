//package com.demo.controller;
//
//import com.demo.model.universal.AppReport;
//import com.demo.model.universal.ResultJson;
//import com.demo.service.IndexService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.crypto.BadPaddingException;
//import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.NoSuchPaddingException;
//import javax.servlet.http.HttpServletResponse;
//import java.io.FileInputStream;
//import java.io.ObjectInputStream;
//import java.io.UnsupportedEncodingException;
//import java.security.InvalidKeyException;
//import java.security.Key;
//import java.security.NoSuchAlgorithmException;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//public class testController {
//    // 首页
//    @Autowired
//    private IndexService indexService;
//
////    获取点检结果
//    @RequestMapping(value = "/a/testApp", method = RequestMethod.GET)
//    @ResponseBody
//
////String mdnewpass = DataExchangeUtil.passwordEncrypt(pass);
//
//
//    public static String passwordEncrypt(String pass){
//        Key keys = DESUtil.getKey();
//        return DESUtil.encrypt(keys,pass);
//    }
//
//
//    public static Key getKey(){
//        try{
//            FileInputStream f = new FileInputStream(url);
//            ObjectInputStream ips = new ObjectInputStream(f);
//            Key k = (Key) ips.readObject();
//            return k;
//        }catch (Exception e) {
//            // TODO: handle exception
//            logger.warning(e.getMessage());
//        }
//        return null;
//
//    }
//
//
//    public static String encrypt(Key k, String code) {
// try {
//     Cipher cp = Cipher.getInstance("DESede");
//     cp.init(Cipher.ENCRYPT_MODE, k);
//     byte codebyte[] = code.getBytes("UTF8");
//     byte encode[] = cp.doFinal(codebyte);
//     return parseByte2HexStr(encode);
// }
// catch (NoSuchAlgorithmException e) {
//     e.printStackTrace();
// } catch (Object e) {
//     e.printStackTrace();
// } catch (NoSuchPaddingException e) {
//     e.printStackTrace();
// } catch (BadPaddingException e) {
//     e.printStackTrace();
// } catch (UnsupportedEncodingException e) {
//     e.printStackTrace();
// } catch (IllegalBlockSizeException e) {
//     e.printStackTrace();
// }
//
//
//        return null;
//
//    }
//
//
//    public static String parseByte2HexStr(byte buf[]) {
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < buf.length; i++) {
//            String hex = Integer.toHexString(buf[i] & 0xFF);
//            if (hex.length() == 1) {
//                hex = '0' + hex;
//            }
//            sb.append(hex.toUpperCase());
//        }
//        return sb.toString();
//
//    }
//}