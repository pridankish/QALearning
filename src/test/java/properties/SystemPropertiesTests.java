package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    void simplePropertyTest() {
        String browserName = System.getProperty("browser");
        System.out.println(browserName);
    }

    @Test
    void simplePropertyTest1() {
        System.setProperty("browser", "chrome ");
        String browserName = System.getProperty("browser");
        System.out.println(browserName);
    }

    @Test
    void simplePropertyTest2() {
        String browserName = System.getProperty("browser", "firefox");
        System.out.println(browserName);
    }

    @Test
    @Tag("one_property")
    void simplePropertyTest4() {
        String browserName = System.getProperty("browser");
        System.out.println(browserName);
        // gradle clean one_property_test

        // gradle clean one_property_test -Dbrowser=safari
    }
}
