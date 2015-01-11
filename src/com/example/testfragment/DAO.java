package com.example.testfragment;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DAO {

	// Database fields
	private SQLiteDatabase database;
	private VinSQLiteHelper dbHelper;
	private String[] allColumns = { VinSQLiteHelper.COLUMN_ID,
			VinSQLiteHelper.COLUMN_NOM,
			VinSQLiteHelper.COLUMN_COULEUR ,VinSQLiteHelper.COLUMN_REGION,
			VinSQLiteHelper.COLUMN_AOC,
			VinSQLiteHelper.COLUMN_DETAIL };

	public DAO(Context context) {
		dbHelper = new VinSQLiteHelper(context);
	}

	public SQLiteDatabase getDatabase() {
		return database;
	}

	public void setDatabase(SQLiteDatabase database) {
		this.database = database;
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public Vin createVin(Vin Vin) {
		ContentValues values = new ContentValues();
		values.put(VinSQLiteHelper.COLUMN_NOM, Vin.getNom());
		values.put(VinSQLiteHelper.COLUMN_COULEUR, Vin.getCouleur());
		values.put(VinSQLiteHelper.COLUMN_REGION, Vin.getRegion());
		values.put(VinSQLiteHelper.COLUMN_AOC, Vin.getAoc());
		values.put(VinSQLiteHelper.COLUMN_DETAIL, Vin.getDetail());
		long insertId = database.insert(VinSQLiteHelper.TABLE_VINS, null,
				values);
		Cursor cursor = database.query(VinSQLiteHelper.TABLE_VINS,
				allColumns, VinSQLiteHelper.COLUMN_ID + " = " + insertId, null, null,
				null, null, null);
		cursor.moveToFirst();
		Vin newComment = cursorToVin(cursor);
		cursor.close();
		return newComment;
	}

	public void deleteComment(Vin Vin) {
		long id = Vin.getId();
		System.out.println("Vin deleted with id: " + id);
		database.delete(VinSQLiteHelper.TABLE_VINS, VinSQLiteHelper.COLUMN_ID
				+ " = " + id, null);
	}

	public List<Vin> getAllVins() {
		List<Vin> Vins = new ArrayList<Vin>();

		Cursor cursor = database.query(VinSQLiteHelper.TABLE_VINS,
				allColumns, null, null, null, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Vin Vin = cursorToVin(cursor);
			Vins.add(Vin);
			cursor.moveToNext();
		}
		// Make sure to close the cursor
		cursor.close();
		return Vins;
	}

	public static Vin cursorToVin(Cursor cursor) {
		Vin Vin = new Vin();
		Vin.setId(cursor.getLong(0));
		Vin.setNom(cursor.getString(1));
		Vin.setCouleur(cursor.getString(2));
		Vin.setRegion(cursor.getString(3));
		Vin.setAoc(cursor.getString(4));
		Vin.setDetail(cursor.getString(5));
		return Vin;
	}
}