package com.tujidan.android.layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tujidan.android.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFifthFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFifthFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";




    public HomeFifthFragment() {
        // Required empty public constructor
    }

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_fifth, container, false);
    }

}
