package com.pdf.failed;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontStyle;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDestination;
import com.itextpdf.text.pdf.PdfOutline;
import com.itextpdf.text.pdf.PdfWriter;

 
public class Bookmarks1PDF{
  public static void main(String[] args) {
    Document document = new Document(PageSize.A6);
    try {
      PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Bookmarks1PDF.pdf"));
      writer.setViewerPreferences(PdfWriter.PageModeUseOutlines);
      document.open();
            
      document.add(new Paragraph("Text.", new Font()));
      PdfContentByte cb = writer.getDirectContent();
      PdfDestination destination = new PdfDestination(PdfDestination.FITH, 0);
      PdfOutline outline = new PdfOutline(cb.getRootOutline(), destination, "paragraph " + 1);
      
      document.add(new Paragraph("Text.", new Font()));
      document.add(new Paragraph("Text.", new Font()));
      
      cb = writer.getDirectContent();
      destination = new PdfDestination(PdfDestination.FITH, 1);
      outline = new PdfOutline(cb.getRootOutline(), destination, "paragraph " + 2);
      
      document.add(new Paragraph("Text.", new Font()));
    } catch (Exception de) {
      de.printStackTrace();
    }
    document.close();
  }
}
           
       