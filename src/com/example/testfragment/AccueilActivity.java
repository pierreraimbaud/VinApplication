package com.example.testfragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

public class AccueilActivity extends Activity {

	private DAO datasource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accueil);

		datasource = new DAO(this);

		final Context currentContext = this;

		//Bouton pour passer direct au catalogue
		Button sans = (Button) findViewById(R.id.sans);
		sans.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(AccueilActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});

		//Bouton pour ajouter un vin (afficher les menus d'ajout)
		final Button affiche = (Button) findViewById(R.id.affiche);
		affiche.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				View block = findViewById(R.id.ajoutBlock);
				block.setVisibility(View.VISIBLE);
			}
		});

		//Bouton pour valider l'ajout d'un vin en base
		Button valider = (Button) findViewById(R.id.valider);
		valider.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				datasource.open();
				SQLiteDatabase database = datasource.getDatabase();	

				String nom="";
				TextView t1 = (TextView)findViewById(R.id.nom);
				nom += t1.getText();
				nom = nom.replaceAll("'"," ");
				t1.setText("");

				String couleur="";
				Spinner t2 = (Spinner)findViewById(R.id.couleurs_spinner);
				couleur += t2.getSelectedItem();

				String region="";
				Spinner t3 = (Spinner)findViewById(R.id.region_spinner);
				region += t3.getSelectedItem();

				String aoc="";
				Spinner t4 = (Spinner)findViewById(R.id.aoc_spinner);
				aoc += t4.getSelectedItem();

				String plat="";
				TextView t5 = (TextView)findViewById(R.id.detail);
				plat += t5.getText();
				plat = plat.replaceAll("'"," ");
				t5.setText("");

				String addQuery = "INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('"+nom+"','"+couleur+"', '"+region+"', '"+aoc+"', '"+plat+"')";
				database.execSQL(addQuery);

				//Confirmation d'ajout
				AlertDialog.Builder alert = new AlertDialog.Builder(currentContext);
				alert.setMessage("Votre vin a bien été ajouté à la base");
				alert.setPositiveButton("Ok", null);
				alert.show();

				//On remonte en haut de l'écran pour éviter à l'utilisateur de scroller manuellement
				View block = findViewById(R.id.ajoutBlock);
				block.setVisibility(View.INVISIBLE);
				ScrollView scroll = (ScrollView) findViewById(R.id.scroll);
				scroll.fullScroll(ScrollView.FOCUS_UP);
			}
		});

		//Bouton pour annuler l'ajout
		Button cancel = (Button) findViewById(R.id.cancel);
		cancel.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				//Confirmation d'annulation
				AlertDialog.Builder alert = new AlertDialog.Builder(currentContext);
				alert.setMessage("Vous avez annulé l'ajout de ce vin");
				alert.setPositiveButton("Ok", null);
				alert.show();

				//On remonte en haut de l'écran pour éviter à l'utilisateur de scroller manuellement
				View block = findViewById(R.id.ajoutBlock);
				block.setVisibility(View.INVISIBLE);
				ScrollView scroll = (ScrollView) findViewById(R.id.scroll);
				scroll.fullScroll(ScrollView.FOCUS_UP);
			}
		});
	}

	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		//doit garder le nouvel intent jusqu'a ce que getIntent() renvoie l'ancien
		setIntent(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		return super.onOptionsItemSelected(item);
	}
}