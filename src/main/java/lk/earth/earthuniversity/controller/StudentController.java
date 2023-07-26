package lk.earth.earthuniversity.controller;


import lk.earth.earthuniversity.dao.StudentDao;
import lk.earth.earthuniversity.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping(value = "/students")

public class StudentController {

    @Autowired
    private StudentDao studentdao;

    @GetMapping(produces = "application/json")
    public List<Student> get(@RequestParam HashMap<String, String> params) {

        List<Student> students = this.studentdao.findAll();

        if(params.isEmpty())  return students;

        String studentstatus= params.get("statusid");
        String name= params.get("name");
        String phoneno= params.get("mobile");


        Stream<Student> sstream = students.stream();

        if(studentstatus!=null) sstream = sstream.filter(e -> e.getStudentstatus().getId()==Integer.parseInt(studentstatus));
        if(name!=null) sstream = sstream.filter(e -> e.getName().equals(name));
        if(phoneno!=null) sstream = sstream.filter(e -> e.getPhoneno().contains(phoneno));


        return sstream.collect(Collectors.toList());

    }

    @GetMapping(path ="/list",produces = "application/json")
    public List<Student> get() {

        List<Student> students = this.studentdao.findAllNameId();

        students = students.stream().map(
                student -> {
                    Student s = new Student(student.getId(), student.getName());
                    return  s;
                }
        ).collect(Collectors.toList());

        return students;

    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> add(@RequestBody Student student){

        HashMap<String,String> response = new HashMap<>();
        String errors="";

        if(studentdao.findAllByList(student.getId(),student.getName())!=null)
            errors = errors+"<br> Existing Student";

        //System.out.println(student.getName());

        if(errors=="")
            studentdao.save(student);
        else errors = "Server Validation Errors : <br> "+errors;

        response.put("id",String.valueOf(student.getId()));
        response.put("url","/students/"+student.getId());
        response.put("errors",errors);

        return response;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> update(@RequestBody Student student){

        HashMap<String,String> response = new HashMap<>();
        String errors="";

        Student stu = studentdao.findAllByList(student.getId(),student.getName());

        if(stu!=null && student.getId()!=stu.getId())
            errors = errors+"<br> Existing Student";

        if(errors=="") studentdao.save(student);
        else errors = "Server Validation Errors : <br> "+errors;

        response.put("id",String.valueOf(student.getId()));
        response.put("url","/students/"+student.getId());
        response.put("errors",errors);

        return response;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> delete(@PathVariable Integer id){

        System.out.println(id);

        HashMap<String,String> response = new HashMap<>();
        String errors="";

        Student stu = studentdao.findByMyId(id);

        if(stu==null)
            errors = errors+"<br> Student Does Not Existed";

        if(errors=="") studentdao.delete(stu);
        else errors = "Server Validation Errors : <br> "+errors;

        response.put("id",String.valueOf(id));
        response.put("url","/students/"+id);
        response.put("errors",errors);

        return response;
    }

    }





