package com.xing.superaiagent;

import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiniMaxController {

    @Autowired
    private ChatLanguageModel chatLanguageModel;

    @GetMapping("/chat")
    public String chat(@RequestParam String message) {
        // 这行代码会调用配置文件中设定的 MiniMax 模型
        return chatLanguageModel.chat(message);
    }
}