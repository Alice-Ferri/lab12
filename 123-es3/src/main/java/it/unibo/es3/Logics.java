package it.unibo.es3;

import java.util.List;

public interface Logics {

    List<Pair<Integer, Integer>> randomCell(int nRandomCells);

    List<Pair<Integer, Integer>> nearCells();

    boolean toQuit();

}
