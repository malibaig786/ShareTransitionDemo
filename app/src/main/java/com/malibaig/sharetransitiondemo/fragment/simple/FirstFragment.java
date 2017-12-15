package com.malibaig.sharetransitiondemo.fragment.simple;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.malibaig.sharetransitiondemo.R;

public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);
        initializeViews(rootView);
        return rootView;
    }

    private void initializeViews(View rootView) {
        ImageView lionImage = (ImageView) rootView.findViewById(R.id.iv_lion);
        lionImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSecondFragment(view);
            }
        });
    }

    private void goToSecondFragment(View lionImage) {
        Fragment fragment = SecondFragment.newInstance();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fragment.setSharedElementEnterTransition(TransitionInflater.from(getContext()).inflateTransition(android.R.transition.move));
        }
        getFragmentManager().beginTransaction()
                .addSharedElement(lionImage, ViewCompat.getTransitionName(lionImage))
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

}