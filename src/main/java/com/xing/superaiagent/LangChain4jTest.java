package com.xing.superaiagent;

import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LangChain4jTest implements CommandLineRunner {

    // Spring Boot Starter 会根据 yml 配置自动注入这个 Bean
    private final ChatLanguageModel chatLanguageModel;

    public LangChain4jTest(ChatLanguageModel chatLanguageModel) {
        this.chatLanguageModel = chatLanguageModel;
    }

    @Override
    public void run(String... args) {
        System.out.println("==== 开始测试 LangChain4j 连接 MiniMax ====");
        try {
            // 发起最简单的对话
            String response = chatLanguageModel.chat("你好，如果你收到了这条消息，请回复：连接成功！");

            System.out.println("AI 回复内容: " + response);
            System.out.println("==== 连接测试完成！ ====");
        } catch (Exception e) {
            System.err.println("==== 连接失败！错误信息如下： ====");
            e.printStackTrace();
        }
    }
}