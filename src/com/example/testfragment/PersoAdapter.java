package com.example.testfragment;

import com.example.testfragment.R.color;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class PersoAdapter extends ArrayAdapter<Vin>{

	Context context;

	int layoutResourceId; 

	Vin data[] = null;

	private DAO datasource = new DAO(this.getContext());

	public PersoAdapter(Context context, int layoutResourceId, Vin[] data) {
		super(context, layoutResourceId, data);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.data = data;
	}

	// La fonction qui permet l'affichage du fond selon la couleur du vin
	// ainsi que le choix du vin (click) et la suppression du vin (long click)
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View v = super.getView(position, convertView, parent);
		TextView tv1 = (TextView)v.findViewById(android.R.id.text1);
		final int taille = getCount();
		String couleur = getItem(position).getCouleur();
		final long id = getItem(position).getId();
		final int pos = position;

		if (couleur.equals("Blanc")){
			tv1.setBackgroundResource(color.Blanc);
		}
		else {
			if (couleur.equals("Rouge")){

				tv1.setBackgroundResource(color.Rouge);
			}

			else {
				if (couleur.equals("Rosé")){
					tv1.setBackgroundResource(color.Rosé);
				}

				else  {
					tv1.setBackgroundResource(color.Fond);
				}
			}
		}

		// Pour sélectionner le vin
		v.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Vin vin = getItem(pos);
				WineListFragment.getListener().changerDetailVin(vin);
			}
		});

		// Pour supprimer un vin (ouverture d'une alert)
		v.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				final Context currentContext = getContext();
				AlertDialog.Builder alert = new AlertDialog.Builder(currentContext);
				alert.setTitle("Suppression d'un vin");
				alert.setMessage("Voulez-vous vraiment supprimer ce vin, définitivement ?");
				alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						String addQuery = "DELETE FROM vin WHERE id = "+id;
						datasource.open();
						SQLiteDatabase database = datasource.getDatabase();	
						database.execSQL(addQuery);
						System.out.println("pos"+pos);
						for (int i= pos; i < taille-1; i++){
							getItem(i).setVin(getItem(i+1));
						}
						notifyDataSetChanged();	
					}
				});

				alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// Canceled.
					}
				});
				alert.show();
				return true;
			}
		});
		return v;
	}
}