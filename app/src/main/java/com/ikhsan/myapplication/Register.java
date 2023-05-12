package com.ikhsan.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button buttonRegister = findViewById(R.id.btn_register);
        TextView loginText = findViewById(R.id.login_text);

        buttonRegister.setOnClickListener(view -> {
            EditText usernameField = findViewById(R.id.username);
            EditText passwordField = findViewById(R.id.password);
            EditText fullNameField = findViewById(R.id.fullname);
            EditText nimField = findViewById(R.id.nim);
            EditText kelasField = findViewById(R.id.kelas);
            String usernameData = usernameField.getText().toString();
            String passwordData = passwordField.getText().toString();
            String fullNameData = fullNameField.getText().toString();
            String nimData = nimField.getText().toString();
            String kelasData = kelasField.getText().toString();

            if (usernameData.isEmpty()) {
                Toast.makeText(this, "Username tidak boleh kosong", Toast.LENGTH_SHORT).show();
                return;
            }

            if (passwordData.isEmpty()) {
                Toast.makeText(this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                return;
            }

            if (fullNameData.isEmpty()) {
                Toast.makeText(this, "Full Name tidak boleh kosong", Toast.LENGTH_SHORT).show();
                return;
            }

            if (nimData.isEmpty()) {
                Toast.makeText(this, "Full Name tidak boleh kosong", Toast.LENGTH_SHORT).show();
                return;
            }

            if (kelasData.isEmpty()) {
                Toast.makeText(this, "Kelas tidak boleh kosong", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(Register.this, Login.class);
            intent.putExtra("USERNAME", usernameData);
            intent.putExtra("PASSWORD", passwordData);
            intent.putExtra("FULLNAME", fullNameData);
            intent.putExtra("NIM", nimData);
            intent.putExtra("KELAS", kelasData);
            startActivity(intent);
        });

        loginText.setOnClickListener(view -> {
            Intent intent = new Intent(Register.this, Login.class);
            startActivity(intent);
        });
    }
}
