package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.ClassDao;
import lk.earth.earthuniversity.entity.Clazz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping(value = "/classes")
public class ClassController {


    @Autowired
    private ClassDao classdao;

    @GetMapping(produces = "application/json")
    public List<Clazz> get(@RequestParam HashMap<String,String> params){

        List<Clazz> clazzes = this.classdao.findAll();

        if (params.isEmpty()) return clazzes;

        String batchid =  params.get("batchid");
        String teacherid =  params.get("teacherid");

        Stream<Clazz>cstream = clazzes.stream();

        if (batchid !=null) cstream = cstream.filter(c -> c.getBatch().getId() == Integer.parseInt(batchid));
        if (teacherid !=null) cstream = cstream.filter(c -> c.getTeacher().getId()== Integer.parseInt(teacherid));

        return cstream.collect(Collectors.toList());

    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> add(@RequestBody Clazz clazz){

        HashMap<String,String> response = new HashMap<>();
        String errors = "";

        if (classdao.findAllById(clazz.getId())!=null)
            errors = errors+"<br> Class Already Exist";


        if (errors=="")
            classdao.save(clazz);
        else errors = "Server Validation Errors : <br>"+errors;

        response.put("id",String.valueOf(clazz.getId()));
        response.put("url","/classes/"+clazz.getId());
        response.put("errors",errors);

        return response;

    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> update(@RequestBody Clazz clazz){

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        Clazz clz1 = classdao.findByMyId(clazz.getId());

        if(clz1!=null && clazz.getId()!=clz1.getId())
            errors = errors+"<br> Existing Class";


        if(errors=="") classdao.save(clazz);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(clazz.getId()));
        responce.put("url","/employees/"+clazz.getId());
        responce.put("errors",errors);

        return responce;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> delete(@PathVariable Integer id){

        System.out.println(id);

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        Clazz clz1 = classdao.findByMyId(id);

        if(clz1==null)
            errors = errors+"<br> Class Does Not Existed";

        if(errors=="") classdao.delete(clz1);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(id));
        responce.put("url","/classes/"+id);
        responce.put("errors",errors);

        return responce;
    }
}
