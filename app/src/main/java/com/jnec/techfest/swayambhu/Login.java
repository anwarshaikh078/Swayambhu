package com.jnec.techfest.swayambhu;

import android.animation.ValueAnimator;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    private AutoCompleteTextView mUser,mPass;
    private Button mlogin;
    private ProgressDialog mProLogin;
    private FirebaseAuth mAuth;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.login_layout);
        TextView bt = (TextView) findViewById(R.id.cli);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),Signup.class));

            }
        });




        mProLogin= new ProgressDialog(this);
        //linking java to xml
        mUser= (AutoCompleteTextView) findViewById(R.id.login_user);
        mPass= (AutoCompleteTextView) findViewById(R.id.login_pass);
        mlogin=(Button) findViewById(R.id.btnsignuplogin);

        //FIREBASE
        mAuth= FirebaseAuth.getInstance();


        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user=mUser.getText().toString();
                String pass=mPass.getText().toString();

                if(TextUtils.isEmpty(user))
                {
                    Toast.makeText(getApplicationContext(),"Enter Valid Email",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!user.matches(emailPattern))
                {
                    Toast.makeText(getApplicationContext(),"Please provide your valid Email address",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(pass))
                {
                    Toast.makeText(getApplicationContext(),"Enter Valid Password",Toast.LENGTH_SHORT).show();
                    return;
                }else if(pass.length() < 6)
                {
                    Toast.makeText(getApplicationContext(),"Password should have atleast 6 characters",Toast.LENGTH_SHORT).show();
                    return;
                }



                mProLogin.setTitle("Logging In");
                mProLogin.setMessage("Please wait while we check your credentials");
                mProLogin.setCanceledOnTouchOutside(false);
                mProLogin.show();

                signin(user,pass);
            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    private void signin(String user,String pass) {

        mAuth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    mProLogin.dismiss();
                    Intent loginIntent= new Intent(Login.this,Bottom_NavBar.class);
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(loginIntent);
                    
                }
                else {
                    mProLogin.dismiss();
                    Toast.makeText(getApplication(),"UserName Or Password Incorrect",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void Reset(View v)
    {
        startActivity(new Intent(Login.this,forgotpassword.class));
    }

}
