package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import SpringMVCTestProject.HelloController;

@Configuration
public class ControllerConfig {
	@Bean
	public HelloController helloController() {
		return new HelloController();
	}
}
