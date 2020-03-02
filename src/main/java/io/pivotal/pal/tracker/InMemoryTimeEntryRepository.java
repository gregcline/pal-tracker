package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private Long nextId = 1L;
    private ConcurrentMap<Long, TimeEntry> mapRepo;

    public InMemoryTimeEntryRepository() {
        mapRepo = new ConcurrentHashMap<Long, TimeEntry>();
    }

    public TimeEntry create(TimeEntry entry) {
        TimeEntry newEntry = new TimeEntry(
                nextId,
                entry.getProjectId(),
                entry.getUserId(),
                entry.getDate(),
                entry.getHours()
            );

        mapRepo.put(nextId, newEntry);
        nextId++;

        return newEntry;
    }

    public TimeEntry find(Long id) {
        return mapRepo.get(id);
    }

    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(mapRepo.values());
    }

    public TimeEntry update(Long id, TimeEntry newEntry) {
        if(!mapRepo.containsKey(id)) {
            return null;
        }

        TimeEntry updatedEntry = new TimeEntry(
                id,
                newEntry.getProjectId(),
                newEntry.getUserId(),
                newEntry.getDate(),
                newEntry.getHours()
            );

        mapRepo.put(id, updatedEntry);

        return updatedEntry;
    }

    public void delete(Long id) {
        mapRepo.remove(id);
    }
}
