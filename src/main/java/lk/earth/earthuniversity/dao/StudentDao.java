package lk.earth.earthuniversity.dao;
import lk.earth.earthuniversity.entity.Batch;
import lk.earth.earthuniversity.entity.Employee;
import lk.earth.earthuniversity.entity.Student;
import lk.earth.earthuniversity.entity.Studentstatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentDao extends JpaRepository<Student,Integer> {

    List<Student> findAll();

    @Query("SELECT NEW Student (s.id, s.name) FROM Student s")
    List<Student> findAllNameId();

    @Query("select s from Student s where s.id = :id and s.name = :name")
    Student findAllByList(@Param("id") Integer id,@Param("name") String name);

    @Query("select s from Student s where s.id = :id")
    Student findByMyId(@Param("id") Integer id);


}
