package image;

import javafx.scene.paint.Color;
import util.Matrices;
import static util.Matrices.*;

public class BruteRasterImage extends RasterImage{

    private Color[][] pixels;

    public BruteRasterImage(Color color, int width, int height){
        super(color, width, height);
    }

    public BruteRasterImage(Color[][] colors){
        super(colors);
    }

    public void createRepresentation(){
        pixels = new Color[width][height];
    }

    public void setPixelColor(Color color, int x, int y){
        pixels[x][y] = color;
    }

    @Override
    public Color getPixelColor(int x, int y){
        return pixels[x][y];
    }


}
