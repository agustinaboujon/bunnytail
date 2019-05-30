package bunnytail.bunnytail.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class resourcesSprites {
    private final int width;
    private final int height;
    public final int[] pixels;

    public resourcesSprites(final String route, final int width, final int height) throws IOException {
        this.height = height;
        this.width = width;

        pixels = new int[height * width];

        BufferedImage image = ImageIO.read(resourcesSprites.class.getResource(route));
        image.getRGB(0,0, width, height, pixels, 0, width);
    }
}
