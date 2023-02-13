package kg.mega.student_achievement_v2.dao;

import kg.mega.student_achievement_v2.models.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRep extends JpaRepository<Grade, Long> {

    @Query (value = "select * from grades where student_id = :id", nativeQuery = true)
    List<Grade> findByStudent (Long id);
}
