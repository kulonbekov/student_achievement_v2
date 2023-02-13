package kg.mega.student_achievement_v2.dao;

import kg.mega.student_achievement_v2.models.entities.Scholarship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ScholarshipRep extends JpaRepository<Scholarship, Long> {

    @Query (value = "select * from scholarships where student_id = :id", nativeQuery = true)
    List<Scholarship> findByStudentId (Long id);
}
