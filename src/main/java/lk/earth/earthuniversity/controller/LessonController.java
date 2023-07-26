package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.LessonDao;
import lk.earth.earthuniversity.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping(value = "/lessons")
public class LessonController {

    @Autowired
    private LessonDao lessondao;

    @GetMapping(produces = "application/json")
    public List<Lesson> get(@RequestParam HashMap<String,String> params){

//        List<Lesson> lessons = this.lessondao.findAll();
//
//        lessons = lessons.stream().map(
//                lesson -> {
//                    Lesson l = new Lesson();
//                    l.setId(lesson.getId());
//                    l.setName(lesson.getName());
//                    l.setCourse(lesson.getCourse());
//                    return l;
//                }
//        ).collect(Collectors.toList());
//
//        return lessons;

        String id =  params.get("id");
        String name =  params.get("name");
        String course =  params.get("course");



        List<Lesson> lessons = this.lessondao.findAll();

        if (params.isEmpty()) return lessons;

        Stream<Lesson> lsstream = lessons.stream();


        if (id !=null) lsstream = lsstream.filter(e-> e.getId()== Integer.parseInt(id)) ;
        if (name !=null) lsstream = lsstream.filter(e->e.getName().equals(name));
        if (course !=null) lsstream = lsstream.filter(e->e.getCourse().getId()== Integer.parseInt(course));



        return lsstream.collect(Collectors.toList());

    }

    @GetMapping(path ="/list",produces = "application/json")
    public List<Lesson> get() {

        List<Lesson> lessons = this.lessondao.findAllNameId();

        lessons = lessons.stream().map(
                lesson -> {
                    Lesson l = new Lesson(lesson.getId(), lesson.getName());
                    return  l;
                }
        ).collect(Collectors.toList());

        return lessons;

    }
}
