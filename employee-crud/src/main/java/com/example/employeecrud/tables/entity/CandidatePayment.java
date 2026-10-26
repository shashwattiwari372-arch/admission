package com.example.employeecrud.tables.entity;

import com.example.employeecrud.tables.base.TableEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

/** Maps table `candidate_payment`. */
@Entity
@Table(name = "candidate_payment")
public class CandidatePayment implements TableEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "payId")
    private Integer payId;

    @Column(name = "appId")
    private Integer appId;

    @Size(max = 75, message = "Request payment ID can be at most 75 characters")
    @Column(name = "reqPayId", length = 75)
    private String reqPayId;

    @Size(max = 60, message = "Fee code can be at most 60 characters")
    @Column(name = "feeCode", length = 60)
    private String feeCode;

    @Size(max = 75, message = "User email can be at most 75 characters")
    @Column(name = "usrEmail", length = 75)
    private String usrEmail;

    @Size(max = 20, message = "User mobile can be at most 20 characters")
    @Column(name = "usrMobile", length = 20)
    private String usrMobile;

    @Size(max = 100, message = "User name can be at most 100 characters")
    @Column(name = "usrName", length = 100)
    private String usrName;

    @Size(max = 300, message = "Payment success URL can be at most 300 characters")
    @Column(name = "paySuccessURL", length = 300)
    private String paySuccessURL;

    @Size(max = 15, message = "Payment amount can be at most 15 characters")
    @Column(name = "payAmt", length = 15)
    private String payAmt;

    @Size(max = 200, message = "Gateway secret key can be at most 200 characters")
    @Column(name = "gwSecrKey", length = 200)
    private String gwSecrKey;

    @Size(max = 75, message = "Transaction ID can be at most 75 characters")
    @Column(name = "transId", length = 75)
    private String transId;

    @Column(name = "transDt")
    private LocalDate transDt;

    @Size(max = 15, message = "Transaction amount can be at most 15 characters")
    @Column(name = "transAmt", length = 15)
    private String transAmt;

    @Size(max = 50, message = "Gateway name can be at most 50 characters")
    @Column(name = "gwName", length = 50)
    private String gwName;

    @Size(max = 45, message = "Payment status can be at most 45 characters")
    @Column(name = "payStatus", length = 45)
    private String payStatus;

    @Size(max = 75, message = "Update by user can be at most 75 characters")
    @Column(name = "updateByUsr", length = 75)
    private String updateByUsr;

    @Column(name = "updateDtUsr")
    private LocalDate updateDtUsr;

    @Size(max = 45, message = "Update time user can be at most 45 characters")
    @Column(name = "updateTimeUsr", length = 45)
    private String updateTimeUsr;

    @Size(max = 45, message = "Update by gateway can be at most 45 characters")
    @Column(name = "updateByGw", length = 45)
    private String updateByGw;

    @Column(name = "updateDtGw")
    private LocalDate updateDtGw;

    @Size(max = 45, message = "Update time gateway can be at most 45 characters")
    @Column(name = "updateTimeGw", length = 45)
    private String updateTimeGw;

    @Size(max = 45, message = "Payment method can be at most 45 characters")
    @Column(name = "payMethod", length = 45)
    private String payMethod;

    @Size(max = 500, message = "Payment detail can be at most 500 characters")
    @Column(name = "payDetail", length = 500)
    private String payDetail;

    @Size(max = 500, message = "Remark can be at most 500 characters")
    @Column(name = "remark", length = 500)
    private String remark;

    @Size(max = 10, message = "Uploaded visible can be at most 10 characters")
    @Column(name = "uploadedVisible", length = 10)
    private String uploadedVisible;

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

    public Integer getPayId() { return payId; }
    public void setPayId(Integer payId) { this.payId = payId; }

    public Integer getAppId() { return appId; }
    public void setAppId(Integer appId) { this.appId = appId; }

    public String getReqPayId() { return reqPayId; }
    public void setReqPayId(String reqPayId) { this.reqPayId = reqPayId; }

    public String getFeeCode() { return feeCode; }
    public void setFeeCode(String feeCode) { this.feeCode = feeCode; }

    public String getUsrEmail() { return usrEmail; }
    public void setUsrEmail(String usrEmail) { this.usrEmail = usrEmail; }

    public String getUsrMobile() { return usrMobile; }
    public void setUsrMobile(String usrMobile) { this.usrMobile = usrMobile; }

    public String getUsrName() { return usrName; }
    public void setUsrName(String usrName) { this.usrName = usrName; }

    public String getPaySuccessURL() { return paySuccessURL; }
    public void setPaySuccessURL(String paySuccessURL) { this.paySuccessURL = paySuccessURL; }

    public String getPayAmt() { return payAmt; }
    public void setPayAmt(String payAmt) { this.payAmt = payAmt; }

    public String getGwSecrKey() { return gwSecrKey; }
    public void setGwSecrKey(String gwSecrKey) { this.gwSecrKey = gwSecrKey; }

    public String getTransId() { return transId; }
    public void setTransId(String transId) { this.transId = transId; }

    public LocalDate getTransDt() { return transDt; }
    public void setTransDt(LocalDate transDt) { this.transDt = transDt; }

    public String getTransAmt() { return transAmt; }
    public void setTransAmt(String transAmt) { this.transAmt = transAmt; }

    public String getGwName() { return gwName; }
    public void setGwName(String gwName) { this.gwName = gwName; }

    public String getPayStatus() { return payStatus; }
    public void setPayStatus(String payStatus) { this.payStatus = payStatus; }

    public String getUpdateByUsr() { return updateByUsr; }
    public void setUpdateByUsr(String updateByUsr) { this.updateByUsr = updateByUsr; }

    public LocalDate getUpdateDtUsr() { return updateDtUsr; }
    public void setUpdateDtUsr(LocalDate updateDtUsr) { this.updateDtUsr = updateDtUsr; }

    public String getUpdateTimeUsr() { return updateTimeUsr; }
    public void setUpdateTimeUsr(String updateTimeUsr) { this.updateTimeUsr = updateTimeUsr; }

    public String getUpdateByGw() { return updateByGw; }
    public void setUpdateByGw(String updateByGw) { this.updateByGw = updateByGw; }

    public LocalDate getUpdateDtGw() { return updateDtGw; }
    public void setUpdateDtGw(LocalDate updateDtGw) { this.updateDtGw = updateDtGw; }

    public String getUpdateTimeGw() { return updateTimeGw; }
    public void setUpdateTimeGw(String updateTimeGw) { this.updateTimeGw = updateTimeGw; }

    public String getPayMethod() { return payMethod; }
    public void setPayMethod(String payMethod) { this.payMethod = payMethod; }

    public String getPayDetail() { return payDetail; }
    public void setPayDetail(String payDetail) { this.payDetail = payDetail; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }

    public String getUploadedVisible() { return uploadedVisible; }
    public void setUploadedVisible(String uploadedVisible) { this.uploadedVisible = uploadedVisible; }

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
