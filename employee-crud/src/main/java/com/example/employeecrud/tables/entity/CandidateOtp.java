package com.example.employeecrud.tables.entity;

import com.example.employeecrud.tables.base.TableEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

/** Maps table `candidate_otp`. */
@Entity
@Table(name = "candidate_otp")
public class CandidateOtp implements TableEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(max = 45, message = "Candidate ID can be at most 45 characters")
    @Column(name = "cndtId", length = 45)
    private String cndtId;

    @Size(max = 45, message = "Candidate name can be at most 45 characters")
    @Column(name = "cndtName", length = 45)
    private String cndtName;

    @Size(max = 45, message = "Candidate mobile no can be at most 45 characters")
    @Column(name = "cndtMobileNo", length = 45)
    private String cndtMobileNo;

    @Size(max = 45, message = "OTP can be at most 45 characters")
    @Column(name = "cndtOTP", length = 45)
    private String cndtOTP;

    @Column(name = "updateDt")
    private LocalDate updateDt;

    @Size(max = 45, message = "Update time can be at most 45 characters")
    @Column(name = "updateTime", length = 45)
    private String updateTime;

    @Size(max = 45, message = "Status can be at most 45 characters")
    @Column(name = "status", length = 45)
    private String status;

    @Column(name = "otpReqId")
    private Integer otpReqId;

    @Size(max = 255, message = "Remark can be at most 255 characters")
    @Column(name = "remark", length = 255)
    private String remark;

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

    public String getCndtId() { return cndtId; }
    public void setCndtId(String cndtId) { this.cndtId = cndtId; }

    public String getCndtName() { return cndtName; }
    public void setCndtName(String cndtName) { this.cndtName = cndtName; }

    public String getCndtMobileNo() { return cndtMobileNo; }
    public void setCndtMobileNo(String cndtMobileNo) { this.cndtMobileNo = cndtMobileNo; }

    public String getCndtOTP() { return cndtOTP; }
    public void setCndtOTP(String cndtOTP) { this.cndtOTP = cndtOTP; }

    public LocalDate getUpdateDt() { return updateDt; }
    public void setUpdateDt(LocalDate updateDt) { this.updateDt = updateDt; }

    public String getUpdateTime() { return updateTime; }
    public void setUpdateTime(String updateTime) { this.updateTime = updateTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getOtpReqId() { return otpReqId; }
    public void setOtpReqId(Integer otpReqId) { this.otpReqId = otpReqId; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }

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
}
