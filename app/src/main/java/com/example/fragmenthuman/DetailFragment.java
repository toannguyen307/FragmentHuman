package com.example.fragmenthuman;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DetailFragment extends Fragment {
    private static final String ARG_PARAM = "param";

    private TextView txtName,txtAge;
    private Button btnDel;
    private OnReceiveHuman onReceiveHuman;

    // TODO: Rename and change types of parameters
    private Human mParam;

    public DetailFragment() {
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (getActivity() != null) {
            onReceiveHuman = (OnReceiveHuman) getActivity();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getParcelable("human");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtName = view.findViewById(R.id.textView_name);
        txtAge = view.findViewById(R.id.textView_age);
        btnDel = view.findViewById(R.id.button_delete);

        txtName.setText("Ho Ten: " + mParam.getName());
        txtAge.setText("Tuoi: " + mParam.getAge());

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ListFragment.getInstance().deleteHuman(mParam);
                onReceiveHuman.receive(mParam.getId());
                getActivity().getSupportFragmentManager().popBackStack();

            }
        });
    }

}