package study.clinica.dao;

import org.springframework.stereotype.Repository;
import study.clinica.model.Doctor;
import study.clinica.model.DoctorForm;

import java.util.*;

@Repository
public class DoctorDAO {

    private static final Map<Long, Doctor> docMap = new HashMap<Long, Doctor>();
    static {
        initDocs();
    }

    private static void initDocs() {
        Doctor doc1 = new Doctor(1L, "E01", "Петров","Иван", "Иванович", "хирург", "25.03.2005", "№6");
        Doctor doc2 = new Doctor(2L, "E02","Маслов",  "Игорь", "Сергеевич", "ортопед", "16.02.2010", "№5");
        Doctor doc3 = new Doctor(3L, "E03", "Ольховская",  "Ирина", "Витальевна", "терапевт", "02.03.2001", "№2");
        Doctor doc4 = new Doctor(4L, "E04", "Сидорова",  "Светлана", "Олеговна", "окулист", "26.09.1999", "№12");
        Doctor doc5 = new Doctor(5L, "E05", "Кубарева",  "Тамара", "Петровна", "терапевт", "10.10.2000", "№2");
        Doctor doc6 = new Doctor(6L, "E06", "Пипкин",  "Олег","Сергеевич","невролог", "05.06.2001", "№4");
        Doctor doc7 = new Doctor(7L, "E07", "Отт", "Алексей", "Олегович","психотерапевт", "20.03.1995", "№7");
        Doctor doc8 = new Doctor(8L, "E08", "Катаева",  "Ольга", "Васильевна", "стоматолог", "15.06.1997", "№10");
        Doctor doc9 = new Doctor(9L, "E09", "Иванова",  "Ольга", "Георгиевна", "фтизиатр", "21.11.2001","№11");
        Doctor doc10 = new Doctor(10L, "E010", "Сидоренко",  "Татьяна", "Ивановна", "хирург", "13.10.1992", "№6");
        Doctor doc11 = new Doctor(11L, "E011", "Зайка",  "Софья", "Сергеевна", "дерматолог", "07.05.2000", "№3");

        docMap.put(doc1.getDocId(), doc1);
        docMap.put(doc2.getDocId(), doc2);
        docMap.put(doc3.getDocId(), doc3);
        docMap.put(doc4.getDocId(), doc4);
        docMap.put(doc5.getDocId(), doc5);
        docMap.put(doc6.getDocId(), doc6);
        docMap.put(doc7.getDocId(), doc7);
        docMap.put(doc8.getDocId(), doc8);
        docMap.put(doc9.getDocId(), doc9);
        docMap.put(doc10.getDocId(), doc10);
        docMap.put(doc11.getDocId(), doc11);

    }

    public Long getMaxDocId() {
        Set<Long> keys = docMap.keySet();
        Long max = 0L;
        for (Long key : keys) {
            if (key > max) {
                max = key;
            }
        }
        return max;
    }
    public Doctor getDoctor(Long docId) {
        return docMap.get(docId);
    }

    public Doctor addDoctor(DoctorForm docForm) {
        Long docId= this.getMaxDocId()+ 1;
        docForm.setDocId(docId);
        Doctor newDoc = new Doctor(docForm);

        docMap.put(newDoc.getDocId(), newDoc);
        return newDoc;


    }
    public Doctor updateDoctor(DoctorForm docForm) {
        Doctor doc = this.getDoctor(docForm.getDocId());
        if(doc!= null)  {
            doc.setDocNo(docForm.getDocNo());
            doc.setDocSurname(docForm.getDocSurname());
            doc.setDocName(docForm.getDocName());
            doc.setDocPatronymic(docForm.getDocPatronymic());
            doc.setPosition(docForm.getPosition());
            doc.setDocRecruitment(docForm.getDocRecruitment());
            doc.setDocCabinet(docForm.getDocCabinet());
        }
        return doc;
    }
    public void deleteDoctor(Long docId) {
        docMap.remove(docId);
    }

    public List<Doctor> getAllDoctors() {
        Collection<Doctor> c = docMap.values();
        List<Doctor> list = new ArrayList<Doctor>(c);
        return list;
    }
}
