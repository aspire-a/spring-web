package yte.intern.spring_web.validationDeneme;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidationController {

    @PostMapping("/validation")
    public void validation(@RequestBody @Valid User user) {
        System.out.println(user);
    }
}
