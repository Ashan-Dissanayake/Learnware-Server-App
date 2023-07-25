package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.DevisionDao;
import lk.earth.earthuniversity.entity.Devision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/divisions")
public class DivisionController {

    @Autowired
    private DevisionDao divisiondao;

    @GetMapping(path = "/list",produces = "application/json")
    public List<Devision> get(){

        List<Devision> divisions = this.divisiondao.findAll();

        divisions = divisions.stream().map(
                division -> {Devision d = new Devision();
                            d.setId(division.getId());
                           d.setName(division.getName()); return d;}
        ).collect(Collectors.toList());

        return divisions;

    }
}
