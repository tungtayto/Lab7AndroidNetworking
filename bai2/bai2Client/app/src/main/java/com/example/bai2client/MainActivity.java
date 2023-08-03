package com.example.bai2client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textViewResult;
    private LinearLayout LinearLayout1;
    private EditText addressEditText;
    private EditText portEditText;
    private Button connectButton;
    private Button clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.responseTextView);


        LinearLayout1 = (LinearLayout) findViewById(R.id.LinearLayout1);
        addressEditText = (EditText) findViewById(R.id.addressEditText);
        portEditText = (EditText) findViewById(R.id.portEditText);
        connectButton = (Button) findViewById(R.id.connectButton);
        clearButton = (Button) findViewById(R.id.clearButton);

        connectButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.connectButton){
            String serverIP = addressEditText.getText().toString().trim();
            int serverPort = Integer.parseInt(portEditText.getText().toString().trim());
            Client client = new Client(serverIP, serverPort, textViewResult);
            // Execute the AsyncTask to connect to the server
            client.execute();

        } else if (view.getId() == R.id.clearButton) {
            addressEditText.setText("");
            portEditText.setText("");
        }
    }
}