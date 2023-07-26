package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.GuardiantypeDao;

import lk.earth.earthuniversity.entity.Gaurdiantype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/guardiantypes")
public class GuardiantypeController {

    @Autowired
    private GuardiantypeDao gtdao;

    @GetMapping(path = "/list",produces = "application/json")
    public List<Gaurdiantype> get(){

        List<Gaurdiantype> gaurdiantypes = this.gtdao.findAll();

        gaurdiantypes = gaurdiantypes.stream().map(
                gaurdiantype -> {
                    Gaurdiantype gt = new Gaurdiantype();
                    gt.setId(gaurdiantype.getId());
                    gt.setName(gaurdiantype.getName()); return gt;}
        ).collect(Collectors.toList());
        
        return gaurdiantypes;

    }
}
