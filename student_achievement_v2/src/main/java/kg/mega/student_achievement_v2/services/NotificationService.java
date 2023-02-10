package kg.mega.student_achievement_v2.services;

public interface NotificationService {
    void send(String to, String subject, String text);
}
