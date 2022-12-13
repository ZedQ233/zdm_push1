package com.unfbx.zdm_push;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import lombok.Data;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: ZedQ
 * @Date: 2022/12/13 10:07
 * @Description:
 */
public class top {

//FiddlerReponse-POJO

    @Data
    public class Datum {
        private long index;
        private String title;
        private String link;
        private String hot;

        public long getIndex() { return index; }
        public void setIndex(long value) { this.index = value; }

        public String getTitle() { return title; }
        public void setTitle(String value) { this.title = value; }

        public String getLink() { return link; }
        public void setLink(String value) { this.link = value; }

        public String getHot() { return hot; }
        public void setHot(String value) { this.hot = value; }
    }




    public class FiddlerReponseModel {
        private long state;
        private String title;
        private String subtitle;
        private String type;
        private long ruleID;
        private String updateTime;
        private List<Datum> data;

        public long getState() { return state; }
        public void setState(long value) { this.state = value; }

        public String getTitle() { return title; }
        public void setTitle(String value) { this.title = value; }

        public String getSubtitle() { return subtitle; }
        public void setSubtitle(String value) { this.subtitle = value; }

        public String getType() { return type; }
        public void setType(String value) { this.type = value; }

        public long getRuleID() { return ruleID; }
        public void setRuleID(long value) { this.ruleID = value; }

        public String getUpdateTime() { return updateTime; }
        public void setUpdateTime(String value) { this.updateTime = value; }

        public List<Datum> getData() { return data; }
        public void setData(List<Datum> value) { this.data = value; }
    }
    public static void main(String[] args) {
//        //存储 键值对 抖音今日热门视频-> 100038
//        HashMap<String, String> hashMap = new HashMap<>();
//        OkHttpClient client1 = new OkHttpClient();
//
//        Request request1 = new Request.Builder()
//                .url("https://www.ionews.top/list.html")
//                .get()
//                .addHeader("cookie", "X_CACHE_KEY=684e456aec92785339bd1fad433d257f")
//                .addHeader("Host", "www.ionews.top")
//                .addHeader("Connection", "keep-alive")
//                .addHeader("Cache-Control", "max-age=0")
//                .addHeader("Upgrade-Insecure-Requests", "1")
//                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
//                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
//                .addHeader("Referer", "https://www.ionews.top/")
//                .addHeader("Accept-Language", "zh-CN,zh;q=0.9")
//                .build();
//
//        try {
//            Response response = client1.newCall(request1).execute();
//            String s = response.body().string();
//            String[] split = s.split("<li class=\"hot-list\" data-id=\"");
//            for (int j = 1 ;j<split.length;j++) {
//                String s2 = split[j].split("\"><a href=\"/id-")[0];
//
////                100000" data-user="system" data-name="百度实时热点排行榜
//
//                String[] strings = s2.split("\"");
//                String[] strings1 = s2.split("\"", 1);
//                //编号
//                String num = strings[0];
//                //名称
//                String name = strings[4];
//                hashMap.put(name,num);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        String token = "TURJeU1ESXhOVGMzTWpreU5UUT11OHNSU05UZzJhRXhuYkdoWGExQjVPRU5yVWpGVVYxZG1hVGhYUkVSdlNHbDJVWFZy";
        String id = "100038";

        OkHttpClient client = new OkHttpClient();

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

            FiddlerReponseModel fiddlerReponseModel = jsonObject.toBean(FiddlerReponseModel.class);
            List<Datum> list = fiddlerReponseModel.getData();

            for (Datum datum : list) {
                System.out.println(datum.toString());
            }

            String s = jsonObject.toString();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
