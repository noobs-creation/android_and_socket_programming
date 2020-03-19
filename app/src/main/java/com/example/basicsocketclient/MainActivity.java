package com.example.basicsocketclient;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {
    public String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.editText);
        final Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                send sendcode = new send();
                message = editText.getText().toString();
                sendcode.execute();

            }
        });
    }
    class send extends AsyncTask<Void,Void,Void>{

        Socket s;
        PrintWriter pw;

        @Override
        protected Void doInBackground(Void... params){
            try{
                s = new Socket("DESKTOP-2MC2GJ1",8000);
                pw = new PrintWriter(s.getOutputStream());
                pw.write(message);
                pw.flush();
                pw.close();
                s.close();
            }catch(UnknownHostException e){
                System.out.println("Fail!");
                e.printStackTrace();
            }catch (IOException e){
                System.out.println("Fail!");
                e.printStackTrace();
            }
            return null;
        }
    }
}