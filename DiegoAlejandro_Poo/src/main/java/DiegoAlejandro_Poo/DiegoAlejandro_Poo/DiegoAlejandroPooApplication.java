package DiegoAlejandro_Poo.DiegoAlejandro_Poo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiegoAlejandroPooApplication {

	public static void main(String[] args) {
		//Codigo para cargar los valores del archivo .env sobre el archivo application.properties
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		dotenv.entries().forEach(entry ->
				System.setProperty(entry.getKey(), entry.getValue())
		);

		//Esta linea no se borra
		SpringApplication.run(DiegoAlejandroPooApplication.class, args);
	}

}
