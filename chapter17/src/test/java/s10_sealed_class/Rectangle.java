package s10_sealed_class;

/**
 * This subtype permits a subtype on its own.
 */
public sealed class Rectangle extends Shape permits Square {

    private final int width;
    private final int height;

    public Rectangle(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return width + " x " + height;
    }
}
