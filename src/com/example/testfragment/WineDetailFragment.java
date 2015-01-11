package com.example.testfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WineDetailFragment extends Fragment {

	private Vin vin = new Vin();

	private TextView nom = null;
	private TextView couleur = null;
	private TextView region = null;
	private TextView aoc = null;
	private TextView det = null;

	public Vin getVin() {
		return vin;
	}

	public void setVin(Vin vin) {
		this.vin = vin;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.wine_detail_fragment,
				container, false);

		nom = (TextView)view.findViewById(R.id.txtnom);
		nom.setText("Nom : "+ vin.getNom()+ "\n");

		couleur = (TextView)view.findViewById(R.id.txtcouleur);
		couleur.setText("Couleur : " + vin.getCouleur()+ "\n");

		region = (TextView)view.findViewById(R.id.txtregion);
		region.setText("Region : " + vin.getRegion()+ "\n");

		aoc = (TextView)view.findViewById(R.id.txtaoc);
		aoc.setText("AOC : " + vin.getAoc()+ "\n");

		det = (TextView)view.findViewById(R.id.txtdetail);
		det.setText("Plat conseillé : "+ vin.getDetail()+ "\n");

		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);		
	}

	//Pour mettre à jour les détails selon le vin
	public void updateDetail(Vin v){
		nom.setText("Nom : "+ v.getNom()+ "\n");
		couleur.setText("Couleur : " + v.getCouleur()+ "\n");
		region.setText("Region : " + v.getRegion()+ "\n");
		aoc.setText("AOC : " + v.getAoc()+ "\n");
		det.setText("Plat conseillé : " + v.getDetail()+ "\n");
	}
} 