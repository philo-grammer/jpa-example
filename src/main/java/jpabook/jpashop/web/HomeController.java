package jpabook.jpashop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by sykim on 2016. 3. 27..
 */
//@RestController
@Controller
@RequestMapping("home")
public class HomeController {

    @RequestMapping(method = GET)
    public String home(Model model) {
        return "home";
    }

    /*
    @ResponseBody
    @RequestMapping("/wait")
    public String wait(Model model) throws InterruptedException {

        Thread.sleep(1000);

        return "response";
    }
    */
}
