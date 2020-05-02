package study.clinica.dao;

import org.springframework.stereotype.Repository;
import study.clinica.model.Patient;
import study.clinica.model.PatientForm;

import java.util.*;

@Repository
public class PatientDAO {

    private static final Map<Long, Patient> patMap = new HashMap<Long, Patient>();
    static {
        initPats();
    }

    private static void initPats() {
        Patient pat1 = new Patient(11L, "Кузин","Иван", "Васильевич", "П-321", "25.10.1982", "мужской");
        Patient pat2 = new Patient(12L, "Маркина","Алена", "Петровна", "П-536", "13.05.1980", "женский");
        Patient pat3 = new Patient(13L, "Маслова","Тамара", "Олеговна", "П-244", "10.01.1965", "женский");
        Patient pat4 = new Patient(14L, "Отт","Светлана", "Ивановна", "П-222", "26.12.1979", "женский");
        Patient pat5 = new Patient(15L, "Павлов","Константин", "Игоревич", "П-421", "28.06.1986", "мужской");
        Patient pat6 = new Patient(16L, "Юркин","Станислав", "Петрович", "П-698", "01.07.1974", "мужской");
        Patient pat7 = new Patient(17L, "Кузькина","Лариса", "Викторовна", "П-256", "15.04.1969", "женский");
        Patient pat8 = new Patient(18L, "Петров","Игорь", "Васильевич", "П-200", "22.12.1975", "мужской");
        Patient pat9 = new Patient(19L, "Сидоров","Михаил", "Алексеевич", "П-195", "11.11.1971", "мужской");
        Patient pat10 = new Patient(20L, "Мелкова","Анна", "Михайловна", "П-164", "24.04.1988", "женский");
        Patient pat11 = new Patient(21L, "Канзеров","Юрий", "Петрович", "П-258", "30.03.1990", "мужской");
        Patient pat12 = new Patient(22L, "Лебедева","Анжелика", "Николаевна", "П-54", "17.02.1969", "женский");

        patMap.put(pat1.getPatId(), pat1);
        patMap.put(pat2.getPatId(), pat2);
        patMap.put(pat3.getPatId(), pat3);
        patMap.put(pat4.getPatId(), pat4);
        patMap.put(pat5.getPatId(), pat5);
        patMap.put(pat6.getPatId(), pat6);
        patMap.put(pat7.getPatId(), pat7);
        patMap.put(pat8.getPatId(), pat8);
        patMap.put(pat9.getPatId(), pat9);
        patMap.put(pat10.getPatId(), pat10);
        patMap.put(pat11.getPatId(), pat11);
        patMap.put(pat12.getPatId(), pat12);

    }

    public Long getMaxPatId() {
        Set<Long> keys = patMap.keySet();
        Long max = 10L;
        for (Long key : keys) {
            if (key > max) {
                max = key;
            }
        }
        return max;
    }
    public Patient getPatient(Long patId) {
        return patMap.get(patId);
    }

    public Patient addPatient(PatientForm patForm) {
        Long patId= this.getMaxPatId()+ 1;
        patForm.setPatId(patId);
        Patient newPat = new Patient(patForm);

        patMap.put(newPat.getPatId(), newPat);
        return newPat;


    }
    public Patient updatePatient(PatientForm patForm) {
        Patient pat = this.getPatient(patForm.getPatId());
        if(pat!= null)  {
            pat.setPatSurname(patForm.getPatSurname());
            pat.setPatName(patForm.getPatName());
            pat.setPatPatronymic(patForm.getPatPatronymic());
            pat.setPatMedicalCardNumber(patForm.getPatMedicalCardNumber());
            pat.setPatDateOfBirth(patForm.getPatDateOfBirth());
            pat.setPatGender(patForm.getPatGender());
        }
        return pat;
    }
    public void deletePatient(Long patId) {
        patMap.remove(patId);
    }

    public List<Patient> getAllPatients() {
        Collection<Patient> c = patMap.values();
        List<Patient> list = new ArrayList<Patient>(c);
        return list;
    }
}

