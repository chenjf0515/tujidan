package com.tujidan.android.layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tujidan.android.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFirstFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";


    private String mParam1;



    public FirstFirstFragment() {
        // Required empty public constructor
    }

    /**
     * @param param1 Parameter 1.
     * @return A new instance of fragment FirstFirstFragment.
     */
    public static FirstFirstFragment newInstance(String param1) {
        FirstFirstFragment fragment = new FirstFirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first_first, container, false);
        TextView textView= (TextView) view.findViewById(R.id.first_view);
        textView.setText(mParam1);
        return view;
    }

}
