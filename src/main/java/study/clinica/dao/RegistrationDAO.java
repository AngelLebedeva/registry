package study.clinica.dao;

import org.springframework.stereotype.Repository;

import study.clinica.model.Registration;
import study.clinica.model.RegistrationForm;

import java.util.*;

@Repository
public class RegistrationDAO {

    private static final Map<Long, Registration> regMap = new HashMap<Long, Registration>();
    static {
        initRegs();
    }

    private static void initRegs() {
        Registration reg1 = new Registration(1L, "окулист", "Сидорова", "Павлов", "13.03.2020", "14:35:10");


        regMap.put(reg1.getRegId(), reg1);

    }

    public Long getMaxRegId() {
        Set<Long> keys = regMap.keySet();
        Long max = 0L;
        for (Long key : keys) {
            if (key > max) {
                max = key;
            }
        }
        return max;
    }
    public Registration getRegistration(Long regId) {
        return regMap.get(regId);
    }

    public Registration addRegistration(RegistrationForm regForm) {
        Long regId= this.getMaxRegId()+ 1;
        regForm.setRegId(regId);
        Registration newReg = new Registration(regForm);

        regMap.put(newReg.getRegId(), newReg);
        return newReg;


    }
    public Registration updateRegistration(RegistrationForm regForm) {
        Registration reg = this.getRegistration(regForm.getRegId());
        if(reg!= null)  {
            reg.setPosition(regForm.getPosition());
            reg.setDocSurname(regForm.getDocSurname());
            reg.setPatSurname(regForm.getPatSurname());
            reg.setVisDate(regForm.getVisDate());
            reg.setVisTime(regForm.getVisTime());
        }
        return reg;
    }
    public void deleteRegistration(Long regId) {
        regMap.remove(regId);
    }

    public List<Registration> getAllRegistrations() {
        Collection<Registration> c = regMap.values();
        List<Registration> list = new ArrayList<Registration>(c);
        return list;
    }
}

