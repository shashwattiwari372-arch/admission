package com.example.employeecrud.tables.entity;

import com.example.employeecrud.tables.base.TableEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

/** Maps table `candidate_form_status`. */
@Entity
@Table(name = "candidate_form_status")
public class CandidateFormStatus implements TableEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "formStatusId")
    private Integer formStatusId;

    @Column(name = "appId")
    private Integer appId;

    @Size(max = 80, message = "Form name can be at most 80 characters")
    @Column(name = "formName", length = 80)
    private String formName;

    @Size(max = 45, message = "Form status can be at most 45 characters")
    @Column(name = "formStatus", length = 45)
    private String formStatus;

    @Size(max = 50, message = "Update by can be at most 50 characters")
    @Column(name = "updateBy", length = 50)
    private String updateBy;

    @Column(name = "updateDt")
    private LocalDate updateDt;

    @Size(max = 45, message = "Update time can be at most 45 characters")
    @Column(name = "updateTime", length = 45)
    private String updateTime;

    @Size(max = 250, message = "Remark can be at most 250 characters")
    @Column(name = "remark", length = 250)
    private String remark;

    @Size(max = 255, message = "Status can be at most 255 characters")
    @Column(name = "status", length = 255)
    private String status;

    @Size(max = 255, message = "Verification status can be at most 255 characters")
    @Column(name = "vStatus", length = 255)
    private String vStatus;

    @Size(max = 255, message = "Verified by can be at most 255 characters")
    @Column(name = "vBy", length = 255)
    private String vBy;

    @Size(max = 255, message = "Verified at can be at most 255 characters")
    @Column(name = "vStamp", length = 255)
    private String vStamp;

    @Size(max = 255, message = "Processing status can be at most 255 characters")
    @Column(name = "pStatus", length = 255)
    private String pStatus;

    @Size(max = 255, message = "Processed by can be at most 255 characters")
    @Column(name = "pBy", length = 255)
    private String pBy;

    @Size(max = 255, message = "Processed at can be at most 255 characters")
    @Column(name = "pStamp", length = 255)
    private String pStamp;

    @Size(max = 255, message = "Extra 1 can be at most 255 characters")
    @Column(name = "f1", length = 255)
    private String f1;

    @Size(max = 255, message = "Extra 2 can be at most 255 characters")
    @Column(name = "f2", length = 255)
    private String f2;

    @Size(max = 255, message = "Extra 3 can be at most 255 characters")
    @Column(name = "f3", length = 255)
    private String f3;

    @Size(max = 255, message = "Extra 4 can be at most 255 characters")
    @Column(name = "f4", length = 255)
    private String f4;

    @Size(max = 255, message = "Extra 5 can be at most 255 characters")
    @Column(name = "f5", length = 255)
    private String f5;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getFormStatusId() { return formStatusId; }
    public void setFormStatusId(Integer formStatusId) { this.formStatusId = formStatusId; }

    public Integer getAppId() { return appId; }
    public void setAppId(Integer appId) { this.appId = appId; }

    public String getFormName() { return formName; }
    public void setFormName(String formName) { this.formName = formName; }

    public String getFormStatus() { return formStatus; }
    public void setFormStatus(String formStatus) { this.formStatus = formStatus; }

    public String getUpdateBy() { return updateBy; }
    public void setUpdateBy(String updateBy) { this.updateBy = updateBy; }

    public LocalDate getUpdateDt() { return updateDt; }
    public void setUpdateDt(LocalDate updateDt) { this.updateDt = updateDt; }

    public String getUpdateTime() { return updateTime; }
    public void setUpdateTime(String updateTime) { this.updateTime = updateTime; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @JsonProperty("vStatus")
    public String getVStatus() { return vStatus; }
    @JsonProperty("vStatus")
    public void setVStatus(String vStatus) { this.vStatus = vStatus; }

    @JsonProperty("vBy")
    public String getVBy() { return vBy; }
    @JsonProperty("vBy")
    public void setVBy(String vBy) { this.vBy = vBy; }

    @JsonProperty("vStamp")
    public String getVStamp() { return vStamp; }
    @JsonProperty("vStamp")
    public void setVStamp(String vStamp) { this.vStamp = vStamp; }

    @JsonProperty("pStatus")
    public String getPStatus() { return pStatus; }
    @JsonProperty("pStatus")
    public void setPStatus(String pStatus) { this.pStatus = pStatus; }

    @JsonProperty("pBy")
    public String getPBy() { return pBy; }
    @JsonProperty("pBy")
    public void setPBy(String pBy) { this.pBy = pBy; }

    @JsonProperty("pStamp")
    public String getPStamp() { return pStamp; }
    @JsonProperty("pStamp")
    public void setPStamp(String pStamp) { this.pStamp = pStamp; }

    public String getF1() { return f1; }
    public void setF1(String f1) { this.f1 = f1; }

    public String getF2() { return f2; }
    public void setF2(String f2) { this.f2 = f2; }

    public String getF3() { return f3; }
    public void setF3(String f3) { this.f3 = f3; }

    public String getF4() { return f4; }
    public void setF4(String f4) { this.f4 = f4; }

    public String getF5() { return f5; }
    public void setF5(String f5) { this.f5 = f5; }

    @Override
    public void stamp(String by, LocalDate date, LocalTime time) {
        this.updateBy = by;
        this.updateDt = date;
        this.updateTime = time.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
