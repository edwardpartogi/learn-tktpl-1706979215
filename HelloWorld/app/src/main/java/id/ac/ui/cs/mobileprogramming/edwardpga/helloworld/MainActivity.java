package id.ac.ui.cs.mobileprogramming.edwardpga.helloworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button firstFragmentBtn, secondFragmentBtn;
    Fragment firstFragment, secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment = new SimpleFragment();
        secondFragment = new PraiseCurseFragment();

        // get the reference of Button's
        firstFragmentBtn = (Button) findViewById(R.id.btnFragment1);
        secondFragmentBtn = (Button) findViewById(R.id.btnFragment2);

        loadFragment(firstFragment);
        firstFragmentBtn.setVisibility(View.GONE);

        // perform setOnClickListener event on First Button
        firstFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // load First Fragment
                loadFragment(firstFragment);
                secondFragmentBtn.setVisibility(View.VISIBLE);
                firstFragmentBtn.setVisibility(View.GONE);
            }
        });

        // perform setOnClickListener event on Second Button
        secondFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // load Second Fragment
                loadFragment(secondFragment);
                secondFragmentBtn.setVisibility(View.GONE);
                firstFragmentBtn.setVisibility(View.VISIBLE);
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.flFragment, fragment).addToBackStack(null);
        fragmentTransaction.commit(); // save the changes
    }
}