package com.example.demo.services;

import com.example.demo.entity.Emprunt;
import com.example.demo.repository.EmpruntRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpruntServices {

    @Autowired
    private EmpruntRepository empruntRepository;

    public Emprunt createEmprunt(Emprunt emprunt) {
        return empruntRepository.save(emprunt);
    }

    public List<Emprunt> createEmpruntList(List<Emprunt> list) {
        return empruntRepository.saveAll(list);
    }

    public List<Emprunt> getEmpruntList() {
        return empruntRepository.findAll();
    }

    public Emprunt getEmpruntById(int id) {
        return empruntRepository.findById(id).orElse(null);
    }

    public Emprunt updateEmpruntById(Emprunt emprunt) {
        Optional<Emprunt> empruntFound = empruntRepository.findById(emprunt.getId());

        if (empruntFound.isPresent()) {
            Emprunt empruntUpdate = empruntFound.get();
            empruntUpdate.setType(emprunt.getType());
            empruntUpdate.setCinadherent(emprunt.getCinadherent());
            empruntUpdate.setDocumentid(emprunt.getDocumentid());
            empruntUpdate.setDateemprunt(emprunt.getDateemprunt());
            empruntUpdate.setDateretour(emprunt.getDateretour());

            return empruntRepository.save(emprunt);
        } else {
            return null;
        }
    }

    public String deleteEmpruntById(int id) {
        empruntRepository.deleteById(id);
        return "Emprunt "+ id +" deleted";
    }
}
