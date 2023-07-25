package lk.earth.earthuniversity.dao;

import lk.earth.earthuniversity.entity.Classstatus;
import lk.earth.earthuniversity.entity.Clazz;
import lk.earth.earthuniversity.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface ClassDao extends JpaRepository<Clazz,Integer>{

    Clazz findAllById(Integer id);

    Optional<Clazz> findById(Integer id);

    @Query("select c from Clazz c where c.id = :id")
    Clazz findByMyId(@Param("id") Integer id);

    @Query("SELECT NEW Clazz (c.id) FROM Clazz c")
    List<Clazz> findAllNameId();



}
