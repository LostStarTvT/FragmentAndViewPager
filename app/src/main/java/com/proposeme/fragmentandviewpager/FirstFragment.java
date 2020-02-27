package com.proposeme.fragmentandviewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class FirstFragment extends Fragment {
    private static final String TAG = "FirstFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        Button btn = (Button) view.findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                FragmentTransaction trans = getFragmentManager()
//                        .beginTransaction();
//                /*
//                 * IMPORTANT: We use the "root frame" defined in
//                 * "root_fragment.xml" as the reference to replace fragment
//                 */
//                trans.replace(R.id.fragment_second, new SecondFragment());
//
//                /*
//                 * IMPORTANT: The following lines allow us to add the fragment
//                 * to the stack and return to it later, by pressing back
//                 */
//                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//                trans.addToBackStack(null);
//
//                trans.commit();
            }
        });

        return view;
    }

}
