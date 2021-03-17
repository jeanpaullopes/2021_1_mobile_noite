package br.edu.uniritter.mobile.nossaprimeiraappnoite;

import android.os.Parcel;
import android.os.Parcelable;

public class Pessoa implements Parcelable {

    private String nome;
    private int id;

    public Pessoa(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }
    private Pessoa(Parcel p) {
        this.nome =  p.readString();
        this.id = p.readInt();
    }

    public static final Creator<Pessoa> CREATOR = new Creator<Pessoa>() {
        @Override
        public Pessoa createFromParcel(Parcel in) {
            return new Pessoa(in);
        }

        @Override
        public Pessoa[] newArray(int size) {
            return new Pessoa[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nome);
        parcel.writeInt(this.id);

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
