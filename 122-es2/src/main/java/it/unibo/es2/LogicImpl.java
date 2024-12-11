package it.unibo.es2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LogicImpl implements Logic{

    private final int size;
    private List<List<Boolean>> matrix;

    public LogicImpl(int size) {
		this.size = size;
        matrix = new ArrayList<>();

        for(int i = 0; i < this.size; i++){
            matrix.add(new ArrayList<>());
            for(int j = 0; j < this.size; j++){
                matrix.get(i).add(false);
            }
        }
	}

    @Override
    public int size() {
        return this.size;    
    }

    @Override
    public List<Boolean> values() {
        return matrix.stream().map(v -> v.listIterator().next()).toList();
    }

    @Override
    public boolean hit(final int x, final int y) {
        if(matrix.get(x).get(y).equals(false)) {
            matrix.get(x).set(y, true);
        } else {
            matrix.get(x).set(y, false);
        }
        return matrix.get(x).get(y);        
    }

    @Override
    public boolean toQuit() {
        if(checkColumns()) return true;
        if(checkLines()) return true;
        return false;
        //return checkColumns() || checkLines();
    }
    /*public boolean toQuit() {
        
        for(int i = 0; i < this.size; i++) {
            boolean test = true;
            for(int j = 0; i < this.size; j++) {
                if(!matrix.get(i).get(j)){
                    test = false;
                    break;
                }
            }
            if (test) return true;
        }
    }
    */
    private boolean checkColumns(){
        return IntStream.range(0, size)
            .anyMatch(i -> matrix.get(i).stream().allMatch(col -> col));
    }

    private boolean checkLines(){
        return matrix.stream().anyMatch(i -> i.stream().allMatch(p -> p));
    }

}
