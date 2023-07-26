package lk.earth.earthuniversity.controller;


import lk.earth.earthuniversity.dao.DayDao;
import lk.earth.earthuniversity.entity.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/days")
public class DayController {

    @Autowired
    private DayDao daydao;

    @GetMapping(path = "/list",produces = "application/json")
    public List<Day> get(){

        List<Day> days = this.daydao.findAll();

        days = days.stream().map(
                day -> {
                    Day d = new Day();
                    d.setId(day.getId());
                    d.setName(day.getName()); return d;}
        ).collect(Collectors.toList());

        return days;

    }
}
