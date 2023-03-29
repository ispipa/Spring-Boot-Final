package com.example.proyectofinalback.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Task")
    private Long id_Task;

    @Column(name = "title",nullable = false, length = 20)
    private String title;

    @Column(name = "description",nullable = false, length = 100)
    private String description;

    @Column(name="expiration_date")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "Europe/Madrid")
    private Date expiration_date;

    @Column(name="state",nullable = false)
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_User" ,referencedColumnName = "id_User")
    @JsonIgnoreProperties("tasks")
    private User user;

    public Task() {
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
