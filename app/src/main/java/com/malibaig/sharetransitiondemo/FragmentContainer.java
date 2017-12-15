package com.malibaig.sharetransitiondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.malibaig.sharetransitiondemo.fragment.simple.FirstFragment;

public class FragmentContainer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_container);

        addFragment();
    }

    private void addFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, FirstFragment.newInstance())
                .commit();
    }
}
