package study.clinica.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import study.clinica.model.Registration;


@Controller
public class MainController {

    @RequestMapping("/")
    public String registry() {
        return "registry";
    }

    @RequestMapping("/registration")
    public String registration() {
        return "registration";
    }


    @RequestMapping("/doctor")
    public String doctor() {
        return "doctor";
    }

    @RequestMapping("/patient")
    public String patient() {
        return "patient";
    }

    @RequestMapping("/disease")
    public String disease() {
        return "disease";
    }

    @RequestMapping("/visit")
    public String visits() {
        return "visit";
    }

}
