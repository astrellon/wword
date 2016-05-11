package com.wword;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class WWord {
    public ArrayList<int[]> values = new ArrayList<int[]>();
    public String word;

    public static WWord createFromImage(String word, BufferedImage image, java.awt.Rectangle rectangle) {
        WWord result = new WWord();
        result.word = word;

        int subWidth = 50;
        BufferedImage subimage = image.getSubimage(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        BufferedImage scaled = new BufferedImage(subWidth, rectangle.height, BufferedImage.TYPE_INT_ARGB);
        AffineTransform transform = new AffineTransform();
        transform.scale(subWidth / (double)rectangle.width, 1.0);

        AffineTransformOp transformOp = new AffineTransformOp(transform, AffineTransformOp.TYPE_BICUBIC);
        scaled = transformOp.filter(subimage, scaled);

        for (int x = 0; x < subWidth; x++) {
            int []columnValues = new int[rectangle.height];

            int yi = 0;
            for (int y = 0; y < rectangle.height; y++) {
                int argb = scaled.getRGB(x, y);
                int value = (0xFF - (0xFF & argb)) / 16;
                columnValues[yi++] = value;
            }
            result.values.add(columnValues);
        }

        return result;
    }

    public String debugDisplay() {
        String result = "Word: " + word + "\n";
        int height = values.get(0).length;
        for (int x = 0; x < values.size(); x++) {
            result += " V ";
        }
        result += "\n";
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < values.size(); x++) {
                int value = values.get(x)[y];
                String v = value < 10 ? " " + value : Integer.toString(value);
                result += v + " ";
            }
            result += "\n";
        }

        return result;
    }
}
