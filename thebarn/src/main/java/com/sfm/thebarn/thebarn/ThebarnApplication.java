package com.sfm.thebarn.thebarn;

import com.sfm.thebarn.thebarn.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

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
		Users user = new Users("CSINEQ","KIRALY",farm);
		FarmsCRUD repo = configurableApplicationContext.getBean(FarmsCRUD.class);
		UsersCRUD userrepo = configurableApplicationContext.getBean(UsersCRUD.class);
		repo.save(farm);
		userrepo.save(user);
	}
}
