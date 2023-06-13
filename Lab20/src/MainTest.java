import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    int[][] matrix = {
            {5, 3, 8, 2},
            {9, 4, 1, 7},
            {6, 2, 0, 3},
            {1, 5, 4, 9}
    };
    int[][] expectedNew  = {
            {9,0,9,1},
            {8,1,2,7},
            {6,2,3,3},
            {4,5,4,5},
    };
    /*@org.junit.jupiter.api.Test
    void calculateAver()
    {
        assertEquals(4,Main.calculateAverage(matrix));
    }*/

    @org.junit.jupiter.api.Test
    void sort()
    {
        assertArrayEquals(expectedNew ,Main.sort(matrix));
    }
    @org.junit.jupiter.api.Test
    void main(){}
}

