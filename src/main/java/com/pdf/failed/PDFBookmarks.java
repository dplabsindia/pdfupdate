package com.pdf.failed;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDestination;
import com.itextpdf.text.pdf.PdfOutline;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter; 

public class PDFBookmarks extends PdfPageEventHelper {
	public void onParagraph(PdfWriter writer, Document document, float position) {
	    PdfContentByte cb = writer.getDirectContent();
	    new PdfOutline(cb.getRootOutline(), new PdfDestination(PdfDestination.FITH, position), "paragraph at position: " +position);
	  }

	  public static void main(String[] args) {
	    Document document = new Document(PageSize.A6);
	    try {
	      PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("BookmarksPDF.pdf"));
	      writer.setViewerPreferences(PdfWriter.PageModeUseOutlines);
	      document.open();
	      writer.setPageEvent(new PDFBookmarks());

	      document.add(new Paragraph("Text", new Font()));
	      document.newPage();
	      document.add(new Paragraph("Text Text", new Font()));
	      document.newPage();
	      document.add(new Paragraph("Text Text Text", new Font()));
	      document.newPage();
	      document.add(new Paragraph("Text Text Text Text", new Font()));
	    } catch (Exception de) {
	      de.printStackTrace();
	    }
	    document.close();
	  }
}