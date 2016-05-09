import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class WWord
{
    public ArrayList<int[]> values = new ArrayList<int[]>();
    public String word;

    public static WWord createFromImage(String word, BufferedImage image, java.awt.Rectangle rectangle) {
        WWord result = new WWord();
        result.word = word;

        for (int x = rectangle.x; x < rectangle.x + rectangle.width; x++) {
            int []columnValues = new int[rectangle.height];

            int yi = 0;
            for (int y = rectangle.y; y < rectangle.y + rectangle.height; y++) {
                int argb = image.getRGB(x, y);
                int value = (0xFF - (0xFF & argb)) / 16;
                columnValues[yi++] = value;
            }
            result.values.add(columnValues);
        }

        return result;
    }
}
