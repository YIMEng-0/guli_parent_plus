import org.junit.Test;

/**
 * @author Doraemon
 * @date 2022/4/30 12:32 下午
 * @version 1.0
 */
public class MyTest {
    @Test
    public void testTry() {
        try {
            return;
        }catch (Exception e) {
            return;
        } finally {
            System.out.println("cd");
            return;
        }
    }
}
