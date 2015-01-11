package com.example.testfragment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class VinSQLiteHelper  extends SQLiteOpenHelper{

	public static final String TABLE_VINS = "vin";
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_NOM = "nom";
	public static final String COLUMN_COULEUR = "couleur";
	public static final String COLUMN_REGION = "region";
	public static final String COLUMN_AOC = "aoc";
	public static final String COLUMN_DETAIL = "detail";

	private static final String DATABASE_NAME = "vin.db";
	private static final int DATABASE_VERSION = 1;

	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_VINS + "( " + COLUMN_ID
			+ " integer primary key autoincrement, " 
			+ COLUMN_NOM + " text not null, " 
			+ COLUMN_COULEUR + " text not null, "
			+ COLUMN_REGION + " text not null, "
			+ COLUMN_AOC + " text not null, "
			+ COLUMN_DETAIL + " text not null);";

	public VinSQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// A la création de la base (installation de l'application ou après un clear data)
	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
		String addQuery = 
				"INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('Château de la bigotière','Blanc', 'Loire', 'Muscadet', 'Haddock moutarde')";
		database.execSQL(addQuery);
		addQuery = "INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('Château la perrière','Blanc', 'Loire', 'Muscadet', 'Tourte verte au saumon')";
		database.execSQL(addQuery);
		addQuery = "INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('Château de l Éclair','Rouge', 'Beaujolais et lyonnais', 'Beaujolais', 'Risotto aux champignons')";
		database.execSQL(addQuery);
		addQuery = "INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('Domaine de la creuze noire','Blanc', 'Beaujolais et lyonnais', 'Beaujolais', 'Jambon cru')";
		database.execSQL(addQuery);
		addQuery = "INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('Étienne Descotes et fils','Blanc', 'Beaujolais et lyonnais', 'Coteaux du lyonnais', 'Oeuf en meurette')";
		database.execSQL(addQuery);
		addQuery = "INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('Domaine de Baptiste','Rouge', 'Beaujolais et lyonnais', 'Coteaux du lyonnais', 'Tartare de boeuf façon bistrot')";
		database.execSQL(addQuery);
		addQuery = "INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('Domaine de bois mozé','Rosé', 'Loire', 'Cabernet d anjou', 'Carpaccio de fraises et d ananas au muscat')";
		database.execSQL(addQuery);
		addQuery = "INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('Domaine des petites grouas','Rosé', 'Loire', 'Cabernet d anjou', 'Cake zen au thé vert')";
		database.execSQL(addQuery);
		addQuery = "INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('Les coteaux du pic','Rouge', 'Languedoc', 'Languedoc', 'Tortilla aux herbes de provence')";
		database.execSQL(addQuery);
		addQuery = "INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('Vignoble du martinet','Blanc', 'Loire', 'Coteaux du layon', 'Tarte aux pommes à la normande')";
		database.execSQL(addQuery);
		addQuery = "INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('Domaine leroy','Blanc', 'Loire', 'Coteaux du layon', 'Gratin d orange aux pépites de chocolat')";
		database.execSQL(addQuery);
		addQuery = "INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('Excellence de bazin','Rouge', 'Sud-ouest', 'Côtes du marmandais', 'Poulet au chocolat')";
		database.execSQL(addQuery);
		addQuery = "INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('Domaine de la bretonnière','Blanc', 'Loire', 'Gros plant', 'Filet de grenadier à la moutarde')";
		database.execSQL(addQuery);
		addQuery = "INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('Haute cour de la débaudière','Blanc', 'Loire', 'Gros plant', 'Crevette à l aneth')";
		database.execSQL(addQuery);
		addQuery = "INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('Château de reynaud','Rouge', 'Bordelais', 'Côtes de bourg', 'Gratin dauphinois')";
		database.execSQL(addQuery);
		addQuery = "INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('Domaine de la tour','Blanc', 'Bourgogne', 'Bourgogne', 'Lapin à la sariette')";
		database.execSQL(addQuery);
		addQuery = "INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('Bergerie du capucin','Rosé', 'Languedoc', 'Languedoc', 'Empanadas au boeuf')";
		database.execSQL(addQuery);
		addQuery = "INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('Château bois beaulieu','Rosé', 'Sud-ouest', 'Côtes du marmandais', 'Lentilles à la tomate')";
		database.execSQL(addQuery);
		addQuery = "INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('Château de monteberiot','Rouge', 'Bordelais', 'Côtes de bourg', 'Gigot de mouton aux artichauts')";
		database.execSQL(addQuery);
		addQuery = "INSERT INTO vin(nom, couleur, region, aoc, detail) VALUES ('Merlin','Rouge', 'Bourgogne', 'Bourgogne', 'Endives au jambon')";
		database.execSQL(addQuery);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(VinSQLiteHelper.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_VINS);
		onCreate(db);
	}
}