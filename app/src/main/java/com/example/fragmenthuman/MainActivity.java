package com.example.fragmenthuman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements OnReceiveHuman {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.fragment_container, new ListFragment(), ListFragment.class.getSimpleName())
                .addToBackStack(null)
                .commit();

    }


    @Override
    public void receive(int id) {
        ListFragment frg = (ListFragment) getSupportFragmentManager().findFragmentByTag(ListFragment.class.getSimpleName());
        if (frg != null) {
            frg.deleteHuman(id);
        }
    }
}