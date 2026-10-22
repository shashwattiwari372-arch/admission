package com.example.employeecrud.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** Field names match core/models/employee.model.ts. */
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Full name is required")
    @Size(max = 100, message = "Full name is too long (max 100)")
    @Column(nullable = false, length = 100)
    private String fullName;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email address")
    @Size(max = 150)
    @Column(nullable = false, unique = true, length = 150)
    private String email;

    /** BCrypt hash. Accepted from the client, never sent back. */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(length = 100)
    private String password;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be between 18 and 70")
    @Max(value = 70, message = "Age must be between 18 and 70")
    private Integer age;

    @NotBlank(message = "Gender is required")
    @Size(max = 20)
    @Column(length = 20)
    private String gender;

    @NotBlank(message = "Department is required")
    @Size(max = 100)
    @Column(length = 100)
    private String department;

    @Convert(converter = SkillsConverter.class)
    @Column(length = 1000)
    private List<String> skills = new ArrayList<>();

    @NotBlank(message = "Employment type is required")
    @Size(max = 50)
    @Column(length = 50)
    private String employmentType;

    private Boolean active = true;

    @NotNull(message = "Joining date is required")
    private LocalDate joiningDate;

    @Size(max = 500)
    @Column(length = 500)
    private String address;

    @Column(length = 255)
    private String profileImage;

    @Column(length = 255)
    private String resume;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public List<String> getSkills() { return skills; }
    public void setSkills(List<String> skills) { this.skills = skills != null ? skills : new ArrayList<>(); }
    public String getEmploymentType() { return employmentType; }
    public void setEmploymentType(String employmentType) { this.employmentType = employmentType; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active != null ? active : Boolean.TRUE; }
    public LocalDate getJoiningDate() { return joiningDate; }
    public void setJoiningDate(LocalDate joiningDate) { this.joiningDate = joiningDate; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public String getProfileImage() { return profileImage; }
    public void setProfileImage(String profileImage) { this.profileImage = profileImage; }
    public String getResume() { return resume; }
    public void setResume(String resume) { this.resume = resume; }
}
