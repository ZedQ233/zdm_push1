package com.unfbx.zdm_push.service;

import cn.hutool.core.date.DateUtil;
import com.unfbx.zdm_push.api.ServerJPushApi;
import com.unfbx.zdm_push.api.ServerPushPlusApi;
import com.unfbx.zdm_push.constant.ServerJPushResponse;
import com.unfbx.zdm_push.constant.ServerPushPlusResponse;
import com.unfbx.zdm_push.constant.ServerResponse;
import com.unfbx.zdm_push.pojo.Move;
import com.unfbx.zdm_push.pojo.ZdmInfo;
import com.unfbx.zdm_push.utils.JSMethods;
import com.unfbx.zdm_push.utils.JavaScriptProvider;
import com.unfbx.zdm_push.utils.TripleDES;
import lombok.extern.java.Log;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Grt
 * @Date 2020-12-11
 */
@Service
@Log
public class ServerPush {


    @Resource
    private ServerJPushApi serverJPushApi;
    @Resource
    private ServerPushPlusApi serverPushPlusApi;
    /**
     * 私人密钥
     */
    @Value("${key.value}")
    private String keyValue;




//    @PostConstruct
//    public void getCode(){
//        String h1 = "mDfmtmKmDtmDmmtDKmKtmKfKtmKDftmKmftmDDftmKfKtmKfDtDmDDtDKfftmKKDtmKmftDDmKtmDDKtDmKKtmDKftmDDKtmDKDtDfDmtmKmftmDfmtDfDDtmDmDtDfmDtmDDKtmmKmtDDfDtDmfDtmKfftmDmftmDmmtDmmftDmKKtDffKtmDmDtmmKKtDfmmtmKfKtmKmftmKfmtDmfKtmKKmtDmKKtmKfmtmDKftmDDftDDKftDmmmtmDDftmDKKtmKKmtDDmmtmDmftDmDDtDKfftDmKft";
//        Integer u1 = 61;
//        String n1 = "KDmftWhJc";
//        Integer t1 = 40;
//        Integer e1 = 4;
//        Integer r1 = 52;
//        try {
//
//
//
//            JavaScriptProvider<JSMethods> jsProvider = new JavaScriptProvider<>();
////            JSMethods jsMethods = jsProvider.loadJs("com\\unfbx\\zdm_push\\utils\\js\\method.js",JSMethods.class);
//            JSMethods jsMethods = jsProvider.loadJs("method",JSMethods.class);
//            String code = jsMethods.getCode(h1,u1,n1,t1,e1,r1);
//            String str = "SIg54C9I0rgA8RG6E8JAQqc1O5uKrZCqUIDALEZ2nFnSwuVIfsPOiOFccC4LSAGtGeYgealuH3ISKcGp5vQ8TA";
//            System.out.println(code);
//
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (ScriptException e) {
//            e.printStackTrace();
//        }
//    }


    //推送docker信息 启动项目时执行
    @PostConstruct
    public ServerResponse pushPushMsgToWechat(){
        if(StringUtils.isBlank(keyValue)){
            return ServerResponse.createByError("为配置微信推送密钥，到application.yml配置");
        }
        Map<String,String> param = new HashMap<>();
        param.put("token",keyValue);
        param.put("title","docker镜像已上传");

        String content = "docker镜像已上传dockerhub <br> " +
                "3112560244/push_api:latest " +
                "<br> " +
                "来自 https://github.com/3112560244/zdm_push1/actions"
                +"<br> "
                + DateUtil.now();
                ;



//        System.out.println("-----------------------------------");
//        System.out.println(content);
//        System.out.println("-----------------------------------");

        param.put("content",content);
        param.put("template","html");
//        //群组 不填推送给自己
//        param.put("topic","电影");

        ServerPushPlusResponse serverPushResponse = serverPushPlusApi.sendToServerPushPlus(param);

        if (serverPushResponse == null){
            log.info("推送失败：系统异常");
            return ServerResponse.createByError("推送失败");
        }
        if(serverPushResponse.isSuccess(serverPushResponse.getCode())){
            return ServerResponse.createBySuccess("推送成功");
        }
        log.info("推送失败："+serverPushResponse.getMsg());
        return ServerResponse.createByError("推送失败");
    }


    //推送zdm
    public ServerResponse pushPushMsgToWechat(ZdmInfo zdmInfo){
        if(StringUtils.isBlank(keyValue)){
            return ServerResponse.createByError("为配置微信推送密钥，到application.yml配置");
        }
        Map<String,String> param = new HashMap<>();
        param.put("token",keyValue);
        param.put("title","近20条数据");

        List<Map<String, String>> mapList = zdmInfo.getMapList();
        String content = "";
        for(int i = 0; i< mapList.size(); i++){
            content+=i+"\n";
            Map<String, String> map = mapList.get(i);
            content +="线报url  "+map.get("线报url")+"\n";
            content +="线报标题  "+map.get("线报标题")+"\n";
            content +="详细内容  "+map.get("详细内容")+"\n";
            content +="图片地址  "+map.get("图片地址")+"\n";
        }

        System.out.println("-----------------------------------");
        System.out.println(content);
        System.out.println("-----------------------------------");

        param.put("content",content);
        param.put("template","html");
        //群组 不填推送给自己
        param.put("topic","奶");

        ServerPushPlusResponse serverPushResponse = serverPushPlusApi.sendToServerPushPlus(param);

        if (serverPushResponse == null){
            log.info("推送失败：系统异常");
            return ServerResponse.createByError("推送失败");
        }
        if(serverPushResponse.isSuccess(serverPushResponse.getCode())){
            return ServerResponse.createBySuccess("推送成功");
        }
        log.info("推送失败："+serverPushResponse.getMsg());
        return ServerResponse.createByError("推送失败");
    }

    //推送电影
    public ServerResponse pushPushMsgToWechat(List<Move> moves){
        if(StringUtils.isBlank(keyValue)){
            return ServerResponse.createByError("为配置微信推送密钥，到application.yml配置");
        }
        Map<String,String> param = new HashMap<>();
        param.put("token",keyValue);
        param.put("title","电影推送");

        String content = "";
        content+="共计"+moves.size()+"条记录";

        for(int i = 0; i< moves.size(); i++){
            content+=i+"<br>";
            Move move = moves.get(i);
            content +="title  "+move.getTitle()+"<br>";
            content +="url  "+move.getUrl()+"<br>";
            content +="img  "+ "<img src='"+move.getImg()+"' />";
        }

//        System.out.println("-----------------------------------");
//        System.out.println(content);
//        System.out.println("-----------------------------------");

        param.put("content",content);
        param.put("template","html");
        //群组 不填推送给自己
        param.put("topic","电影");

        ServerPushPlusResponse serverPushResponse = serverPushPlusApi.sendToServerPushPlus(param);

        if (serverPushResponse == null){
            log.info("推送失败：系统异常");
            return ServerResponse.createByError("推送失败");
        }
        if(serverPushResponse.isSuccess(serverPushResponse.getCode())){
            return ServerResponse.createBySuccess("推送成功");
        }
        log.info("推送失败："+serverPushResponse.getMsg());
        return ServerResponse.createByError("推送失败");
    }

    public ServerResponse pushJMsgToWechat(ZdmInfo zdmInfo){
        if(StringUtils.isBlank(keyValue)){
            return ServerResponse.createByError("为配置微信推送密钥，到application.yml配置");
        }
        ServerJPushResponse serverPushResponse = serverJPushApi.sendToServerJiang(keyValue,zdmInfo.getName(), zdmInfo.getUrl());

        if (serverPushResponse == null){
            log.info("推送失败：系统异常");
            return ServerResponse.createByError("推送失败");
        }
        if(serverPushResponse.isSuccess(serverPushResponse.getErrmsg())){
            return ServerResponse.createBySuccess("推送成功");
        }
        log.info("推送失败："+serverPushResponse.getErrmsg());
        return ServerResponse.createByError("推送失败");
    }
}
