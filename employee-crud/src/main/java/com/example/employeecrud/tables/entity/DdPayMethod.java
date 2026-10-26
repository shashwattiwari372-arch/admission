package com.example.employeecrud.tables.entity;

import com.example.employeecrud.tables.base.TableEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

/** Maps table `dd_pay_method`. */
@Entity
@Table(name = "dd_pay_method")
public class DdPayMethod implements TableEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Size(max = 45, message = "Code can be at most 45 characters")
    @Column(name = "code", length = 45)
    private String code;

    @Size(max = 45, message = "Value can be at most 45 characters")
    @Column(name = "value", length = 45)
    private String value;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}
