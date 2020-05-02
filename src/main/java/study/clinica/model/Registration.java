package study.clinica.model;

public class Registration {

    private Long regId;
    private String position;
    private String docSurname;
    private String patSurname;
    private String visDate;
    private String visTime;

    public Registration() {

    }
    public Registration(RegistrationForm regForm){
        this.regId = regForm.getRegId();
        this.position = regForm.getPosition();
        this.docSurname = regForm.getDocSurname();
        this.patSurname = regForm.getPatSurname();
        this.visDate = regForm.getVisDate();
        this.visTime = regForm.getVisTime();

    }
    public Registration (Long regId, String position, String  docSurname, String patSurname, String visDate, String visTime) {
        this.regId = regId;
        this.position = position;
        this.docSurname= docSurname;
        this.patSurname = patSurname;
        this.visDate = visDate;
        this.visTime = visTime;

    }

    public Long getRegId() {
        return regId;
    }

    public void setVisId(Long regId) {
        this.regId = regId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDocSurname() {
        return docSurname;
    }

    public void setDocSurname(String docSurname) {
        this.docSurname = docSurname;
    }

    public String getPatSurname() {
        return patSurname;
    }

    public void setPatSurname(String patSurname) {
        this.patSurname = patSurname;
    }

    public String getVisDate() {
        return visDate;
    }

    public void setVisDate(String visDate) {
        this.visDate = visDate;
    }

    public String getVisTime() {
        return visTime;
    }

    public void setVisTime(String visTime) {
        this.visTime = visTime;
    }
}
