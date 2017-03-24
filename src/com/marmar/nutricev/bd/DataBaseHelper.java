package com.marmar.nutricev.bd;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

	// The Android's default system path of your application database.
	private static String DB_PATH = "/data/data/com.marmar.nutricev/databases/";

	private static String DB_NAME = "nutriologo.db";

	private SQLiteDatabase myDataBase;

	private final Context myContext;

	/**
	 * Constructor Takes and keeps a reference of the passed context in order to
	 * access to the application assets and resources.
	 * 
	 * @param context
	 */
	public DataBaseHelper(Context context) {

		super(context, DB_NAME, null, 1);
		this.myContext = context;
	}

	/**
	 * Creates a empty database on the system and rewrites it with your own
	 * database.
	 * */
	public void createDataBase() throws IOException {

		boolean dbExist = checkDataBase();

		if (dbExist) {
			// do nothing - database already exist
		} else {

			// By calling this method and empty database will be created into
			// the default system path
			// of your application so we are gonna be able to overwrite that
			// database with our database.
			this.getReadableDatabase();

			try {

				copyDataBase();

			} catch (IOException e) {

				throw new Error("Error copying database");

			}
		}

	}

	/**
	 * Check if the database already exist to avoid re-copying the file each
	 * time you open the application.
	 * 
	 * @return true if it exists, false if it doesn't
	 */
	private boolean checkDataBase() {

		SQLiteDatabase checkDB = null;

		try {
			String myPath = DB_PATH + DB_NAME;
			checkDB = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READONLY);

		} catch (SQLiteException e) {

			// database does't exist yet.

		}

		if (checkDB != null) {

			checkDB.close();

		}

		return checkDB != null ? true : false;
	}

	/**
	 * Copies your database from your local assets-folder to the just created
	 * empty database in the system folder, from where it can be accessed and
	 * handled. This is done by transfering bytestream.
	 * */
	private void copyDataBase() throws IOException {

		// Open your local db as the input stream
		InputStream myInput = myContext.getAssets().open(DB_NAME);

		// Path to the just created empty db
		String outFileName = DB_PATH + DB_NAME;

		// Open the empty db as the output stream
		OutputStream myOutput = new FileOutputStream(outFileName);

		// transfer bytes from the inputfile to the outputfile
		byte[] buffer = new byte[1024];
		int length;
		while ((length = myInput.read(buffer)) > 0) {
			myOutput.write(buffer, 0, length);
		}

		// Close the streams
		myOutput.flush();
		myOutput.close();
		myInput.close();

	}

	public void openDataBase() throws SQLException {

		// Open the database
		String myPath = DB_PATH + DB_NAME;
		myDataBase = SQLiteDatabase.openDatabase(myPath, null,
				SQLiteDatabase.OPEN_READONLY);

	}

	@Override
	public synchronized void close() {

		if (myDataBase != null)
			myDataBase.close();

		super.close();

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try {
			createDataBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

	// the public helper methods to access and get content from the database.
	// You could return cursors by doing "return myDataBase.query(....)" so it'd
	// be easy
	// to you to create adapters for your views.

	public List<Alimento> getAlimentosDeTabla(String tabla) {
		List<Alimento> list = new ArrayList<Alimento>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + tabla;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Alimento al = new Alimento(
						Integer.parseInt(cursor.getString(0)),
						cursor.getString(1), cursor.getString(2));
				// Adding contact to list
				list.add(al);
			} while (cursor.moveToNext());
		}

		// return contact list
		return list;
	}

	public Alimento getAlimento(String tabla, int id) {
		Alimento al = null;
		// Select All Query
		String selectQuery = "SELECT  * FROM " + tabla + " where _id="+id;

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor != null) {
			cursor.moveToFirst();

			al = new Alimento(Integer.parseInt(cursor.getString(0)),
					cursor.getString(1), cursor.getString(2));
		}
		return al;
	}

	// Adding new contact
	public void addMenu(Menu menu) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put("id_aceites", menu.getId_aceites().get_id());
		values.put("id_aoa", menu.getId_aoa().get_id());
		values.put("id_azucares", menu.getId_azucares().get_id());
		values.put("id_cereales", menu.getId_cereales().get_id());
		values.put("id_frutas", menu.getId_frutas().get_id());
		values.put("id_lacteos", menu.getId_lacteos().get_id());
		values.put("id_leguminosas", menu.getId_leguminosas().get_id());
		values.put("id_verduras", menu.getId_verduras().get_id());
		values.put("comida", menu.getComida());
		values.put("dia_semana", menu.getDia_semana());
		values.put("dia_mes", menu.getDia());
		values.put("mes", menu.getMes());
		values.put("anyo", menu.getAnyo());
		
		values.put("cant_aceites", menu.getCant_aceites());
		values.put("cant_aoa", menu.getCant_aoa() );
		values.put("cant_azucares", menu.getCant_azucares() );
		values.put("cant_cereales", menu.getCant_cereales() );
		values.put("cant_fruta", menu.getCant_fruta() );
		values.put("cant_lacteo",menu.getCant_lacteo() );
		values.put("cant_legumbres", menu.getCant_legumbres() );
		values.put("cant_verduras", menu.getCant_verduras() );
		
		// TODO poner los otros datos, maybe

		// Inserting Row
		db.insert("menu", null, values);
		db.close(); // Closing database connection
	}
	
	public Menu getMenu( ) {
		Menu menu = null;
		// Select All Query
		String selectQuery = "SELECT  * FROM menu ";

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if (cursor != null) {
			cursor.moveToFirst();

			//TODO
//			menu = new Alimento(Integer.parseInt(cursor.getString(0)),
//					cursor.getString(1), cursor.getString(2));
		}
		return menu;
	}
	
	public List<Menu> getMenus() {
		List<Menu> list = new ArrayList<Menu>();
		// Select All Query
		String selectQuery = "SELECT  * FROM menu";

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Menu al = new Menu();
				al.setId_lacteos(getAlimento("lacteos",Integer.parseInt(cursor.getString(0))));
				al.setId_aoa(getAlimento("aoa",Integer.parseInt(cursor.getString(1))));
				al.setId_aceites(getAlimento("aceites",Integer.parseInt(cursor.getString(2))));
				al.setId_frutas(getAlimento("frutas",Integer.parseInt(cursor.getString(3))));
				al.setId_verduras(getAlimento("verduras",Integer.parseInt(cursor.getString(4))));
				al.setId_azucares(getAlimento("azucares",Integer.parseInt(cursor.getString(5))));
				al.setId_cereales(getAlimento("cereales",Integer.parseInt(cursor.getString(6))));
				al.setId_leguminosas(getAlimento("leguminosas",Integer.parseInt(cursor.getString(7))));
				al.setComida(cursor.getString(8));
				al.setDia_semana(Integer.parseInt(cursor.getString(9)));
				al.setDia(Integer.parseInt(cursor.getString(10)));
				al.setMes(Integer.parseInt(cursor.getString(11)));
				al.setAnyo(Integer.parseInt(cursor.getString(12)));
				al.setCant_lacteo(cursor.getString(13));
				al.setCant_fruta(cursor.getString(14));
				al.setCant_verduras(cursor.getString(15));
				al.setCant_azucares(cursor.getString(16));
				al.setCant_legumbres(cursor.getString(17));
				al.setCant_cereales(cursor.getString(18));
				al.setCant_aoa(cursor.getString(19));
				al.setCant_aceites(cursor.getString(20));
				
				// Adding contact to list
				list.add(al);
			} while (cursor.moveToNext());
		}

		// return contact list
		return list;
	}
	
	public void borrarTodosMenus( ) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.execSQL("DELETE FROM menu"); //delete all rows in a table
		db.close();
	}
}
