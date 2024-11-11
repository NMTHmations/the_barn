package com.sfm.thebarn.thebarn;

import com.sfm.thebarn.thebarn.model.Farms;
import com.sfm.thebarn.thebarn.model.FarmsCRUD;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ThebarnApplication {

	public static void main(String[] args) {

		//SpringApplication.run(ThebarnApplication.class, args);
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ThebarnApplication.class, args);
		/*Just a simple test for Future Implementations*/
		Farms farm = new Farms("9821398","Csonkas Tanya",3893,"Mogyoroska","Csonkas Tanya utca",1);
		FarmsCRUD repo = configurableApplicationContext.getBean(FarmsCRUD.class);
		repo.save(farm);
	}

}
