package kg.mega.student_achievement_v2.dao;

import kg.mega.student_achievement_v2.models.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRep extends JpaRepository<Exam, Long> {

    @Query(value = "select * from exams where subject_id = :id",nativeQuery = true)
    List<Exam> findBySubject(Long id);
}
