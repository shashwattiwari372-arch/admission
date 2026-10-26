package com.example.employeecrud.tables.entity;

import com.example.employeecrud.tables.base.TableEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/** Maps table `candidate_training`. */
@Entity
@Table(name = "candidate_training")
public class CandidateTraining implements TableEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "appId")
    private Integer appId;

    @Size(max = 255, message = "Course name can be at most 255 characters")
    @Column(name = "courseName", length = 255)
    private String courseName;

    @Column(name = "fromDt")
    private LocalDate fromDt;

    @Column(name = "toDt")
    private LocalDate toDt;

    @Size(max = 255, message = "Organisation name can be at most 255 characters")
    @Column(name = "orgName", length = 255)
    private String orgName;

    @Size(max = 15, message = "Organisation mobile can be at most 15 characters")
    @Column(name = "orgMobile", length = 15)
    private String orgMobile;

    @Size(max = 100, message = "Organisation email can be at most 100 characters")
    @Column(name = "orgEmail", length = 100)
    private String orgEmail;

    @Size(max = 255, message = "Organisation website can be at most 255 characters")
    @Column(name = "orgWebsite", length = 255)
    private String orgWebsite;

    @Size(max = 50, message = "Skill level can be at most 50 characters")
    @Column(name = "skillLevel", length = 50)
    private String skillLevel;

    @Column(name = "totalMarks", precision = 6, scale = 2)
    private BigDecimal totalMarks;

    @Column(name = "obtainedMarks", precision = 6, scale = 2)
    private BigDecimal obtainedMarks;

    @Column(name = "percentile", precision = 5, scale = 2)
    private BigDecimal percentile;

    @Size(max = 50, message = "Result status can be at most 50 characters")
    @Column(name = "resultStatus", length = 50)
    private String resultStatus;

    @Column(name = "description", columnDefinition = "text")
    private String description;

    @Size(max = 100, message = "Update by can be at most 100 characters")
    @Column(name = "updateBy", length = 100)
    private String updateBy;

    @Column(name = "updateDt")
    private LocalDate updateDt;

    @Column(name = "updateTime")
    private LocalTime updateTime;

    @Size(max = 45, message = "Extra 1 can be at most 45 characters")
    @Column(name = "f1", length = 45)
    private String f1;

    @Size(max = 45, message = "Extra 2 can be at most 45 characters")
    @Column(name = "f2", length = 45)
    private String f2;

    @Size(max = 45, message = "Extra 3 can be at most 45 characters")
    @Column(name = "f3", length = 45)
    private String f3;

    @Size(max = 45, message = "Extra 4 can be at most 45 characters")
    @Column(name = "f4", length = 45)
    private String f4;

    @Size(max = 45, message = "Extra 5 can be at most 45 characters")
    @Column(name = "f5", length = 45)
    private String f5;

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

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getAppId() { return appId; }
    public void setAppId(Integer appId) { this.appId = appId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public LocalDate getFromDt() { return fromDt; }
    public void setFromDt(LocalDate fromDt) { this.fromDt = fromDt; }

    public LocalDate getToDt() { return toDt; }
    public void setToDt(LocalDate toDt) { this.toDt = toDt; }

    public String getOrgName() { return orgName; }
    public void setOrgName(String orgName) { this.orgName = orgName; }

    public String getOrgMobile() { return orgMobile; }
    public void setOrgMobile(String orgMobile) { this.orgMobile = orgMobile; }

    public String getOrgEmail() { return orgEmail; }
    public void setOrgEmail(String orgEmail) { this.orgEmail = orgEmail; }

    public String getOrgWebsite() { return orgWebsite; }
    public void setOrgWebsite(String orgWebsite) { this.orgWebsite = orgWebsite; }

    public String getSkillLevel() { return skillLevel; }
    public void setSkillLevel(String skillLevel) { this.skillLevel = skillLevel; }

    public BigDecimal getTotalMarks() { return totalMarks; }
    public void setTotalMarks(BigDecimal totalMarks) { this.totalMarks = totalMarks; }

    public BigDecimal getObtainedMarks() { return obtainedMarks; }
    public void setObtainedMarks(BigDecimal obtainedMarks) { this.obtainedMarks = obtainedMarks; }

    public BigDecimal getPercentile() { return percentile; }
    public void setPercentile(BigDecimal percentile) { this.percentile = percentile; }

    public String getResultStatus() { return resultStatus; }
    public void setResultStatus(String resultStatus) { this.resultStatus = resultStatus; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUpdateBy() { return updateBy; }
    public void setUpdateBy(String updateBy) { this.updateBy = updateBy; }

    public LocalDate getUpdateDt() { return updateDt; }
    public void setUpdateDt(LocalDate updateDt) { this.updateDt = updateDt; }

    public LocalTime getUpdateTime() { return updateTime; }
    public void setUpdateTime(LocalTime updateTime) { this.updateTime = updateTime; }

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

    @Override
    public void stamp(String by, LocalDate date, LocalTime time) {
        this.updateBy = by;
        this.updateDt = date;
        this.updateTime = time;
    }
}
