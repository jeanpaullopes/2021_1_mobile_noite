package br.edu.uniritter.mobile.nossaprimeiraappnoite.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    public int id;
    public String name;
    public String email;
    public Address address;

    public User(int id, String name, String email, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }
    private User(Parcel parcel) {

        id = parcel.readInt();
        name = parcel.readString();
        email = parcel.readString();

        //parcel.writeParcelable(this.address);
        Address add = new Address(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
       null);
        add.geo =  new Geo(
                parcel.readFloat(),
                parcel.readFloat());

        this.address = add;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.email);
        //parcel.writeParcelable(this.address);
        parcel.writeString(this.address.street);
        parcel.writeString(this.address.suite);
        parcel.writeString(this.address.city);
        parcel.writeString(this.address.zipcode);
        parcel.writeFloat(this.address.geo.lat);
        parcel.writeFloat(this.address.geo.lng);


    }
}
