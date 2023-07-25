package lk.earth.earthuniversity.dao;

import lk.earth.earthuniversity.entity.Devision;
import lk.earth.earthuniversity.entity.Employee;
import lk.earth.earthuniversity.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface LessonDao extends JpaRepository<Lesson,Integer>{

    @Query("SELECT NEW Lesson (l.id, l.name) FROM Lesson l")
    List<Lesson> findAllNameId();

    List<Lesson> findAll();
}
