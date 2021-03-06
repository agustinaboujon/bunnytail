package bunnytail.bunnytail.graphics;
import bunnytail.bunnytail.graphics.Sprite;

public class Screen {
    private final int width;
    private final int height;
    public final int[] pixels;

    //Test
    private final static int SIDE_SPRITE = 32;
    private final static int MASK_SPRITE = SIDE_SPRITE - 1;

    public Screen(final int width, final int height){
        this.width = width;
        this.height = height;

        pixels = new int[width * height];
    }

    public void clean(){
        for(int i = 0; i < pixels.length; i++){
            pixels[i] = 0;
        }
    }

    public void showIt(final int compX, final int compY){
         for(int y = 0; y < height; y++){
             int positionY = y + compY;
             if(positionY < 0 || positionY >= height){
                 continue;
             }
             for(int x = 0; x < width; x++){
                 int positionX = x + compX;
                 if(positionX < 0 || positionX >= width){
                     continue;
                 }
                 //Test
                     pixels[positionX + positionY * width] = Sprite.grass.pixels[(x & MASK_SPRITE)
                             + (y & MASK_SPRITE) * SIDE_SPRITE];

             }
         }
    }
}
