package s30_randomgenerator;

import org.junit.jupiter.api.Test;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class RandomGeneratorTest {

    @Test
    void listAll() {
        System.out.println("Listing all RandomGeneratorFactory instances and if they are splittable:");
        RandomGeneratorFactory.all()
                .forEach(factory -> {
                    System.out.printf("  - '%s' (%b)\n",
                            factory.name(), factory.isSplittable());
                });
    }

    @Test
    void getDefault() {
        RandomGeneratorFactory<RandomGenerator> factory = RandomGeneratorFactory.getDefault();
        RandomGenerator randomGenerator = factory.create();
        randomGenerator.nextInt(0, 101); // random int 0-100
    }

    @Test
    void split() {
        var factory = RandomGeneratorFactory.<RandomGenerator.SplittableGenerator>of("L128X128MixRandom");
        var rootGenerator = factory.create();
        var subGenerator = rootGenerator.split();
    }
}
