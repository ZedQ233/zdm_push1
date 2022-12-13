package com.unfbx.zdm_push;
import cn.hutool.core.net.URLEncoder;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.json.JSONUtil;
import lombok.Data;
import okhttp3.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author: ZedQ
 * @Date: 2022/12/10 18:50
 * @Description:
 */
public class pianku {

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


    public static void main(String[] args) {
        String word = "_E5_90_9E_E5_99_AC1";
        String encode = URLUtil.encode("吞噬星空");
        encode = StrUtil.removePrefix(encode,"%");
        String[] split = encode.split("%");
        word = "";
        for (String s : split) {
            word+="_"+s;
        }




        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://www.btnull.org/s/ajax/"+word)
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




    }
}






