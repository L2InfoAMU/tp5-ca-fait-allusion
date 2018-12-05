package image;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;
import static util.Matrices.*;


public class PaletteRasterImage extends RasterImage{

    private List<Color> palette;
    private int[][] indexOfColors;

    public PaletteRasterImage(Color color, int width, int height){
        super(color, width, height);
    }

    public PaletteRasterImage(Color[][] colors){
        super(colors);
    }

    public void createRepresentation(){
        palette = new ArrayList<>();
        indexOfColors = new int[width][height];
    }

    public void setPixelColor(Color color, int x, int y){
        int index;
        if(!palette.contains(color)){
            palette.add(color);
            index = palette.size()-1;
        }
        else
            index = palette.indexOf(color);

        indexOfColors[x][y] = index;
    }

    @Override
    public Color getPixelColor(int x, int y){
        int index = indexOfColors[x][y];
        return palette.get(index);
    }
}
