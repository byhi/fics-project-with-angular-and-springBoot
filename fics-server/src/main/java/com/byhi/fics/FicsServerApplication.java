package com.byhi.fics;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.byhi.fics.domain.Modul;
import com.byhi.fics.domain.Rendszer;
import com.byhi.fics.repository.ModulRepository;
import com.byhi.fics.repository.RendszerRepository;

@SpringBootApplication
public class FicsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FicsServerApplication.class, args);
	}

	@Bean
	ApplicationRunner init(ModulRepository modulRepository, RendszerRepository rendszerRepository) {
		return args -> {
			Stream.of("A1 rednszer", "A3 rednszer", "B1 rednszer", "B2 rednszer", "C1 rednszer").forEach(name -> {
						Rendszer rendszer = new Rendszer();
						rendszer.setName(name);
						rendszer.setDesc(name + " valami leírás, infó.");
						rendszerRepository.save(rendszer);
					});
			Rendszer rendszer = rendszerRepository.findById(new Long(new Integer(1))) .orElse(new Rendszer());
			Stream.of("A1 modul", "A3 modul", "B1 modul", "B2 modul", "C1 modul").forEach(name -> {
				Modul modul = new Modul();
				modul.setName(name);
				modul.setDesc(name + " valami leírás, infó.");
				modul.setR_id(rendszer);
				modulRepository.save(modul);
			});
			rendszerRepository.findAll().forEach(System.out::println);
		};
	}
}
