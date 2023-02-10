package kg.mega.student_achievement_v2.dao;

import kg.mega.student_achievement_v2.models.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRep extends JpaRepository<Subject, Long> {
}
