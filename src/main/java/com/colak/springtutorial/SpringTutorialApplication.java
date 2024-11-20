package com.colak.springtutorial;

import com.colak.springtutorial.marker.CustomMarker;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@Slf4j
public class SpringTutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTutorialApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void logSomething() {
		log.info("This is a log message");
		log.info(CustomMarker.TELEGRAM_MARKER, "This is a log message for telegram");
	}

	// when application ends, log message will be printed
	@PreDestroy
	public void destroy() {
		log.info(CustomMarker.TELEGRAM_MARKER, "Application is shutting down");
	}

}
