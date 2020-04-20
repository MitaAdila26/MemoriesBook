package com.example.memoriesbook;


import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class FotoFragment extends Fragment {
    private ImageButton img1,img2,img3,img4,img5,img6;
    private Siswa siswa;
    private Bundle bundle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle=getArguments();
        siswa= (Siswa) bundle.getSerializable("siswa3");
    }

    public FotoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_foto, container, false);
        img1=(ImageButton) view.findViewById(R.id.imgView1);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder=new AlertDialog.Builder(getActivity());
                View view1=getLayoutInflater().inflate(R.layout.dialog_custom_layout,null);
                PhotoView photoView=view1.findViewById(R.id.imgView);
                Picasso.with(getContext()).load(siswa.getFoto1()).into(photoView);
                mBuilder.setView(view1);
                AlertDialog mDialog=mBuilder.create();
                mDialog.show();
            }
        });

        img2=(ImageButton) view.findViewById(R.id.imgView2);
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder=new AlertDialog.Builder(getActivity());
                View view1=getLayoutInflater().inflate(R.layout.dialog_custom_layout,null);
                PhotoView photoView=view1.findViewById(R.id.imgView);
                Picasso.with(getContext()).load(siswa.getFoto2()).into(photoView);
                mBuilder.setView(view1);
                AlertDialog mDialog=mBuilder.create();
                mDialog.show();

            }
        });

        img3=(ImageButton) view.findViewById(R.id.imgView3);
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder=new AlertDialog.Builder(getActivity());
                View view1=getLayoutInflater().inflate(R.layout.dialog_custom_layout,null);
                PhotoView photoView=view1.findViewById(R.id.imgView);
                Picasso.with(getContext()).load(siswa.getFoto3()).into(photoView);
                mBuilder.setView(view1);
                AlertDialog mDialog=mBuilder.create();
                mDialog.show();
            }
        });

        img4=(ImageButton) view.findViewById(R.id.imgView4);
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder=new AlertDialog.Builder(getActivity());
                View view1=getLayoutInflater().inflate(R.layout.dialog_custom_layout,null);
                PhotoView photoView=view1.findViewById(R.id.imgView);
                Picasso.with(getContext()).load(siswa.getFoto4()).into(photoView);
                mBuilder.setView(view1);
                AlertDialog mDialog=mBuilder.create();
                mDialog.show();
            }
        });

        img5=(ImageButton) view.findViewById(R.id.imgView5);
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder=new AlertDialog.Builder(getActivity());
                View view1=getLayoutInflater().inflate(R.layout.dialog_custom_layout,null);
                PhotoView photoView=view1.findViewById(R.id.imgView);
                Picasso.with(getContext()).load(siswa.getFoto5()).into(photoView);
                mBuilder.setView(view1);
                AlertDialog mDialog=mBuilder.create();
                mDialog.show();
            }
        });

        img6=(ImageButton) view.findViewById(R.id.imgView6);
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder=new AlertDialog.Builder(getActivity());
                View view1=getLayoutInflater().inflate(R.layout.dialog_custom_layout,null);
                PhotoView photoView=view1.findViewById(R.id.imgView);
                Picasso.with(getContext()).load(siswa.getFoto6()).into(photoView);
                mBuilder.setView(view1);
                AlertDialog mDialog=mBuilder.create();
                mDialog.show();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Picasso.with(getContext()).load(siswa.getFoto1()).into(img1);
        Picasso.with(getContext()).load(siswa.getFoto2()).into(img2);
        Picasso.with(getContext()).load(siswa.getFoto3()).into(img3);
        Picasso.with(getContext()).load(siswa.getFoto4()).into(img4);
        Picasso.with(getContext()).load(siswa.getFoto5()).into(img5);
        Picasso.with(getContext()).load(siswa.getFoto6()).into(img6);
    }
}
