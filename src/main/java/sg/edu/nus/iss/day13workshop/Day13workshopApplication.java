package sg.edu.nus.iss.day13workshop;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Day13workshopApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(Day13workshopApplication.class, args);
	}

	@Override
	public void run (ApplicationArguments args){
		if(args.containsOption("dataDir")){
			final String dataDir = args.getOptionValues("dataDir").get(0);
			System.out.printf("Using %s as data directory \n", dataDir);
		}else {

		}
	}
}
