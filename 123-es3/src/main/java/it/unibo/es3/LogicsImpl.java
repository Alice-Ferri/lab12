package it.unibo.es3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LogicsImpl implements Logics{


    private List<Pair<Integer, Integer>> matrix;
    private final int width;

    public LogicsImpl(int width) {
        this.width = width;
        matrix = new ArrayList<>();
    }

    public List<Pair<Integer, Integer>> randomCell (final int nRandomCells){
        final Random r = new Random();
        for(int i = 0; i < nRandomCells; i++){
            final int x = r.nextInt(this.width);
            final int y = r.nextInt(this.width);
            matrix.add(new Pair<Integer,Integer>(x, y));
        }
        return matrix;
    }
    

    @Override
    public List<Pair<Integer, Integer>> nearCells() {
        List<Pair<Integer, Integer>> nearList = new ArrayList<>();
        for(int x1 = 0; x1 < this.width; x1++){
            for(int y1 = 0; y1 < this.width; y1++){
                final var tempX1 = x1;
                final var tempY1 = y1;
                if(matrix.stream().anyMatch(p -> Math.abs(p.getX() - tempX1) <= 1 && Math.abs(p.getY() - tempY1) <= 1)){
                    nearList.add(new Pair<>(x1, y1));
                }
            }
        }
        nearList.forEach( (o) -> {
            if(!matrix.contains(o))
                matrix.add(o);
        });
        return nearList;
    }

    @Override
    public boolean toQuit() {
        return matrix.size() == (width*width);
    }

}
