package com.example.fareshare;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fareshare.ui.activities.OfferActivity;
import com.example.fareshare.ui.activities.SessionActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class QRCodeScanner extends AppCompatActivity {

    Button button_scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        button_scan = findViewById(R.id.button_scan);
        button_scan.setOnClickListener(v ->
        {
            scanCode();
        });
    }

    private void scanCode() {
        ScanOptions options = new ScanOptions();
        options.setPrompt("Volume up to turn on flash");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(options);
    }

    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(), result ->
    {
        if(result.getContents() != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(QRCodeScanner.this);
            builder.setTitle("Result");
            builder.setMessage(result.getContents());
            String taxiID = result.getContents();
            ((Globals) this.getApplication()).setTaxiID(taxiID);
            ((Globals) this.getApplication()).getOffer().setTaxiID(taxiID);
            builder.setPositiveButton("Continue", new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show();
        }
    });

}
