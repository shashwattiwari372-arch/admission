package com.example.employeecrud.tables.entity;

import com.example.employeecrud.tables.base.TableEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

/** Maps table `candidate_quali`. */
@Entity
@Table(name = "candidate_quali")
public class CandidateQuali implements TableEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "appId")
    private Integer appId;

    @Size(max = 255, message = "Degree name can be at most 255 characters")
    @Column(name = "degreeName", length = 255)
    private String degreeName;

    @Size(max = 255, message = "Institute name can be at most 255 characters")
    @Column(name = "instituteName", length = 255)
    private String instituteName;

    @Size(max = 255, message = "Board university can be at most 255 characters")
    @Column(name = "boardUniversity", length = 255)
    private String boardUniversity;

    @Column(name = "yearOfPassing", columnDefinition = "year")
    private Integer yearOfPassing;

    @Column(name = "fromDay", columnDefinition = "tinyint")
    private Integer fromDay;

    @Column(name = "fromMonth", columnDefinition = "tinyint")
    private Integer fromMonth;

    @Column(name = "fromYear", columnDefinition = "year")
    private Integer fromYear;

    @Column(name = "toDay", columnDefinition = "tinyint")
    private Integer toDay;

    @Column(name = "toMonth", columnDefinition = "tinyint")
    private Integer toMonth;

    @Column(name = "toYear", columnDefinition = "year")
    private Integer toYear;

    @Size(max = 50, message = "Enrollment no can be at most 50 characters")
    @Column(name = "enrollmentNo", length = 50)
    private String enrollmentNo;

    @Column(name = "obtainedMarks", precision = 6, scale = 2)
    private BigDecimal obtainedMarks;

    @Size(max = 45, message = "Total marks can be at most 45 characters")
    @Column(name = "totalMarks", length = 45)
    private String totalMarks;

    @Column(name = "percentage", precision = 5, scale = 2)
    private BigDecimal percentage;

    @Size(max = 100, message = "Subject branch can be at most 100 characters")
    @Column(name = "subjectBranch", length = 100)
    private String subjectBranch;

    @Column(name = "cgpa", precision = 4, scale = 2)
    private BigDecimal cgpa;

    @Size(max = 10, message = "Grade can be at most 10 characters")
    @Column(name = "grade", length = 10)
    private String grade;

    @Size(max = 50, message = "Division can be at most 50 characters")
    @Column(name = "division", length = 50)
    private String division;

    @Size(max = 255, message = "Specialization can be at most 255 characters")
    @Column(name = "specialization", length = 255)
    private String specialization;

    @Size(max = 255, message = "Institute website can be at most 255 characters")
    @Column(name = "instituteWebsite", length = 255)
    private String instituteWebsite;

    @Size(max = 100, message = "Institute email can be at most 100 characters")
    @Column(name = "instituteEmail", length = 100)
    private String instituteEmail;

    @Size(max = 100, message = "Update by can be at most 100 characters")
    @Column(name = "updateBy", length = 100)
    private String updateBy;

    @Column(name = "updateDt")
    private LocalDate updateDt;

    @Column(name = "updateTime")
    private LocalTime updateTime;

    @Size(max = 45, message = "Remark can be at most 45 characters")
    @Column(name = "remark", length = 45)
    private String remark;

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

    public String getDegreeName() { return degreeName; }
    public void setDegreeName(String degreeName) { this.degreeName = degreeName; }

    public String getInstituteName() { return instituteName; }
    public void setInstituteName(String instituteName) { this.instituteName = instituteName; }

    public String getBoardUniversity() { return boardUniversity; }
    public void setBoardUniversity(String boardUniversity) { this.boardUniversity = boardUniversity; }

    public Integer getYearOfPassing() { return yearOfPassing; }
    public void setYearOfPassing(Integer yearOfPassing) { this.yearOfPassing = yearOfPassing; }

    public Integer getFromDay() { return fromDay; }
    public void setFromDay(Integer fromDay) { this.fromDay = fromDay; }

    public Integer getFromMonth() { return fromMonth; }
    public void setFromMonth(Integer fromMonth) { this.fromMonth = fromMonth; }

    public Integer getFromYear() { return fromYear; }
    public void setFromYear(Integer fromYear) { this.fromYear = fromYear; }

    public Integer getToDay() { return toDay; }
    public void setToDay(Integer toDay) { this.toDay = toDay; }

    public Integer getToMonth() { return toMonth; }
    public void setToMonth(Integer toMonth) { this.toMonth = toMonth; }

    public Integer getToYear() { return toYear; }
    public void setToYear(Integer toYear) { this.toYear = toYear; }

    public String getEnrollmentNo() { return enrollmentNo; }
    public void setEnrollmentNo(String enrollmentNo) { this.enrollmentNo = enrollmentNo; }

    public BigDecimal getObtainedMarks() { return obtainedMarks; }
    public void setObtainedMarks(BigDecimal obtainedMarks) { this.obtainedMarks = obtainedMarks; }

    public String getTotalMarks() { return totalMarks; }
    public void setTotalMarks(String totalMarks) { this.totalMarks = totalMarks; }

    public BigDecimal getPercentage() { return percentage; }
    public void setPercentage(BigDecimal percentage) { this.percentage = percentage; }

    public String getSubjectBranch() { return subjectBranch; }
    public void setSubjectBranch(String subjectBranch) { this.subjectBranch = subjectBranch; }

    public BigDecimal getCgpa() { return cgpa; }
    public void setCgpa(BigDecimal cgpa) { this.cgpa = cgpa; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public String getDivision() { return division; }
    public void setDivision(String division) { this.division = division; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getInstituteWebsite() { return instituteWebsite; }
    public void setInstituteWebsite(String instituteWebsite) { this.instituteWebsite = instituteWebsite; }

    public String getInstituteEmail() { return instituteEmail; }
    public void setInstituteEmail(String instituteEmail) { this.instituteEmail = instituteEmail; }

    public String getUpdateBy() { return updateBy; }
    public void setUpdateBy(String updateBy) { this.updateBy = updateBy; }

    public LocalDate getUpdateDt() { return updateDt; }
    public void setUpdateDt(LocalDate updateDt) { this.updateDt = updateDt; }

    public LocalTime getUpdateTime() { return updateTime; }
    public void setUpdateTime(LocalTime updateTime) { this.updateTime = updateTime; }

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
