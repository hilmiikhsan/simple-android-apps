package com.ikhsan.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button buttonLogin = findViewById(R.id.btn_login);
        TextView registerText = findViewById(R.id.register_text);

        buttonLogin.setOnClickListener(view -> {
            EditText usernameField = findViewById(R.id.username);
            EditText passwordField = findViewById(R.id.password);
            String usernameData = usernameField.getText().toString();
            String passwordData = passwordField.getText().toString();
            Intent i = getIntent();
            String userName = i.getStringExtra("USERNAME");
            String fullName = i.getStringExtra("FULLNAME");
            String pass = i.getStringExtra("PASSWORD");
            String nim = i.getStringExtra("NIM");
            String kelas = i.getStringExtra("KELAS");

            if (usernameData.isEmpty()) {
                Toast.makeText(this, "Username tidak boleh kosong", Toast.LENGTH_SHORT).show();
                return;
            }

            if (passwordData.isEmpty()) {
                Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!usernameData.equals(userName)) {
                Toast.makeText(this, "Username atau password tidak sesuai", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!passwordData.equals(pass)) {
                Toast.makeText(this, "Username atau password tidak sesuai", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(Login.this, Personal.class);
            intent.putExtra("USERNAME", userName);
            intent.putExtra("FULLNAME", fullName);
            intent.putExtra("NIM", nim);
            intent.putExtra("KELAS", kelas);
            startActivity(intent);
        });

        registerText.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, Register.class);
            startActivity(intent);
        });
    }
}