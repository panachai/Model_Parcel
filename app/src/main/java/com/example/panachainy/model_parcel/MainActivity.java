package com.example.panachainy.model_parcel;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.panachainy.model_parcel.model.ParcelLibrary;

import org.parceler.Parcels;

public class MainActivity extends AppCompatActivity {
    ParcelLibrary parcelmodel;
    Button btnParcelIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Initial();
        AddEventClick();
        TestParcel();
        AddBundle();
//        IntentParcel();
    }

    void Initial() {
        parcelmodel = new ParcelLibrary("ทดสอบชื่อ", ParcelLibrary.Gender.MALE, 20);
        btnParcelIntent = (Button) findViewById(R.id.btnParcelIntent);
    }

    void AddEventClick() {
        btnParcelIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentParcel();
            }
        });
    }

    void TestParcel() {


        Parcelable wrapped = Parcels.wrap(parcelmodel);         //wrapped


        ParcelLibrary parcelModel = Parcels.unwrap(wrapped);    //unwrapped
        Log.d("ParcelTestValue", parcelModel.getAge() + " " + parcelModel.getFullname() + " " + parcelModel.getGender());
    }

    void AddBundle() {
        //for onSaveInstanceState & onRestoreInstanceState
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable("person key", Parcels.wrap(parcelmodel));

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        parcelmodel = Parcels.unwrap(savedInstanceState.getParcelable("person key"));
    }

    void IntentParcel() {
        Intent i = new Intent(this, ReceiveParcelActivity.class);
        i.putExtra("personkey", Parcels.wrap(parcelmodel));
        startActivity(i);
    }
}
