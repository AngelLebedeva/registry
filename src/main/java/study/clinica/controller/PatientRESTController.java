package study.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import study.clinica.dao.PatientDAO;

import study.clinica.model.Patient;
import study.clinica.model.PatientForm;


import java.util.List;

@RestController
public class PatientRESTController {

    @Autowired
    private PatientDAO patientDAO;

    @RequestMapping(value = "/patients", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })

    @ResponseBody
    public List<Patient> getPatients() {
        List<Patient> list = patientDAO.getAllPatients();
        return list;
    }

    @RequestMapping(value = "/patient/{patId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Patient getPatient(@PathVariable("patId") Long patId) {
        return patientDAO.getPatient(patId);
    }

    @RequestMapping(value = "/patient", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Patient addPatient(@RequestBody PatientForm patForm) {

        System.out.println("(Service Side) Добавили пациента с ID: " + patForm.getPatId());

        return patientDAO.addPatient(patForm);
    }
    @RequestMapping(value = "/patient", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })

    @ResponseBody
    public Patient updatePatient(@RequestBody PatientForm patForm) {

        System.out.println("(Service Side) Редактировали данные пациента под ID: " + patForm.getPatId());

        return patientDAO.updatePatient(patForm);
    }
    @RequestMapping(value = "/patient/{patId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deletePatient(@PathVariable("patId") Long patId) {

        System.out.println("(Service Side) Удалили данные пациента с ID: " + patId);

        patientDAO.deletePatient(patId);
    }
}