import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import java.util.*;
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
public class ReadPdf
{
	public static void main(String args[]) throws IOException 
	{
		try
		{
			PDDocument document = PDDocument.load(new File("Pdf1.pdf"));
			document.getClass();
			BufferedWriter writer =
              new BufferedWriter(new FileWriter("./FinalFile.txt"));
			if (!document.isEncrypted())
			{
				PDFTextStripperByArea stripper = new PDFTextStripperByArea();
				stripper.setSortByPosition(true);
				PDFTextStripper Tstripper = new PDFTextStripper();
				String str = Tstripper.getText(document);
				Scanner scn = null;					
				scn = new Scanner(str);
				String line="";
				
				while (scn.hasNextLine()) 
				{		
					line = scn.nextLine();
					System.out.println("\n"+line);
					
            writer.write("\n"+line);
		
				}	
			}
			  writer.close();
			document.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
			
	}
}