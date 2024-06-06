import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream.concat(
                Stream.of(
                        new JFrame("tetris")
                ).peek(
                        (frame) -> frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
                ).peek(
                        (frame) -> frame.setSize(12*26+10, 26*23+25)
                ),

                Stream.of(
                        (Runnable) () -> IntStream.range(0, 12).forEach(i ->
                                IntStream.range(0, 23).forEach(j ->
                                        ((Color[][]) Stream.of((Object) new Color[12][24]).findFirst().get())[i][j] = (i == 0 || i == 11 || j == 22) ? Color.GRAY : Color.BLACK
                                )
                        )
                ).peek(Runnable::run).peek(
                        System.out::println
                )
        ).findFirst().filter(
                frame -> frame instanceof JFrame
        ).stream().findFirst().ifPresent(
                (frame) -> ((JFrame) frame).setVisible(true)
        );
    }
}