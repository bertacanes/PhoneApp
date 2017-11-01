package com.example.berta.phoneapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.berta.phoneapp.R.string.calling;

public class PhoneActivity extends AppCompatActivity {

    private TextView phonenumber;
    private String act_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);

        phonenumber = (TextView) findViewById(R.id.show_number);
        Button btn_call = (Button) findViewById(R.id.btn_call);
        Button btn_erase = (Button) findViewById(R.id.btn_erase);

        act_number = "";

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PhoneActivity.this);
                builder.setTitle(R.string.confirm);
                String message = String.format("%s %s?", getString(R.string.sure), phonenumber.getText());
                builder.setMessage(message);
                builder.setPositiveButton(R.string.call, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        /*
                        String calling = String.format("%s %s", getString(R.string.calling), phonenumber.getText());
                        Toast.makeText(PhoneActivity.this, calling , Toast.LENGTH_LONG).show();
                        */
                        //PART 1
                        Intent intent = new Intent(PhoneActivity.this, CallingActivity.class);
                        intent.putExtra("number", act_number);
                        startActivityForResult(intent, 0);
                    }
                });
                builder.setNegativeButton(android.R.string.cancel, null);
                builder.create().show();
            }
        });

        btn_erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                act_number = act_number.substring(0, act_number.length() - 1);
                phonenumber.setText(act_number);
            }
        });
    }

    //PART 4
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 0:
                if (resultCode == AppCompatActivity.RESULT_OK){
                    act_number= data.getStringExtra("number");
                    phonenumber.setText(act_number);
                }
        }
    }

    public void Click(View v){
        Button btn = (Button) v;
        String btn_number = btn.getText().toString();
        act_number = act_number + btn_number;
        phonenumber.setText(act_number);
    }
}
