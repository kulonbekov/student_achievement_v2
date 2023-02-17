package kg.mega.student_achievement_v2.dao;

import kg.mega.student_achievement_v2.models.dtos.ExamDto;
import kg.mega.student_achievement_v2.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRep extends JpaRepository<Student, Long> {

    @Query(value = "select * from students s where s.subject_id = :id", nativeQuery = true)
    Student findbyStudent (Long id);
}
