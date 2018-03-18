package com.jnec.techfest.swayambhu;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//comment by ashay

public class Bottom_NavBar extends AppCompatActivity {

    private TextView mTextMessage;
    private FirebaseAuth mAuth;
    private DatabaseReference mdatabase;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                   // mTextMessage.setText(R.string.title_home);
                    fragment_home frag1 = new fragment_home();
                    FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                    ft1.replace(R.id.fram,frag1);
                    ft1.commit();
                    return true;

               /* case R.id.navigation_dashboard:
                   // mTextMessage.setText(R.string.title_dashboard);
                    fragment_home frag2 = new fragment_home();
                    FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                    ft2.replace(R.id.fram,frag2);
                    ft2.commit();
                    return true;*/

                case R.id.navigation_notifications:
                   // mTextMessage.setText  ("Profile");
                    Profile frag3 = new Profile();
                    FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
                    ft3.replace(R.id.fram,frag3);
                    ft3.commit();
                    return true;

                case R.id.navigation_Logout:

                    mAuth.signOut();
                    finish();
                    startActivity(new Intent(getApplicationContext(),Login.class));


                    return true;
            }
            return false;


        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom__nav_bar);


        //getActionBar().setDisplayShowHomeEnabled(false);  // hides action bar icon
        //getActionBar().setDisplayShowTitleEnabled(false); // hides action bar title

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



        fragment_home fragment = new fragment_home();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fram,fragment);
        ft.commit();

        mAuth=FirebaseAuth.getInstance();


        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationViewBehavior());
        View decorView = getWindow().getDecorView();
// Hide both the navigation bar and the status bar.
// SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
// a general rule, you should design your app to hide the status bar whenever you
// hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user == null)
        {
            startActivity(new Intent(getApplicationContext(),Login.class));
        }
        else
        {
            mdatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(user.getUid());

            mdatabase.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    StudentInfo StudentInfo = new StudentInfo();
                    String name=dataSnapshot.child("Name").getValue().toString();
                    String con = dataSnapshot.child("Contact").getValue().toString();
                    String email= dataSnapshot.child("Email").getValue().toString();
                    String college=dataSnapshot.child("College").getValue().toString();
                    StudentInfo.setName(name);
                    StudentInfo.setEmail(email);
                    StudentInfo.setContact(con);
                    StudentInfo.setCollege(college);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}
