package com.marmar.nutricev;

//import edu.uaz.poo2.clienteandroidescolares.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class IMCFragment extends Fragment {

	public IMCFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_imc, container,
				false);

		return rootView;
	}

}
