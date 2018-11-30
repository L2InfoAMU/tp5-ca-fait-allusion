package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import static util.Matrices.*;


public class PaletteRasterImage implements Image {

    private List<Color> palette;
    private int[][] indexOfColors;
    private int height;
    private int width;

    public PaletteRasterImage(Color color, int width, int height){
        this.height = height;
        this.width = width;

        createRepresentation();
        setPixelsColor(color);
    }

    public PaletteRasterImage(Color[][] colors){
        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        requiresRectangularMatrix(colors);

        height = getColumnCount(colors);
        width = getRowCount(colors);

        createRepresentation();
        setPixelsColor(colors);
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

    public void setPixelsColor(Color[][] pixels){
        for (int row = 0; row < height; row ++)
            for(int column = 0; column < width; column ++)
                setPixelColor(pixels[column][row],column,row);
    }

    private void setPixelsColor(Color color){
        for (int row = 0; row < height; row ++)
            for(int column = 0; column < width; column ++)
                setPixelColor(color,column, row);
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
