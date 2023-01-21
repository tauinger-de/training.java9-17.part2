package s10_sealed_class;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.lang.System.out;

public class SealedTest {

    @Test
    void demoReflection() {
        out.println("Listing all permitted subclasses of Shape (and if they are sealed themselves):");
        Arrays.stream(Shape.class.getPermittedSubclasses())
                .forEach(c -> out.printf("  - %s (%b)\n", c.getSimpleName(), c.isSealed()));
    }

    @Test
    void demoInstanceof() {
        var shape = getShape();
        if (shape instanceof Runnable) {
            // we could have an extension of Polygon that implements Runnable
            out.println("It's a Runnable");
        } else if (shape instanceof Rectangle rectangle) {
            out.println("It's a Rectangle");
            // but never a Rectangle that implements Runnable because Rectangle is sealed
            // if (rectangle instanceof Runnable) {}    // does not compile
        }
    }

    private Shape getShape() {
        return new Circle();
    }
}
