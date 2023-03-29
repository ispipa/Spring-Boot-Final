package com.example.proyectofinalback.payload.request;

import com.example.proyectofinalback.entities.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

public class TaskRequest {

    @NotBlank
    private Long id_Task;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private Date expiration_date;

    @NotBlank
    private Boolean state;

    private Long id_User;

    public Long getId_Task() {
        return id_Task;
    }

    public void setId_Task(Long id_Task) {
        this.id_Task = id_Task;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Long getId_User() {
        return id_User;
    }

    public void setId_User(Long id_User) {
        this.id_User = id_User;
    }
}
