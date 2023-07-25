package lk.earth.earthuniversity.controller;
import lk.earth.earthuniversity.dao.RegisterDao;
import lk.earth.earthuniversity.entity.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping(value = "/registers")
public class RegisterController {


    @Autowired
    private RegisterDao registerdao;

    @GetMapping(produces = "application/json")
    public List<Register> get(@RequestParam HashMap<String,String> params){

        List<Register> registers = this.registerdao.findAll();

        if (params.isEmpty()) return registers;

        String batchid =  params.get("batchid");
        String studentid =  params.get("studentid");


        Stream<Register>rstream = registers.stream();

        if (batchid !=null) rstream = rstream.filter(r -> r.getBatch().getId() == Integer.parseInt(batchid));
        if (studentid !=null) rstream = rstream.filter(r -> r.getStudent().getId()== Integer.parseInt(studentid));

        return rstream.collect(Collectors.toList());

    }


//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public HashMap<String,String> add(@RequestBody Clazz clazz){
//
//        HashMap<String,String> response = new HashMap<>();
//        String errors = "";
//
//        if (classdao.findAllById(clazz.getId())!=null)
//            errors = errors+"<br> Class Already Exist";
//
//
//        if (errors=="")
//            classdao.save(clazz);
//        else errors = "Server Validation Errors : <br>"+errors;
//
//        response.put("id",String.valueOf(clazz.getId()));
//        response.put("url","/classes/"+clazz.getId());
//        response.put("errors",errors);
//
//        return response;
//
//    }
//
//    @PutMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public HashMap<String,String> update(@RequestBody Clazz clazz){
//
//        HashMap<String,String> responce = new HashMap<>();
//        String errors="";
//
//        Clazz clz1 = classdao.findByMyId(clazz.getId());
//
//        if(clz1!=null && clazz.getId()!=clz1.getId())
//            errors = errors+"<br> Existing Class";
//
//
//        if(errors=="") classdao.save(clazz);
//        else errors = "Server Validation Errors : <br> "+errors;
//
//        responce.put("id",String.valueOf(clazz.getId()));
//        responce.put("url","/employees/"+clazz.getId());
//        responce.put("errors",errors);
//
//        return responce;
//    }
//
//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.CREATED)
//    public HashMap<String,String> delete(@PathVariable Integer id){
//
//        System.out.println(id);
//
//        HashMap<String,String> responce = new HashMap<>();
//        String errors="";
//
//        Clazz clz1 = classdao.findByMyId(id);
//
//        if(clz1==null)
//            errors = errors+"<br> Class Does Not Existed";
//
//        if(errors=="") classdao.delete(clz1);
//        else errors = "Server Validation Errors : <br> "+errors;
//
//        responce.put("id",String.valueOf(id));
//        responce.put("url","/classes/"+id);
//        responce.put("errors",errors);
//
//        return responce;
//    }
}
