package bunnytail.bunnytail.graphics;

public class resourcesSprites {
    private final int width;
    private final int height;
    public final int[] pixels;

    public resourcesSprites(final String route, final int width, final int height){
        this.height = height;
        this.width = width;

        pixels = new int[height * width];
    }
}
