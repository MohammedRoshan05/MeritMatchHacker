package com.example.meritmatch_hacker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class ActivitySignin extends AppCompatActivity {

    EditText User_name,Password;
    Button Signup,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.signin_activity);

        User_name = findViewById(R.id.singin_username);
        Password = findViewById(R.id.singin_password);
        Signup = findViewById(R.id.signup);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new APICall().login(User_name.getText().toString(), Password.getText().toString(), ActivitySignin.this, new APICall.loginCallback() {
                    @Override
                    public void onResponse(CallStatus status) {
                        if(status != null){
                            if(Objects.equals(status.getStatus(), "Invalid password")){
                                Toast.makeText(ActivitySignin.this, "Invalid password", Toast.LENGTH_SHORT).show();
                            }else if(Objects.equals(status.getStatus(), "Login successful")){
                                Toast.makeText(ActivitySignin.this, "Welcome " + User_name.getText(), Toast.LENGTH_SHORT).show();
                                passUsername(User_name.getText().toString(), ActivitySignin.this, ActivityDashboard.class);
                            }else if(Objects.equals(status.getStatus(), "User not found")){
                                Toast.makeText(ActivitySignin.this, "User not found", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        });

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = setIntent(ActivitySignin.this, ActivitySignup.class);
                startActivity(intent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public Intent setIntent(Context context,Class<?> cls){
        Intent intent = new Intent(context,cls);
        return intent;
    }
    public void passUsername(String name,Context context,Class<?> cls){
        Intent intent = setIntent(context,cls);
        intent.putExtra("Username",name);
        startActivity(intent);
    }

}