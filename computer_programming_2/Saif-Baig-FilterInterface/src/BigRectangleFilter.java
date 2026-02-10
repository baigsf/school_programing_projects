import java.awt.Rectangle;

/**
 * Filter implementation that accepts Rectangle objects with perimeter > 10
 */
public class BigRectangleFilter implements Filter {
    @Override
    public boolean accept(Object x) {
        if (x instanceof Rectangle) {
            Rectangle rect = (Rectangle) x;
            // Perimeter = 2 * (width + height)
            double perimeter = 2 * (rect.getWidth() + rect.getHeight());
            return perimeter > 10;
        }
        return false;
    }
}
