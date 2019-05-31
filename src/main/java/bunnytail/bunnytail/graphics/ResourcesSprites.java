package bunnytail.bunnytail.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourcesSprites {
    private final int width;
    private final int height;
    public final int[] pixels;

    public static ResourcesSprites texture;
    static {
        try {
            texture = new ResourcesSprites("/textures/sprites.png", 320, 320);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ResourcesSprites(final String route, final int width, final int height) throws IOException {


        this.height = height;
        this.width = width;

        pixels = new int[height * width];

        BufferedImage image = ImageIO.read(ResourcesSprites.class.getResource(route));
        image.getRGB(0,0, width, height, pixels, 0, width);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
