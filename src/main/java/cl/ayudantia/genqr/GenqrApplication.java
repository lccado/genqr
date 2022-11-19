package cl.ayudantia.genqr;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

@SpringBootApplication
public class GenqrApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(GenqrApplication.class, args);
		File file = QRCode.from("www.google.com").to(ImageType.PNG)
        .withSize(200, 200)
        .file();
 
		String fileName = "c:\\qrgen-qrcode.png";
		
		Path path = Paths.get(fileName);
		if ( Files.exists(path)) {
			Files.delete(path);
		}
		
		Files.copy(file.toPath(), path);
	}
}
