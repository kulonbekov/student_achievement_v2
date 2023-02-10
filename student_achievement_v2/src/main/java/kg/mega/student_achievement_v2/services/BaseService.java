package kg.mega.student_achievement_v2.services;

import java.util.List;

public interface BaseService<T>{

    T save (T t);
    T findById(long id);
    List<T> findAll();
    T delete(long id);
    T update(long id);
}
