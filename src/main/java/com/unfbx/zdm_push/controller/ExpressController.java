package com.unfbx.zdm_push.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.unfbx.zdm_push.constant.ServerPushPlusResponse;
import com.unfbx.zdm_push.constant.ServerResponse;
import com.unfbx.zdm_push.pojo.Move;
import com.unfbx.zdm_push.pojo.Top;
import com.unfbx.zdm_push.service.ServerPush;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.*;

/**
 * @Author: ZedQ
 * @Date: 2022/12/11 14:14
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/tools")
public class ExpressController {

    @Autowired
    private ServerPush serverPush = new ServerPush();

    public class FiddlerReponseModel {
        private String message;
        private long status;
        private Data1 data;

        public String getMessage() { return message; }
        public void setMessage(String value) { this.message = value; }

        public long getStatus() { return status; }
        public void setStatus(long value) { this.status = value; }

        public Data1 getData() { return data; }
        public void setData(Data1 value) { this.data = value; }
    }

    public class Data1 {
        private List<ToReachable> toReachable;
        private List<Object> fromReachable;

        public List<ToReachable> getToReachable() { return toReachable; }
        public void setToReachable(List<ToReachable> value) { this.toReachable = value; }

        public List<Object> getFromReachable() { return fromReachable; }
        public void setFromReachable(List<Object> value) { this.fromReachable = value; }
    }

    @Data
    public class ToReachable {
        private String expressCode;
        private Boolean reachable;
        private String reason;
        private String totalprice;
        private String costTotalPrice;
        private String couponPrice;

        public String getExpressCode() { return expressCode; }
        public void setExpressCode(String value) { this.expressCode = value; }

        public Boolean getReachable() { return reachable; }
        public void setReachable(Boolean value) { this.reachable = value; }

        public String getReason() { return reason; }
        public void setReason(String value) { this.reason = value; }

        public String getTotalprice() { return totalprice; }
        public void setTotalprice(String value) { this.totalprice = value; }

        public String getCostTotalPrice() { return costTotalPrice; }
        public void setCostTotalPrice(String value) { this.costTotalPrice = value; }

        public String getCouponPrice() { return couponPrice; }
        public void setCouponPrice(String value) { this.couponPrice = value; }



    }
    /*
     * @author ZedQ
     * @date 2022/12/11 15:07
     * @param null
     * @return null
     * @Description: 请求地址是否能够发货
     *     提供快递能否发货 查询接口
           /express/ban get请求
    {
        "toProvince": "河南省",
            "toCity": "郑州市",
            "toArea": "惠济区",
            "toAddress": "郑州财经学院"
    }
    */
    @GetMapping("/ban")
    public List<ToReachable> ExpressList(@RequestParam(defaultValue = "") String toProvince,
                                         @RequestParam(defaultValue = "") String toCity,
                                         @RequestParam(defaultValue = "") String toArea,
                                         @RequestParam(defaultValue = "") String toAddress
                                         ){
        System.out.println(toProvince+toCity+toArea+toAddress);
        String sendxzq="北京";
        String token="Z2Uklxp4Q4LeLVFUuKJVnEVLcV0KDc_Au48ytTQN7c8";

        OkHttpClient client = new OkHttpClient();


        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "platform=WWW&toProvince="+toProvince+"&toCity="+toCity+"&toArea="+toArea+"&toAddress="+toAddress+"&sendxzq="+sendxzq+"&token="+token);
        Request request = new Request.Builder()
                .url("https://www.kuaidi100.com/apicenter/order.do?method=expressStopInquiries")
                .post(body)
//                .addHeader("cookie", "_ga=GA1.1.317569217.1670649680; _gcl_au=1.1.1658459902.1670649680; loginId=313674334; loginType=SELLER; loginName=17739510180; nickname=17739510180; loginEmail=; loginMobile=17739510180; loginExt=%257B%2522country%2522%253Anull%252C%2522avatarId%2522%253A%2522http%253A%2F%2Fthirdqq.qlogo.cn%2Fg%253Fb%253Doidb%2526k%253D0NAUrC3lNrTFgc3oXaQWOQ%2526s%253D100%2526t%253D1582386125%2522%252C%2522province%2522%253A%2522%25u6CB3%25u5357%2522%252C%2522city%2522%253A%2522%25u7126%25u4F5C%25u5E02%2522%257D; _ga_RX03B5S2PX=GS1.1.1670654353.2.1.1670654532.60.0.0; WWWID=WWW4F8B84BC76F01274CD35EF043277594C; _adadqeqwe1321312dasddocTitle=kuaidi100; _adadqeqwe1321312dasddocReferrer=; _adadqeqwe1321312dasddocHref=; DEVICE_NUM=83589477b66b4a5b99bbd25da6b25c3d; SNT_TOKEN=PS2C10_108fa06c863a485daa005691f3f42691; SELF_TOKEN=PI2C10_1d4f9fd6d21248f699d9b55f8e91b98c; TOKEN=Z2Uklxp4Q4LeLVFUuKJVnEVLcV0KDc_Au48ytTQN7c8; auth=5; loginSession=1")
//                .addHeader("Host", "www.kuaidi100.com")
//                .addHeader("Connection", "keep-alive")
//                .addHeader("Content-Length", "281")
//                .addHeader("Accept", "application/json, text/javascript, */*; q=0.01")
//                .addHeader("Content-Type", "application/json")
//                .addHeader("X-Requested-With", "XMLHttpRequest")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                .addHeader("Origin", "https://www.kuaidi100.com")
                .addHeader("Referer", "https://www.kuaidi100.com/stop/stop.jsp")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9")
                .build();



        List<ToReachable> list;
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ResponseBody responseBody = response.body();

        String s = null;

        try {
            s = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //通过对象一步步解析
        FiddlerReponseModel fiddlerReponseModel = JSONUtil.toBean(s, FiddlerReponseModel.class);
        try {
            list = fiddlerReponseModel.getData().getToReachable();
        }catch (NullPointerException e){
            return null;
        }

        //拼音转文字
        for (ToReachable toReachable : list) {
            String name = null;
            switch (toReachable.getExpressCode()){
                case "zhongtong": name = "中通快递";break;
                case "yunda": name = "韵达快递";break;
                case "yuantong": name = "圆通速递";break;
                case "shentong": name = "申通快递";break;
                case "jtexpress": name = "极兔速递";break;
                case "jd": name = "京东物流";break;
                case "debangkuaidi": name = "德邦快递";break;
                case "shunfeng": name = "顺丰速运";break;
                case "youzhengguonei": name = "邮政国内快递";break;
                default:name = "未知";break;
            }
            toReachable.setExpressCode(name);
        }

//        list.stream().collect(Collectors.groupingBy(obj -> obj.getReachable()));

        list.sort(Comparator.comparing(ToReachable::getReachable));
        return list;
    }



    @GetMapping("/pianku")
    public ArrayList<Move> PianKuList(@RequestParam(defaultValue = "") String word) {

        String encode = URLUtil.encode(word);

        //去掉前缀
        encode = StrUtil.removePrefix(encode, "%");
        //分割
        String[] split = encode.split("%");

        //设置_前缀
        word = "";
        for (String s : split) {
            word += "_" + s;
        }

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://www.btnull.org/s/ajax/" + word)
                .get()
                .addHeader("cookie", "BT_auth=d00dnpjGuwLvSRxwPHi1wFq41uE4jZt3oZqlwEuKx5CsuWszOksVDmwIlY4iPWkg1-LHAXTtcra0rSsoWdGt4ItSfp9f7tww4b_8ycOfYLldoS69uwQ4F1wKAngEH7OszEaR5WZk8NGyMpn6tdMqoQOwh4GYFIvwXUzuVI_bDaAHaBM; BT_cookietime=b4c45LQj3kQ7fvLCpxehUNpi0dX5juO-mtFmdds; d_c=d_1219810101")
                .addHeader("Host", "www.btnull.org")
                .addHeader("Connection", "keep-alive")
                .addHeader("Accept", "application/json, text/javascript, */*; q=0.01")
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                .addHeader("Referer", "https://www.btnull.org/s/1---1/_E5_90_9E_E5_99_AC.html")
//                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9")
                .build();


        Response response = null;
        String string = "";

        try {
            response = client.newCall(request).execute();
            string = response.body().string();
            System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //通过jsonObject 解析
        JSONObject jsonObject = JSONUtil.parseObj(string);

//        JSONObject data = (JSONObject) jsonObject.get("data");
        JSONArray titleArray = (JSONArray) jsonObject.get("data");


        ArrayList<Move> moves = new ArrayList<>();

        for (Object o : titleArray) {
            String title, url, img;

            JSONObject json1 = JSONUtil.parseObj(o);
            title = (String) json1.get("title");
            url = (String) json1.get("url");
            img = (String) json1.get("img");
            moves.add(new Move(title, url, img));
        }

//        for (Move move : moves) {
//            System.out.println(move);
//        }


        //推送
//        if(moves.size()>0){
//            ServerResponse serverResponse = null;
//            serverResponse = serverPush.pushPushMsgToWechat(moves);
//            log.info("~~~~~~~~~~~~~~~~"+serverResponse.getMsg()+"~~~~~~~~~~~~~~~~");
//        }

        return moves;
    }



    @GetMapping("/top")
    public List<Top> TopsList(@RequestParam(defaultValue = "100038") String id) {
        String token = "TURJeU1ESXhOVGMzTWpreU5UUT11OHNSU05UZzJhRXhuYkdoWGExQjVPRU5yVWpGVVYxZG1hVGhYUkVSdlNHbDJVWFZy";
//        String id = "100038";

        OkHttpClient client = new OkHttpClient();
        List<Top> list = new ArrayList<>();
        Request request = new Request.Builder()
                .url("https://ionews.top/api/get.php?rule_id="+id+"&key="+token)
                .get()
                .addHeader("Host", "ionews.top")
                .addHeader("Connection", "keep-alive")
                .addHeader("Accept", "application/json, text/javascript, */*; q=0.01;charset=utf-8")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                .addHeader("Origin", "https://ioois.com")
                .addHeader("Referer", "https://ioois.com/")
//                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9")
                .build();

        try {
            Response response = client.newCall(request).execute();
            JSONObject jsonObject = new JSONObject(response.body().string());

            JSONArray jsonArray = (JSONArray) jsonObject.get("data");
            for (Object o : jsonArray) {
                JSONObject json = (JSONObject) o;
                list.add(json.toBean(Top.class));
            }


//            for (Top datum : list) {
//                System.out.println(datum.toString());
//            }
//
//            String s = jsonObject.toString();
//            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }



}





