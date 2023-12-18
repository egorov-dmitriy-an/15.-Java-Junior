package HomeWork2;

public class HomeWork2 {

    /**
     * Расширить пример с запуском тестов следующими фичами:
     * 1. Добавить аннотации BeforeEach, AfterEach,
     * которые ставятся над методами void без аругментов и запускаются ДО и ПОСЛЕ всех тестов соответственно.
     * 2. В аннотацию Test добавить параметр order() со значением 0 по умолчанию.
     * Необходимо при запуске тестов фильтровать тесты по этому параметру (от меньшего к большему).
     * Т.е. если есть методы @Test(order = -2) void first, @Test void second, Test(order = 5) void third,
     * то порядок вызовов first -> second -> third
     */
    public static void main(String[] args) {
        TestProcessor.runTest(MyTest.class);
    }

    static class MyTest {
        @BeforeEach
        void beforeEach() {
            System.out.println("beforeEach запущен");
        }

        @AfterEach
        void afterEach() {
            System.out.println("afterEach запущен");
        }

        @Test(order = -2)
        void firstTest() {
            System.out.println("firstTest запущен");
        }

        @Test(order = 0)
        void secondTest() {
            System.out.println("secondTest запущен");
        }

        @Test(order = 5)
        void thirdTest() {
            System.out.println("thirdTest запущен");
        }
    }
}