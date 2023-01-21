package s10_sealed_interface;

public sealed interface Ship permits SailingShip, Ferry {
}
