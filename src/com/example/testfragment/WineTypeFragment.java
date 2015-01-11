package com.example.testfragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class WineTypeFragment extends Fragment {

	//Le listener
	private changeTypeDeVinListener listener;

	//L'interface implémentée par MainActivity
	public interface changeTypeDeVinListener{
		public void changerCouleurVin(String couleur);
		public void changerRegionVin(String region);
		public void changerAocVin(String aoc);
	}

	public void setListener(changeTypeDeVinListener l){
		this.listener = l;
	}

	//A la création, les choix de couleur, région et AOC
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.wine_type_fragment,
				container, false);

		Button rouge = (Button)view.findViewById(R.id.rouge);
		rouge.setBackgroundResource(R.color.Rouge);

		rouge.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.changerCouleurVin("Rouge");
			}
		});

		Button blanc = (Button)view.findViewById(R.id.blanc);
		blanc.setBackgroundResource(R.color.Blanc);
		blanc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.changerCouleurVin("Blanc");
			}
		});

		Button rosé = (Button)view.findViewById(R.id.rosé);
		rosé.setBackgroundResource(R.color.Rosé);
		rosé.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.changerCouleurVin("Rosé");
			}
		});

		Button beaujolaislyonnais = (Button)view.findViewById(R.id.beaujolaislyonnais);
		beaujolaislyonnais.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.changerRegionVin("Beaujolais et lyonnais");
			}
		});

		Button bordelais = (Button)view.findViewById(R.id.bordelais);
		bordelais.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.changerRegionVin("Bordelais");
			}
		});


		Button bourgogne = (Button)view.findViewById(R.id.bourgogne);
		bourgogne.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.changerRegionVin("Bourgogne");
			}
		});

		Button languedoc = (Button)view.findViewById(R.id.languedoc);
		languedoc.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.changerRegionVin("Languedoc");
			}
		});

		Button loire = (Button)view.findViewById(R.id.loire);
		loire.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.changerRegionVin("Loire");
			}
		});

		Button sudouest = (Button)view.findViewById(R.id.sudouest);
		sudouest.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.changerRegionVin("Sud-ouest");
			}
		});

		Button beaujolais = (Button)view.findViewById(R.id.beaujolais);
		beaujolais.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.changerAocVin("Beaujolais");
			}
		});

		Button bourgogneAOC = (Button)view.findViewById(R.id.bourgogneAOC);
		bourgogneAOC.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.changerAocVin("Bourgogne");
			}
		});
		Button cabernetdanjou = (Button)view.findViewById(R.id.cabernetdanjou);
		cabernetdanjou.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.changerAocVin("Cabernet d anjou");
			}
		});
		Button coteauxdulayon = (Button)view.findViewById(R.id.coteauxdulayon);
		coteauxdulayon.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.changerAocVin("Coteaux du layon");
			}
		});
		Button coteauxdulyonnais = (Button)view.findViewById(R.id.coteauxdulyonnais);
		coteauxdulyonnais.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.changerAocVin("Coteaux du lyonnais");
			}
		});
		Button cotesdebourg = (Button)view.findViewById(R.id.cotesdebourg);
		cotesdebourg.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.changerAocVin("Côtes de bourg");
			}
		});
		Button cotesdumarmandais = (Button)view.findViewById(R.id.cotesdumarmandais);
		cotesdumarmandais.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.changerAocVin("Côtes du marmandais");
			}
		});
		Button grosplant = (Button)view.findViewById(R.id.grosplant);
		grosplant.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.changerAocVin("Gros plant");
			}
		});

		Button languedocAOC = (Button)view.findViewById(R.id.languedocAOC);
		languedocAOC.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.changerAocVin("Languedoc");
			}
		});

		Button muscadet = (Button)view.findViewById(R.id.muscadet);
		muscadet.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				listener.changerAocVin("Muscadet");
			}
		});
		return view;
	}
} 