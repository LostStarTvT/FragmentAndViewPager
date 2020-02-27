package com.proposeme.fragmentandviewpager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class ThirdFragment extends Fragment {
    private static final String TAG = "SecondFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater
                .inflate(R.layout.fragment_third, container, false);

        Button btn = (Button) view.findViewById(R.id.btn);

//        btn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                FragmentTransaction trans = getFragmentManager()
//                        .beginTransaction();
//                trans.replace(R.id.root_frame, new StaticFragment());
//                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//                trans.addToBackStack(null);
//                trans.commit();
//            }
//        });

        return view;
    }
}
