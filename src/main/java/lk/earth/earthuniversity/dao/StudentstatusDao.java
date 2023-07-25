package lk.earth.earthuniversity.dao;

import lk.earth.earthuniversity.entity.Studentstatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentstatusDao extends JpaRepository<Studentstatus,Integer> {

    List<Studentstatus> findAll();
}
