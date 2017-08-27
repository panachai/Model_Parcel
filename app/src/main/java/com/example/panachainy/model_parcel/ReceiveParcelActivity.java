package com.example.panachainy.model_parcel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.panachainy.model_parcel.model.ParcelLibrary;

import org.parceler.Parcels;

public class ReceiveParcelActivity extends AppCompatActivity {

    ParcelLibrary parcelModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_parcel);

        ReceiveParcel();
    }

    void ReceiveParcel() {

        Intent i = getIntent();

        parcelModel = Parcels.unwrap(i.getParcelableExtra("personkey"));

     Log.d("ParcelReceiveModel",parcelModel.getFullname()+" "+parcelModel.getGender()+" "+parcelModel.getAge());
    }


}
