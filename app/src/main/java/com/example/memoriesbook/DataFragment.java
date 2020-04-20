package com.example.memoriesbook;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment {
    private TextView nama,noHp,alamat,desa,kec;
    private ImageView img;
    private Siswa siswa;
    private Bundle bundle;


    public DataFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();
        siswa = (Siswa) bundle.getSerializable("siswa1");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_data, container, false);
        nama=(TextView)view.findViewById(R.id.profil_nama);
        noHp=(TextView)view.findViewById(R.id.profil_noHp);
        alamat=(TextView)view.findViewById(R.id.profil_alamat);
        desa=(TextView)view.findViewById(R.id.profil_desa);
        kec=(TextView)view.findViewById(R.id.profil_kec);
        img=(ImageView)view.findViewById(R.id.profil_img);

        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        nama.setText(siswa.getNama());
        noHp.setText(siswa.getNo_hp());
        alamat.setText(siswa.getKampung());
        desa.setText(siswa.getDesa());
        kec.setText(siswa.getKecamatan());
        Picasso.with(getContext()).load(siswa.getFoto1()).into(img);
    }
}
