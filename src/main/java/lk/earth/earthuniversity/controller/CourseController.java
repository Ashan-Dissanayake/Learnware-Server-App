package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.CourseDao;

import lk.earth.earthuniversity.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        if (coursestatusid !=null) cstream = cstream.filter(c->c.getCoursestatus().getId() == Integer.parseInt(coursestatusid));
        if (coursecategoryid !=null) cstream = cstream.filter(c->c.getCoursecategory().getId() == Integer.parseInt(coursecategoryid));

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


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> add(@RequestBody Course course){

        HashMap<String,String> response = new HashMap<>();
        String errors = "";
        if (coursedao.findByCode(course.getCode())!=null)
            errors = errors+"<br> Existing Code";

        if (errors=="")
            coursedao.save(course);
        else errors = "Server Validation Errors : <br>"+errors;

        response.put("id",String.valueOf(course.getId()));
        response.put("url","/courses/"+course.getId());
        response.put("errors",errors);

        return response;

    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> update(@RequestBody Course course){

        HashMap<String,String> response = new HashMap<>();
        String errors = "";

        Course crs = coursedao.findByCode(course.getCode());

        if (crs!=null && course.getId()!=crs.getId())
            errors = errors+"<br> Existing Code";

        if (errors=="") coursedao.save(course);
        else errors = "Server Validation Errors : <br>"+errors;

        response.put("id",String.valueOf(course.getId()));
        response.put("url","/courses/"+course.getId());
        response.put("errors",errors);

        return response;

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> delete(@PathVariable Integer id){
        System.out.println(id);


        HashMap<String,String> response = new HashMap<>();
        String errors="";

        Course crs = coursedao.findAllById(id);


        if(crs==null)
            errors = errors+"<br> Course Does Not Existed";
        if(errors=="") coursedao.delete(crs);

        else errors = "Server Validation Errors : <br> "+errors;

        response.put("id",String.valueOf(id));
        response.put("url","/courses/"+id);
        response.put("errors",errors);

        return response;
    }



}
