package kg.mega.student_achievement_v2.dao;

import kg.mega.student_achievement_v2.models.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRep extends JpaRepository<Teacher, Long> {
}
