package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;

public class TimeEntry {
    private long timeEntryId;
    private final long projectId;
    private final long userId;
    private final LocalDate parse;
    private final int i;

    public TimeEntry(long projectId, long userId, LocalDate parse, int i) {
        this.timeEntryId = 0;
        this.projectId = projectId;
        this.userId = userId;
        this.parse = parse;
        this.i = i;
    }

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate parse, int i) {
        this.timeEntryId = timeEntryId;
        this.projectId = projectId;
        this.userId = userId;
        this.parse = parse;
        this.i = i;
    }

    public TimeEntry() {
        this.timeEntryId = 0;
        this.projectId = 111L;
        this.userId = 111L;
        this.parse = LocalDate.parse("2017-01-08");
        this.i = 0;
    }

    public long getId() {
        return this.timeEntryId;
    }

    public void setId(long ID) {
        this.timeEntryId = ID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return timeEntryId == timeEntry.timeEntryId &&
                projectId == timeEntry.projectId &&
                userId == timeEntry.userId &&
                i == timeEntry.i &&
                Objects.equals(parse, timeEntry.parse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeEntryId, projectId, userId, parse, i);
    }




}
