package study.clinica.model;

public class Doctor {

    public Long docId;
    public String docNo;
    public String docSurname;
    public String docName;
    public String docPatronymic;
    public String position;
    public String docRecruitment;
    public String docCabinet;


    public Doctor() {

    }

    public Doctor(DoctorForm docForm) {
        this.docId = docForm.getDocId();
        this.docNo = docForm.getDocNo();
        this.docSurname= docForm.getDocSurname();
        this.docName = docForm.getDocName();
        this.docPatronymic = docForm.getDocPatronymic();
        this.position = docForm.getPosition();
        this.docRecruitment = docForm.getDocRecruitment();
        this.docCabinet = docForm.getDocCabinet();
    }

    public Doctor(Long docId, String docNo, String  docSurname, String docName, String docPatronymic, String position, String docRecruitment, String docCabinet) {
        this.docId = docId;
        this.docNo = docNo;
        this.docSurname= docSurname;
        this.docName = docName;
        this.docPatronymic = docPatronymic;
        this.position = position;
        this.docRecruitment = docRecruitment;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public String getDocPatronymic() {
        return docPatronymic;
    }

    public void setDocPatronymic(String docPatronymic) {
        this.docPatronymic = docPatronymic;
    }

    public String getDocRecruitment() {
        return docRecruitment;
    }

    public void setDocRecruitment(String docRecruitment) {
        this.docRecruitment = docRecruitment;
    }

    public String getDocCabinet() {
        return docCabinet;
    }

    public void setDocCabinet(String docCabinet) {
        this.docCabinet = docCabinet;
    }

}
