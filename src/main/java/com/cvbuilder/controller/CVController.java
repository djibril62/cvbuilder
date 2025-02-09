package com.cvbuilder.controller;

import com.cvbuilder.model.CV;
import com.cvbuilder.service.CVService;
import com.cvbuilder.service.PDFService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/cv")
@RequiredArgsConstructor
public class CVController {

    private final CVService cvService;
    private final PDFService pdfService;

    @PostMapping("/generate")
    public ResponseEntity<CV> creerCV(@RequestBody CV cv) {
        return ResponseEntity.ok(cvService.creerCV(cv));
    }

    @GetMapping
    public ResponseEntity<List<CV>> getAllCVs() {
        return ResponseEntity.ok(cvService.obtenirTousLesCV());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CV> getCV(@PathVariable String id) {
        return ResponseEntity.ok(cvService.obtenirCVParId(id));
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<byte[]> downloadCV(@PathVariable String id) {
        CV cv = cvService.obtenirCVParId(id);

        // Vérification de l'ID dans la console
        System.out.println("Recherche du CV avec ID: " + id);
        if (cv == null) {
            System.out.println("CV introuvable !");
            return ResponseEntity.notFound().build();
        }

        try {
            byte[] pdfBytes = pdfService.genererCVEnPDF(cv);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=cv_" + cv.getNom() + ".pdf");
            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            System.out.println("Erreur lors de la génération du PDF : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
