package com.unfbx.zdm_push.utils;

/**
 * @Author: ZedQ
 * @Date: 2022/12/14 14:56
 * @Description: js函数
 */
public interface JSMethods {
    //解密js
//    String decrypt(String str,String key);

    //获取d_code
    String getCode(String h1,Integer u1,String n1,Integer t1,Integer e1,Integer r1);

}
