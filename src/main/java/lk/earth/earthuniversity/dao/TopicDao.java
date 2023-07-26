package lk.earth.earthuniversity.dao;
import lk.earth.earthuniversity.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicDao extends JpaRepository<Topic,Integer> {
}
