package com.motivation.ChatApp.controller;

import com.motivation.ChatApp.model.Message;
import com.motivation.ChatApp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private final MessageService messageService;
    private final RestTemplate restTemplate;

    @Autowired
    public ChatController(MessageService messageService, RestTemplate restTemplate) {
        this.messageService = messageService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/send")
    public String showChatForm() {
        return "chat-form";
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String pseudo, @RequestParam String content, Model model) {
        // Appel à l'API de citations
        String quoteApiUrl = "http://localhost:8080/api/random";
        Map<String, String> quoteResponse = restTemplate.getForObject(quoteApiUrl, Map.class);
        String quote = (quoteResponse != null) ? quoteResponse.get("content") : "No quote available";

        // Sauvegarde du message sans le quote
        Message message = new Message(pseudo, content);
        messageService.saveMessage(message);

        model.addAttribute("quote", quote);
        model.addAttribute("message", message);
        return "chat-form";
    }

    @GetMapping("/history")
    public String showMessageHistory(Model model) {
        List<Message> messages = messageService.getAllMessages();
        System.out.println("Messages récupérés: " + messages.get(1));
        model.addAttribute("messages", messages);
        return "chat-history";
    }

}
