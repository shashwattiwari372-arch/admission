package com.example.employeecrud.tables.base;

import java.time.LocalDate;
import java.time.LocalTime;

/** Common shape of every generated table entity so one controller class can serve all of them. */
public interface TableEntity<ID> {

    ID getId();

    void setId(ID id);

    /** Fills updateBy / updateDt / updateTime. Entities that have those columns override this. */
    default void stamp(String by, LocalDate date, LocalTime time) {
    }
}
