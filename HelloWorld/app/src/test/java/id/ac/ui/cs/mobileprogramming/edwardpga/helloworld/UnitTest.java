package id.ac.ui.cs.mobileprogramming.edwardpga.helloworld;

import org.junit.Test;
import static org.junit.Assert.*;

import android.graphics.Color;
public class UnitTest {
    @Test
    public void testCheckBlackColor() {
        int black = Color.BLACK;
        boolean colorIsBlack = MainActivity.checkBlackColor(black);
        assertEquals(true, colorIsBlack);
    }
}
