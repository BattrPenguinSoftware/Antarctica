import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;

class QRTest {
	
	public static void main (String[] args){
		
		QRTest test = new QRTest();
		String result = test.decode(new File("/home/reagan/Documents/School/Software Dev QA/QRTestImage.png"));
		System.out.println(result);
	}

	public String decode(File imageFile) {
         BufferedImage image;
         
         try {
        	 image = ImageIO.read(imageFile);
         } catch (IOException e1) {
        	 return "io outch";
         }

         // creating luminance source
         LuminanceSource lumSource = new BufferedImageLuminanceSource(image);
         BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(lumSource));

         // barcode decoding
         QRCodeReader reader = new QRCodeReader();

         Result result = null;
         try {
        	 result = reader.decode(bitmap);
         } catch (ReaderException e) {
        	 return "reader error";
         }

         return result.getText();
	}
}