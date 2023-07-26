package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.TimelostDao;
import lk.earth.earthuniversity.dao.UserstatusDao;
import lk.earth.earthuniversity.entity.Timelost;
import lk.earth.earthuniversity.entity.Userstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/timelost")
public class TimelostController {

    @Autowired
    private TimelostDao timelostDao;

    @GetMapping(path ="/list", produces = "application/json")
    public List<Timelost> get() {

        List<Timelost> timelosts = this.timelostDao.findAll();

        timelosts = timelosts.stream().map(
                timelost -> { Timelost d = new Timelost();
                    d.setId(timelost.getId());
                    d.setName(timelost.getName());
                    return d; }
        ).collect(Collectors.toList());

        return timelosts;

    }

}
