package com.example.employeecrud.candidateexp;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "candidate_exp")
public class CandidateExp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "Application id is required")
    @Column(name = "appId")
    private Integer appId;

    @NotBlank(message = "Employer name is required")
    @Size(max = 150)
    @Column(name = "employerName", length = 150)
    private String employerName;

    @Size(max = 50)
    @Column(name = "orgType", length = 50)
    private String orgType;

    @Size(max = 255)
    @Column(name = "orgWebsite", length = 255)
    private String orgWebsite;

    @Size(max = 15)
    @Column(name = "orgMobile", length = 15)
    private String orgMobile;

    @Email(message = "Enter a valid email address")
    @Size(max = 100)
    @Column(name = "orgEmail", length = 100)
    private String orgEmail;

    @Column(name = "fromDt")
    private LocalDate fromDt;

    @Column(name = "toDt")
    private LocalDate toDt;

    @Column(name = "noOfYears")
    private Integer noOfYears;

    @Column(name = "noOfMonths")
    private Integer noOfMonths;

    @Column(name = "noOfDays")
    private Integer noOfDays;

    @NotBlank(message = "Designation is required")
    @Size(max = 100)
    @Column(name = "designation", length = 100)
    private String designation;

    @Size(max = 45)
    @Column(name = "payLevel", length = 45)
    private String payLevel;

    @Size(max = 45)
    @Column(name = "jobType", length = 45)
    private String jobType;

    @Size(max = 45)
    @Column(name = "lastPay", length = 45)
    private String lastPay;

    @Column(name = "basicPay")
    private BigDecimal basicPay;

    @Column(name = "otherAllowance")
    private BigDecimal otherAllowance;

    @Column(name = "totalEmoluments")
    private BigDecimal totalEmoluments;

    @Size(max = 500)
    @Column(name = "natureWork", length = 500)
    private String natureWork;

    @Column(name = "responsibilities", columnDefinition = "TEXT")
    private String responsibilities;

    @Size(max = 500)
    @Column(name = "reasonLeave", length = 500)
    private String reasonLeave;

    @Size(max = 70)
    @Column(name = "updateBy", length = 70)
    private String updateBy;

    @Column(name = "updateDt")
    private LocalDate updateDt;

    @Size(max = 45)
    @Column(name = "updateTime", length = 45)
    private String updateTime;

    @Size(max = 45)
    @Column(name = "remark", length = 45)
    private String remark;

    @Size(max = 45)
    @Column(name = "f1", length = 45)
    private String f1;

    @Size(max = 45)
    @Column(name = "f2", length = 45)
    private String f2;

    @Size(max = 45)
    @Column(name = "f3", length = 45)
    private String f3;

    @Size(max = 45)
    @Column(name = "f4", length = 45)
    private String f4;

    @Size(max = 45)
    @Column(name = "f5", length = 45)
    private String f5;

    @Size(max = 255)
    @Column(name = "vStatus", length = 255)
    private String vStatus;

    @Size(max = 255)
    @Column(name = "vBy", length = 255)
    private String vBy;

    @Size(max = 255)
    @Column(name = "vStamp", length = 255)
    private String vStamp;

    @Size(max = 255)
    @Column(name = "pStatus", length = 255)
    private String pStatus;

    @Size(max = 255)
    @Column(name = "pBy", length = 255)
    private String pBy;

    @Size(max = 255)
    @Column(name = "pStamp", length = 255)
    private String pStamp;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getAppId() { return appId; }
    public void setAppId(Integer appId) { this.appId = appId; }

    public String getEmployerName() { return employerName; }
    public void setEmployerName(String employerName) { this.employerName = employerName; }

    public String getOrgType() { return orgType; }
    public void setOrgType(String orgType) { this.orgType = orgType; }

    public String getOrgWebsite() { return orgWebsite; }
    public void setOrgWebsite(String orgWebsite) { this.orgWebsite = orgWebsite; }

    public String getOrgMobile() { return orgMobile; }
    public void setOrgMobile(String orgMobile) { this.orgMobile = orgMobile; }

    public String getOrgEmail() { return orgEmail; }
    public void setOrgEmail(String orgEmail) { this.orgEmail = orgEmail; }

    public LocalDate getFromDt() { return fromDt; }
    public void setFromDt(LocalDate fromDt) { this.fromDt = fromDt; }

    public LocalDate getToDt() { return toDt; }
    public void setToDt(LocalDate toDt) { this.toDt = toDt; }

    public Integer getNoOfYears() { return noOfYears; }
    public void setNoOfYears(Integer noOfYears) { this.noOfYears = noOfYears; }

    public Integer getNoOfMonths() { return noOfMonths; }
    public void setNoOfMonths(Integer noOfMonths) { this.noOfMonths = noOfMonths; }

    public Integer getNoOfDays() { return noOfDays; }
    public void setNoOfDays(Integer noOfDays) { this.noOfDays = noOfDays; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public String getPayLevel() { return payLevel; }
    public void setPayLevel(String payLevel) { this.payLevel = payLevel; }

    public String getJobType() { return jobType; }
    public void setJobType(String jobType) { this.jobType = jobType; }

    public String getLastPay() { return lastPay; }
    public void setLastPay(String lastPay) { this.lastPay = lastPay; }

    public BigDecimal getBasicPay() { return basicPay; }
    public void setBasicPay(BigDecimal basicPay) { this.basicPay = basicPay; }

    public BigDecimal getOtherAllowance() { return otherAllowance; }
    public void setOtherAllowance(BigDecimal otherAllowance) { this.otherAllowance = otherAllowance; }

    public BigDecimal getTotalEmoluments() { return totalEmoluments; }
    public void setTotalEmoluments(BigDecimal totalEmoluments) { this.totalEmoluments = totalEmoluments; }

    public String getNatureWork() { return natureWork; }
    public void setNatureWork(String natureWork) { this.natureWork = natureWork; }

    public String getResponsibilities() { return responsibilities; }
    public void setResponsibilities(String responsibilities) { this.responsibilities = responsibilities; }

    public String getReasonLeave() { return reasonLeave; }
    public void setReasonLeave(String reasonLeave) { this.reasonLeave = reasonLeave; }

    public String getUpdateBy() { return updateBy; }
    public void setUpdateBy(String updateBy) { this.updateBy = updateBy; }

    public LocalDate getUpdateDt() { return updateDt; }
    public void setUpdateDt(LocalDate updateDt) { this.updateDt = updateDt; }

    public String getUpdateTime() { return updateTime; }
    public void setUpdateTime(String updateTime) { this.updateTime = updateTime; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }

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
}
