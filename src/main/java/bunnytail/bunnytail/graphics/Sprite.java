package bunnytail.bunnytail.graphics;

public class Sprite {
    private final int arist;
    private int x;
    private int y;
    public int[] pixels;
    private final ResourcesSprites resource;

    public static  Sprite grass = new Sprite(32, 0,0, ResourcesSprites.grass);

    public Sprite(final int arist, final int colum, final int row, final ResourcesSprites resource){
        this.arist = arist;
        this.pixels = new int[arist * arist];

        this.x = colum * arist;
        this.y = row * arist;
        this.resource = resource;

        for(int y = 0; y < arist; y++){
            for(int x = 0; x < arist; x++){
                pixels[x + y * arist] = resource.pixels[(x + this.x)
                        + (y + this.y) * resource.getWidth()];
            }
        }

    }
}
