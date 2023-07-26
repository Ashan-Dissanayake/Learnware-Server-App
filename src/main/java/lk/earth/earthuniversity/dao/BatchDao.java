package lk.earth.earthuniversity.dao;
import lk.earth.earthuniversity.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BatchDao extends JpaRepository<Batch,Integer> {

    @Query("SELECT NEW Batch (b.id, b.name) FROM Batch b")
    List<Batch> findAllNameId();

    List<Batch> findAll();

    Batch findAllById(Integer id);

    Batch findAllByNumber(String number);

//    @Query("select b from Batch b where b.name = :name")
//    List<Batch> findByBatchName(@Param("name") String name);
}
