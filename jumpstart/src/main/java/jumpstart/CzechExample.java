package jumpstart;
 
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

 
import java.io.File;
 

public class CzechExample {
    public static final String DEST = "czech_example.pdf";
    public static final String FONT = "./src/test/resources/FreeSans.ttf";
 
    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new CzechExample().manipulatePdf(DEST);
    }
 
   
    protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(DEST));
        Document doc = new Document(pdfDoc);
        PdfFont f1 = PdfFontFactory.createFont(FONT, "Cp1250", true);
        Paragraph p1 = new Paragraph("Testing of letters \u010c,\u0106,\u0160,\u017d,\u0110").setFont(f1);
        doc.add(p1);
        PdfFont f2 = PdfFontFactory.createFont(FONT, "Identity-H", true);
        Paragraph p2 = new Paragraph("Testing of letters \u010c,\u0106,\u0160,\u017d,\u0110").setFont(f2);
        doc.add(p2);
        doc.close();
    }
}