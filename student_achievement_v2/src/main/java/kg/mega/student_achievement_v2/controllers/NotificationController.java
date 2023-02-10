package kg.mega.student_achievement_v2.controllers;

import io.swagger.annotations.Api;
import kg.mega.student_achievement_v2.services.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Почта")
@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/send")
    public void send(@RequestParam String to, @RequestParam String subject, @RequestParam String text){
        notificationService.send(to,subject,text);
    }
}
