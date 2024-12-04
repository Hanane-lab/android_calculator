package com.example.myfirstapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    Button btnweb,btncall,btn3;
    Intent intent,intent2,intent3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //instantiation
        btnweb = findViewById(R.id.btnweb);
        btncall = findViewById(R.id.btncall);//important de declarer
        btn3 = findViewById(R.id.btn3);

        // event : Accéder au site
        btnweb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String url="https://www.ensaf.ac.ma";
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        // event : faire Appel
        btncall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Uri uri =Uri.parse("tel:0656789045");
                intent2 = new Intent(Intent.ACTION_CALL, uri);
                startActivity(intent2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                intent3 = new Intent(MainActivity2.this, MainActivity3.class);
                // .class pour rapidité
                startActivity(intent3);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu , menu);
        return true;
    }

}