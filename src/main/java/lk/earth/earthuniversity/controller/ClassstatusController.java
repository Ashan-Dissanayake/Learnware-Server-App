package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.ClassstatusDao;
import lk.earth.earthuniversity.entity.Classstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/classstatus")
public class ClassstatusController {

    @Autowired
    private ClassstatusDao classstatusDao;

    @GetMapping(produces = "application/json")
    public List<Classstatus> get(){

        List<Classstatus> classstatuses = this.classstatusDao.findAll();

        classstatuses = classstatuses.stream().map(
                classstatus -> {
                    Classstatus cs = new Classstatus();
                    cs.setId(classstatus.getId());
                    cs.setName(classstatus.getName());

                    return cs;
                }
        ).collect(Collectors.toList());

        return classstatuses;

    }



}
