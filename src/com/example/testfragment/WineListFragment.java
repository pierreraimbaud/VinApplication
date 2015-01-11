package com.example.testfragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WineListFragment extends ListFragment {

	private Vin[] listeVins = new Vin[0];

	//Le listener
	private static changeDetailDeVinListener listener;

	//L'interface implémentée par MainActivity
	public interface changeDetailDeVinListener{
		public void changerDetailVin(Vin vin);
	}

	public static changeDetailDeVinListener getListener(){
		return listener;
	}
	public void setListener(changeDetailDeVinListener l){
		listener = l;
	}

	public Vin[] getlisteVins() {
		return listeVins;
	}

	public void setlisteVins(Vin[] listeVins) {
		this.listeVins = listeVins;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.wine_list_fragment,
				container, false);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		setListAdapter(new PersoAdapter(getActivity(),
				android.R.layout.simple_list_item_1, listeVins));
	}

	//Pour mettre à jour la liste
	public void updateList(Vin[] v){
		this.setlisteVins(v);
		setListAdapter(new PersoAdapter(getActivity(),
				android.R.layout.simple_list_item_1, listeVins));
	}
}