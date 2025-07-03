package junit;

import org.junit.jupiter.api.*;

public class FirstJUnitTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Общая конфигурация для всех тестов");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After each");
    }

    @Test
    void firstTest()  {
        System.out.println("first test");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void secondTest()  {
        System.out.println("second test");
        Assertions.assertTrue(3 > 2);
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Очистка общей конфигурации");
    }
}
