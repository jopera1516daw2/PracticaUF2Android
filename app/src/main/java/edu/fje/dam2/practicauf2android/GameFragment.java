package edu.fje.dam2.practicauf2android;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class GameFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View op = inflater.inflate(R.layout.fragment_options, container, false);
        op.setClickable(false);

        return inflater.inflate(R.layout.fragment_game, container, false);
    }
}
