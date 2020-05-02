package study.clinica.model;



public class Visit {

    public Long visId;
    public String docId;
    public String patId;
    public String visDate;
    public String visTime;
    public String disId;

    public Visit() {

    }

    public Visit(VisitForm visForm) {
        this.visId = visForm.getVisId();
        this.docId = visForm.getDocId();
        this.patId = visForm.getPatId();
        this.visDate = visForm.getVisDate();
        this.visTime = visForm.getVisTime();
        this.disId = visForm.getDisId();


    }

    public Visit(Long visId, String docId, String  patId, String visDate, String visTime, String disId) {
        this.visId = visId;
        this.docId = docId;
        this.patId= patId;
        this.visDate = visDate;
        this.visTime = visTime;
        this.disId = disId;

    }

    public String getVisTime() {
        return visTime;
    }

    public void setVisTime(String visTime) {
        this.visTime = visTime;
    }

    public Long getVisId() {
        return visId;
    }

    public void setVisId(Long visId) {
        this.visId = visId;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId;
    }

    public String getVisDate() {
        return visDate;
    }

    public void setVisDate(String visDate) {
        this.visDate = visDate;
    }

    public String getDisId() {
        return disId;
    }

    public void setDisId(String disId) {
        this.disId = disId;
    }
}
