package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<MascotasDto> mascotas;
    RecyclerView listmascotas;
    MascotasAdaptador adaptador;
    public CardView mCardView;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar actionBar =(Toolbar) findViewById(R.layout.actionbar);

       setSupportActionBar((Toolbar) actionBar);
        
        ArrayList <MascotasDto> mascotas= new ArrayList<MascotasDto>();
         listmascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listmascotas.setLayoutManager(llm);
        inicializarListMascotas();
        inicializarAdaptador();
        ImageView star = (ImageView) findViewById(R.id.star);
        star.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                adaptador.getLikeArray();
                adaptador.getMascotas();
                        Intent intent = new Intent(MainActivity.this,FavoritiesActivity.class );
                        intent.putExtra("mascotaArray",adaptador.getMascotas());
                        intent.putExtra("mascotaLikeCounter",adaptador.getLikeArray());
                      startActivity(intent);
            }
        });

    }
   public void inicializarAdaptador(){
         adaptador = new MascotasAdaptador(mascotas);
        listmascotas.setAdapter(adaptador);

    }

    public void inicializarListMascotas(){
        mascotas= new ArrayList<MascotasDto>();
       // mascotas.add(new MascotasDto(R.id.petImg,"Ulises",R.id.boneImg,1,R.id.boneLikeImg));
       // mascotas.add(new MascotasDto(R.id.petImg,"Malena",R.id.boneImg,1,R.id.boneLikeImg));
       // mascotas.add(new MascotasDto(R.id.petImg,"Lola",R.id.boneImg,1,R.id.boneLikeImg));
       // mascotas.add(new MascotasDto(R.id.petImg,"Morita",R.id.boneImg,1,R.id.boneLikeImg));

        mascotas.add(new MascotasDto(R.drawable.pet48,"Ulises",R.drawable.bonesvg,"0",R.mipmap.bonelike48));
         mascotas.add(new MascotasDto(R.drawable.pet48,"Malena",R.drawable.bonesvg,"0",R.mipmap.bonelike48));
         mascotas.add(new MascotasDto(R.drawable.pet48,"Lola",R.drawable.bonesvg,"0",R.mipmap.bonelike48));
         mascotas.add(new MascotasDto(R.drawable.pet48,"Morita",R.drawable.bonesvg,"0",R.mipmap.bonelike48));

    }


}