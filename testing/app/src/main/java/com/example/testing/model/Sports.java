package com.example.testing.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Date;

public class Sports implements Parcelable {
    private String name;
    private String description;
    private String id;
    private Date date;
    private String hall;   // spinner field

    public Sports() {}

    public Sports(String name, String description, String id, Date date, String hall) {
            this.name = name;
            this.description = description;
            this.id = id;
            this.date = date;
            this.hall = hall;

    }

    protected Sports(Parcel in){
        name=in.readString();
        description = in.readString();
        id = in.readString();
        date = new Date(in.readLong());
        hall = in.readString();
    }


    public static final Creator<Sports> CREATOR = new Creator<Sports>() {
        @Override
        public Sports createFromParcel(Parcel in) {
            return new Sports(in);
        }

        @Override
        public Sports[] newArray(int size) {
            return new Sports[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(id);
        parcel.writeLong(date.getTime());
        parcel.writeString(hall);
    }

    @Override
    public String toString() {
        return "Sports{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                ", date=" + date +
                ", hall='" + hall + '\'' +
                '}';
    }
};
