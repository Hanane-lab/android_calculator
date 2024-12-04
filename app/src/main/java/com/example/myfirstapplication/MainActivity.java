package com.example.myfirstapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvLogin;
    EditText etLogin;
    Button btnValider;
    String login;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnValider), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tvLogin = findViewById(R.id.tvLogin);
        etLogin = findViewById(R.id.etLogin);
        btnValider = findViewById(R.id.btnValider);


        tvLogin.setText("bonjour");
        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // etLogin.setText("khadija");
                String login = etLogin.getText().toString();
                if (login.length() != 0){
                    Toast.makeText(MainActivity.this, "bonjour" + login, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Empty login !!! ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}