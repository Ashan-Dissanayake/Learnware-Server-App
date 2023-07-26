package lk.earth.earthuniversity.dao;

import lk.earth.earthuniversity.entity.Timelost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimelostDao extends JpaRepository<Timelost,Integer> {
}
