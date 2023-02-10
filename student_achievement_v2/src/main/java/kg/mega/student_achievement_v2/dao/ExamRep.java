package kg.mega.student_achievement_v2.dao;

import kg.mega.student_achievement_v2.models.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRep extends JpaRepository<Exam, Long> {
}
