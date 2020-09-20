package com.example.javamaildemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText email, subject, message;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.et_to);
        subject = findViewById(R.id.et_subject);
        message = findViewById(R.id.et_message);
        button = findViewById(R.id.bt_send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }

    private void sendEmail() {
        String mEmail = email.getText().toString();
        String mSubject = subject.getText().toString();
        String mMessage = message.getText().toString();

        JavaMailApi javaMailApi = new JavaMailApi(this, mEmail, mSubject, mMessage);
        javaMailApi.execute();
    }
}