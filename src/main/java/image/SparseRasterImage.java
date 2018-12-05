package image;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

import static util.Matrices.*;
import static util.Matrices.getRowCount;

public class SparseRasterImage implements Image{

    private int height;
    private int width;
    private Map<Point, Color> pixelsMap;

    public SparseRasterImage(Color[][] colors) {

        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        requiresRectangularMatrix(colors);

        height = getColumnCount(colors);
        width = getRowCount(colors);

        createRepresentation();
        setPixelsColor(colors);
    }

    public SparseRasterImage(Color color, int width, int height) {
        this.height = height;
        this.width = width;

        createRepresentation();
        setPixelsColor(color);
    }

    public void createRepresentation() {
        pixelsMap = new HashMap<>();
    }

    public void setPixelColor(Color color, int x, int y) {
        Point myPoint = new Point(x, y);
        pixelsMap.put(myPoint, color);
    }

    public Color getPixelColor(int x, int y) {
        return pixelsMap.get(new Point(x, y));
    }

    private void setPixelsColor(Color[][] pixels) {
        for(int row = 0; row < height; row++) {
            for(int column = 0; column < width; column++) {
                setPixelColor(pixels[column][row], column, row);
            }
        }
    }

    private void setPixelsColor(Color color) {
        for(int row = 0; row < height; row++) {
            for(int column = 0; column < width; column++) {
                setPixelColor(color, column, row);
            }
        }

    }

    public int getWidth() { return width; }

    public int getHeight() { return height; }

    protected void setWidth(int width) { this.width = width; }

    protected void setHeight(int height) { this.height = height; }
}










