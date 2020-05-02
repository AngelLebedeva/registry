package study.clinica.dao;

import org.springframework.stereotype.Repository;
import study.clinica.model.Disease;
import study.clinica.model.DiseaseForm;


import java.util.*;

    @Repository
    public class DiseaseDAO {

        private static final Map<Long, Disease> disMap = new HashMap<Long, Disease>();
        static {
            initDiseases();
        }

        private static void initDiseases() {
            Disease dis1 = new Disease(101L, "Астегматизм", "Генетическая");
            Disease dis2 = new Disease(102L, "Псориаз","Микроорганизмы");
            Disease dis3 = new Disease(103L, "Туберкулез", "Микроорганизмы");
            Disease dis4 = new Disease(104L, "Ишемия", "Дегенеративная");
            Disease dis5 = new Disease(105L, "Анемия", "Дегенеративная");
            Disease dis6 = new Disease(106L, "Шизофрения", "Генетическая");
            Disease dis7 = new Disease(107L, "Раздвоение личности", "Генетическая");
            Disease dis8 = new Disease(108L, "Лейкемия", "Генетическая");
            Disease dis9 = new Disease(109L, "Ветрянка", "Микроорганизмы");


            disMap.put(dis1.getDisId(), dis1);
            disMap.put(dis2.getDisId(), dis2);
            disMap.put(dis3.getDisId(), dis3);
            disMap.put(dis4.getDisId(), dis4);
            disMap.put(dis5.getDisId(), dis5);
            disMap.put(dis6.getDisId(), dis6);
            disMap.put(dis7.getDisId(), dis7);
            disMap.put(dis8.getDisId(), dis8);
            disMap.put(dis9.getDisId(), dis9);

        }

        public Long getMaxDisId() {
            Set<Long> keys = disMap.keySet();
            Long max = 0L;
            for (Long key : keys) {
                if (key > max) {
                    max = key;
                }
            }
            return max;
        }
        public Disease getDisease(Long disId) {
            return disMap.get(disId);
        }

        public Disease addDisease(DiseaseForm disForm) {
            Long disId= this.getMaxDisId()+ 1;
            disForm.setDisId(disId);
            Disease newDis = new Disease(disForm);

            disMap.put(newDis.getDisId(), newDis);
            return newDis;


        }
        public Disease updateDisease(DiseaseForm disForm) {
            Disease dis = this.getDisease(disForm.getDisId());
            if(dis!= null)  {
                dis.setDisName(disForm.getDisName());
                dis.setDisGroup(disForm.getDisGroup());
            }
            return dis;
        }
        public void deleteDisease(Long disId) {
            disMap.remove(disId);
        }

        public List<Disease> getAllDiseases() {
            Collection<Disease> c = disMap.values();
            List<Disease> list = new ArrayList<Disease>(c);
            return list;
        }
}
