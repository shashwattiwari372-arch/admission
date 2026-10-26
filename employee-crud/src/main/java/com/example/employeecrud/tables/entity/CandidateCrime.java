package com.example.employeecrud.tables.entity;

import com.example.employeecrud.tables.base.TableEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

/** Maps table `candidate_crime`. */
@Entity
@Table(name = "candidate_crime")
public class CandidateCrime implements TableEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "crimeId")
    private Integer crimeId;

    @Column(name = "appId")
    private Integer appId;

    @Size(max = 45, message = "Crime no can be at most 45 characters")
    @Column(name = "crimeNo", length = 45)
    private String crimeNo;

    @Size(max = 150, message = "Section act can be at most 150 characters")
    @Column(name = "sectionAct", length = 150)
    private String sectionAct;

    @Size(max = 45, message = "Court name can be at most 45 characters")
    @Column(name = "courtName", length = 45)
    private String courtName;

    @Column(name = "crimeDt")
    private LocalDate crimeDt;

    @Size(max = 500, message = "Remark punishment can be at most 500 characters")
    @Column(name = "remarkPunishment", length = 500)
    private String remarkPunishment;

    @Size(max = 70, message = "Update by can be at most 70 characters")
    @Column(name = "updateBy", length = 70)
    private String updateBy;

    @Column(name = "updateDt")
    private LocalDate updateDt;

    @Size(max = 45, message = "Update time can be at most 45 characters")
    @Column(name = "updateTime", length = 45)
    private String updateTime;

    @Size(max = 255, message = "Remark can be at most 255 characters")
    @Column(name = "remark", length = 255)
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

    public Integer getCrimeId() { return crimeId; }
    public void setCrimeId(Integer crimeId) { this.crimeId = crimeId; }

    public Integer getAppId() { return appId; }
    public void setAppId(Integer appId) { this.appId = appId; }

    public String getCrimeNo() { return crimeNo; }
    public void setCrimeNo(String crimeNo) { this.crimeNo = crimeNo; }

    public String getSectionAct() { return sectionAct; }
    public void setSectionAct(String sectionAct) { this.sectionAct = sectionAct; }

    public String getCourtName() { return courtName; }
    public void setCourtName(String courtName) { this.courtName = courtName; }

    public LocalDate getCrimeDt() { return crimeDt; }
    public void setCrimeDt(LocalDate crimeDt) { this.crimeDt = crimeDt; }

    public String getRemarkPunishment() { return remarkPunishment; }
    public void setRemarkPunishment(String remarkPunishment) { this.remarkPunishment = remarkPunishment; }

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
