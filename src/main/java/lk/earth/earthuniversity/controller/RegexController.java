package lk.earth.earthuniversity.controller;
import lk.earth.earthuniversity.entity.*;
import lk.earth.earthuniversity.util.RegexProvider;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;


@CrossOrigin
@RestController
@RequestMapping(value = "/regexes")
public class RegexController {

        @GetMapping(path = "/users" , produces = "application/json")
        public HashMap<String, HashMap<String,String>> user(){
                return RegexProvider.get(new User());
        }

        @GetMapping(path = "/employee" , produces = "application/json")
        public HashMap<String, HashMap<String,String>> employee(){
                return RegexProvider.get(new Employee());
        }

        @GetMapping(path = "/course" , produces = "application/json")
        public HashMap<String, HashMap<String,String>> course(){
                return RegexProvider.get(new Course());
        }

        @GetMapping(path = "/class" , produces = "application/json")
        public HashMap<String, HashMap<String,String>> clazz(){
                return RegexProvider.get(new Clazz());
        }

        @GetMapping(path = "/batch" , produces = "application/json")
        public HashMap<String, HashMap<String,String>> batch(){
                return RegexProvider.get(new Batch());
        }

        @GetMapping(path = "/student" , produces = "application/json")
        public HashMap<String, HashMap<String,String>> student(){
                return RegexProvider.get(new Student());
        }

}
