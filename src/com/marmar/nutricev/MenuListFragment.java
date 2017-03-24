package com.marmar.nutricev;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.marmar.nutricev.bd.DataBaseHelper;
import com.marmar.nutricev.bd.Menu;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MenuListFragment extends Fragment {

	public MenuListFragment() {
	}

	private UsersAdapterMenu ua;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		DataBaseHelper myDbHelper = new DataBaseHelper(getActivity());
		try {
			myDbHelper.createDataBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Menu> things = myDbHelper.getMenus();

		ua = new UsersAdapterMenu(getActivity(), (ArrayList<Menu>) things);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_list_menu,
				container, false);

		final ListView lv = (ListView) rootView.findViewById(R.id.listView_menus);
		lv.setAdapter(ua);
		
		return rootView;
	}
}

class UsersAdapterMenu extends ArrayAdapter<Menu> {
	public UsersAdapterMenu(Context context, ArrayList<Menu> users) {
		super(context, 0, users);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Get the data item for this position
		Menu user = getItem(position);
		// Check if an existing view is being reused, otherwise inflate the view
		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(
					R.layout.item_list, parent, false);
		}
		// Lookup view for data population
		TextView tvName = (TextView) convertView
				.findViewById(R.id.textView__li_comida);
		tvName.setText(user.getComida())
		;
		String s = diaSemana(user.getDia_semana());
		TextView day = (TextView) convertView
				.findViewById(R.id.textView_li_dia);
		day.setText(s);

		TextView cantidad = (TextView) convertView
				.findViewById(R.id.textView_li_cantidad);
		TextView medida = (TextView) convertView
				.findViewById(R.id.textView_li_medida);
		TextView nombre = (TextView) convertView
				.findViewById(R.id.textView_id_nombre);

		cantidad.setText(user.getCant_aceites());
		medida.setText(user.getId_aceites().getUnidad_medida());
		nombre.setText(user.getId_aceites().getNombre());

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		cantidad = (TextView) convertView.findViewById(R.id.textView_li_can_2);
		medida = (TextView) convertView.findViewById(R.id.textView_li_me_2);
		nombre = (TextView) convertView.findViewById(R.id.textView_li_nom_2);

		cantidad.setText(user.getCant_aoa());
		medida.setText(user.getId_aoa().getUnidad_medida());
		nombre.setText(user.getId_aoa().getNombre());

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		cantidad = (TextView) convertView.findViewById(R.id.textView_li_can_3);
		medida = (TextView) convertView.findViewById(R.id.textView_li_me_3);
		nombre = (TextView) convertView.findViewById(R.id.textView_li_nom_3);

		cantidad.setText(user.getCant_azucares());
		medida.setText(user.getId_azucares().getUnidad_medida());
		nombre.setText(user.getId_azucares().getNombre());

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		cantidad = (TextView) convertView.findViewById(R.id.textView_li_can_4);
		medida = (TextView) convertView.findViewById(R.id.textView_li_me_4);
		nombre = (TextView) convertView.findViewById(R.id.textView_li_nom_4);

		cantidad.setText(user.getCant_cereales());
		medida.setText(user.getId_cereales().getUnidad_medida());
		nombre.setText(user.getId_cereales().getNombre());

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		cantidad = (TextView) convertView.findViewById(R.id.textView_li_can_5);
		medida = (TextView) convertView.findViewById(R.id.textView_li_me_5);
		nombre = (TextView) convertView.findViewById(R.id.textView_li_nom_5);

		cantidad.setText(user.getCant_fruta());
		medida.setText(user.getId_frutas().getUnidad_medida());
		nombre.setText(user.getId_frutas().getNombre());

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		cantidad = (TextView) convertView.findViewById(R.id.textView_li_can_6);
		medida = (TextView) convertView.findViewById(R.id.textView_li_me_6);
		nombre = (TextView) convertView
				.findViewById(R.id.textView_li_nom_nom_6);

		cantidad.setText(user.getCant_lacteo());
		medida.setText(user.getId_lacteos().getUnidad_medida());
		nombre.setText(user.getId_lacteos().getNombre());

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		cantidad = (TextView) convertView.findViewById(R.id.textView_li_can_7);
		medida = (TextView) convertView.findViewById(R.id.textView_li_me_7);
		nombre = (TextView) convertView.findViewById(R.id.textView_li_nom_7);

		cantidad.setText(user.getCant_legumbres());
		medida.setText(user.getId_leguminosas().getUnidad_medida());
		nombre.setText(user.getId_leguminosas().getNombre());

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		cantidad = (TextView) convertView.findViewById(R.id.textView_li_can_8);
		medida = (TextView) convertView.findViewById(R.id.textView_li_me_8);
		nombre = (TextView) convertView.findViewById(R.id.textView_li_nom_8);

		cantidad.setText(user.getCant_verduras());
		medida.setText(user.getId_verduras().getUnidad_medida());
		nombre.setText(user.getId_verduras().getNombre());
		// Return the completed view to render on screen
		return convertView;
	}
	
	private String diaSemana(int d){
		String s = null;
		switch(d){
		case 1: s= "Lunes";
			break;
		case 2: s= "Martes";
			break;
		case 3:s= "Miercoles";
			break;
		case 4: s= "Jueves";
			break;
		case 5: s= "Viernes";
			break;
		case 6: s= "Sabado";
			break;
		case 7: s= "Domingo";
			break;
		}
		return s;
	}
}
