package com.example.employeecrud.tables.entity;

import com.example.employeecrud.tables.base.TableEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

/** Maps table `candidate_entrance`. */
@Entity
@Table(name = "candidate_entrance")
public class CandidateEntrance implements TableEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "appId")
    private Integer appId;

    @Size(max = 255, message = "Exam name can be at most 255 characters")
    @Column(name = "examName", length = 255)
    private String examName;

    @Size(max = 45, message = "Year of passing can be at most 45 characters")
    @Column(name = "yearOfPassing", length = 45)
    private String yearOfPassing;

    @Size(max = 45, message = "All india rank can be at most 45 characters")
    @Column(name = "allIndiaRank", length = 45)
    private String allIndiaRank;

    @Size(max = 45, message = "Total marks can be at most 45 characters")
    @Column(name = "totalMarks", length = 45)
    private String totalMarks;

    @Size(max = 45, message = "Obtained marks can be at most 45 characters")
    @Column(name = "obtainedMarks", length = 45)
    private String obtainedMarks;

    @Size(max = 45, message = "Percentile can be at most 45 characters")
    @Column(name = "percentile", length = 45)
    private String percentile;

    @Size(max = 45, message = "Category rank can be at most 45 characters")
    @Column(name = "categoryRank", length = 45)
    private String categoryRank;

    @Size(max = 45, message = "Percentage can be at most 45 characters")
    @Column(name = "percentage", length = 45)
    private String percentage;

    @Size(max = 10, message = "Grade can be at most 10 characters")
    @Column(name = "grade", length = 10)
    private String grade;

    @Size(max = 255, message = "Board can be at most 255 characters")
    @Column(name = "board", length = 255)
    private String board;

    @Column(name = "examDate")
    private LocalDate examDate;

    @Size(max = 50, message = "Result status can be at most 50 characters")
    @Column(name = "resultStatus", length = 50)
    private String resultStatus;

    @Size(max = 100, message = "Update by can be at most 100 characters")
    @Column(name = "updateBy", length = 100)
    private String updateBy;

    @Column(name = "updateDt")
    private LocalDate updateDt;

    @Size(max = 45, message = "Update time can be at most 45 characters")
    @Column(name = "updateTime", length = 45)
    private String updateTime;

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

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getAppId() { return appId; }
    public void setAppId(Integer appId) { this.appId = appId; }

    public String getExamName() { return examName; }
    public void setExamName(String examName) { this.examName = examName; }

    public String getYearOfPassing() { return yearOfPassing; }
    public void setYearOfPassing(String yearOfPassing) { this.yearOfPassing = yearOfPassing; }

    public String getAllIndiaRank() { return allIndiaRank; }
    public void setAllIndiaRank(String allIndiaRank) { this.allIndiaRank = allIndiaRank; }

    public String getTotalMarks() { return totalMarks; }
    public void setTotalMarks(String totalMarks) { this.totalMarks = totalMarks; }

    public String getObtainedMarks() { return obtainedMarks; }
    public void setObtainedMarks(String obtainedMarks) { this.obtainedMarks = obtainedMarks; }

    public String getPercentile() { return percentile; }
    public void setPercentile(String percentile) { this.percentile = percentile; }

    public String getCategoryRank() { return categoryRank; }
    public void setCategoryRank(String categoryRank) { this.categoryRank = categoryRank; }

    public String getPercentage() { return percentage; }
    public void setPercentage(String percentage) { this.percentage = percentage; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public String getBoard() { return board; }
    public void setBoard(String board) { this.board = board; }

    public LocalDate getExamDate() { return examDate; }
    public void setExamDate(LocalDate examDate) { this.examDate = examDate; }

    public String getResultStatus() { return resultStatus; }
    public void setResultStatus(String resultStatus) { this.resultStatus = resultStatus; }

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

    @Override
    public void stamp(String by, LocalDate date, LocalTime time) {
        this.updateBy = by;
        this.updateDt = date;
        this.updateTime = time.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
