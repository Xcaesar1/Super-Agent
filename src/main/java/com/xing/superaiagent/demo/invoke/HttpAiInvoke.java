package com.xing.superaiagent.demo.invoke;

import cn.hutool.core.lang.Dict;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;

import java.util.Arrays;

public class HttpAiInvoke {

    public static void main(String[] args) {
        // 从环境变量获取，或者直接填入你的 DASHSCOPE_API_KEY
        String apiKey = TestAPIkey.API_KEY;
        String url = "https://dashscope.aliyuncs.com/api/v1/services/aigc/text-generation/generation";

        // 使用 Hutool 的 Dict 优雅地构建 JSON（推荐）
        Dict requestBody = Dict.create()
                .set("model", "qwen-plus")
                .set("input", Dict.create()
                        .set("messages", Arrays.asList(
                                Dict.create().set("role", "system").set("content", "You are a helpful assistant."),
                                Dict.create().set("role", "user").set("content", "你是谁？")
                        ))
                )
                .set("parameters", Dict.create()
                        .set("result_format", "message")
                );
        String jsonBody = JSONUtil.toJsonStr(requestBody);

        // 发起 HTTP POST 请求
        try (HttpResponse response = HttpRequest.post(url)
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json") // 在 hutool 中，传 json 字符串的 body 会自动设置此 content-type，不加这行也可以
                .body(jsonBody)
                .execute()) {

            // 打印请求返回结果
            System.out.println("Status: " + response.getStatus());
            System.out.println("Response Body: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
