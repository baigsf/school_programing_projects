import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * Main program that creates ArrayList of 10 Rectangles and lists those with big perimeters
 */
public class BigRectLister {
    public static void main(String[] args) {
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        
        // Add rectangles with various dimensions
        // Some with small perimeters (<= 10) and some with big perimeters (> 10)
        rectangles.add(new Rectangle(0, 0, 1, 1));    // Perimeter = 4
        rectangles.add(new Rectangle(0, 0, 2, 2));    // Perimeter = 8
        rectangles.add(new Rectangle(0, 0, 3, 3));    // Perimeter = 12 (BIG)
        rectangles.add(new Rectangle(0, 0, 4, 4));    // Perimeter = 16 (BIG)
        rectangles.add(new Rectangle(0, 0, 5, 2));    // Perimeter = 14 (BIG)
        rectangles.add(new Rectangle(0, 0, 2, 1));    // Perimeter = 6
        rectangles.add(new Rectangle(0, 0, 6, 3));    // Perimeter = 18 (BIG)
        rectangles.add(new Rectangle(0, 0, 1, 4));    // Perimeter = 10 (NOT BIG)
        rectangles.add(new Rectangle(0, 0, 5, 5));    // Perimeter = 20 (BIG)
        rectangles.add(new Rectangle(0, 0, 2, 3));    // Perimeter = 10 (NOT BIG)
        
        Filter filter = new BigRectangleFilter();
        
        System.out.println("All Rectangles:");
        System.out.println("--------------");
        for (int i = 0; i < rectangles.size(); i++) {
            Rectangle r = rectangles.get(i);
            double perimeter = 2 * (r.getWidth() + r.getHeight());
            System.out.printf("Rectangle %d: width=%.1f, height=%.1f, perimeter=%.1f%n", 
                i + 1, r.getWidth(), r.getHeight(), perimeter);
        }
        
        System.out.println("\nRectangles with Big Perimeter (> 10):");
        System.out.println("---------------------------------------");
        for (int i = 0; i < rectangles.size(); i++) {
            Rectangle r = rectangles.get(i);
            if (filter.accept(r)) {
                double perimeter = 2 * (r.getWidth() + r.getHeight());
                System.out.printf("Rectangle %d: width=%.1f, height=%.1f, perimeter=%.1f%n", 
                    i + 1, r.getWidth(), r.getHeight(), perimeter);
            }
        }
    }
}
