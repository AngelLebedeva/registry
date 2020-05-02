package study.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import study.clinica.dao.RegistrationDAO;
import study.clinica.model.Registration;
import study.clinica.model.RegistrationForm;


import java.util.List;

@RestController
public class RegistrationRESTController {

    @Autowired
    private RegistrationDAO registrationDAO;

   /* @RequestMapping(value="/registration", method=RequestMethod.GET)
    public String registrationForm(Model model) {
        model.addAttribute("registration", new Registration());
        return "registration";
    }
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registrationSubmit(@ModelAttribute Registration registration , Model model) {
        model.addAttribute("registration", registration);
        return "registration";
    }*/

    @RequestMapping(value = "/registrations", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })

    @ResponseBody
    public List<Registration> getRegistrations() {
        List<Registration> list = registrationDAO.getAllRegistrations();
        return list;
    }

    @RequestMapping(value = "/registration/{regId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Registration getRegistration(@PathVariable("regId") Long regId) {
        return registrationDAO.getRegistration(regId);
    }

    @RequestMapping(value = "/registration", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Registration addRegistration(@RequestBody RegistrationForm regForm) {

        System.out.println("(Service Side) Добавили регистрации с ID: " + regForm.getRegId());

        return registrationDAO.addRegistration(regForm);
    }
    @RequestMapping(value = "/registration", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })

    @ResponseBody
    public Registration updateRegistration(@RequestBody RegistrationForm regForm) {

        System.out.println("(Service Side) Редактировали данные регистрации под ID: " + regForm.getRegId());

        return registrationDAO.updateRegistration(regForm);
    }
    @RequestMapping(value = "/registration/{regId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteRegistration(@PathVariable("regId") Long regId) {

        System.out.println("(Service Side) Удалили данные регистрации с ID: " + regId);

        registrationDAO.deleteRegistration(regId);

    }
}
