package id.ac.ui.cs.mobileprogramming.edwardpga.helloworld;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.graphics.Color;
import android.widget.TextView;
import id.ac.ui.cs.mobileprogramming.edwardpga.helloworld.MainActivity;
public class UnitTest {
    @Test
    public void testCheckBlackColor() {
        int black = Color.BLACK;
        boolean colorIsBlack = MainActivity.checkBlackColor(black);
        assertEquals(true, colorIsBlack);
    }
}
