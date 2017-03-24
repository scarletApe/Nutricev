package com.marmar.nutricev;

import com.marmar.nutricev.model.Individuo;
import com.marmar.nutricev.model.Populatable;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class PesoIdealFragment extends Fragment implements Populatable {
	
	Activity a;
	public PesoIdealFragment(Activity a){
		this.a = a;
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_peso_ideal, container, false);
//        rootView.get
        return rootView;
    }
	
	public void populate(Activity a){
		EditText teTalla = (EditText) a.findViewById(R.id.editText_Talla_PI);
		if(teTalla != null)
        teTalla.setText(Individuo.getInstance().getTalla()+"");
	}
}
