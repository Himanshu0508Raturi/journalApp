// Business logic for journalEntity controller.
package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalEntityService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;


    @Transactional // works only with mongodb atlas due to db replica issue with local db.
    public void saveEntry(JournalEntry obj, String userName) {
        try {

            User user = userService.findByUserName(userName);
            obj.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(obj);
            user.getJournalEntry().add(saved);
            userService.saveUser(user);
        } catch (Exception e) {
            System.out.println(e);
            throw new RuntimeException("Error occurred while saving the entry " + e);
        }
    }

    public void saveEntry(JournalEntry obj) {

        journalEntryRepository.save(obj);
    }

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }
    @Transactional
    public boolean deleteById(ObjectId id, String userName) {
        boolean removed = false;
        try {

            User user = userService.findByUserName(userName);
            removed = user.getJournalEntry().removeIf(x -> x.getId().equals(id)); //lambda expression
            if (removed) {
                userService.saveUser(user);
                journalEntryRepository.deleteById(id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while saving the entry");
        }
        return removed;
    }
}

