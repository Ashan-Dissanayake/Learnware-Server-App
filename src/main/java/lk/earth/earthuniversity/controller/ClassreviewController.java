package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.ClassreviewDao;
import lk.earth.earthuniversity.entity.Classreview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/classreviews")
public class ClassreviewController {

    @Autowired
    private ClassreviewDao classreviewdao;

    @GetMapping(produces = "application/json")
    public List<Classreview> get(){

        List<Classreview> classreviews = this.classreviewdao.findAll();

        return classreviews;

    }
}
