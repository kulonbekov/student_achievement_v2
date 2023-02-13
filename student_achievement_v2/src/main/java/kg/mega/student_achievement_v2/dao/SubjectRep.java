package kg.mega.student_achievement_v2.dao;

import kg.mega.student_achievement_v2.models.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRep extends JpaRepository<Subject, Long> {

    @Query(value = "select * from subjects where teacher_id = :id", nativeQuery = true)
    List<Subject> findByTeacher(Long id);
}
