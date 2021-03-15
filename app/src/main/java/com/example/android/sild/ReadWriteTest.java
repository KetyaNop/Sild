package com.example.android.sild;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ReadWriteTest extends AppCompatActivity {

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference userRef = mRootRef.child("Users").child("1");
    DatabaseReference firstNameRef = userRef.child("FirstName");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database_read_write_test);


        //attach listener
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String firstName = dataSnapshot.child("FirstName").getValue().toString();
                Log.d("usernameTest", firstName);
                TextView usernameTextRef= (TextView) findViewById(R.id.usernameView);
                usernameTextRef.setText(firstName);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    //called when user click the click the update username button
    public void updateUsernameTrigger(View view){
        EditText nameInput = (EditText) findViewById(R.id.editText2);
        updateUsername(nameInput.getText().toString());
    }


    //update username value on the database`
    private void updateUsername(String username){
        firstNameRef.setValue(username);
    }
}
