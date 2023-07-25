package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.CoursecategoryDao;
import lk.earth.earthuniversity.entity.Coursecategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/coursecategory")
public class CoursecategoryController {

    @Autowired
    private CoursecategoryDao coursecategorydao;

    @GetMapping(path = "/list",produces = "application/json")
    public List<Coursecategory> get(){

        List<Coursecategory> coursecategories = this.coursecategorydao.findAll();

        coursecategories = coursecategories.stream().map(
                coursecategory -> {
                    Coursecategory c = new Coursecategory();
                           c.setId(coursecategory.getId());
                           c.setName(coursecategory.getName());
                           c.setDevisions(coursecategory.getDevisions());return c;}
        ).collect(Collectors.toList());

        return coursecategories;

    }
}
