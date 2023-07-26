package lk.earth.earthuniversity.dao;
import lk.earth.earthuniversity.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseDao extends JpaRepository<Course,Integer>{
    Course findAllByCode(Integer id);

    Course findByCode(String code);

    Course findAllById(Integer id);

    @Query("SELECT NEW Course (c.id, c.name) FROM Course c")
    List<Course> findAllNameId();
}
