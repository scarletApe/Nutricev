package com.marmar.nutricev;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GEByETAFragment extends Fragment {
	
	public GEByETAFragment(){}
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_geb_y_eta, container, false);
         
        return rootView;
    }
}
