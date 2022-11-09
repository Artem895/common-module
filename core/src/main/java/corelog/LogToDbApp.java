package corelog;

import corelog.model.DbLogModel;
import corelog.myanotation.DbLog;
import corelog.repository.LogEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class LogToDbApp {
    public static void main(String[] args) {
        SpringApplication.run(LogToDbApp.class, args);
    }
}
