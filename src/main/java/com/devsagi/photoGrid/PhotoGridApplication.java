package com.devsagi.photoGrid;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;

import com.devsagi.photoGrid.model.Polaroid;
import com.devsagi.photoGrid.repository.PolaroidRepository;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class PhotoGridApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoGridApplication.class, args);
	}
	
	@Bean//para a aplicação entender q é gerenciada pelo spring
	CommandLineRunner init (ReactiveMongoOperations operations, PolaroidRepository repository ) {
		return arg ->{
			Flux<Polaroid> polaroidFlux = Flux.just(
					new Polaroid(null,"Aula Roblox","Evento em que tivemos aula sobre liderança utilizando games", "https://i.ibb.co/VVZ3kvk/evento-mine.jpg"),
					new Polaroid(null,"BootCamp AWS"," Sábado em que tivemos aula o dia inteiro","https://i.ibb.co/wWpmnTL/evento-aws.jpg"),
					new Polaroid(null,"NG 2023","Inauguração na nova turma","https://i.ibb.co/0mqyyVD/2a3d190a-5703-4d96-8fb2-fa0c158b2682.jpg"),
					new Polaroid(null,"Dia D","Primeiro evento presencial no caldeira","https://i.ibb.co/b2xD2d7/u1Kfohz.jpg"),
					new Polaroid(null,"Quinta de estância","Passeio de formatura","https://i.ibb.co/hXYzzDw/quinta.jpg"),
					new Polaroid(null,"Túlio Milman","Palestra Sobre Story Telling","https://i.ibb.co/yNwPprd/image.png"),
					new Polaroid(null,"Copa","Jogo da copa na arquibancada do caldeira","https://i.ibb.co/KW73ZS1/66bfb767-1c83-412b-bae9-7b71d58eb31a.jpg"),
					
					new Polaroid(null,"Aparecemos no jornal","Matéria sobre o NG no jornal","https://i.ibb.co/YjWn6t4/124b280c-143a-4555-bab8-82ca3c8219b1.jpg")
					).flatMap(repository::save);
			
			polaroidFlux
				.thenMany(repository.findAll())
				.subscribe(System.out::println);
			
		};
		
	}
}
