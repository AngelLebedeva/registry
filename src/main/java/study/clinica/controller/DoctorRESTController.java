package study.clinica.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import study.clinica.dao.DoctorDAO;
import study.clinica.model.Doctor;
import study.clinica.model.DoctorForm;



import java.util.List;

@RestController
public class DoctorRESTController {

    @Autowired
    private  DoctorDAO doctorDAO;

      @RequestMapping(value = "/doctors", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })

    @ResponseBody
    public List<Doctor> getDoctors() {
        List<Doctor> list = doctorDAO.getAllDoctors();
        return list;
    }

    @RequestMapping(value = "/doctor/{docId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Doctor getDoctor(@PathVariable("docId") Long docId) {
        return doctorDAO.getDoctor(docId);
    }

    @RequestMapping(value = "/doctor", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Doctor addDoctor(@RequestBody DoctorForm docForm) {

        System.out.println("(Service Side) Добавили доктора с ID: " + docForm.getDocId());

        return doctorDAO.addDoctor(docForm);
    }
    @RequestMapping(value = "/doctor", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })

    @ResponseBody
    public Doctor updateDoctor(@RequestBody DoctorForm docForm) {

        System.out.println("(Service Side) Редактировали данные доктора под ID: " + docForm.getDocId());

        return doctorDAO.updateDoctor(docForm);
    }
    @RequestMapping(value = "/doctor/{docId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteDoctor(@PathVariable("docId") Long docId) {

        System.out.println("(Service Side) Удалили данные доктора с ID: " + docId);

        doctorDAO.deleteDoctor(docId);
    }
}
