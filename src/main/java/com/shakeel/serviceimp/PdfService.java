package com.shakeel.serviceimp;

import org.springframework.stereotype.Service;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class PdfService {

    private static final String FILE_DIRECTORY = "uploads/";

    public File createRankListPDF() throws IOException {
        File directory = new File(FILE_DIRECTORY);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File file = new File(directory, "rank-list.pdf");

        try (FileOutputStream fos = new FileOutputStream(file)) {
            Document document = new Document();
            PdfWriter.getInstance(document, fos);
            document.open();
            document.add(new Paragraph("Rank List"));
            // Add content to the PDF here
            document.close();
        } catch (DocumentException e) {
            throw new IOException("Error creating PDF", e);
        }

        return file;
    }
}
