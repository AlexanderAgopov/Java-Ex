package jumpstart;

import java.io.FileNotFoundException;
import java.io.IOException;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDate;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.AreaBreakType;
import com.itextpdf.layout.property.TextAlignment;

public class Try2 {

	/**
	 * The objects of class OrderToPDF extract data from the order currently loaded
	 * in the application, create new pdf document and fill it with this data.
	 * 
	 * @author a
	 * @throws FileNotFoundException
	 *
	 */

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		PdfWriter writer = new PdfWriter("222");

		PdfDocument pdfDoc = new PdfDocument(writer);
		Document document = new Document(pdfDoc);
		//document.add(new Paragraph("sdsds"));
		PdfDate date = new PdfDate();
        document.showTextAligned(date.getW3CDate(), 555, 340, TextAlignment.RIGHT);
		
		document.close();
	}
}
