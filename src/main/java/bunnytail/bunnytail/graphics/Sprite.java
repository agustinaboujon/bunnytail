package bunnytail.bunnytail.graphics;

public class Sprite {
    private final int arist;
    private int x;
    private int y;
    public int[] pixels;

    public Sprite(final int arist, final int colum, final int row, final resourcesSprites resource){
        this.arist = arist;
        this.pixels = new int[arist * arist];

        this.x = colum * arist;
        this.y = row * arist;

        for(int y = 0; y < arist; y++){
            
        }

    }
}
