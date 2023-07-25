package lk.earth.earthuniversity.dao;

import lk.earth.earthuniversity.entity.Registrationstatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationstatusDao extends JpaRepository<Registrationstatus,Integer> {

    List<Registrationstatus> findAll();
}
