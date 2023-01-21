package s10_sealed_class;

/**
 * A final subtype of Rectangle and hence a sub-subtype of a Shape. No further subtyping allowed here.
 */
public final class Square extends Rectangle {
    public Square(int baseLength) {
        super(baseLength, baseLength);
    }
}
