package io.pivotal.pal.tracker;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Repository
public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    private HashMap <Long,TimeEntry> hashRepo;
    private long latestTimeEntryID;

    public InMemoryTimeEntryRepository(){

        latestTimeEntryID = 1;
        this.hashRepo = new HashMap();
    }


    @Override
    public TimeEntry create(TimeEntry timeEntry) {

        timeEntry.setId(latestTimeEntryID);
        hashRepo.put(latestTimeEntryID,timeEntry);
        this.latestTimeEntryID++;
        return timeEntry;

    }

    @Override
    public TimeEntry find(long timeEntryId) {

        return hashRepo.get(timeEntryId);
    }


    @Override
    public List<TimeEntry> list() {

        return new ArrayList<TimeEntry>(hashRepo.values());

    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {

        if(hashRepo.containsKey(id)) {
            timeEntry.setId(id);
            hashRepo.put(id, timeEntry);
            return timeEntry;
        }
        return null;
    }

    @Override
    public void delete(long id) {
        hashRepo.remove(id);
    }
}
