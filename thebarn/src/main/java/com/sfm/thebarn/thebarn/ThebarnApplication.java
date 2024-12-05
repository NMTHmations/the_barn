package com.sfm.thebarn.thebarn;

import com.sfm.thebarn.thebarn.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.Date;
import java.time.LocalDate;

@SpringBootApplication
public class ThebarnApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ThebarnApplication.class, args);
		/*Just a simple test for Future Implementations*/
		//Farms farm = new Farms("9821398","Csonkas Tanya",3893,"Mogyoroska","Csonkas Tanya utca",1);
		Farms farm = Farms.builder()
				.id("9821398")
				.FarmName("Csonkas Tanya")
				.ZIPCode(3893)
				.Settlement("Mogyoroska")
				.Street("Csonkas Tanya utca")
				.StreetNumber(1)
				.build();

		/*Temp breed, type & animals for debugging reasons*/
		BreedCodes breed = BreedCodes.builder()
				.id(1)
				.name("breed1")
				.build();
		TypeCodes type = TypeCodes.builder()
				.id(1)
				.name("type1")
				.build();

		/*Some dummy animals for debugging reasons*/
		Animals animal = Animals.builder()
				.id("100")
				.sex(false)
				.farmid(farm)
				.breed(breed)
				.type(type)
				.BirthDate(Date.valueOf(LocalDate.now()))
				.PrevId("99")
				.DeathDate(Date.valueOf(LocalDate.now()))
				.build();
		Animals animal2 = Animals.builder()
				.id("101")
				.sex(true)
				.farmid(farm)
				.breed(breed)
				.type(type)
				.BirthDate(Date.valueOf(LocalDate.now()))
				.PrevId("100")
				.DeathDate(Date.valueOf(LocalDate.now()))
				.build();
		Animals animal3 = Animals.builder()
				.id("102")
				.sex(true)
				.farmid(farm)
				.breed(breed)
				.type(type)
				.BirthDate(Date.valueOf(LocalDate.now()))
				.PrevId("101")
				.DeathDate(Date.valueOf(LocalDate.now()))
				.build();
		AnimalsCRUD animalrepo = configurableApplicationContext.getBean(AnimalsCRUD.class);
		Users user = new Users("CSINEQ","KIRALY",farm);
		FarmsCRUD repo = configurableApplicationContext.getBean(FarmsCRUD.class);
		UsersCRUD userrepo = configurableApplicationContext.getBean(UsersCRUD.class);

		repo.save(farm);
		userrepo.save(user);

		animalrepo.save(animal);
		animalrepo.save(animal2);
		animalrepo.save(animal3);




	}
}
