package configuration;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources("file:src/test/resources/conf.properties")
public interface MyConfig extends Config {
    String page();
    String password();
    String homePage();
}
