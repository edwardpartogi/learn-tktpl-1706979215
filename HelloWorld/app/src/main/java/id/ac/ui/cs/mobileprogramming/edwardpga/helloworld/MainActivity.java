package id.ac.ui.cs.mobileprogramming.edwardpga.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int counter;
    boolean timer_going = false;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button= (Button) findViewById(R.id.button);
        textView= (TextView) findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!timer_going) {
                    new CountDownTimer(30000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            timer_going = true;
                            textView.setText(String.valueOf(counter+1));
                            counter++;
                        }

                        public void onFinish() {
                            textView.setText("FINISH!!");
                            counter = 0;
                            timer_going = false;
                        }
                    }.start();
                }

            }
        });
    }
}