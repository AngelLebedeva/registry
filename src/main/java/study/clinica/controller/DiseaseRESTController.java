package study.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import study.clinica.dao.DiseaseDAO;
import study.clinica.model.Disease;
import study.clinica.model.DiseaseForm;


import java.util.List;

@RestController
public class DiseaseRESTController {

    @Autowired
    private DiseaseDAO diseaseDAO;

    @RequestMapping(value = "/diseases", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })

    @ResponseBody
    public List<Disease> getDiseases() {
        List<Disease> list = diseaseDAO.getAllDiseases();
        return list;
    }

    @RequestMapping(value = "/disease/{disId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Disease getDisease(@PathVariable("disId") Long disId) {
        return diseaseDAO.getDisease(disId);
    }

    @RequestMapping(value = "/disease", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Disease addDisease(@RequestBody DiseaseForm disForm) {

        System.out.println("(Service Side) Добавили данные болезни под ID: " + disForm.getDisId());

        return diseaseDAO.addDisease(disForm);
    }
    @RequestMapping(value = "/disease", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })

    @ResponseBody
    public Disease updateDisease(@RequestBody DiseaseForm disForm) {

        System.out.println("(Service Side) Редактировали данные болезни под ID: " + disForm.getDisId());

        return diseaseDAO.updateDisease(disForm);
    }
    @RequestMapping(value = "/disease/{disId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteDisease(@PathVariable("disId") Long disId) {

        System.out.println("(Service Side) Удалили данные болезни с ID: " + disId);

        diseaseDAO.deleteDisease(disId);
    }
}
