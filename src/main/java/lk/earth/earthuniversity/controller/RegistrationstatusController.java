package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.EmployeestatusDao;
import lk.earth.earthuniversity.dao.RegistrationstatusDao;
import lk.earth.earthuniversity.entity.Employeestatus;
import lk.earth.earthuniversity.entity.Registrationstatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/registrationstatuses")
public class RegistrationstatusController {

    @Autowired
    private RegistrationstatusDao Registrationstatusdao;

    @GetMapping(path = "/list",produces = "application/json")
    public List<Registrationstatus> get(){

        List<Registrationstatus> registrationstatuses = this.Registrationstatusdao.findAll();

        registrationstatuses = registrationstatuses.stream().map(
                registrationstatus -> {
                    Registrationstatus r = new Registrationstatus();
                    r.setId(registrationstatus.getId());
                    r.setName(registrationstatus.getName()); return r;}
        ).collect(Collectors.toList());
        
        return registrationstatuses;

    }
}
