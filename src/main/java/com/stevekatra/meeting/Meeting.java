package com.stevekatra.meeting;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

@ApiModel(description = "Meeting domain object")
public class Meeting {

    @ApiModelProperty(notes = "Database auto generated id")
    private long id;
    @ApiModelProperty(notes = "Name of the meeting")
    private String name;
    @ApiModelProperty(notes = "Purpose of the meeting")
    private String purpose;

    public Meeting() {
    }

    public Meeting(String name, String purpose) {
        this.name = name;
        this.purpose = purpose;
    }

    public Meeting(long id, String name, String purpose) {
        this.id = id;
        this.name = name;
        this.purpose = purpose;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meeting meeting = (Meeting) o;
        return id == meeting.id &&
                Objects.equals(name, meeting.name) &&
                Objects.equals(purpose, meeting.purpose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, purpose);
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", purpose='" + purpose + '\'' +
                '}';
    }
}
