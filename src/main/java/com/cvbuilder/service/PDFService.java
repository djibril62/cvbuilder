package com.cvbuilder.service;

import com.cvbuilder.model.CV;
import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
@Slf4j
public class PDFService {

    public byte[] genererCVEnPDF(CV cv) throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                // Titre
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 16);
                contentStream.beginText();
                contentStream.newLineAtOffset(100, 700);
                contentStream.showText("Curriculum Vitae");
                contentStream.endText();

                // Texte normal
                contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);

                // Nom
                contentStream.beginText();
                contentStream.newLineAtOffset(100, 670);
                contentStream.showText("Nom: " + cv.getNom());
                contentStream.endText();

                // Email
                contentStream.beginText();
                contentStream.newLineAtOffset(100, 650);
                contentStream.showText("Email: " + cv.getEmail());
                contentStream.endText();

                // Téléphone
                contentStream.beginText();
                contentStream.newLineAtOffset(100, 630);
                contentStream.showText("Téléphone: " + cv.getTelephone());
                contentStream.endText();

                // Compétences
                contentStream.beginText();
                contentStream.newLineAtOffset(100, 600);
                contentStream.showText("Compétences: " + String.join(", ", cv.getCompetences()));
                contentStream.endText();

                // Expériences
                contentStream.beginText();
                contentStream.newLineAtOffset(100, 570);
                contentStream.showText("Expériences: " + String.join(", ", cv.getExperiences()));
                contentStream.endText();

                // Formations
                contentStream.beginText();
                contentStream.newLineAtOffset(100, 540);
                contentStream.showText("Formations: " + String.join(", ", cv.getFormations()));
                contentStream.endText();
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            document.save(outputStream);
            return outputStream.toByteArray();
        }
    }
}
