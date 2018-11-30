package image;

import javafx.scene.paint.Color;
import util.Matrices;
import static util.Matrices.*;

public class BruteRasterImage implements Image{

    private Color[][] pixels;
    private int height;
    private int width;

    public BruteRasterImage(Color color, int width, int height){
        this.height = height;
        this.width = width;
        pixels = new Color[width][height];
        setPixelsColor(color);
    }

    public BruteRasterImage(Color[][] colors){

        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        requiresRectangularMatrix(colors);

        height = getColumnCount(colors);
        width = getRowCount(colors);
        createRepresantation();
        setPixelsColor(colors);
    }

    public void createRepresantation(){
        pixels = new Color[width][height];
    }

    public void setPixelColor(Color color, int x, int y){
        pixels[x][y] = color;
    }

    @Override
    public Color getPixelColor(int x, int y){
        return pixels[x][y];
    }

    private void setPixelsColor(Color[][] pixels){
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
