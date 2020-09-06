package nix;

import nix.hibernate.ApplicationWithHibernate;
import nix.jdbc.ApplicationWithJDBC;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Scanner;

public class StartApplication {
    final static Logger LOGGER = Logger.getLogger(StartApplication.class);

    public static void main(String[] args) {
        String log4jConfigPath = "src/main/resources/log4j.properties";
        PropertyConfigurator.configure(log4jConfigPath);
        Scanner in = new Scanner(System.in);
        System.out.println("Select mode 0-Hibernate  1-JDBC");
        int mode = in.nextInt();
        if(mode==0){
            LOGGER.info("User selected Hibernate mode");
            ApplicationWithHibernate.main(args);
        }
        else{
            ApplicationWithJDBC.main(args);
            LOGGER.info("User selected JDBC mode");
        }

    }
}
