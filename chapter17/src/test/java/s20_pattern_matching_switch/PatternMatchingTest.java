package s20_pattern_matching_switch;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.lang.System.out;

public class PatternMatchingTest {

    @Test
    void demoSwitchOverTypes() {
        for (int n = 0; n < 3; n++) {
            final var obj = createSomeObject(n);
            switch (obj) {
                case Integer i -> out.println("Integer!");
                case String s -> out.println("String!");
                case LocalDate localDate -> out.println("LocalDate, with year " + localDate.getYear());
                case Object o -> out.println("Total pattern matching for Object");
            }
        }
    }

    @Test
    void demoGuardedPattern() {
        var obj = createSomeObject(0);
        switch (obj) {
            case Integer i && i < 100 -> out.println("Integer with value less than 100");
            case Integer ignored -> out.println("Any other Integer");
            default -> out.println("Default case");
        }
    }

    @Test
    void demoParenthesizedPattern() {
        var obj = createSomeObject(1);
        switch (obj) {
            case String s && (s.length() <= 5 || s.length() > 50) -> out.println("Very short or long String");
            case String s -> out.println("Medium sized String");
            default -> out.println("Anything else...");
        }
    }

    @Test
    void demoAllCases() {
        var obj = instantiateClass("B");
        switch (obj) {
            case C c -> out.println("C");
            case B b -> out.println("B");
            // no default required thanks to sealed classes
        }
    }

    /**
     * This code is commented by design, since compilation fails with reason:
     * "Label is dominated by a preceding case label 'CharSequence cs'".
     */
    @Test
    void demoDominatedCaseLabel() {
//        var obj = createSomeObject(1);
//        switch (obj) {
//            case CharSequence cs -> out.println("CharSequence");
//            case String s -> out.println("String");
//        }
    }

    @Test
    void demoNullCaseLabel() {
        var obj = createSomeObject(-1);
        switch (obj) {
            case String s -> out.println("String");
            case CharSequence cs -> out.println("CharSequence");
            case null -> out.println("null");
            default -> out.println("whatever");
        }
    }

    /**
     * The `case null` line is commented on purpose to show that the total-type-pattern `Object o` includes null.
     * Compilation fails if uncommented.
     */
    @Test
    void demoTotalTypePattern() {
        var obj = createSomeObject(-1);
        switch (obj) {
            case String s -> out.println("String");
            case CharSequence cs -> out.println("CharSequence");
            case Object o -> out.println("Object");
            // case null -> out.println("null");
        }
    }

    /**
     * Hilfsfunktion zur Erzeugung eines nicht-deterministischen Typs (IDE austricksen)
     */
    private Object createSomeObject(int type) {
        return switch (type) {
            case -1 -> null;
            case 0 -> 42;
            case 1 -> "Hello";
            case 2 -> LocalDate.now();
            default -> throw new IllegalStateException("Unexpected value");
        };
    }

    /**
     * Hilfsfunktion zur Erzeugung eines nicht-deterministischen Typs (IDE austricksen)
     */
    private A instantiateClass(String className) {
        return switch (className) {
            case "B" -> new B();
            default -> new C();
        };
    }

    private static abstract sealed class A permits B, C {
    }

    private static final class B extends A {
    }

    private static non-sealed class C extends A {
    }
}
