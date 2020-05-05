package com.example.aprendaingles.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumerosFragment extends Fragment implements View.OnClickListener {


    private ImageButton ButtonUm, ButtonDois, ButtonTres, ButtonQuatro, ButtonCinco, ButtonSeis;
    private MediaPlayer mediaPlayer;


    public NumerosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);

        ButtonUm = view.findViewById(R.id.ButtonUm);
        ButtonDois = view.findViewById(R.id.ButtonDois);
        ButtonTres = view.findViewById(R.id.ButtonTres);
        ButtonQuatro = view.findViewById(R.id.ButtonQuatro);
        ButtonCinco = view.findViewById(R.id.ButtonCinco);
        ButtonSeis = view.findViewById(R.id.ButtonSeis);

        ButtonUm.setOnClickListener(this);
        ButtonDois.setOnClickListener(this);
        ButtonTres.setOnClickListener(this);
        ButtonQuatro.setOnClickListener(this);
        ButtonCinco.setOnClickListener(this);
        ButtonSeis.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {

        //Log.i("Elemento clicado","Item" + v.getId()); habilita log

        switch (v.getId()) {
            case R.id.ButtonUm:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.one);
                tocarSom();
                break;

            case R.id.ButtonDois:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.two);
                tocarSom();
                break;

            case R.id.ButtonTres:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.three);
                tocarSom();
                break;

            case R.id.ButtonQuatro:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.four);
                tocarSom();
                break;
            case R.id.ButtonCinco:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.five);
                tocarSom();
                break;
            case R.id.ButtonSeis:
                mediaPlayer = MediaPlayer.create(getActivity(), R.raw.six);
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

