package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.TopicDao;
import lk.earth.earthuniversity.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/topics")
public class TopicController {

    @Autowired
    private TopicDao topicdao;

    @GetMapping(path = "/list",produces = "application/json")
    public List<Topic> get(){

        List<Topic> topics = this.topicdao.findAll();

        topics = topics.stream().map(
                topic -> {Topic t = new Topic();
                            t.setId(topic.getId());
                           t.setName(topic.getName()); return t;}
        ).collect(Collectors.toList());

        return topics;

    }
}
