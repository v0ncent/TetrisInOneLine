import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream.of(
                new JFrame()
        ).collect(
                new Collector<JFrame, List<JFrame>, List<JFrame>>() {

                    @Override
                    public Supplier<List<JFrame>> supplier() {
                        return ArrayList::new;
                    }

                    @Override
                    public BiConsumer<List<JFrame>, JFrame> accumulator() {
                        return List::add;
                    }

                    @Override
                    public BinaryOperator<List<JFrame>> combiner() {
                        return (l1, l2) -> {
                            l1.forEach(
                                    (jFrame) -> jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
                            );
                            l1.addAll(l2);
                            return l2;
                        };
                    }

                    @Override
                    public Function<List<JFrame>, List<JFrame>> finisher() {
                        return Collections::unmodifiableList;
                    }

                    @Override
                    public Set<Characteristics> characteristics() {
                        return Set.of(Characteristics.UNORDERED);
                    }
                }
        );
    }
}