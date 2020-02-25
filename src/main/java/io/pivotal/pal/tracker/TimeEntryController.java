package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    // POST /timeEntries
    @PostMapping(path="/time-entries")
    public ResponseEntity create(TimeEntry timeEntryToCreate) {
        TimeEntry entry = timeEntryRepository.create(timeEntryToCreate);

        return ResponseEntity.status(HttpStatus.CREATED).body(entry);
    }

    // GET /time-entries/1
    public ResponseEntity<TimeEntry> read(long timeEntryId) {
        TimeEntry entry = timeEntryRepository.find(timeEntryId);
        if (entry == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(timeEntryRepository.find(timeEntryId));
    }

    // GET /time-entries
    public ResponseEntity<List<TimeEntry>> list() {
        return ResponseEntity.ok(timeEntryRepository.list());
    }

    // PATCH /time-entries/1
    public ResponseEntity update(long timeEntryId, TimeEntry expected) {
        TimeEntry entry = timeEntryRepository.update(timeEntryId, expected);

        if (entry == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(entry);
    }

    // DELETE /time-entries/1
    public ResponseEntity delete(long timeEntryId) {
        timeEntryRepository.delete(timeEntryId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
