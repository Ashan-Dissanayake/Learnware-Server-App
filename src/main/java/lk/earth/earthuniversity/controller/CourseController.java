package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.CourseDao;
import lk.earth.earthuniversity.entity.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    private CourseDao coursedao;
    @GetMapping(produces = "application/json")
    public List<Course> get(@RequestParam HashMap<String,String> params){

        System.out.println(params.get("coursestatusid"));

        String name =  params.get("name");
        String code =  params.get("code");
        String coursestatusid =  params.get("coursestatusid");
        String coursecategoryid =  params.get("coursecategoryid");


        List<Course> courses = this.coursedao.findAll();

        if (params.isEmpty()) return courses;

        Stream<Course> cstream = courses.stream();


        if (name !=null) cstream = cstream.filter(c-> c.getName().contains(name)) ;
        if (code !=null) cstream = cstream.filter(c->c.getCode().equalsIgnoreCase(code));
        if (coursestatusid !=null) cstream = cstream.filter(c->c.getCoursestatusByCoursestatusId().getId() == Integer.parseInt(coursestatusid));
        if (coursecategoryid !=null) cstream = cstream.filter(c->c.getCoursecategoryByCoursecategoryId().getId() == Integer.parseInt(coursecategoryid));

        return cstream.collect(Collectors.toList());

    }

    @GetMapping(path ="/list",produces = "application/json")
    public List<Course> get() {

        List<Course> courses = this.coursedao.findAllNameId();

        courses = courses.stream().map(
                course -> {
                    Course c = new Course(course.getId(), course.getName());
                    return  c;
                }
        ).collect(Collectors.toList());

        return courses;

    }



}
