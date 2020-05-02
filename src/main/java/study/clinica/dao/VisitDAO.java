package study.clinica.dao;

import org.springframework.stereotype.Repository;
import study.clinica.model.Visit;
import study.clinica.model.VisitForm;
import java.util.*;


@Repository
public class VisitDAO {


    private static final Map<Long, Visit> visMap = new HashMap<Long, Visit>();
    static {
        initVisits();
    }

    private static void initVisits() {

        Visit vis1 = new Visit(100L, "4L", "15L","13.03.2020", "14:35:10", "101L");
        Visit vis2 = new Visit(101L, "4L","11L",  "10.02.2019", "12:10:12", "101L");
        Visit vis3 = new Visit(102L, "11L", "12L",  "26.01.2018", "16:30:01", "102L");
        Visit vis4 = new Visit(103L, "9L", "17L",  "20.10.2019", "08:10:02", "103L");
        Visit vis5 = new Visit(104L, "3L", "13L",  "15.06.2019", "09:50:13", "104L");
        Visit vis6 = new Visit(105L, "3L", "16L",  "01.07.2019", "09:25:25","105L");
        Visit vis7 = new Visit(106L, "6L", "11L", "29.07.2019", "16:30:01", "106L");
        Visit vis8 = new Visit(107L, "6L", "14L",  "14.03.2019","12:10:12","107L");
        Visit vis9 = new Visit(108L, "5L", "21L",  "11.05.2019", "16:30:01", "108L");

        visMap.put(vis1.getVisId(), vis1);
        visMap.put(vis2.getVisId(), vis2);
        visMap.put(vis3.getVisId(), vis3);
        visMap.put(vis4.getVisId(), vis4);
        visMap.put(vis5.getVisId(), vis5);
        visMap.put(vis6.getVisId(), vis6);
        visMap.put(vis7.getVisId(), vis7);
        visMap.put(vis8.getVisId(), vis8);
        visMap.put(vis9.getVisId(), vis9);

    }
    public Long getMaxVisId() {
        Set<Long> keys = visMap.keySet();
        Long max = 0L;
        for (Long key : keys) {
            if (key > max) {
                max = key;
            }
        }
        return max;
    }
    public Visit getVisit(Long visId) {
        return visMap.get(visId);
    }

    public Visit addVisit(VisitForm visForm) {
        Long visId= this.getMaxVisId()+ 1;
        visForm.setVisId(visId);
        Visit newVis = new Visit(visForm);

        visMap.put(newVis.getVisId(), newVis);
        return newVis;


    }
    public Visit updateVisit(VisitForm visForm) {
        Visit vis = this.getVisit(visForm.getVisId());
        if(vis!= null)  {
            vis.setVisId(visForm.getVisId());
            vis.setDocId(visForm.getDocId());
            vis.setPatId(visForm.getPatId());
            vis.setVisDate(visForm.getVisDate());
            vis.setVisTime(visForm.getVisTime());
            vis.setDisId(visForm.getDisId());

        }
        return vis;
    }
    public void deleteVisit(Long visId) {
        visMap.remove(visId);
    }

    public List<Visit> getAllVisits() {
        Collection<Visit> v = visMap.values();
        List<Visit> list = new ArrayList<Visit>(v);
        return list;
    }

}
