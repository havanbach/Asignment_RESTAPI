package com.example.asignment_restapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asignment_restapi.Model.USER;
import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {
    EditText edt_hotenrgt,edt_tkrgt,edt_sdtrgt,edt_mkrgt;
    Button btn_register;
    TextView txt_log;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference user = firebaseDatabase.getReference("USER");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edt_hotenrgt = findViewById(R.id.edt_hotenrgt);
        edt_tkrgt = findViewById(R.id.edt_tkrgt);
        edt_sdtrgt = findViewById(R.id.edt_sdtrgt);
        edt_mkrgt = findViewById(R.id.edt_mkrgt);

        btn_register = findViewById(R.id.btn_register);
        txt_log = findViewById(R.id.txt_log);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String hoten = edt_hotenrgt.getText().toString();
                final String tk = edt_tkrgt.getText().toString();
                final String sdt = edt_sdtrgt.getText().toString();
                final String mk = edt_mkrgt.getText().toString();

                user.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.child(tk).exists()) {
                            Toast.makeText(Register.this, "Tài khoản đã tồn tại", Toast.LENGTH_SHORT).show();
                        } else {
                            USER newUser = new USER(hoten, tk, sdt, mk);
                            user.child(tk).setValue(newUser);
                            Toast.makeText(Register.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(Register.this, "Đăng ký không thành công", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

}