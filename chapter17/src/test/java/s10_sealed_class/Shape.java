package s10_sealed_class;

/**
 * Shape is sealed -- and can thus make assumptions about its subtypes. It controls which types are allowed to extend
 * it and hence knows what functionality those types offer.
 */
public abstract sealed class Shape permits Rectangle, Circle, Polygon {
}
