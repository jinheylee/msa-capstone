package hwmsacapstone.common;

import hwmsacapstone.CommunicationApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { CommunicationApplication.class })
public class CucumberSpingConfiguration {}
