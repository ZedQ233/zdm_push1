package com.unfbx.zdm_push.utils;

import org.apache.commons.codec.binary.Base64;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Objects;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


/**
 * @Author: ZedQ
 * @Date: 2022/12/14 14:33
 * @Description:
 */
public class JavaScriptProvider<T> {


//    /**
//     * @return 解密后的字符串
//     * @Description: 解密
//     * @Param encodedStrBase64 加密过的密文base64形式（由加密方法返回的）  key 密钥，长度必须大于等于8位
//     * @Date: 2021/4/8 13:27
//     **/
//    public static String decrypt(String encodedStrBase64, String key) throws Exception {
//        if (encodedStrBase64 == null || encodedStrBase64.isEmpty()) {
//            throw new Exception("密文不能为空！");
//        }
//
//        if (key == null || key.isEmpty() || key.length() < 8) {
//            throw new Exception("密钥不能为空，且密钥必须大于等于8位！");
//        }
//
//        byte[] src = Base64.decodeBase64(encodedStrBase64);
//
//        // DES算法要求有一个可信任的随机数源
//        SecureRandom random = new SecureRandom();
//        // 创建一个DESKeySpec对象
//        DESKeySpec desKey = new DESKeySpec(key.getBytes("utf-8"));
//        // 创建一个密匙工厂
//        // 返回实现指定转换的 Cipher 对象
//        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("TripleDES");
//        // 将DESKeySpec对象转换成SecretKey对象
//        SecretKey securekey = keyFactory.generateSecret(desKey);
//        // Cipher对象实际完成解密操作
//        Cipher cipher = Cipher.getInstance("DES");
//        // 用密匙初始化Cipher对象
//        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
//        // 真正开始解密操作
//        return new String(cipher.doFinal(src));
//    }


//    public T loadJs(String jsName,Class<T> clazz) throws FileNotFoundException, ScriptException {
//        // 创建一个脚本引擎管理器
//        ScriptEngineManager manager = new ScriptEngineManager();
//        // 获取一个指定的名称的脚本引擎
//        ScriptEngine engine = manager.getEngineByName("js");
//        // 获取js文件所在目录的路径
//        String path = JavaScriptProvider.class.getResource("").getPath()+"js/";
//        engine.eval(new FileReader(path + jsName + ".js"));
//        // 从脚本引擎中返回一个给定接口的实现
//        Invocable invocable = (Invocable) engine;
//        return invocable.getInterface(clazz);
//    }


//    public static void main(String[] args) {
//        String str = "B0Zf4gET1B4cRbaFKZZDyegKUjmF4QYJN0wPlVhxsPzIsAheQBA9KujcC/ZAM2R8XqB+VAy8kfQgeOEuhpS38A==";
//        String key = "'L/PmfFIKf1Z2jtYRd3nCaC8TqxRdcfDZ8fko+BohZ2s='";
//
//        //获取d_code
//        String h1 = "TsJsXEJEJXTsTsXJETXEJTTXEJEEXEJTEXTsEEXEJTTXEJTJXEEsJXJJEXETEEXEETTXEsJEXEsTEXEEJsXTsEEXEJTTXEJTTXETJEXEsTJXTsTTXETEsXETEsXTsEJXETEEXETETXTsTTXETEEXETTTXTsEsXEsEEXETTEXEsJTXETTTXTsEJXTsJTXETTsXEJTTXEJTEXEJJsXEETTXEJssXEsJTXEJJsXTssEXTsEEXEssEXEETsXTsEEXEJJTXEJssXEsTsXTsTEXEEsJXJJEXEEsEX";
//        Integer u1 = 5;
//        String n1 = "sETJXnPFz";
//        Integer t1 = 22;
//        Integer e1 = 4;
//        Integer r1 = 42;
//
//
//        try {
//            JavaScriptProvider<JSMethods> jsProvider = new JavaScriptProvider<>();
//            JSMethods jsMethods = jsProvider.loadJs("method", JSMethods.class);
//            System.out.println(jsMethods.getCode(h1,u1,n1,t1,e1,r1));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
////        try {
////            System.out.println(JavaScriptProvider.decrypt(str,key));
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//
//    }


    public T loadJs(String jsName,Class<T> clazz) throws FileNotFoundException, ScriptException {
        //当前路径
//        String root = System.getProperty("user.dir");
//        System.out.println(root);

        //创建一个脚本引擎管理器
        ScriptEngineManager manager = new ScriptEngineManager();
        //获取一个指定的名称的脚本管理器
        ScriptEngine engine = manager.getEngineByName("js");
        //获取js文件所在的目录的路径
        String path = JavaScriptProvider.class.getResource("").getPath()+"/js/";
        engine.eval(new FileReader(path+jsName+".js"));
//        engine.eval(new FileReader(jsName));
        //从脚本引擎中返回一个给定接口的实现
        Invocable invocable = (Invocable) engine;
        return invocable.getInterface(clazz);
    }

//







}
