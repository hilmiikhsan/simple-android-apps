package com.ikhsan.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Personal extends AppCompatActivity {
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);

        Button buttonLogout = findViewById(R.id.btn_logout);

        Intent i = getIntent();
        String fullName = i.getStringExtra("FULLNAME");
        String userName = i.getStringExtra("USERNAME");
        String nim = i.getStringExtra("NIM");
        String kelas = i.getStringExtra("KELAS");

        TextView fullnameField = findViewById(R.id.fullname_personal);
        TextView usernameField = findViewById(R.id.username_personal);
        TextView nimField = findViewById(R.id.nim_personal);
        TextView kelasField = findViewById(R.id.kelas_personal);

        String fullnameValue = fullnameField.getText().toString();
        String usernameValue = usernameField.getText().toString();
        String nimValue = nimField.getText().toString();
        String kelasValue = kelasField.getText().toString();

        fullnameField.setText(fullnameValue + " : " + fullName);
        usernameField.setText(usernameValue + " : " + userName);
        nimField.setText(nimValue + " : " + nim);
        kelasField.setText(kelasValue + " : " + kelas);

        buttonLogout.setOnClickListener(view -> {
            Intent intent = new Intent(Personal.this, Login.class);
            startActivity(intent);
        });
    }
}
