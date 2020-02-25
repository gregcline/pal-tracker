package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {
    private long timeEntryId;
    private  long projectId;
    private  long userId;
    private  LocalDate date;
    private  int hours;

    public TimeEntry(long projectId, long userId, LocalDate date, int i) {
        this.timeEntryId = 0;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = i;
    }

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate date, int i) {
        this.timeEntryId = timeEntryId;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = i;
    }

    public TimeEntry() {
        this.timeEntryId = 0;
        this.projectId = 111L;
        this.userId = 111L;
        this.date = LocalDate.parse("2017-01-08");
        this.hours = 0;
    }

    public long getId() {
        return this.timeEntryId;
    }

    public void setId(long ID) {
        this.timeEntryId = ID;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return timeEntryId == timeEntry.timeEntryId &&
                projectId == timeEntry.projectId &&
                userId == timeEntry.userId &&
                hours == timeEntry.hours &&
                Objects.equals(date, timeEntry.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeEntryId, projectId, userId, date, hours);
    }


    @Override
    public String toString() {
        return "TimeEntry{" +
                "id=" + timeEntryId +
                ", projectId=" + projectId +
                ", userId=" + userId +
                ", date='" + date + '\'' +
                ", hours=" + hours +
                '}';
    }

}
