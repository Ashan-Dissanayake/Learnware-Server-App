package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.BatchstatusDao;
import lk.earth.earthuniversity.entity.Batchstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/batchstatuses")
public class BatchstatusController {

    @Autowired
    private BatchstatusDao batchstatusdao;

    @GetMapping(path = "/list",produces = "application/json")
    public List<Batchstatus> get(){

        List<Batchstatus> batchstatuses = this.batchstatusdao.findAll();

        batchstatuses = batchstatuses.stream().map(
                batchstatus -> {
                    Batchstatus b = new Batchstatus();
                    b.setId(batchstatus.getId());
                    b.setName(batchstatus.getName()); return b;}
        ).collect(Collectors.toList());

        return batchstatuses;

    }
}

