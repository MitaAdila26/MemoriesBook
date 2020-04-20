package com.example.memoriesbook;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.lang.reflect.Member;


/**
 * A simple {@link Fragment} subclass.
 */
public class KenanganFragment extends Fragment {
    private TextView pesan, kesan;
    private Siswa siswa;
    private Bundle bundle;

    public KenanganFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();
        siswa = (Siswa) bundle.getSerializable("siswa2");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kenangan, container, false);
        pesan=(TextView)view.findViewById(R.id.txt_pesan);
        kesan=(TextView)view.findViewById(R.id.txt_kesan);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pesan.setText(siswa.getPesan());
        kesan.setText(siswa.getKesan());
    }
}
