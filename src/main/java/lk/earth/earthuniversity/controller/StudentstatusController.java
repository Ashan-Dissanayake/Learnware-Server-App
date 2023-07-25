package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.EmployeestatusDao;
import lk.earth.earthuniversity.dao.StudentstatusDao;
import lk.earth.earthuniversity.entity.Employeestatus;
import lk.earth.earthuniversity.entity.Studentstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/studentstatuses")
public class StudentstatusController {

    @Autowired
    private StudentstatusDao ssdao;

    @GetMapping(path = "/list",produces = "application/json")
    public List<Studentstatus> get(){

        List<Studentstatus> studentstatuses = this.ssdao.findAll();

        studentstatuses = studentstatuses.stream().map(
                studentstatus -> {
                    Studentstatus ss = new Studentstatus();
                    ss.setId(studentstatus.getId());
                    ss.setName(studentstatus.getName()); return ss;}
        ).collect(Collectors.toList());
        
        return studentstatuses;

    }
}
