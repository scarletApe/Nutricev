package com.marmar.nutricev;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marmar.nutricev.tabla.TableMainLayout;

public class TablaFragment extends Fragment {
	
	public TablaFragment(){
		
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
//        View rootView = inflater.inflate(R.layout.fragment_alimentos, container, false);
        
        View rootView = new TableMainLayout(getActivity(), getActivity());
         
        return rootView;
    }
}
