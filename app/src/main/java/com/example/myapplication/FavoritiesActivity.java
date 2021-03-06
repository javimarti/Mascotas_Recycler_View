package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class FavoritiesActivity extends AppCompatActivity {
    ArrayList<MascotasDto> mascotas;
    RecyclerView listmascotas;
    MascotasAdaptador adaptador;
    ArrayList<Integer> likeArraySorted;
    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ArrayList<MascotasDto> mascotasfromMain = null;
        int likeArray[] = new int[5];
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoritieslayout);
        Toolbar actionBar =(Toolbar) findViewById(R.layout.favoritesubirsactionbar);

        setSupportActionBar((Toolbar) actionBar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
             mascotasfromMain= (ArrayList<MascotasDto>)extras.getSerializable("mascotaArray");

             likeArray= extras.getIntArray("mascotaLikeCounter");

            Arrays.sort(likeArray);
        }
        mascotas= new ArrayList<MascotasDto>();
        for (int i=0 ;i< 5;i++) {
            mascotas.add(mascotasfromMain.get(i));
        }

        listmascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listmascotas.setLayoutManager(llm);
        inicializarAdaptador();

        ImageView star = (ImageView) findViewById(R.id.arrowImg);
        star.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FavoritiesActivity.this,MainActivity.class );

                startActivity(intent);
            }
        });
    }
    public void inicializarAdaptador(){
        adaptador = new MascotasAdaptador(mascotas);
        listmascotas.setAdapter(adaptador);

    }
}
