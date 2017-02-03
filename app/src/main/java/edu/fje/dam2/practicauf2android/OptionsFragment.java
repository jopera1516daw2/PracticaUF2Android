package edu.fje.dam2.practicauf2android;

import android.app.FragmentManager;
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

public class OptionsFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_options, container, false);
        view.setClickable(true);

        Button btnReturn = (Button) view.findViewById(R.id.btReturn);
        btnReturn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Fragment frag = manager.findFragmentByTag("TAG_OPTIONS");
                if (frag != null)
                    transaction.remove(frag);

                final Fragment fragPrin =  getFragmentManager().findFragmentByTag("TAG_PRINCIPAL");
                try {
                    if (fragPrin != null && fragPrin.isVisible()) {
                        transaction.replace(R.id.principalFragment, new PrincipalFragment());
                        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        transaction.commit();
                    }else{
                        Fragment fragO = manager.findFragmentByTag("TAG_OPTIONS");
                        if (fragO != null)
                            transaction.remove(fragO);
                        transaction.commit();
                    }
                }catch (Exception e){
                    transaction.commit();
                }
            }
        });

        CheckBox cbMusic= ( CheckBox ) view.findViewById( R.id.cbMusic);
        PrincipalActivity p = (PrincipalActivity) getActivity();
        if(p.isMyServiceRunning(BackgroundSoundService.class)){
            cbMusic.setChecked(true);
        }else{
            cbMusic.setChecked(false);
        }
        cbMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    getActivity().startService(new Intent(getActivity(), BackgroundSoundService.class));
                }else{
                    getActivity().stopService(new Intent(getActivity(), BackgroundSoundService.class));
                }
            }
        });

        CheckBox cbSound= ( CheckBox ) view.findViewById( R.id.cbSound);
        cbSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                }else{
                }
            }
        });

        return view;
    }
}
