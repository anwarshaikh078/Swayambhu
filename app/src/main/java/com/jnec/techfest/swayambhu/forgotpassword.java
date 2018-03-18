package com.jnec.techfest.swayambhu;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class forgotpassword extends AppCompatActivity {

    private AutoCompleteTextView mEmail;
    private Button mbtn;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        mAuth = FirebaseAuth.getInstance();
        mbtn = (Button) findViewById(R.id.btnreset);
        mEmail = (AutoCompleteTextView) findViewById(R.id.reset_email);


        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEmail.getText().toString();
                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(getApplication(),"Enter email id",Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(),"Mail has been send to your email id",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(forgotpassword.this,Login.class));
                            finish();
                        }
                    }
                });

            }
        });
    }
}
