package com.example.employeecrud.candidate;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

/** Candidate profile. Field names match core/models/candidate-profile.model.ts exactly. */
@Entity
@Table(name = "candidate_profile")
public class CandidateProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(max = 20, message = "title is too long (max 20)")
    @Column(name = "title", length = 20)
    private String title;

    @NotBlank(message = "Full name is required")
    @Size(max = 150, message = "fullName is too long (max 150)")
    @Column(name = "fullName", length = 150)
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email address")
    @Size(max = 150, message = "email is too long (max 150)")
    @Column(name = "email", length = 150)
    private String email;

    @Size(max = 20, message = "mobileNo is too long (max 20)")
    @Column(name = "mobileNo", length = 20)
    private String mobileNo;

    @Size(max = 150, message = "fatherHusbandName is too long (max 150)")
    @Column(name = "fatherHusbandName", length = 150)
    private String fatherHusbandName;

    @Size(max = 150, message = "motherName is too long (max 150)")
    @Column(name = "motherName", length = 150)
    private String motherName;

    @Size(max = 20, message = "fatherMobile is too long (max 20)")
    @Column(name = "fatherMobile", length = 20)
    private String fatherMobile;

    @Size(max = 20, message = "motherMobile is too long (max 20)")
    @Column(name = "motherMobile", length = 20)
    private String motherMobile;

    @Size(max = 150, message = "fatherOccupation is too long (max 150)")
    @Column(name = "fatherOccupation", length = 150)
    private String fatherOccupation;

    @Size(max = 150, message = "motherOccupation is too long (max 150)")
    @Column(name = "motherOccupation", length = 150)
    private String motherOccupation;

    @Min(value = 0, message = "Siblings cannot be negative")
    @Column(name = "siblings")
    private Integer siblings;

    @Size(max = 50, message = "annualIncome is too long (max 50)")
    @Column(name = "annualIncome", length = 50)
    private String annualIncome;

    @Size(max = 200, message = "orgName is too long (max 200)")
    @Column(name = "orgName", length = 200)
    private String orgName;

    @Size(max = 150, message = "designation is too long (max 150)")
    @Column(name = "designation", length = 150)
    private String designation;

    @Size(max = 100, message = "city is too long (max 100)")
    @Column(name = "city", length = 100)
    private String city;

    @Size(max = 100, message = "distt is too long (max 100)")
    @Column(name = "distt", length = 100)
    private String distt;

    @Size(max = 100, message = "state is too long (max 100)")
    @Column(name = "state", length = 100)
    private String state;

    @Size(max = 20, message = "orgPhone is too long (max 20)")
    @Column(name = "orgPhone", length = 20)
    private String orgPhone;

    @Email(message = "Enter a valid email address")
    @Size(max = 150, message = "orgEmail is too long (max 150)")
    @Column(name = "orgEmail", length = 150)
    private String orgEmail;

    @Size(max = 255, message = "orgWebsite is too long (max 255)")
    @Column(name = "orgWebsite", length = 255)
    private String orgWebsite;

    @Size(max = 10, message = "physicallyChallenged is too long (max 10)")
    @Column(name = "physicallyChallenged", length = 10)
    private String physicallyChallenged;

    @Size(max = 20, message = "aadhaarNo is too long (max 20)")
    @Column(name = "aadhaarNo", length = 20)
    private String aadhaarNo;

    @Size(max = 50, message = "apaarId is too long (max 50)")
    @Column(name = "apaarId", length = 50)
    private String apaarId;

    @Size(max = 20, message = "panNo is too long (max 20)")
    @Column(name = "panNo", length = 20)
    private String panNo;

    @Size(max = 30, message = "voterId is too long (max 30)")
    @Column(name = "voterId", length = 30)
    private String voterId;

    @Size(max = 30, message = "passportNo is too long (max 30)")
    @Column(name = "passportNo", length = 30)
    private String passportNo;

    @Size(max = 30, message = "drivingLicenseNo is too long (max 30)")
    @Column(name = "drivingLicenseNo", length = 30)
    private String drivingLicenseNo;

    @Size(max = 20, message = "gender is too long (max 20)")
    @Column(name = "gender", length = 20)
    private String gender;

    @Size(max = 10, message = "bloodGroup is too long (max 10)")
    @Column(name = "bloodGroup", length = 10)
    private String bloodGroup;

    @Size(max = 30, message = "category is too long (max 30)")
    @Column(name = "category", length = 30)
    private String category;

    @Size(max = 500, message = "localAddress is too long (max 500)")
    @Column(name = "localAddress", length = 500)
    private String localAddress;

    @Size(max = 500, message = "permanentAddress is too long (max 500)")
    @Column(name = "permanentAddress", length = 500)
    private String permanentAddress;

    @Column(name = "dob")
    private LocalDate dob;

    @Size(max = 30, message = "maritalStatus is too long (max 30)")
    @Column(name = "maritalStatus", length = 30)
    private String maritalStatus;

    @Size(max = 500, message = "remark is too long (max 500)")
    @Column(name = "remark", length = 500)
    private String remark;

    @Size(max = 70, message = "updateBy is too long (max 70)")
    @Column(name = "updateBy", length = 70)
    private String updateBy;

    @Column(name = "updateDt")
    private LocalDate updateDt;

    @Size(max = 45, message = "updateTime is too long (max 45)")
    @Column(name = "updateTime", length = 45)
    private String updateTime;

    @Email(message = "Enter a valid email address")
    @Size(max = 150, message = "alternativeEmail is too long (max 150)")
    @Column(name = "alternativeEmail", length = 150)
    private String alternativeEmail;

    @Size(max = 60, message = "nationality is too long (max 60)")
    @Column(name = "nationality", length = 60)
    private String nationality;

    @Size(max = 60, message = "religion is too long (max 60)")
    @Column(name = "religion", length = 60)
    private String religion;

    @Size(max = 45, message = "f1 is too long (max 45)")
    @Column(name = "f1", length = 45)
    private String f1;

    @Size(max = 45, message = "f2 is too long (max 45)")
    @Column(name = "f2", length = 45)
    private String f2;

    @Size(max = 45, message = "f3 is too long (max 45)")
    @Column(name = "f3", length = 45)
    private String f3;

    @Size(max = 45, message = "f4 is too long (max 45)")
    @Column(name = "f4", length = 45)
    private String f4;

    @Size(max = 45, message = "f5 is too long (max 45)")
    @Column(name = "f5", length = 45)
    private String f5;

    @Size(max = 255, message = "vStatus is too long (max 255)")
    @Column(name = "vStatus", length = 255)
    private String vStatus;

    @Size(max = 255, message = "vBy is too long (max 255)")
    @Column(name = "vBy", length = 255)
    private String vBy;

    @Size(max = 255, message = "vStamp is too long (max 255)")
    @Column(name = "vStamp", length = 255)
    private String vStamp;

    @Size(max = 255, message = "pStatus is too long (max 255)")
    @Column(name = "pStatus", length = 255)
    private String pStatus;

    @Size(max = 255, message = "pBy is too long (max 255)")
    @Column(name = "pBy", length = 255)
    private String pBy;

    @Size(max = 255, message = "pStamp is too long (max 255)")
    @Column(name = "pStamp", length = 255)
    private String pStamp;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobileNo() { return mobileNo; }
    public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }

    public String getFatherHusbandName() { return fatherHusbandName; }
    public void setFatherHusbandName(String fatherHusbandName) { this.fatherHusbandName = fatherHusbandName; }

    public String getMotherName() { return motherName; }
    public void setMotherName(String motherName) { this.motherName = motherName; }

    public String getFatherMobile() { return fatherMobile; }
    public void setFatherMobile(String fatherMobile) { this.fatherMobile = fatherMobile; }

    public String getMotherMobile() { return motherMobile; }
    public void setMotherMobile(String motherMobile) { this.motherMobile = motherMobile; }

    public String getFatherOccupation() { return fatherOccupation; }
    public void setFatherOccupation(String fatherOccupation) { this.fatherOccupation = fatherOccupation; }

    public String getMotherOccupation() { return motherOccupation; }
    public void setMotherOccupation(String motherOccupation) { this.motherOccupation = motherOccupation; }

    public Integer getSiblings() { return siblings; }
    public void setSiblings(Integer siblings) { this.siblings = siblings; }

    public String getAnnualIncome() { return annualIncome; }
    public void setAnnualIncome(String annualIncome) { this.annualIncome = annualIncome; }

    public String getOrgName() { return orgName; }
    public void setOrgName(String orgName) { this.orgName = orgName; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getDistt() { return distt; }
    public void setDistt(String distt) { this.distt = distt; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getOrgPhone() { return orgPhone; }
    public void setOrgPhone(String orgPhone) { this.orgPhone = orgPhone; }

    public String getOrgEmail() { return orgEmail; }
    public void setOrgEmail(String orgEmail) { this.orgEmail = orgEmail; }

    public String getOrgWebsite() { return orgWebsite; }
    public void setOrgWebsite(String orgWebsite) { this.orgWebsite = orgWebsite; }

    public String getPhysicallyChallenged() { return physicallyChallenged; }
    public void setPhysicallyChallenged(String physicallyChallenged) { this.physicallyChallenged = physicallyChallenged; }

    public String getAadhaarNo() { return aadhaarNo; }
    public void setAadhaarNo(String aadhaarNo) { this.aadhaarNo = aadhaarNo; }

    public String getApaarId() { return apaarId; }
    public void setApaarId(String apaarId) { this.apaarId = apaarId; }

    public String getPanNo() { return panNo; }
    public void setPanNo(String panNo) { this.panNo = panNo; }

    public String getVoterId() { return voterId; }
    public void setVoterId(String voterId) { this.voterId = voterId; }

    public String getPassportNo() { return passportNo; }
    public void setPassportNo(String passportNo) { this.passportNo = passportNo; }

    public String getDrivingLicenseNo() { return drivingLicenseNo; }
    public void setDrivingLicenseNo(String drivingLicenseNo) { this.drivingLicenseNo = drivingLicenseNo; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getLocalAddress() { return localAddress; }
    public void setLocalAddress(String localAddress) { this.localAddress = localAddress; }

    public String getPermanentAddress() { return permanentAddress; }
    public void setPermanentAddress(String permanentAddress) { this.permanentAddress = permanentAddress; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getMaritalStatus() { return maritalStatus; }
    public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }

    public String getUpdateBy() { return updateBy; }
    public void setUpdateBy(String updateBy) { this.updateBy = updateBy; }

    public LocalDate getUpdateDt() { return updateDt; }
    public void setUpdateDt(LocalDate updateDt) { this.updateDt = updateDt; }

    public String getUpdateTime() { return updateTime; }
    public void setUpdateTime(String updateTime) { this.updateTime = updateTime; }

    public String getAlternativeEmail() { return alternativeEmail; }
    public void setAlternativeEmail(String alternativeEmail) { this.alternativeEmail = alternativeEmail; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public String getReligion() { return religion; }
    public void setReligion(String religion) { this.religion = religion; }

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
