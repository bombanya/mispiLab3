import com.bombanya.web3.HitChecker;

import static org.junit.Assert.assertTrue;

import com.bombanya.web3.ResultsListManager;
import com.bombanya.web3.TableRow;
import org.junit.BeforeClass;
import org.junit.Test;


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

    @BeforeClass
    public static void beforeAll() {
        checker = new HitChecker();
        checker.setListManager(new ResultsListManager(){
            @Override
            public void addNewRow(TableRow row) {}
        });
    }

    //first quarter
    @Test
    public void originCheck() {
        assertTrue("Начало координат не прошло", testHit(5, 0, 0));
    }

    @Test
    public void squareOYPointOne() {
        assertTrue("Точка (0; R/2) не прошла", testHit(4, 2, 2));
    }

    @Test
    public void squareOYPointTwo() {
        assertTrue("Точка (0; R) не прошла", testHit(3, 0, 3));
    }

    @Test
    public void squareOXPointOne() {
        assertTrue("Точка (R/2; 0) не прошла", testHit(3, 1.5, 0));
    }

    @Test
    public void squareOXPointTwo() {
        assertTrue("Точка (R; 0) не прошла", testHit(5, 5, 0));
    }

    @Test
    public void squareRYPointOne() {
        assertTrue("Точка (R; R/2) не прошла", testHit(1, 1, 0.5));
    }

    @Test
    public void squareRRPoint() {
        assertTrue("Точка (R; R) не прошла", testHit(3, 3, 3));
    }

    @Test
    public void squareXRPointOne() {
        assertTrue("Точка (R/2; R) не прошла", testHit(2, 1, 2));
    }

    @Test
    public void insideSquare() {
        assertTrue("Точка внутри квадрата не прошла", testHit(3, 2, 1.2));
    }

    @Test
    public void outsideSquare() {
        assertTrue("Прошла точка вне квадрата", testNoHit(2, 5, 6));
    }

    //second quarter
    @Test
    public void pointOne() {
        assertTrue("Прошла точка во второй четверти", testNoHit(3, -1, 5));
    }

    @Test
    public void pointTwo() {
        assertTrue("Прошла точка во второй четверти", testNoHit(4, -15, 2));
    }

    //third quarter
    @Test
    public void triangleOXPointOne() {
        assertTrue("Точка (-R/2, 0) не прошла", testHit(5, -2.5, 0));
    }

    @Test
    public void triangleOYPointOne() {
        assertTrue("Точка (0, -R/2) не прошла", testHit(4, 0, -2));
    }

    @Test
    public void triangleOYPointTwo() {
        assertTrue("Точка (0, -R) не прошла", testHit(1, 0, -1));
    }

    @Test
    public void triangleEdgePoint() {
        assertTrue("Точка на дальней стороне треугольника не прошла", testHit(2, -0.7, -0.6));
    }

    @Test
    public void insideTriangle() {
        assertTrue("Точка внутри треугольника не прошла", testHit(4, -1.1,-1));
    }

    @Test
    public void outsideTriangle() {
        assertTrue("Точка вне треугольника прошла", testNoHit(5, -5, -2));
    }

    //fourth quarter
    @Test
    public void circleEdgePoint() {
        assertTrue("Точка на окружности не прошла", testHit(2, 0.8, -0.6));
    }

    @Test
    public void insideCircle() {
        assertTrue("Точка внутри круга не прошла", testHit(4, 1.2, -1.3));
    }

    @Test
    public void outsideCircle() {
        assertTrue("Прошла точка вне круга", testNoHit(5, 7, -8));
    }
}
