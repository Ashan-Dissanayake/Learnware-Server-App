package lk.earth.earthuniversity.dao;
import lk.earth.earthuniversity.entity.Gaurdiantype;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuardiantypeDao extends JpaRepository<Gaurdiantype,Integer> {

    List<Gaurdiantype> findAll();

}
