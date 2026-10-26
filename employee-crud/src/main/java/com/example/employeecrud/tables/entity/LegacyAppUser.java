package com.example.employeecrud.tables.entity;

import com.example.employeecrud.tables.base.TableEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

/** Maps table `app_user`. */
@Entity
@Table(name = "app_user")
public class LegacyAppUser implements TableEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "User ID is required")
    @Size(max = 1000, message = "User ID can be at most 1000 characters")
    @Column(name = "userId", length = 1000)
    private String userId;

    @Size(max = 1000, message = "Password (plain text) can be at most 1000 characters")
    @Column(name = "textPwd", length = 1000)
    private String textPwd;

    @Size(max = 1000, message = "Group ID can be at most 1000 characters")
    @Column(name = "group_id", length = 1000)
    private String group_id;

    @Size(max = 1000, message = "Password can be at most 1000 characters")
    @Column(name = "pwd", length = 1000)
    private String pwd;

    @Size(max = 1000, message = "User name can be at most 1000 characters")
    @Column(name = "userName", length = 1000)
    private String userName;

    @Size(max = 500, message = "User dept can be at most 500 characters")
    @Column(name = "userDept", length = 500)
    private String userDept;

    @Size(max = 15, message = "Mobile no can be at most 15 characters")
    @Column(name = "mobileNo", length = 15)
    private String mobileNo;

    @Size(max = 5, message = "New user verification status can be at most 5 characters")
    @Column(name = "newUserVStatus", length = 5)
    private String newUserVStatus;

    @Size(max = 45, message = "New user verification code can be at most 45 characters")
    @Column(name = "newUserVCode", length = 45)
    private String newUserVCode;

    @Size(max = 45, message = "Forget password code can be at most 45 characters")
    @Column(name = "forgetPwdCode", length = 45)
    private String forgetPwdCode;

    @Size(max = 255, message = "Update by can be at most 255 characters")
    @Column(name = "updateBy", length = 255)
    private String updateBy;

    @Column(name = "updateDt")
    private LocalDate updateDt;

    @Column(name = "updateTime")
    private LocalTime updateTime;

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

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getTextPwd() { return textPwd; }
    public void setTextPwd(String textPwd) { this.textPwd = textPwd; }

    public String getGroup_id() { return group_id; }
    public void setGroup_id(String group_id) { this.group_id = group_id; }

    public String getPwd() { return pwd; }
    public void setPwd(String pwd) { this.pwd = pwd; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getUserDept() { return userDept; }
    public void setUserDept(String userDept) { this.userDept = userDept; }

    public String getMobileNo() { return mobileNo; }
    public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }

    public String getNewUserVStatus() { return newUserVStatus; }
    public void setNewUserVStatus(String newUserVStatus) { this.newUserVStatus = newUserVStatus; }

    public String getNewUserVCode() { return newUserVCode; }
    public void setNewUserVCode(String newUserVCode) { this.newUserVCode = newUserVCode; }

    public String getForgetPwdCode() { return forgetPwdCode; }
    public void setForgetPwdCode(String forgetPwdCode) { this.forgetPwdCode = forgetPwdCode; }

    public String getUpdateBy() { return updateBy; }
    public void setUpdateBy(String updateBy) { this.updateBy = updateBy; }

    public LocalDate getUpdateDt() { return updateDt; }
    public void setUpdateDt(LocalDate updateDt) { this.updateDt = updateDt; }

    public LocalTime getUpdateTime() { return updateTime; }
    public void setUpdateTime(LocalTime updateTime) { this.updateTime = updateTime; }

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
        this.updateTime = time;
    }
}
