package s10_sealed_class;

/**
 * This subtype of Shape is open for more subtyping. However, it enforces implementation of a method to impose some kind
 * of information to be provided by subtypes.
 */
public abstract non-sealed class Polygon extends Shape {

    public abstract int edgeCount();

}
