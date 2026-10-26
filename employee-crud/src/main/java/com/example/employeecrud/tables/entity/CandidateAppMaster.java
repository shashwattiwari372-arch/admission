package com.example.employeecrud.tables.entity;

import com.example.employeecrud.tables.base.TableEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

/** Maps table `candidate_app_master`. */
@Entity
@Table(name = "candidate_app_master")
public class CandidateAppMaster implements TableEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "appId")
    private Integer appId;

    @Size(max = 80, message = "Candidate ID can be at most 80 characters")
    @Column(name = "candidateId", length = 80)
    private String candidateId;

    @Size(max = 80, message = "Post code can be at most 80 characters")
    @Column(name = "postCode", length = 80)
    private String postCode;

    @Size(max = 80, message = "Payment status can be at most 80 characters")
    @Column(name = "payStatus", length = 80)
    private String payStatus;

    @Column(name = "payId")
    private Integer payId;

    @Size(max = 20, message = "Submit status can be at most 20 characters")
    @Column(name = "submitStatus", length = 20)
    private String submitStatus;

    @Column(name = "submitDt")
    private LocalDate submitDt;

    @Size(max = 50, message = "Submit time can be at most 50 characters")
    @Column(name = "submitTime", length = 50)
    private String submitTime;

    @Size(max = 20, message = "Final status can be at most 20 characters")
    @Column(name = "finalStatus", length = 20)
    private String finalStatus;

    @Column(name = "profileId")
    private Integer profileId;

    @Size(max = 6, message = "Title can be at most 6 characters")
    @Column(name = "title", length = 6)
    private String title;

    @Size(max = 100, message = "Full name can be at most 100 characters")
    @Column(name = "fullName", length = 100)
    private String fullName;

    @Size(max = 80, message = "Email can be at most 80 characters")
    @Column(name = "email", length = 80)
    private String email;

    @Size(max = 20, message = "Mobile no can be at most 20 characters")
    @Column(name = "mobileNo", length = 20)
    private String mobileNo;

    @Size(max = 45, message = "Father husband name can be at most 45 characters")
    @Column(name = "fatherHusbandName", length = 45)
    private String fatherHusbandName;

    @Size(max = 120, message = "Organisation name can be at most 120 characters")
    @Column(name = "orgName", length = 120)
    private String orgName;

    @Size(max = 45, message = "Designation can be at most 45 characters")
    @Column(name = "designation", length = 45)
    private String designation;

    @Size(max = 45, message = "City can be at most 45 characters")
    @Column(name = "city", length = 45)
    private String city;

    @Size(max = 45, message = "District can be at most 45 characters")
    @Column(name = "distt", length = 45)
    private String distt;

    @Size(max = 45, message = "State can be at most 45 characters")
    @Column(name = "state", length = 45)
    private String state;

    @Size(max = 20, message = "Organisation phone can be at most 20 characters")
    @Column(name = "orgPhone", length = 20)
    private String orgPhone;

    @Size(max = 80, message = "Organisation email can be at most 80 characters")
    @Column(name = "orgEmail", length = 80)
    private String orgEmail;

    @Size(max = 100, message = "Organisation website can be at most 100 characters")
    @Column(name = "orgWebsite", length = 100)
    private String orgWebsite;

    @Size(max = 10, message = "Physically challenged can be at most 10 characters")
    @Column(name = "physicallyChallenged", length = 10)
    private String physicallyChallenged;

    @Size(max = 20, message = "Aadhaar no can be at most 20 characters")
    @Column(name = "aadhaarNo", length = 20)
    private String aadhaarNo;

    @Size(max = 10, message = "Gender can be at most 10 characters")
    @Column(name = "gender", length = 10)
    private String gender;

    @Size(max = 30, message = "Category can be at most 30 characters")
    @Column(name = "category", length = 30)
    private String category;

    @Size(max = 300, message = "Local address can be at most 300 characters")
    @Column(name = "localAddress", length = 300)
    private String localAddress;

    @Size(max = 300, message = "Permanent address can be at most 300 characters")
    @Column(name = "permanentAddress", length = 300)
    private String permanentAddress;

    @Column(name = "dob")
    private LocalDate dob;

    @Size(max = 10, message = "Marital status can be at most 10 characters")
    @Column(name = "maritalStatus", length = 10)
    private String maritalStatus;

    @Size(max = 200, message = "Remark can be at most 200 characters")
    @Column(name = "remark", length = 200)
    private String remark;

    @Size(max = 100, message = "Update by can be at most 100 characters")
    @Column(name = "updateBy", length = 100)
    private String updateBy;

    @Column(name = "updateDt")
    private LocalDate updateDt;

    @Size(max = 45, message = "Update time can be at most 45 characters")
    @Column(name = "updateTime", length = 45)
    private String updateTime;

    @Size(max = 80, message = "Alternative email can be at most 80 characters")
    @Column(name = "alternativeEmail", length = 80)
    private String alternativeEmail;

    @Size(max = 10, message = "Claim age relax can be at most 10 characters")
    @Column(name = "claimAgeRelax", length = 10)
    private String claimAgeRelax;

    @Size(max = 45, message = "Nationality can be at most 45 characters")
    @Column(name = "nationality", length = 45)
    private String nationality;

    @Size(max = 45, message = "Religion can be at most 45 characters")
    @Column(name = "religion", length = 45)
    private String religion;

    @Size(max = 10, message = "EWS can be at most 10 characters")
    @Column(name = "ews", length = 10)
    private String ews;

    @Size(max = 10, message = "Ex serviceman can be at most 10 characters")
    @Column(name = "exServiceman", length = 10)
    private String exServiceman;

    @Size(max = 10, message = "Sportsman can be at most 10 characters")
    @Column(name = "sportsman", length = 10)
    private String sportsman;

    @Size(max = 250, message = "Achievement can be at most 250 characters")
    @Column(name = "achievement", length = 250)
    private String achievement;

    @Size(max = 45, message = "Present pay level can be at most 45 characters")
    @Column(name = "presentPayLevel", length = 45)
    private String presentPayLevel;

    @Size(max = 45, message = "Expected pay can be at most 45 characters")
    @Column(name = "expectedPay", length = 45)
    private String expectedPay;

    @Size(max = 10, message = "Consent RTI can be at most 10 characters")
    @Column(name = "consentRti", length = 10)
    private String consentRti;

    @Size(max = 70, message = "Name referee1 can be at most 70 characters")
    @Column(name = "nameReferee1", length = 70)
    private String nameReferee1;

    @Size(max = 150, message = "Address referee1 can be at most 150 characters")
    @Column(name = "addressReferee1", length = 150)
    private String addressReferee1;

    @Size(max = 70, message = "Name referee2 can be at most 70 characters")
    @Column(name = "nameReferee2", length = 70)
    private String nameReferee2;

    @Size(max = 150, message = "Address referee2 can be at most 150 characters")
    @Column(name = "addressReferee2", length = 150)
    private String addressReferee2;

    @Size(max = 10, message = "Criminal case can be at most 10 characters")
    @Column(name = "criminalCase", length = 10)
    private String criminalCase;

    @Size(max = 300, message = "Justify post can be at most 300 characters")
    @Column(name = "justifyPost", length = 300)
    private String justifyPost;

    @Size(max = 145, message = "Challan no can be at most 145 characters")
    @Column(name = "challanNo", length = 145)
    private String challanNo;

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

    public Integer getAppId() { return appId; }
    public void setAppId(Integer appId) { this.appId = appId; }

    public String getCandidateId() { return candidateId; }
    public void setCandidateId(String candidateId) { this.candidateId = candidateId; }

    public String getPostCode() { return postCode; }
    public void setPostCode(String postCode) { this.postCode = postCode; }

    public String getPayStatus() { return payStatus; }
    public void setPayStatus(String payStatus) { this.payStatus = payStatus; }

    public Integer getPayId() { return payId; }
    public void setPayId(Integer payId) { this.payId = payId; }

    public String getSubmitStatus() { return submitStatus; }
    public void setSubmitStatus(String submitStatus) { this.submitStatus = submitStatus; }

    public LocalDate getSubmitDt() { return submitDt; }
    public void setSubmitDt(LocalDate submitDt) { this.submitDt = submitDt; }

    public String getSubmitTime() { return submitTime; }
    public void setSubmitTime(String submitTime) { this.submitTime = submitTime; }

    public String getFinalStatus() { return finalStatus; }
    public void setFinalStatus(String finalStatus) { this.finalStatus = finalStatus; }

    public Integer getProfileId() { return profileId; }
    public void setProfileId(Integer profileId) { this.profileId = profileId; }

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

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

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

    public String getClaimAgeRelax() { return claimAgeRelax; }
    public void setClaimAgeRelax(String claimAgeRelax) { this.claimAgeRelax = claimAgeRelax; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public String getReligion() { return religion; }
    public void setReligion(String religion) { this.religion = religion; }

    public String getEws() { return ews; }
    public void setEws(String ews) { this.ews = ews; }

    public String getExServiceman() { return exServiceman; }
    public void setExServiceman(String exServiceman) { this.exServiceman = exServiceman; }

    public String getSportsman() { return sportsman; }
    public void setSportsman(String sportsman) { this.sportsman = sportsman; }

    public String getAchievement() { return achievement; }
    public void setAchievement(String achievement) { this.achievement = achievement; }

    public String getPresentPayLevel() { return presentPayLevel; }
    public void setPresentPayLevel(String presentPayLevel) { this.presentPayLevel = presentPayLevel; }

    public String getExpectedPay() { return expectedPay; }
    public void setExpectedPay(String expectedPay) { this.expectedPay = expectedPay; }

    public String getConsentRti() { return consentRti; }
    public void setConsentRti(String consentRti) { this.consentRti = consentRti; }

    public String getNameReferee1() { return nameReferee1; }
    public void setNameReferee1(String nameReferee1) { this.nameReferee1 = nameReferee1; }

    public String getAddressReferee1() { return addressReferee1; }
    public void setAddressReferee1(String addressReferee1) { this.addressReferee1 = addressReferee1; }

    public String getNameReferee2() { return nameReferee2; }
    public void setNameReferee2(String nameReferee2) { this.nameReferee2 = nameReferee2; }

    public String getAddressReferee2() { return addressReferee2; }
    public void setAddressReferee2(String addressReferee2) { this.addressReferee2 = addressReferee2; }

    public String getCriminalCase() { return criminalCase; }
    public void setCriminalCase(String criminalCase) { this.criminalCase = criminalCase; }

    public String getJustifyPost() { return justifyPost; }
    public void setJustifyPost(String justifyPost) { this.justifyPost = justifyPost; }

    public String getChallanNo() { return challanNo; }
    public void setChallanNo(String challanNo) { this.challanNo = challanNo; }

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
