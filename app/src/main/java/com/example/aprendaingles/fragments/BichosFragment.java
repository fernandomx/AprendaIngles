package com.example.aprendaingles.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BichosFragment extends Fragment implements View.OnClickListener   {

    private ImageButton ButtonCao, ButtonGato, ButtonLeao, ButtonMacaco,ButtonOvelha, ButtonVaca;
    private MediaPlayer mediaPlayer;


    public BichosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_bichos, container, false);

        ButtonCao = view.findViewById(R.id.ButtonCao);
        ButtonGato = view.findViewById(R.id.ButtonGato);
        ButtonLeao = view.findViewById(R.id.ButtonLeao);
        ButtonMacaco = view.findViewById(R.id.ButtonMacaco);
        ButtonOvelha = view.findViewById(R.id.ButtonOvelha);
        ButtonVaca = view.findViewById(R.id.ButtonVaca);

        ButtonCao.setOnClickListener(this);
        ButtonGato.setOnClickListener(this);
        ButtonLeao.setOnClickListener(this);
        ButtonMacaco.setOnClickListener(this);
        ButtonOvelha.setOnClickListener(this);
        ButtonVaca.setOnClickListener(this);


        return  view;
    }

    @Override
    public void onClick(View v) {

        //Log.i("Elemento clicado","Item" + v.getId()); habilita log

        switch (v.getId()){
            case R.id.ButtonCao:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.dog);
                tocarSom();
                break;

            case R.id.ButtonGato:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.cat);
                tocarSom();
                break;

            case R.id.ButtonLeao:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lion);
                tocarSom();
                break;

            case R.id.ButtonMacaco:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.monkey);
                tocarSom();
                break;
            case R.id.ButtonOvelha:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.sheep);
                tocarSom();
                break;
            case R.id.ButtonVaca:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.cow);
                tocarSom();
                break;

        }

    }

    public void tocarSom(){
        if (mediaPlayer != null) {
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.release();
                }
            });
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }

    }


}


