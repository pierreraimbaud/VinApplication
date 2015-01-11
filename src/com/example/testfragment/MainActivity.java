package com.example.testfragment;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.KeyEvent;
import android.view.Menu;

public class MainActivity extends Activity 
implements  
WineTypeFragment.changeTypeDeVinListener,
WineListFragment.changeDetailDeVinListener {

	private DAO datasource = new DAO(this);

	private WineTypeFragment fragment1 = new WineTypeFragment();

	private WineListFragment fragment2 = new WineListFragment();

	private WineDetailFragment fragment3 = new WineDetailFragment();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		if (savedInstanceState == null) { // to avoid recreating if restored from a previous state
			fragment1.setListener(this);
			fragment2.setListener(this);
			// need to check if we are in tablet configuration or in normal configuration
			if (findViewById(R.id.layoutTablet) != null) {
				// tablet configuration 
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				fragmentTransaction.add(R.id.wineTypeFragmentLayout, fragment1);
				fragmentTransaction.add(R.id.wineListFragmentLayout, fragment2);
				fragmentTransaction.add(R.id.wineDetailFragmentLayout, fragment3);
				fragmentTransaction.commit();
			} 
			else {
				// smartphone configuration
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				fragmentTransaction.add(R.id.fragmentLayout, fragment1);
				fragmentTransaction.commit();
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void changerCouleurVin(String couleur) {
		datasource.open();
		SQLiteDatabase database = datasource.getDatabase();
		//Requête pour sélection des vins
		String selectQuery = "SELECT * FROM vin WHERE couleur = " +"'"+couleur+"'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		Vin tv = new Vin();
		Vin [] v = {tv,tv,tv,tv,tv,tv,tv,tv,tv,tv,tv,tv,tv,tv}; // 15 vins max
		int i =0;
		if (cursor.moveToFirst()) {
			do {
				Vin n = DAO.cursorToVin(cursor);
				v[i++]= n;
			} while (cursor.moveToNext());
		}
		// need to check if we are in tablet configuration or in normal configuration
		if (findViewById(R.id.layoutTablet) != null) {
			// tablet configuration 
			//Mise à jour de la liste
			fragment2.updateList(v);
		} 
		else {
			// smartphone configuration
			FragmentManager fragmentManager = getFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
			//Préparation du fragment
			fragment2.setlisteVins(v);
			//Remplacement du fragment et mise à jour de la pile
			fragmentTransaction.replace(R.id.fragmentLayout, fragment2);
			fragmentTransaction.addToBackStack(null);
			fragmentTransaction.commit();
		}
	}

	@Override
	public void changerRegionVin(String region) {
		datasource = new DAO(this);
		datasource.open();
		SQLiteDatabase database = datasource.getDatabase();	
		//Requête pour sélection des vins
		String selectQuery = "SELECT * FROM vin WHERE region = " +"'"+region+"'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		Vin tv = new Vin();
		Vin [] v = {tv,tv,tv,tv,tv,tv,tv,tv,tv,tv,tv,tv,tv,tv}; // 15 vins max
		int i =0;
		if (cursor.moveToFirst()) {
			do {
				Vin n = DAO.cursorToVin(cursor);
				v[i++]= n;
			} while (cursor.moveToNext());
		}	
		// need to check if we are in tablet configuration or in normal configuration
		if (findViewById(R.id.layoutTablet) != null) {
			// tablet configuration 
			//Mise à jour de la liste
			fragment2.updateList(v);
		} 
		else {
			// smartphone configuration
			FragmentManager fragmentManager = getFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
			//Préparation du fragment
			fragment2.setlisteVins(v);
			//Remplacement du fragment et mise à jour de la pile
			fragmentTransaction.replace(R.id.fragmentLayout, fragment2);
			fragmentTransaction.addToBackStack(null);
			fragmentTransaction.commit();
		}
	}

	@Override
	public void changerAocVin(String aoc) {
		datasource = new DAO(this);
		datasource.open();
		SQLiteDatabase database = datasource.getDatabase();	
		//Requête pour sélection des vins
		String selectQuery = "SELECT * FROM vin WHERE aoc = " +"'"+aoc+"'";
		Cursor cursor = database.rawQuery(selectQuery, null);
		Vin tv = new Vin();
		Vin [] v = {tv,tv,tv,tv,tv,tv,tv,tv,tv,tv,tv,tv,tv,tv}; // 15 vins max
		int i =0;
		if (cursor.moveToFirst()) {
			do {
				Vin n = DAO.cursorToVin(cursor);
				v[i++]= n;
			} while (cursor.moveToNext());
		}	
		// need to check if we are in tablet configuration or in normal configuration
		if (findViewById(R.id.layoutTablet) != null) {
			// tablet configuration 
			//Mise à jour de la liste
			fragment2.updateList(v);
		} 
		else {
			// smartphone configuration
			FragmentManager fragmentManager = getFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
			//Préparation du fragment
			fragment2.setlisteVins(v);
			//Remplacement du fragment
			fragmentTransaction.replace(R.id.fragmentLayout, fragment2);
			fragmentTransaction.commit();
		}
	}

	@Override
	public void changerDetailVin(Vin vin) {
		// need to check if we are in tablet configuration or in normal configuration
		if (findViewById(R.id.layoutTablet) != null) {
			// tablet configuration
			//Mise à jour du detail
			fragment3.updateDetail(vin);
		} 
		else {
			// smartphone configuration
			FragmentManager fragmentManager = getFragmentManager();
			FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
			//Préparation du fragment
			fragment3.setVin(vin);
			//Remplacement du fragment et mise à jour de la pile
			fragmentTransaction.replace(R.id.fragmentLayout, fragment3);
			fragmentTransaction.addToBackStack(null);
			fragmentTransaction.commit();
		}
	}

	//Fonction pour la gestion de la touche retour
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)  {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			if( this.getFragmentManager().getBackStackEntryCount() != 0 ){
				this.getFragmentManager().popBackStack();
				return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
}