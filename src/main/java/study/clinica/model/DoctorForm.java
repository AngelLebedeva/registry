package study.clinica.model;

public class DoctorForm {

    public Long docId;
    public String docNo;
    public String docSurname;
    public String docName;
    public String docPatronymic;
    public String position;
    public String docRecruitment;
    public String docCabinet;

    public String getDocCabinet() {
        return docCabinet;
    }

    public void setDocCabinet(String docCabinet) {
        this.docCabinet = docCabinet;
    }

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public String getDocSurname() {
        return docSurname;
    }

    public void setDocSurname(String docSurname) {
        this.docSurname = docSurname;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }
    public String getDocPatronymic() {
        return docPatronymic;
    }

    public void setDocPatronymic(String docPatronymic) {
        this.docPatronymic = docPatronymic;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public String getDocRecruitment() {
        return docRecruitment;
    }

    public void setDocRecruitment(String docRecruitment) {
        this.docRecruitment = docRecruitment;
    }

}
