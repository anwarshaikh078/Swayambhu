package com.jnec.techfest.swayambhu;

import android.app.Dialog;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Beg_Borrow_Steal extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private FirebaseUser user;
    Dialog mydialog;
    Button mbook;
    private int count = 0;int kcount=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beg__borrow__steal);
        mAuth=FirebaseAuth.getInstance();

        Animation a = AnimationUtils.loadAnimation(this,R.anim.viewanim);
        CardView v1 = (CardView)findViewById(R.id.c1_fun);
        CardView v2 = (CardView)findViewById(R.id.c2_fun);
        CardView v3 = (CardView)findViewById(R.id.c3_fun);
        CardView v4 = (CardView)findViewById(R.id.c4_fun);
        CardView v5 = (CardView)findViewById(R.id.c5_fun);



        v1.startAnimation(a);
        v2.startAnimation(a);
        v3.startAnimation(a);
        v4.startAnimation(a);
        v5.startAnimation(a);



        mbook = (Button)findViewById(R.id.button_big);

        mbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getApplication(),"Clicked",Toast.LENGTH_LONG).show();
                Datacheck();
                //smsApiCall();
                // mProLogin.dismiss();
            }
        });

        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


    }
    private void Datacheck()
    {
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        String email=user.getEmail();
        String uid=user.getUid();
        DatabaseReference dr = FirebaseDatabase.getInstance().getReference().child("Fun").child("Big Borrow Steel").child(uid);


        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                try {
                    //Toast.makeText(getApplicationContext(), "in data", Toast.LENGTH_LONG).show();

                    String email = dataSnapshot.child("Email").getValue().toString();
                    if(count >= 1) {
                        Toast.makeText(getApplicationContext(), "Already Registered with this " + email, Toast.LENGTH_SHORT).show();
                    }
                    count++;

                    //mProLogin.dismiss();

                }
                catch (Exception e)
                {

                    //Toast.makeText(getApplicationContext(),"in catch ",Toast.LENGTH_LONG).show();
                    DataEntry();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }


    private void DataEntry() {
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        String email=user.getEmail();
        String uid=user.getUid();

        //Toast.makeText(getApplicationContext(),""+email, Toast.LENGTH_SHORT).show();


        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference().child("Fun").child("Big Borrow Steel").child(uid);

        Map<String, String> data=new HashMap<String,String>();
        data.put("Email",email);
        data.put("Contact",StudentInfo.getContact());
        mDatabase.setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(), "Registered ", Toast.LENGTH_SHORT).show();

                    smsApiCall();

                    String email=StudentInfo.getEmail();
                    String subject="Greetings from JNEC-SWAYAMBHU";
                    String message="Thank you "+ StudentInfo.getname()+" for registering in BEG BORROW STEAL. Kindly show this message/email on payment desk to confirm your booking. This email is valid until bookings are full.";

                    //Toast.makeText(getApplicationContext(),email+" ",Toast.LENGTH_LONG).show();

                    SendMail sm = new SendMail(Beg_Borrow_Steal.this, email, subject, message);

                    //Executing sendmail to send email
                    sm.execute();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Error ",Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    public void smsApiCall()
    {
        try {
            // Construct data
            String apiKey = "apikey=" + "4iQet9zS7N0-8BOlNJ7oGBJzPBA2yesfVrpXDE1K1y";
            String message = "&message=" + "Thank you "+ StudentInfo.getname()+" for registering in  BEG BORROW STEAL. Kindly show this message/email on payment desk to confirm your booking.";
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
                // Toast.makeText(getApplicationContext(),"The Message is: "+line,Toast.LENGTH_LONG).show();

            }

            rd.close();

            //return stringBuffer.toString();
        } catch (Exception e) {
            //System.out.println("Error SMS "+e);
            //return "Error "+e;
            Toast.makeText(getApplicationContext(),"The Error Message is: "+e,Toast.LENGTH_LONG).show();

        }
    }
}
