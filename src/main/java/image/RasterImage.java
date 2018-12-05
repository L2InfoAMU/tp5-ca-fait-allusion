package image;

import javafx.scene.paint.Color;

import static util.Matrices.*;
import static util.Matrices.getRowCount;

abstract class RasterImage implements Image {
    protected int height;
    protected int width;

    public RasterImage(Color[][] colors){

        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        requiresRectangularMatrix(colors);

        height = getColumnCount(colors);
        width = getRowCount(colors);

        createRepresentation();
        setPixelsColor(colors);
    }

    public RasterImage(Color color, int width, int height){
        this.height = height;
        this.width = width;

        createRepresentation();
        setPixelsColor(color);
    }


    public abstract void createRepresentation();

    protected abstract void setPixelColor(Color color, int x, int y);

    protected void setPixelsColor(Color color){
        for (int row = 0; row < height; row ++)
            for(int column = 0; column < width; column ++)
                setPixelColor(color, column, row);
    }

    protected void setPixelsColor(Color[][] pixels){
        for (int row = 0; row < height; row ++)
            for(int column = 0; column < width; column ++)
                setPixelColor(pixels[column][row],column,row);
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
