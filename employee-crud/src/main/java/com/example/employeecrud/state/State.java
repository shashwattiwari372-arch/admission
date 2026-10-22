package com.example.employeecrud.state;

import jakarta.persistence.*;

@Entity
@Table(name = "states")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 10)
    private String code;

    @Column(name = "value", nullable = false, length = 100)
    private String value;

    public State() {}
    public State(String code, String value) { this.code = code; this.value = value; }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}
