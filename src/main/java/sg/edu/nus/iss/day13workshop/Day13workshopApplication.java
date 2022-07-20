package sg.edu.nus.iss.day13workshop;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sg.edu.nus.iss.day13workshop.services.DataBaseService;

import java.io.File;


@SpringBootApplication
public class Day13workshopApplication implements ApplicationRunner {
	DataBaseService dbSvc;

	public static void main(String[] args) {
//		SpringApplication app = new SpringApplication(Day13workshopApplication.class);
//		ApplicationArguments cliOpts = new DefaultApplicationArguments(args);
//		if(cliOpts.containsOption("dataDir")){
//			dataDir=
//		}
		SpringApplication.run(Day13workshopApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		if (args.containsOption("dataDir")) {
			final String dataDir = args.getOptionValues("dataDir").get(0);
			dbSvc.setDataDir(new File(dataDir));
			if (!dbSvc.isdDataDirValid()) {
				System.err.println("Does not exist or unwritable");
				System.exit(-1);
			}
			System.out.printf("Using %s as data directory \n", dataDir);
		} else {
			dbSvc.setDataDir(new File("./data"));

		}
	}

	public boolean save() {

	}

	public void read(String fileId){

	}
}
