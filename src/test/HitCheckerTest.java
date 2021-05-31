import com.bombanya.web3.HitChecker;
import static org.junit.jupiter.api.Assertions.*;

import com.bombanya.web3.ResultsListManager;
import com.bombanya.web3.TableRow;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public class HitCheckerTest {

    private static HitChecker checker;

    private static void testCoords(int r, double x, double y){
        checker.setR(r);
        checker.setX(x);
        checker.setY(y);
        checker.checkHit();
    }

    private static boolean testHit(int r, double x, double y){
        testCoords(r, x, y);
        return checker.getBoolResult() && checker.getLastResult().equals("Точка попала в область");
    }

    private static boolean testNoHit(int r, double x, double y){
        testCoords(r, x, y);
        return !checker.getBoolResult() && checker.getLastResult().equals("Точка не попала в область");
    }

    @BeforeAll
    static void beforeAll() {
        checker = new HitChecker();
        checker.setListManager(new ResultsListManager(){
            @Override
            public void addNewRow(TableRow row) {}
        });
    }

    @Nested
    class firstQuarterTests{

        @Test
        void originCheck() {
            assertTrue(testHit(5, 0, 0), "Начало координат не прошло");
        }

        @Test
        void squareOYPointOne() {
            assertTrue(testHit(4, 2, 2), "Точка (0; R/2) не прошла");
        }

        @Test
        void squareOYPointTwo() {
            assertTrue(testHit(3, 0, 3), "Точка (0; R) не прошла");
        }

        @Test
        void squareOXPointOne() {
            assertTrue(testHit(3, 1.5, 0), "Точка (R/2; 0) не прошла");
        }

        @Test
        void squareOXPointTwo() {
            assertTrue(testHit(5, 5, 0), "Точка (R; 0) не прошла");
        }

        @Test
        void squareRYPointOne() {
            assertTrue(testHit(1, 1, 0.5), "Точка (R; R/2) не прошла");
        }

        @Test
        void squareRRPoint() {
            assertTrue(testHit(3, 3, 3), "Точка (R; R) не прошла");
        }

        @Test
        void squareXRPointOne() {
            assertTrue(testHit(2, 1, 2), "Точка (R/2; R) не прошла");
        }

        @Test
        void insideSquare() {
            assertTrue(testHit(3, 2, 1.2), "Точка внутри квадрата не прошла");
        }

        @Test
        void outsideSquare() {
            assertTrue(testNoHit(2, 5, 6), "Прошла точка вне квадрата");
        }
    }

    @Nested
    class secondQuarterTests{

        @Test
        void pointOne() {
            assertTrue(testNoHit(3, -1, 5), "Прошла точка во второй четверти");
        }

        @Test
        void pointTwo() {
            assertTrue(testNoHit(4, -15, 2), "Прошла точка во второй четверти");
        }
    }

    @Nested
    class thirdQuarterTests{

        @Test
        void triangleOXPointOne() {
            assertTrue(testHit(5, -2.5, 0), "Точка (-R/2, 0) не прошла");
        }

        @Test
        void triangleOYPointOne() {
            assertTrue(testHit(4, 0, -2), "Точка (0, -R/2) не прошла");
        }

        @Test
        void triangleOYPointTwo() {
            assertTrue(testHit(1, 0, -1), "Точка (0, -R) не прошла");
        }

        @Test
        void triangleEdgePoint() {
            assertTrue(testHit(2, -0.7, -0.6), "Точка на дальней стороне треугольника не прошла");
        }

        @Test
        void insideTriangle() {
            assertTrue(testHit(4, -1.1,-1), "Точка внутри треугольника не прошла");
        }

        @Test
        void outsideTriangle() {
            assertTrue(testNoHit(5, -5, -2), "Точка вне треугольника прошла");
        }
    }

    @Nested
    class fourthQuarterTests{

        @Test
        void circleEdgePoint() {
            assertTrue(testHit(2, 0.8, -0.6), "Точка на окружности не прошла");
        }

        @Test
        void insideCircle() {
            assertTrue(testHit(4, 1.2, -1.3), "Точка внутри круга не прошла");
        }

        @Test
        void outsideCircle() {
            assertTrue(testNoHit(5, 7, -8), "Прошла точка вне круга");
        }
    }
}