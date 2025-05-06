package org.manager.model;

import java.sql.Date;

public class Task {
    public Integer id;
    public String description;
    public Date date;

    public Task() {
    }

    public Task(String description, Date date) {
        this.description = description;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
