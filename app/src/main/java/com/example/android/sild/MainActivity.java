package com.example.android.sild;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import javax.xml.transform.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class MainActivity extends AppCompatActivity {
    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void scanCode (View view){
        scannerView = new ZXingScannerView(this);
        scannerView.setResultHandler(new ZXingScannerResultHandler());
        Log.d("This is a test", "message here");
        setContentView(scannerView);
        scannerView.startCamera();
        Log.d("This is a test", "message here 2");
    }

    @Override
    public void onPause(){
        super.onPause();
        scannerView.stopCamera();
    }




    class ZXingScannerResultHandler implements ZXingScannerView.ResultHandler
    {
        @Override
        public void handleResult(com.google.zxing.Result result) {
            Log.d("This is a test", "message here 3");
            String resultCode = result.getText();
            Toast.makeText(MainActivity.this, resultCode, Toast.LENGTH_SHORT).show();

            setContentView(R.layout.activity_main);
            scannerView.stopCamera();
        }


    }
}
