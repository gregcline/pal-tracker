package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    // POST /timeEntries
    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
        TimeEntry entry = timeEntryRepository.create(timeEntryToCreate);

        return ResponseEntity.status(HttpStatus.CREATED).body(entry);
    }

    // GET /time-entries/1
    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id) {
        TimeEntry entry = timeEntryRepository.find(id);
        if (entry == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(entry);
    }

    // GET /time-entries
    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        return ResponseEntity.ok(timeEntryRepository.list());
    }

    // PATCH /time-entries/1
    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody TimeEntry timeEntry) {
        TimeEntry entry = timeEntryRepository.update(id, timeEntry);

        if (entry == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(entry);
    }

    // DELETE /time-entries/1
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable long id) {
        timeEntryRepository.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
