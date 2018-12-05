package image;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

import static util.Matrices.*;
import static util.Matrices.getRowCount;

public class SparseRasterImage implements Map {

    private int height;
    private int width;
    private Map<Point,Color> pixelsMap;

    public SparseRasterImage(Color[][] colors){

        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        requiresRectangularMatrix(colors);

        height = getColumnCount(colors);
        width = getRowCount(colors);

        createRepresentation();
        setPixelsColor(colors);
    }

    public SparseRasterImage(Color color, int width, int height){
        this.height = height;
        this.width = width;

        createRepresentation();
        setPixelsColor(color);
    }

    public void createRepresentation(){
        pixelsMap = new HashMap<>();


    }

    public void setPixelColor(Color color, int x, int y){
        Point myPoint = new Point(x, y);
        pixelsMap.put(myPoint, color);
    }

    public Color getPixelColor(int x, int y){
        return pixelsMap.get(new Point(x, y));
    }

    private void setPixelsColor(Color[][] pixels){
        
    }









}
