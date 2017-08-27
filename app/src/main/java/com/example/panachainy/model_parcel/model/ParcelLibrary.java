package com.example.panachainy.model_parcel.model;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class ParcelLibrary {
    public enum Gender {
        MALE,
        FEMALE
    }

    public String fullname;
    public Gender gender;
    public int age;

    @ParcelConstructor
    public ParcelLibrary(String fullname, Gender gender, int age) {
        this.fullname = fullname;
        this.gender = gender;
        this.age = age;
    }

    public String getFullname() {
        return fullname;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
//        <span id="transmark"></span>
        return age;
    }
}
