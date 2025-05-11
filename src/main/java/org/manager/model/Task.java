package org.manager.model;


import java.sql.Date;

public class Task {
    private Integer id;
    private String description;
    private Date startDate;
    private Date endDate;
    private boolean status;

    public Task() {
    }

    public Task(String description, Date startDate) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = null;
        this.status = false;
    }

    public Task(Integer id, String description, Date startDate, Date endDate, boolean status) {
        this.id = id;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
