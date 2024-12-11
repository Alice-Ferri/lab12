package it.unibo.es2;

import java.util.List;

public interface Logic {
    
	/**
	 * @return the number of lines
	 */
	int size();

    /**
	 * @return ordered integers to appear in buttons
	 */
	List<Boolean> values();

    /**
	 * @return the new value a button should show after being pressed
	 */
	boolean hit(int x, int y);

    /**
	 * @return whether it is time to quit
	 */
	boolean toQuit();
}
