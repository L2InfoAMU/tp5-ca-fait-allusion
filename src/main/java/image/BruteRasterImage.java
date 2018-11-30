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
        pixels = new Color[height][width];
        setPixelsColor(color);
    }

    public BruteRasterImage(Color[][] colors){

        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        requiresRectangularMatrix(colors);

        height = getRowCount(colors);
        width = getColumnCount(colors);
        createRepresantation();
        setPixelsColor(colors);
    }

    public void createRepresantation(){
        pixels = new Color[height][width];
    }

    public void setPixelColor(Color color, int x, int y){
        pixels[y][x] = color;
    }

    @Override
    public Color getPixelColor(int x, int y){
        return pixels[y][x];
    }

    private void setPixelsColor(Color[][] pixels){
        for (int row = 0; row < height; row ++)
            for(int column = 0; column < width; column ++)
                setPixelColor(pixels[column][row],row, column);
    }

    private void setPixelsColor(Color color){
        for (int row = 0; row < height; row ++)
            for(int column = 0; column < width; column ++)
                setPixelColor(color,row, column);
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
