package com.zendesk.ticketviewer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

// Model for mapping output of API to a ticket
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket {

    private Long id;
    private String subject;
    private String type;
    private String description;
    @JsonProperty("requester_id")
    private Long requesterId;
    private ArrayList<String> tags;
    @JsonProperty("updated_at")
    private String updatedAt;

    public Long getId() {
        if(this.id == null)
            return (long)0;
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        if(this.subject == null)
            return "";
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        if(this.type == null)
            return "";
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        if(this.description == null)
            return "";
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getRequesterId() {
        if(this.requesterId == null)
            return (long)0;
        return requesterId;
    }

    public void setRequesterId(Long requesterId) {
        this.requesterId = requesterId;
    }

    public ArrayList<String> getTags() {
        if(this.tags == null)
            return new ArrayList<>();
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getUpdatedAt() {
        if(this.updatedAt == null)
            return "";
        return updatedAt;
    }

    public void setUpdated_at(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}