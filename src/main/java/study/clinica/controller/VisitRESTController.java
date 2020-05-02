package study.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import study.clinica.dao.VisitDAO;
import study.clinica.model.Visit;
import study.clinica.model.VisitForm;

import java.util.List;

@RestController
public class VisitRESTController {

    @Autowired
    private  VisitDAO visitDAO;

    //внедрение зависимости через конструктор
   /* public VisitRESTController(VisitDAO visitDAO) {
        this.visitDAO = visitDAO;
    }*/

    @RequestMapping(value = "/visits", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })

    @ResponseBody
    public List<Visit> getVisits() {
        List<Visit> list = visitDAO.getAllVisits();
        return list;
    }

    @RequestMapping(value = "/visit/{visId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Visit getVisit(@PathVariable("visId") Long visId) {
        return visitDAO.getVisit(visId);
    }

    @RequestMapping(value = "/visit", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Visit addVisit(@RequestBody VisitForm visForm) {

        System.out.println("(Service Side) Добавили посещение с ID: " + visForm.getVisId());

        return visitDAO.addVisit(visForm);
    }
    @RequestMapping(value = "/visit", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })

    @ResponseBody
    public Visit updateVisit(@RequestBody VisitForm visForm) {

        System.out.println("(Service Side) Редактировали данные посещения под ID: " + visForm.getVisId());

        return visitDAO.updateVisit(visForm);
    }
    @RequestMapping(value = "/visit/{visId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteVisit(@PathVariable("visId") Long visId) {

        System.out.println("(Service Side) Удалили данные посещения с ID: " + visId);

        visitDAO.deleteVisit(visId);
    }
}
