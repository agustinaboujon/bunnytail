package bunnytail.bunnytail.graphics;

public class Screen {
    private final int width;
    private final int height;
    public final int[] pixels;

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
}
