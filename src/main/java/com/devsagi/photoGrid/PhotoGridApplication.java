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
					new Polaroid(null,"Aula Roblox","Evento em que tivemos aula sobre liderança utilizando games", 
							"https://i.imgur.com/eaN87vC.jpg"),
					new Polaroid(null,"BootCamp AWS"," Sábado em que tivemos aula o dia inteiro","https://i.imgur.com/20iyRCi.jpg"),
					new Polaroid(null,"Halloween","dança das cadeiras na festa de halloween","https://i.imgur.com/44vC4pI.jpg"),
					new Polaroid(null,"Dia D","Primeiro evento presencial no caldeira","https://i.imgur.com/u1Kfohz.jpg"),
					new Polaroid(null,"Quinta de estância","Passeio de formatura","https://i.imgur.com/dMvUM6P.jpg"),
					new Polaroid(null,"Túlio Milman","Palestra Sobre Story Telling","https://i.imgur.com/zJtzfaq.jpg"),
					new Polaroid(null,"Copa","Jogo da copa na arquibancada do caldeira","https://i.imgur.com/V2VXgHf.jpg"),
					
					new Polaroid(null,"Aparecemos no jornal","Matéria sobre o NG no jornal","https://i.imgur.com/DeMgFBr.jpg")
					).flatMap(repository::save);
			
			polaroidFlux
				.thenMany(repository.findAll())
				.subscribe(System.out::println);
			
		};
		
	}
}
