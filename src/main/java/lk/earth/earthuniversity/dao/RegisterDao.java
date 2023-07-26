package lk.earth.earthuniversity.dao;
import lk.earth.earthuniversity.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisterDao extends JpaRepository<Register,Integer> {

//    Register findAllById(Integer id);

    Optional<Register> findById(Integer id);

//    @Query("select r from Register r where r.id = :id")
//    Register findByMyId(@Param("id") Integer id);

//    @Query("SELECT NEW Register (r.id) FROM Register r")
//    List<Register> findAllNameId();
}
