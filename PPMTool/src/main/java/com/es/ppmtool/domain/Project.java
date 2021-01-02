package com.es.ppmtool.domain;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Generates an ID value starting with 1.
    //@Generated Value may be applied to a primary key of an entity or a mapped superclass in conjunction with the Id annotation
    //@Id Specifies the the primary key of an entity
    private Long id ;
    @NotBlank(message="Project Name cannot be blank")
    //Validation type not blank , from javax.validation
    private String projectName ;
    @NotBlank(message = "Project Identifier is required")
    @Size(min = 4 ,max=4,message = "Please use 4 characters")
    //Validation type sets the size , min = .. , max = .. , from javax.validation
    @Column(unique = true,updatable = false)
    //Column annotation is used to specify the details of the column to which a field or property will be mapped,
    // attributes(name , length , nullable , unique)
    private String projectIdentifier ;
    @NotBlank(message = "Project Description is required")
    private String description ;
    @JsonFormat(pattern = "yyyy-mm-dd")
    //It is a Jackson annotation that is used to specify how to format fields/and or properties for JSON output.
    private Date start_date ;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date end_date ;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date created_At ;
    @JsonFormat(pattern="yyyy-mm-dd")
    private Date updated_At ;


    public Project() {
    }
    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Date getCreated_At() {
        return created_At;
    }

    public void setCreated_At(Date created_At) {
        this.created_At = created_At;
    }

    public Date getUpdated_At() {
        return updated_At;
    }

    public void setUpdated_At(Date updated_At) {
        this.updated_At = updated_At;
    }

    @PrePersist
    //Add date when entry was created
    protected void onCreate(){
        this.created_At = new Date();
    }

    @PreUpdate
    //Add date when entry was updated
    protected void onUpdate(){
        this.updated_At = new Date();
    }

}
