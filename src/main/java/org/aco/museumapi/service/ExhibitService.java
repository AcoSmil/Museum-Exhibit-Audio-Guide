package org.aco.museumapi.service;

import org.aco.museumapi.model.Exhibit;
import org.aco.museumapi.repository.ExhibitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExhibitService {

    private final ExhibitRepository exhibitRepository;

    public ExhibitService(ExhibitRepository exhibitRepository) {
        this.exhibitRepository = exhibitRepository;
    }

    public List<Exhibit> getAllExhibits() {
        return exhibitRepository.findAll();
    }

    public Optional<Exhibit> getExhibitById(String exhibitId) {
        return exhibitRepository.findById(exhibitId);
    }

    public Exhibit createExhibit(Exhibit exhibit) {
        return exhibitRepository.save(exhibit);
    }

    public Exhibit updateExhibit(String exhibitId, Exhibit updated) {
        if (exhibitRepository.existsById(exhibitId)) {
            updated.setExhibitId(exhibitId);
            return exhibitRepository.save(updated);
        }
        return null;
    }

    public void deleteExhibit(String exhibitId) {
        exhibitRepository.deleteById(exhibitId);
    }
}
