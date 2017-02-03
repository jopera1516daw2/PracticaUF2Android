package edu.fje.dam2.practicauf2android;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;


public class PrincipalFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_principal, container, false);

        view.setClickable(true);

        Button btnNewGame=(Button)view.findViewById(R.id.button);
        btnNewGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.add(R.id.principalFragment, new GameFragment(), "TAG_GAME");
            transaction.commit();
            }
        });

        Button btnOptions=(Button)view.findViewById(R.id.button2);
        btnOptions.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.add(R.id.principalFragment, new OptionsFragment(), "TAG_OPTIONS");
            transaction.commit();
            }
        });

        return view;
    }
}
