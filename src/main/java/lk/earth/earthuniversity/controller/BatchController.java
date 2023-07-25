package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.BatchDao;
import lk.earth.earthuniversity.entity.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping(value = "/batches")
public class BatchController {

    @Autowired
    private BatchDao batchdao;

    @GetMapping(produces = "application/json")
    public List<Batch> get(@RequestParam HashMap<String,String> params){

        String name =  params.get("name");
        String snumber =  params.get("number");
        String statusid =  params.get("statusid");

        List<Batch> batches = this.batchdao.findAll();

        if (params.isEmpty()) return batches;

        Stream<Batch> bstream = batches.stream();


        if (name !=null) bstream = bstream.filter(b-> b.getName().equals(name)) ;
        if (snumber !=null) bstream = bstream.filter(e->e.getNumber().contains(snumber));
        if (statusid !=null) bstream = bstream.filter(b->b.getBatchstatus().getId()== Integer.parseInt(statusid));

        return bstream.collect(Collectors.toList());

    }


    @GetMapping(path ="/list",produces = "application/json")
    public List<Batch> get() {

        List<Batch> batches = this.batchdao.findAllNameId();

        batches = batches.stream().map(
                batch -> {
                    Batch b = new Batch(batch.getId(), batch.getName());
                    return  b;
                }
        ).collect(Collectors.toList());

        return batches;

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> add(@RequestBody Batch batch){

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        if(batchdao.findAllById(batch.getId())!=null)
            errors = errors+"<br> Existing Number";
//        if(batchdao.findByBatchName(batch.getName())!=null)
//            errors = errors+"<br> Existing Name";

        if(errors=="")
            batchdao.save(batch);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(batch.getId()));
        responce.put("url","/batches/"+batch.getId());
        responce.put("errors",errors);

        return responce;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> update(@RequestBody Batch batch){

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        Batch bat = batchdao.findAllById(batch.getId());

        if(bat!=null && batch.getId()!=bat.getId())
            errors = errors+"<br> Existing ID";

        if(errors=="") batchdao.save(batch);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(batch.getId()));
        responce.put("url","/batches/"+batch.getId());
        responce.put("errors",errors);

        return responce;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public HashMap<String,String> delete(@PathVariable Integer id){

        HashMap<String,String> responce = new HashMap<>();
        String errors="";

        Batch bat = batchdao.findAllById(id);

        if(bat==null)
            errors = errors+"<br> Batch Does Not Existed";

        if(errors=="") batchdao.delete(bat);
        else errors = "Server Validation Errors : <br> "+errors;

        responce.put("id",String.valueOf(id));
        responce.put("url","/batches/"+id);
        responce.put("errors",errors);

        return responce;
    }

}

