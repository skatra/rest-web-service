package com.stevekatra.driver;

import java.util.Objects;

public class Meeting {
    private long id;
    private String name;
    private String purpose;

    public Meeting() {
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
