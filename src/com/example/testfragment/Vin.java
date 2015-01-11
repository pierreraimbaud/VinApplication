package com.example.testfragment;

import android.os.Parcel;
import android.os.Parcelable;

// La classe Vin et ses différents attributs
public class Vin implements Parcelable{

	private long id;
	private String nom;
	private String couleur;
	private String region;
	private String aoc;
	private String detail;

	public static final Parcelable.Creator<Vin> CREATOR = new Parcelable.Creator<Vin>() {
		public Vin createFromParcel(Parcel in) {
			return new Vin(in);
		}

		public Vin[] newArray(int size) {
			return new Vin[size];
		}
	};

	public Vin(){
		nom = "";
		couleur = "";
		region = "";
		aoc = "";
		detail = "";
	}

	public Vin (String nom, String couleur, String region, String aoc, String detail){
		this.nom = nom;
		this.couleur = couleur;
		this.region = region;
		this.aoc = aoc;
		this.detail = detail;
	}

	public void setVin(Vin v){
		nom = v.getNom();
		couleur = v.getCouleur();
		region = v.getRegion();
		aoc = v.getAoc();
		detail = v.getDetail();
	}

	public Vin (Parcel p){
		nom = p.readString();
		couleur = p.readString();
		region = p.readString();
		aoc = p.readString();
		detail = p.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(nom);
		dest.writeString(couleur);
		dest.writeString(region);
		dest.writeString(aoc);
		dest.writeString(detail);
	}

	public String toString(){
		return this.getNom();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAoc() {
		return aoc;
	}

	public void setAoc(String aoc) {
		this.aoc = aoc;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}
}