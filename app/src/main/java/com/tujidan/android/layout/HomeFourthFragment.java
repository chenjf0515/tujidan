package com.tujidan.android.layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tujidan.android.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFourthFragment extends Fragment {


    public HomeFourthFragment() {
        // Required empty public constructor
    }
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    public static HomeFifthFragment newInstance(String param1) {
        HomeFifthFragment fragment = new HomeFifthFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_fourth, container, false);
        return view;
    }

}
