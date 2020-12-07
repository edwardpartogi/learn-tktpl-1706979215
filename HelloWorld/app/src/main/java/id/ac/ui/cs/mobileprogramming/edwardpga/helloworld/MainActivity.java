package id.ac.ui.cs.mobileprogramming.edwardpga.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }
    public native boolean checkColorInt(int currentColorInt, int standardColorInt);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeColorHelloWorld(View v) {
        TextView hello_text = findViewById(R.id.textView);

        if ( checkColorInt(hello_text.getCurrentTextColor(), Color.BLACK) ) {
            hello_text.setTextColor(Color.RED);
        } else {
            hello_text.setTextColor(Color.BLACK);
        }
    }

    public static boolean checkBlackColor(int currentColor){
        if (currentColor == Color.BLACK) {
            return true;
        } else {
            return false;
        }
    }
}