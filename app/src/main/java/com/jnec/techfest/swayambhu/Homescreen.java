package com.jnec.techfest.swayambhu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Homescreen extends AppCompatActivity {

    private FirebaseAuth mAuth;
    CardView mc1;
    private Button mlogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);


        mlogout=(Button) findViewById(R.id.btnlogout);


        mc1 = (CardView)findViewById((R.id.c1));

        mc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Homescreen.this,CSE_EVENTS_MAIN.class));
            }
        });

        mAuth=FirebaseAuth.getInstance();

        mlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth.signOut();
                startActivity(new Intent(Homescreen.this,Login.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user==null)
        {
            startActivity(new Intent(Homescreen.this,Signup.class));
        }
    }
}
