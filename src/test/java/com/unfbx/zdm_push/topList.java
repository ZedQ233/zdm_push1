package com.unfbx.zdm_push;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;

/**
 * @Author: ZedQ
 * @Date: 2022/12/15 13:34
 * @Description:  获取map列表
 */
public class topList {
    public static void main(String[] args) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://ionews.top/list.html")
                .get()
                .addHeader("cookie", "X_CACHE_KEY=861a5133fce220d4991fa9b5ca6f9266; __51vcke__Jj6dXHipzE0mnSIv=2c7b8a25-3142-54b5-9a77-5085b4a23c34; __51vuft__Jj6dXHipzE0mnSIv=1671067369193; __51huid__Jj6kUSW2yFU47w5P=ae65c668-eedd-5ba0-83a5-d721cb12ad03; __51uvsct__Jj6dXHipzE0mnSIv=3; __vtins__Jj6dXHipzE0mnSIv=%257B%2522sid%2522%253A%2520%2522a660e3ae-05a2-5072-942d-dd60cf7b6f9f%2522%252C%2520%2522vd%2522%253A%25205%252C%2520%2522stt%2522%253A%2520225299%252C%2520%2522dr%2522%253A%2520187183%252C%2520%2522expires%2522%253A%25201671084186933%252C%2520%2522ct%2522%253A%25201671082386933%257D")
                .addHeader("Host", "ionews.top")
                .addHeader("Connection", "keep-alive")
                .addHeader("Cache-Control", "max-age=0")
                .addHeader("Upgrade-Insecure-Requests", "1")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36")
                .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .addHeader("Referer", "https://ionews.top/")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9")
                .build();

        try {
            Response response = client.newCall(request).execute();
            String html = response.body().string();
            System.out.println(html);

            Document document = Jsoup.parse(html);
            Elements elements = document.selectXpath("/html/body/main/div/div[1]/div/div/div/ul/li");
            Elements select = elements.select(".hot-list");

            HashMap<String, String> map = new HashMap<>();

            for (Element element : select) {
//                <li class="hot-list" data-id="100000" data-user="system" data-name="百度实时热点排行榜"><a href="/id-100000.html" class="d-flex text-sm mb-2"><span class="hot-id source-system">100000</span><span class="ml-auto text-nowrap pl-2 hot-mane">百度实时热点排行榜</span></a></li>

                element.text();
                //获取属性对应 值
                String id = element.attr("data-id");
                String name = element.attr("data-name");
                map.put(id,name);
            }

//            System.out.println(map);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
