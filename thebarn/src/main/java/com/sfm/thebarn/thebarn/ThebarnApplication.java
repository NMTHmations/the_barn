package com.sfm.thebarn.thebarn;

import com.sfm.thebarn.thebarn.model.*;
import com.sfm.thebarn.thebarn.controller.PassEncry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ThebarnApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ThebarnApplication.class, args);
		/*Just a simple test for Future Implementations*/
		Farms farm = new Farms("9821398","Csonkas Tanya",3893,"Mogyoroska","Csonkas Tanya utca",1);
		Users user = new Users("CSINEQ","KIRALY",farm);
		FarmsCRUD repo = configurableApplicationContext.getBean(FarmsCRUD.class);
		UsersCRUD userrepo = configurableApplicationContext.getBean(UsersCRUD.class);
		repo.save(farm);
		userrepo.save(user);
	}

}
