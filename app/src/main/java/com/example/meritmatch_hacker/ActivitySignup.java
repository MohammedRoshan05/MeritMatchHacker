package com.example.meritmatch_hacker;

import android.content.Context;
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

public class ActivitySignup extends AppCompatActivity {

    Button Signup;
    EditText User_name,Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        User_name = findViewById(R.id.singup_username);
        Password = findViewById(R.id.singup_password);
        Signup = findViewById(R.id.create_user);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new APICall().signup(User_name.getText().toString(), Password.getText().toString(),
                        ActivitySignup.this, new APICall.UserInfoCallback() {
                            @Override
                            public void onResponse(ClassUserInfo userInfo) {
                                if(userInfo != null){
                                    makeToast(ActivitySignup.this, "Signed up Successfully");
                                }
                            }
                        });
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void makeToast(Context context, String message){
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show();
    }
}