package test.server.demo.ai;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {

    final
    AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/ai")
    public ResponseEntity<String> getAiResponse(@RequestParam String prompt){
        String answerPrompt = String.format("Please answer the following question: %s in about 100-120 words in easily understandable language. Make the answer a little bit funnier using tropical islands", prompt);
        return ResponseEntity.ok(aiService.prompt(answerPrompt));
    }
}
