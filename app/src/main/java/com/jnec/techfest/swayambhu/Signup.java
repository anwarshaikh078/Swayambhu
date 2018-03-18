package com.jnec.techfest.swayambhu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.support.transition.Transition;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {

    private AutoCompleteTextView mName,mEmail,mContact,mPass,mCol;
    private Button mbtnSignup;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private ProgressDialog mProSignUp;
    private String name;
    private String email;
    private String con;
    private String col;
    private String pass;
    String MobilePattern = "[0-9]{10}";
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.signup_layout);

        //progressbar
        mProSignUp=new ProgressDialog(this);

        //linking java to xml
        mName = (AutoCompleteTextView) findViewById(R.id.UserName);
        mEmail = (AutoCompleteTextView) findViewById(R.id.signup_email);
        mContact = (AutoCompleteTextView) findViewById(R.id.signup_contact);
        mPass = (AutoCompleteTextView) findViewById(R.id.signup_password);
        mCol = (AutoCompleteTextView) findViewById(R.id.signup_College);

        //firebase linking
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

        mbtnSignup= (Button) findViewById(R.id.btn_signup);

        mbtnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signup();
            }
        });
    }

    private void signup() {

        //fetching details
        name = mName.getText().toString();
        email = mEmail.getText().toString();
        col = mCol.getText().toString();
        con = mContact.getText().toString();
        pass = mPass.getText().toString();

        if(TextUtils.isEmpty(name))
        {
            Toast.makeText(getApplicationContext(),"Please provide your name",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(col))
        {
            Toast.makeText(getApplicationContext(),"Please provide your college name",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(con))
        {
            Toast.makeText(getApplicationContext(),"Please provide your valid contact number",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!con.matches(MobilePattern))
        {
            Toast.makeText(getApplicationContext(),"Please provide a valid 10 digit contact number",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(getApplicationContext(),"Please provide your valid Email address",Toast.LENGTH_SHORT).show();
            return;
        }
        if(!email.matches(emailPattern))
        {
            Toast.makeText(getApplicationContext(),"Please provide your valid Email address",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass))
        {
            Toast.makeText(getApplicationContext(),"Enter valid password",Toast.LENGTH_SHORT).show();
            return;
        }
        else if(pass.length() < 6)
        {
            Toast.makeText(getApplicationContext(),"Password should have atleast 6 characters",Toast.LENGTH_SHORT).show();
            return;
        }

        mProSignUp.setTitle("Registering User");
        mProSignUp.setMessage("Please wait while we create your account");
        mProSignUp.setCanceledOnTouchOutside(false);
        mProSignUp.show();


        //make a map to add it to database
        final Map<String, String> datamap = new HashMap<String, String>();
        datamap.put("Name", name);
        datamap.put("Email", email);
        datamap.put("Contact", con);


        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    String uid = user.getUid();
                    mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(uid);

                    mDatabase.setValue(datamap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()) {
                                mProSignUp.dismiss();
                                Intent siginupIntent = new Intent(Signup.this, Bottom_NavBar.class);
                                siginupIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(siginupIntent);
                                //startActivity(new Intent(Signup.this,Homescreen.class));
                                smsApiCall();
                            } else {
                                mProSignUp.dismiss();
                                Toast.makeText(getApplicationContext(), "Oopps...!!...Something went wrong", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
    public void smsApiCall()
    {
        try {
            // Construct data
            String apiKey = "apikey=" + "4iQet9zS7N0-8BOlNJ7oGBJzPBA2yesfVrpXDE1K1y";
            String message = "&message=" + "Thank you for showing your interest " + StudentInfo.getname()+ ". Have Great Time!!!";
            String sender = "&sender=" + "";//mtxtsender.getText().toString();
            String numbers = "&numbers=" + StudentInfo.getContact();

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));

            conn.getOutputStream().write(data.getBytes("UTF-8"));

            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                //stringBuffer.append(line);
                Toast.makeText(getApplicationContext(),"The Message is: "+line,Toast.LENGTH_LONG).show();
            }

            rd.close();

            //return stringBuffer.toString();
        } catch (Exception e) {
            //System.out.println("Error SMS "+e);
            //return "Error "+e;
            Toast.makeText(getApplicationContext(),"The Error Message is: "+e,Toast.LENGTH_LONG).show();

        }
    }



    void login(View v)
    {
        startActivity(new Intent(this,Login.class));
    }
}
