import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        BufferedImage inputImage = null;
        try {
            inputImage = ImageIO.read(new File("assets/testdata1.png"));
        }
        catch (IOException exp) {
            System.out.println("Cannot find testdata: " + exp.getMessage());
        }
        WWord almondWord = WWord.createFromImage("almond", inputImage, new Rectangle(0, 1, 30, 7));
        WTree tree = new WTree();
        tree.addWord(almondWord);
        tree.addWord(WWord.createFromImage("honey", inputImage, new Rectangle(1, 10, 20, 7)));
        tree.addWord(WWord.createFromImage("pepitas", inputImage, new Rectangle(1, 19, 24, 7)));
        tree.addWord(WWord.createFromImage("sunflower", inputImage, new Rectangle(1, 28, 33, 7)));
        tree.addWord(WWord.createFromImage("cranberries", inputImage, new Rectangle(1, 37, 39, 7)));
        tree.addWord(WWord.createFromImage("sultanas", inputImage, new Rectangle(1, 46, 28, 7)));
        tree.addWord(WWord.createFromImage("raisins", inputImage, new Rectangle(1, 55, 24, 7)));
        tree.addWord(WWord.createFromImage("rice", inputImage, new Rectangle(1, 64, 14, 7)));
        WWord flakesWord = WWord.createFromImage("flakes", inputImage, new Rectangle(1, 73, 21, 7));
        WWord flourWord = WWord.createFromImage("flour", inputImage, new Rectangle(1, 82, 16, 7));
        tree.addWord(flakesWord);
        tree.addWord(flourWord);
        tree.addWord(WWord.createFromImage("emulsifier", inputImage, new Rectangle(1, 91, 34, 7)));
        tree.addWord(WWord.createFromImage("(471)", inputImage, new Rectangle(1, 100, 17, 7)));
        tree.addWord(WWord.createFromImage("io", inputImage, new Rectangle(1, 109, 9, 7)));
        tree.addWord(WWord.createFromImage("hazelnuts", inputImage, new Rectangle(1, 118, 33, 7)));
        tree.addWord(WWord.createFromImage("pecans", inputImage, new Rectangle(1, 127, 23, 7)));
        tree.addWord(WWord.createFromImage("psyllium", inputImage, new Rectangle(1, 136, 27, 7)));
        tree.addWord(WWord.createFromImage("husk", inputImage, new Rectangle(1, 145, 16, 7)));
        tree.addWord(WWord.createFromImage("307b", inputImage, new Rectangle(1, 154, 15, 7)));
        tree.addWord(WWord.createFromImage("soy", inputImage, new Rectangle(1, 163, 11, 7)));

        //WWordContext context = new WWordContext(almondWord);
        //tree.match(context);

        WWordContext context2 = new WWordContext(flakesWord);
        tree.match(context2);

        WWordContext context3 = new WWordContext(flourWord);
        tree.match(context3);

        System.out.println("Hi");
    }
}
