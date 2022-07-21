package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.sharedpreferences.databinding.ActivityMainBinding;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding tasarim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasarim = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(tasarim.getRoot());

        //Share Preferences  ** local storage

        SharedPreferences sp = getSharedPreferences("bilgiler",MODE_PRIVATE);

        //veri kaydet
        SharedPreferences.Editor e = sp.edit();
        e.putString("ad","Ahmet");
        e.putInt("yas",23);
        e.putFloat("boy",1.82f);
        e.putBoolean("bekar",true);

        HashSet<String> liste = new HashSet<>();
        liste.add("ali");
        liste.add("ece");
        e.putStringSet("liste",liste);

        e.apply();

        //veri silme
       // e.remove("ad");
        //e.apply();

        //veri okuma
        String gelenAd = sp.getString("ad","İsim Yok!");
        int gelenYas = sp.getInt("yas",0);
        float gelenBoy = sp.getFloat("boy",0);
        boolean bekar = sp.getBoolean("bekar",false);
        Set<String> gelenListe = sp.getStringSet("liste",null);
        Log.e("gelen ad", gelenAd );
        Log.e("gelen Yaş", String.valueOf(gelenYas) );
        Log.e("gelen Boy", String.valueOf(gelenBoy) );
        Log.e("gelen Bekar", String.valueOf(bekar) );

        for(String s : gelenListe){
            Log.e("Gelen Arkadaş", s );
        }

        //Sayaç Uygulaması
        int sayac = sp.getInt("sayac",0);
        sayac= sayac + 1;
        e.putInt("sayac", sayac);
        e.apply();

        tasarim.textViewSonuc.setText("Açılış sayısı : " + sayac);
    }
}