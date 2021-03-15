package com.example.android.sild;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

//import com.google.zxing.integration.android.IntentIntegrator;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class MainActivity extends AppCompatActivity {
    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        startReadWriteTest();
        setContentView(R.layout.activity_main);


        //Test Code
//        // Read Data
//        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference();
//        DatabaseReference childRef = databaseRef.child("Users").child("1");
//        childRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String firstName = dataSnapshot.child("FirstName").getValue().toString();
//                Log.d("tag", firstName);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//        DatabaseReference firstNameRef = childRef.child("FirstName");
//        firstNameRef.setValue("Chanketya");
//        firstNameRef.setValue("Ketya");
//
//        verifyPermission();
//        scanCode();


    }

    public void scanCode() {
        scannerView = new ZXingScannerView(this);
        scannerView.setResultHandler(new ZXingScannerResultHandler());
        Log.d("This is a test", "message here");
        setContentView(scannerView);
        scannerView.startCamera();
        Log.d("This is a test", "message here 2");
    }

    //button detection handler
    public void scanCode(View view) {
        scannerView = new ZXingScannerView(this);
        scannerView.setResultHandler(new ZXingScannerResultHandler());

        Log.d("This is a test", "message here");
        setContentView(scannerView);
        scannerView.startCamera();
        Log.d("This is a test", "message here 2");
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        verifyPermission();
    }

    class ZXingScannerResultHandler implements ZXingScannerView.ResultHandler {
        @Override
        public void handleResult(com.google.zxing.Result result) {
            Log.d("This is a test", "message here 3");
            String resultCode = result.getText();
            Toast.makeText(MainActivity.this, resultCode, Toast.LENGTH_SHORT).show();

            setContentView(R.layout.activity_main);
            scannerView.stopCamera();
        }
    }

    //verify camera permission
    private void verifyPermission() {
        Log.d("TAG", "verifyPermission: asking user for permissions");
        String[] permissions = new String[]{Manifest.permission.CAMERA};

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(), permissions[0]) == PackageManager.PERMISSION_GRANTED) {
            return;
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 1);
        }
    }

    //start ReadWriteTest activity
    public void startReadWriteTest() {
        Intent intent = new Intent(this, ReadWriteTest.class);
        startActivity(intent);
    }
}
