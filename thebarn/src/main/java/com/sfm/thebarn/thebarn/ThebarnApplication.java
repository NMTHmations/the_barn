package com.sfm.thebarn.thebarn;

import com.sfm.thebarn.thebarn.model.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ThebarnApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ThebarnApplication.class, args);
		/*Just a simple test for Future Implementations*/
		Farms farm = new Farms("HU-12345-12345","Csonkas Tanya",3893,"Mogyoroska","Csonkas Tanya utca",1);
		Users user = new Users("admin@example.com", DigestUtils.sha256Hex("SFM2024"),farm);
		FarmsCRUD repo = configurableApplicationContext.getBean(FarmsCRUD.class);
		UsersCRUD userrepo = configurableApplicationContext.getBean(UsersCRUD.class);
		repo.save(farm);
		userrepo.save(user);
	}

}
