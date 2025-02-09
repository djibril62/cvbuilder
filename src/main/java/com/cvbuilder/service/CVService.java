package com.cvbuilder.service;

import com.cvbuilder.model.CV;
import com.cvbuilder.repository.CVRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CVService {

    private final CVRepository cvRepository;

    public CV creerCV(CV cv) {
        return cvRepository.save(cv);
    }

    public List<CV> obtenirTousLesCV() {
        return cvRepository.findAll();
    }

    public CV obtenirCVParId(String id) {
        return cvRepository.findById(id).orElse(null);
    }
}
