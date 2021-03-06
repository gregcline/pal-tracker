package io.pivotal.pal.tracker;

import java.util.List;

import io.pivotal.pal.tracker.TimeEntry;

public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry entry);

    public TimeEntry find(Long id);

    public List<TimeEntry> list();

    public TimeEntry update(Long id, TimeEntry newEntry);

    public void delete(Long id);
}
