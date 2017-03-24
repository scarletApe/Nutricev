package com.marmar.nutricev;

import java.text.DecimalFormat;
import java.util.ArrayList;

import com.marmar.nutricev.adapter.NavDrawerListAdapter;
import com.marmar.nutricev.model.Individuo;
import com.marmar.nutricev.model.NavDrawerItem;
import com.marmar.nutricev.model.Populatable;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	// nav drawer title
	private CharSequence mDrawerTitle;

	// used to store app title
	private CharSequence mTitle;

	// slide menu items
	private String[] navMenuTitles;
	private TypedArray navMenuIcons;

	private ArrayList<NavDrawerItem> navDrawerItems;
	private NavDrawerListAdapter adapter;

	private DecimalFormat df = new DecimalFormat("00.00");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTitle = mDrawerTitle = getTitle();

		// load slide menu items
		navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

		// nav drawer icons from resources
		navMenuIcons = getResources()
				.obtainTypedArray(R.array.nav_drawer_icons);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

		navDrawerItems = new ArrayList<NavDrawerItem>();

		// adding nav drawer items to array
		// Home
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons
				.getResourceId(0, -1)));
		// Find People
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons
				.getResourceId(1, -1)));
		// Photos
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons
				.getResourceId(2, -1)));
		// Communities, Will add a counter here
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons
				.getResourceId(3, -1)));
		// Pages
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons
				.getResourceId(4, -1)));
		// What's hot, We will add a counter here
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons
				.getResourceId(5, -1)));

		// Photos
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[6], navMenuIcons
				.getResourceId(6, -1)));
		// Communities, Will add a counter here
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[7], navMenuIcons
				.getResourceId(7, -1)));
		// Pages
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[8], navMenuIcons
				.getResourceId(8, -1)));
		// Communities, Will add a counter here
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[9], navMenuIcons
				.getResourceId(9, -1)));
		// Pages
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[10], navMenuIcons
				.getResourceId(10, -1)));
		// What's hot, We will add a counter here
		navDrawerItems.add(new NavDrawerItem(navMenuTitles[11], navMenuIcons
				.getResourceId(11, -1)));

		// Recycle the typed array
		navMenuIcons.recycle();

		mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

		// setting the nav drawer list adapter
		adapter = new NavDrawerListAdapter(getApplicationContext(),
				navDrawerItems);
		mDrawerList.setAdapter(adapter);

		// enabling action bar app icon and behaving it as toggle button
		getActionBar().setDisplayHomeAsUpEnabled(true);
		// getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, // nav menu toggle icon
				R.string.app_name, // nav drawer open - description for
									// accessibility
				R.string.app_name // nav drawer close - description for
									// accessibility
		) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				// calling onPrepareOptionsMenu() to show action bar icons
				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				// calling onPrepareOptionsMenu() to hide action bar icons
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			// on first time display view for first nav item
			displayView(0);
		}

		// try to change the action bar color
		ActionBar actionBar;
		actionBar = getActionBar();
		ColorDrawable colorDrawable = new ColorDrawable(
				Color.parseColor("#74549c"));
		actionBar.setBackgroundDrawable(colorDrawable);
		// actionBar.

		int titleId = getResources().getIdentifier("action_bar_title", "id",
				"android");
		TextView abTitle = (TextView) findViewById(titleId);
		abTitle.setTextColor(Color.WHITE);
	}

	/**
	 * Slide menu item click listener
	 * */
	private class SlideMenuClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// display view for selected nav drawer item
			displayView(position);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// toggle nav drawer on selecting action bar app icon/title
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action bar actions click
		switch (item.getItemId()) {
		case R.id.action_settings:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/* *
	 * Called when invalidateOptionsMenu() is triggered
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if nav drawer is opened, hide the action items
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	/**
	 * Diplaying fragment view for selected nav drawer list item
	 * */
	public void displayView(int position) {
		// update the main content by replacing fragments
		Fragment fragment = null;
		switch (position) {
		case 0:
			fragment = new HomeFragment();
			break;
		case 1:
			fragment = new IMCFragment();
			break;
		case 2:
			fragment = new PesoIdealFragment(this);
			break;
		case 3:
			fragment = new PesoCorregidoFragment();
			break;
		case 4:
			fragment = new GEBFragment();
			break;
		case 5:
			fragment = new GEByETAFragment();
			break;
		case 6:
			fragment = new ActividadFisicaFragment();
			break;
		case 7:
			fragment = new GETFragment();
			break;
		case 8:
			fragment = new AlimentosFragment(this);
			break;
		case 9:
			fragment = new TablaFragment();
			break;
		case 10:
			fragment = new CreditosFragment();
			break;
		case 11:
			System.exit(0);
			break;
			
		case 12:
			fragment = new MenuListFragment();
			break;

		default:
			break;
		}

		if (fragment != null) {
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction()
					.replace(R.id.frame_container, fragment).commit();

			if(position == 12){
				position = 8;
			}
			// update selected item and title, then close the drawer
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(navMenuTitles[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
			

			if (fragment instanceof Populatable) {
				Populatable p = (Populatable) fragment;
				p.populate(this);

			}
		} else {
			// error in creating fragment
			Log.e("MainActivity", "Error in creating fragment");
		}
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	public void calcularIMC(View v) {
		// v.
		EditText tePA = (EditText) this.findViewById(R.id.editText_PA_IMC);
		EditText teTalla = (EditText) this
				.findViewById(R.id.editText_Talla_IMC);

		double pa = Double.parseDouble(tePA.getText().toString());
		double talla = Double.parseDouble(teTalla.getText().toString());

		double imc = pa / (talla * talla);

		EditText teIMC = (EditText) this.findViewById(R.id.editTextResultado);
		teIMC.setText(df.format(imc) + "");

		Individuo in = Individuo.getInstance();
		in.setPeso(pa);
		in.setTalla(talla);
		in.setImc(imc);
	}

	public void calcularPesoIdeal(View v) {
		EditText teTalla = (EditText) this.findViewById(R.id.editText_Talla_PI);
		double talla = Double.parseDouble(teTalla.getText().toString());

		double pi = 50 + 0.75 * (talla - 150);

		EditText teIMC = (EditText) this.findViewById(R.id.editText_Result_PI);
		teIMC.setText(df.format(pi) + "");
	}

	public void calcularPesoCorregido(View v) {
		EditText te_pa = (EditText) this.findViewById(R.id.editText_PA_PC);
		EditText te_pi = (EditText) this.findViewById(R.id.editText_PI_PC);

		double pa = Double.parseDouble(te_pa.getText().toString());
		double pi = Double.parseDouble(te_pi.getText().toString());

		double pc = ((pa - pi) * 0.25) + pi;

		EditText teIMC = (EditText) this
				.findViewById(R.id.editText_Resultado_PC);
		teIMC.setText(df.format(pc) + "");
	}

	public void calcularGEBHombre(View v) {
		EditText te_pa = (EditText) this.findViewById(R.id.editText_PA_GEB);
		EditText te_talla = (EditText) this
				.findViewById(R.id.editText_Talla_GEB);
		EditText te_edad = (EditText) this.findViewById(R.id.editText_Edad_GEB);

		double pa = Double.parseDouble(te_pa.getText().toString());
		double talla = Double.parseDouble(te_talla.getText().toString());
		double edad = Double.parseDouble(te_edad.getText().toString());

		double geb = 66.47 + (13.75 * pa) + (5 * talla * 100) - (6.75 * edad);

		EditText teIMC = (EditText) this
				.findViewById(R.id.editText_Resultado_GEB);

		teIMC.setText(df.format(geb) + "");
	}

	public void calcularGEBMujer(View v) {
		EditText te_pa = (EditText) this.findViewById(R.id.editText_PA_GEB);
		EditText te_talla = (EditText) this
				.findViewById(R.id.editText_Talla_GEB);
		EditText te_edad = (EditText) this.findViewById(R.id.editText_Edad_GEB);

		double pa = Double.parseDouble(te_pa.getText().toString());
		double talla = Double.parseDouble(te_talla.getText().toString());
		double edad = Double.parseDouble(te_edad.getText().toString());

		double geb = 66.5 + (9.56 * pa) + (1.85 * talla * 100) - (4.68 * edad);

		EditText teIMC = (EditText) this
				.findViewById(R.id.editText_Resultado_GEB);
		teIMC.setText(df.format(geb) + "");
	}

	public void calcularGEBETA(View v) {
		EditText te_geb = (EditText) this
				.findViewById(R.id.editText_GEB_GEBETA);
		EditText te_eta = (EditText) this
				.findViewById(R.id.editText_ETA_GBAETA);

		double geb = Double.parseDouble(te_geb.getText().toString());
		double eta = Double.parseDouble(te_eta.getText().toString());

		double res = geb * eta / 100;

		EditText teIMC = (EditText) this
				.findViewById(R.id.editText_Resultado_GEBETA);
		teIMC.setText(df.format(res) + "");
	}

	public void calcularActividadFisica(View v) {
		EditText te_af = (EditText) this.findViewById(R.id.editText_AF_AF);
		EditText te_eta = (EditText) this.findViewById(R.id.editText_ETA_AF);

		double af = Double.parseDouble(te_af.getText().toString());
		double geb = Double.parseDouble(te_eta.getText().toString());

		double res = geb * af;

		EditText teIMC = (EditText) this
				.findViewById(R.id.editText_Resultado_AF);
		teIMC.setText(df.format(res) + "");
	}
	
	public void calcularGET(View v) {
		EditText te_geb = (EditText) this
				.findViewById(R.id.editText_GEB_GET);
		EditText te_eta = (EditText) this
				.findViewById(R.id.editText_ETA_GET);
		EditText te_af = (EditText) this
				.findViewById(R.id.editText_AF_GET);

		double geb = Double.parseDouble(te_geb.getText().toString());
		double eta = Double.parseDouble(te_eta.getText().toString());
		double af = Double.parseDouble(te_af.getText().toString());

		double res = geb + eta + af;

		EditText teIMC = (EditText) this
				.findViewById(R.id.editText_Resultado_GET);
		teIMC.setText(df.format(res) + "");
	}
}
