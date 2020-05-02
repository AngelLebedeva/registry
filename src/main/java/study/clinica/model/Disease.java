package study.clinica.model;

public class Disease {

    public Long disId;
    public String disName;
    public String disGroup;

    public Disease() {

    }

    public Disease(DiseaseForm disForm) {
        this.disId = disForm.getDisId();
        this.disName = disForm.getDisName();
        this.disGroup = disForm.getDisGroup();
    }

    public Disease(Long disId, String  disName, String disGroup) {
        this.disId = disId;
        this.disName = disName;
        this.disGroup= disGroup;

    }

    public Long getDisId() {
        return disId;
    }

    public void setDisId(Long disId) {
        this.disId = disId;
    }

    public String getDisName() {
        return disName;
    }

    public void setDisName(String disName) {
        this.disName = disName;
    }

    public String getDisGroup() {
        return disGroup;
    }

    public void setDisGroup(String disGroup) {
        this.disGroup = disGroup;
    }
}
