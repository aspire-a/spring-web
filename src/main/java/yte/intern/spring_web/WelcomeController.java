package yte.intern.spring_web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

    @RequestMapping("/welcome/{testNumber}")
    public void welcome(@PathVariable long testNumber, @RequestParam("name") String firstName, @RequestParam String instructor) {
        System.out.println(testNumber + " " + firstName + " " + instructor);
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome.html";
    }
}
