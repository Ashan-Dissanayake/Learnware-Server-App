package lk.earth.earthuniversity.controller;

import lk.earth.earthuniversity.dao.ReviewrateDao;
import lk.earth.earthuniversity.entity.Reviewrate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/reviewrates")
public class ReviewrateController {

    @Autowired
    private ReviewrateDao reviewratedao;

    @GetMapping(path = "/list",produces = "application/json")
    public List<Reviewrate> get(){

        List<Reviewrate> reviewrates = this.reviewratedao.findAll();

        reviewrates = reviewrates.stream().map(
                reviewrate -> {Reviewrate r = new Reviewrate();
                            r.setId(reviewrate.getId());
                           r.setRate(reviewrate.getRate()); return r;}
        ).collect(Collectors.toList());

        return reviewrates;

    }
}
