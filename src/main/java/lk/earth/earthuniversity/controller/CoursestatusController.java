package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.CoursestatusDao;
import lk.earth.earthuniversity.entity.Coursestatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/coursestatus")
public class CoursestatusController {

    @Autowired
    private CoursestatusDao coursestatusdao;

    @GetMapping(path = "/list",produces = "application/json")
    public List<Coursestatus> get(){

        List<Coursestatus> coursestatuses = this.coursestatusdao.findAll();

        coursestatuses = coursestatuses.stream().map(
                coursestatus -> {Coursestatus c = new Coursestatus();
                            c.setId(coursestatus.getId());
                           c.setName(coursestatus.getName()); return c;}
        ).collect(Collectors.toList());

        return coursestatuses;

    }
}
