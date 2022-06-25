package br.com.magnasistemas.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringFoxConfig {
	
	// http://localhost:8080/swagger-ui/index.html
		@Bean
		public GroupedOpenApi swagger() {
			return GroupedOpenApi.builder().group("br.com.magnasistemas")
					.packagesToScan("br.com.magnasistemas.controller").build();
		}

}
