package com.marmar.nutricev;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.marmar.nutricev.bd.Alimento;
import com.marmar.nutricev.bd.DataBaseHelper;
import com.marmar.nutricev.bd.Menu;

public class AlimentosFragment extends Fragment {

	private final MainActivity ma;
	
	private UsersAdapter ua_lactios;
	private UsersAdapter ua_frutas;
	private UsersAdapter ua_verduras;
	private UsersAdapter ua_asg;
//	private UsersAdapter ua_acg;
	private UsersAdapter ua_legumbres;
	private UsersAdapter ua_csg;
//	private UsersAdapter ua_ccg;
	private UsersAdapter ua_aoa_mp;
//	private UsersAdapter ua_aoa_p;
	private UsersAdapter ua_ag_cp;
//	private UsersAdapter ua_ag_sp;
//
	public AlimentosFragment(MainActivity ma) {
		this.ma = ma;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		DataBaseHelper myDbHelper = new DataBaseHelper(getActivity());
		try {
			myDbHelper.createDataBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.err.println("Error: "+e);
		}

		List<Alimento> things = myDbHelper.getAlimentosDeTabla("lacteos");
		ua_lactios = new UsersAdapter(getActivity(),
				(ArrayList<Alimento>) things);
//		ua_lactios.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		things = myDbHelper.getAlimentosDeTabla("frutas");
		ua_frutas = new UsersAdapter(getActivity(),
				(ArrayList<Alimento>) things);

		things = myDbHelper.getAlimentosDeTabla("verduras");
		ua_verduras = new UsersAdapter(getActivity(),
				(ArrayList<Alimento>) things);

		things = myDbHelper.getAlimentosDeTabla("azucares");
		ua_asg = new UsersAdapter(getActivity(), (ArrayList<Alimento>) things);

//		things = myDbHelper.getAlimentosDeTabla("azucares");
//		ua_acg = new UsersAdapter(getActivity(), (ArrayList<Alimento>) things);

		things = myDbHelper.getAlimentosDeTabla("leguminosas");
		ua_legumbres = new UsersAdapter(getActivity(),
				(ArrayList<Alimento>) things);

		things = myDbHelper.getAlimentosDeTabla("cereales");
		ua_csg = new UsersAdapter(getActivity(), (ArrayList<Alimento>) things);

//		things = myDbHelper.getAlimentosDeTabla("cereales");
//		ua_ccg = new UsersAdapter(getActivity(), (ArrayList<Alimento>) things);

		things = myDbHelper.getAlimentosDeTabla("aoa");
		ua_aoa_mp = new UsersAdapter(getActivity(),
				(ArrayList<Alimento>) things);

//		things = myDbHelper.getAlimentosDeTabla("aoa");
//		ua_aoa_p = new UsersAdapter(getActivity(), (ArrayList<Alimento>) things);

		things = myDbHelper.getAlimentosDeTabla("aceites");
		ua_ag_cp = new UsersAdapter(getActivity(), (ArrayList<Alimento>) things);

//		things = myDbHelper.getAlimentosDeTabla("aceites");
//		ua_ag_sp = new UsersAdapter(getActivity(), (ArrayList<Alimento>) things);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		final View rootView = inflater.inflate(R.layout.fragment_alimentos,
				container, false);

		final Spinner sp_l = (Spinner) rootView.findViewById(R.id.spin_lactios);
		sp_l.setAdapter(ua_lactios);

		final Spinner sp_f = (Spinner) rootView.findViewById(R.id.spin_frutas);
		sp_f.setAdapter(ua_frutas);

		final Spinner sp_v = (Spinner) rootView.findViewById(R.id.spin_verduras);
		sp_v.setAdapter(ua_verduras);

		final Spinner sp_az = (Spinner) rootView.findViewById(R.id.spin_asg);
		sp_az.setAdapter(ua_asg);

//		sp = (Spinner) rootView.findViewById(R.id.spin_acg);
//		sp.setAdapter(ua_acg);

		final Spinner sp_le = (Spinner) rootView.findViewById(R.id.spin_legumbres);
		sp_le.setAdapter(ua_legumbres);

		final Spinner sp_cer = (Spinner) rootView.findViewById(R.id.spin_csg);
		sp_cer.setAdapter(ua_csg);

//		sp = (Spinner) rootView.findViewById(R.id.spin_ccg);
//		sp.setAdapter(ua_ccg);

		final Spinner sp_aoa = (Spinner) rootView.findViewById(R.id.spin_aoa_muy_poca);
		sp_aoa.setAdapter(ua_aoa_mp);

//		sp = (Spinner) rootView.findViewById(R.id.spin_aoa_poca);
//		sp.setAdapter(ua_aoa_p);

		final Spinner sp_acei = (Spinner) rootView.findViewById(R.id.spin_ag_cp);
		sp_acei.setAdapter(ua_ag_cp);

//		sp = (Spinner) rootView.findViewById(R.id.spin_ag_sp);
//		sp.setAdapter(ua_ag_sp);
		
		final Context con = getActivity();
		
		Button b_almacenar = (Button) rootView.findViewById(R.id.button_almacenar_menu);
		//TODO
		b_almacenar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Menu m = new Menu();
				m.setId_lacteos((Alimento) sp_l.getSelectedItem());
				m.setId_aceites((Alimento) sp_acei.getSelectedItem());
				m.setId_aoa((Alimento) sp_aoa.getSelectedItem());
				m.setId_azucares((Alimento) sp_az.getSelectedItem());
				m.setId_cereales((Alimento) sp_cer.getSelectedItem());
				m.setId_frutas((Alimento) sp_f.getSelectedItem());
				m.setId_leguminosas((Alimento) sp_le.getSelectedItem());
				m.setId_verduras((Alimento) sp_v.getSelectedItem());
				
				Calendar c = Calendar.getInstance();
				m.setAnyo(c.get(Calendar.YEAR));
				m.setMes(c.get(Calendar.MONTH+1));
				m.setDia(c.get(Calendar.DAY_OF_MONTH));
				m.setDia_semana(c.get(Calendar.DAY_OF_WEEK));
				
				RadioGroup rg = (RadioGroup) rootView.findViewById(R.id.radioGroup1);
				RadioButton rb = (RadioButton)rootView.findViewById(rg.getCheckedRadioButtonId());
				String radiovalue=  rb.getText().toString(); 
				m.setComida(radiovalue);
				
				RadioGroup rg2 = (RadioGroup) rootView.findViewById(R.id.radioGroup2);
				RadioButton rb2 = (RadioButton)rootView.findViewById(rg2.getCheckedRadioButtonId());
				String radiovalue2=  rb2.getText().toString(); 
				m.setDia_semana(diaSemana(radiovalue2));
				
				EditText 
				tv = (EditText) rootView.findViewById(R.id.EditText_ver);
				m.setCant_verduras(tv.getText().toString());
				
				tv = (EditText) rootView.findViewById(R.id.EditText_acei);
				m.setCant_aceites(tv.getText().toString());
				
				tv = (EditText) rootView.findViewById(R.id.EditText_aoa);
				m.setCant_aoa(tv.getText().toString());
				
				tv = (EditText) rootView.findViewById(R.id.EditText_az);
				m.setCant_azucares(tv.getText().toString());
				
				tv = (EditText) rootView.findViewById(R.id.EditText_cer);
				m.setCant_cereales(tv.getText().toString());
				
				tv = (EditText) rootView.findViewById(R.id.EditText_fru);
				m.setCant_fruta(tv.getText().toString());
				
				tv = (EditText) rootView.findViewById(R.id.EditText_legu);
				m.setCant_legumbres(tv.getText().toString());
				
				tv = (EditText) rootView.findViewById(R.id.editText_lac);
				m.setCant_lacteo(tv.getText().toString());
				
				
				
				DataBaseHelper db = new DataBaseHelper(getActivity())
				;
				db.addMenu(m);
				
				Toast.makeText(con, "Se guardo el Menu", Toast.LENGTH_LONG).show();
			}
		});
		
	
		
		Button b_reporte = (Button) rootView.findViewById(R.id.button_reporte_menu);
		b_reporte.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ma.displayView(12);
			}
		});
		
		//button_borrar_todos_menus
		Button b_borrar = (Button) rootView.findViewById(R.id.button_borrar_todos_menus);
		b_borrar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DataBaseHelper myDbHelper = new DataBaseHelper(getActivity());
				myDbHelper.borrarTodosMenus();
				Toast.makeText(con, "Se borraron los Reportes de Menu", Toast.LENGTH_LONG).show();
			}
		});

		return rootView;
	}
	
	private int diaSemana(String d){
		if(d.equalsIgnoreCase("Lunes")){
			return 1;
		}
		if(d.equalsIgnoreCase("Martes")){
			return 2;
		}
		if(d.equalsIgnoreCase("Miercoles")){
			return 3;
		}
		if(d.equalsIgnoreCase("Jueves")){
			return 4;
		}
		if(d.equalsIgnoreCase("Viernes")){
			return 5;
		}
		if(d.equalsIgnoreCase("Sabado")){
			return 6;
		}
		if(d.equalsIgnoreCase("Domingo")){
			return 7;
		}
		return 1;
	}
}

class UsersAdapter extends ArrayAdapter<Alimento> {
	public UsersAdapter(Context context, ArrayList<Alimento> users) {
		super(context, 0, users);
		this.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Get the data item for this position
		Alimento user = getItem(position);
		// Check if an existing view is being reused, otherwise inflate the view
		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(
					R.layout.spinner_item, parent, false);
		}
		// Lookup view for data population
		TextView tvName = (TextView) convertView
				.findViewById(R.id.textView_al_nombre);
		TextView tvMedida = (TextView) convertView
				.findViewById(R.id.textView_al_medida);
		// Populate the data into the template view using the data object
		tvName.setText(user.getNombre());
		tvMedida.setText(user.getUnidad_medida());
		// Return the completed view to render on screen
		return convertView;
	}
}