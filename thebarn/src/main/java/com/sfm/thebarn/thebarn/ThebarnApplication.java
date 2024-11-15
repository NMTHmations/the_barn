package com.sfm.thebarn.thebarn;

import com.sfm.thebarn.thebarn.model.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ThebarnApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThebarnApplication.class, args);
	}

}
