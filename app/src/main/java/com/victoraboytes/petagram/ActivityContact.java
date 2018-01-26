package com.victoraboytes.petagram;

import android.os.StrictMode;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ActivityContact extends AppCompatActivity {
    private String email, password;

    //Declaration of objects
    private EditText edittextMessage, edittextEmail;
    private Button buttonSend;
    private Toolbar actionBar;
    private ActionBar ab;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        //The edit text and button are defined in the layout file
        this.buttonSend         = (Button)findViewById(R.id.buttonSend);
        this.edittextMessage    = (EditText)findViewById(R.id.edittextMessage);
        this.edittextEmail      = (EditText)findViewById(R.id.edittextEmail);

        this.email      = edittextEmail.getText().toString();
        this.password   = "0l@kh3@z3";

        this.buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityContact.this, "Correo enviado",
                        Toast.LENGTH_SHORT).show();
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                        .permitAll().build();
                StrictMode.setThreadPolicy(policy);

                Properties properties = new Properties();
                properties.put("mail.smtp.host","smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port","465");
                properties.put("mail.smtp.socketFactory.class","javax.net.SSLSocketFactory");
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.port","465");

                try {
                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(email, password);
                        }
                    });

                    if (session != null){
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(email));
                        message.setSubject("Email de Petagram");
                        message.setRecipients(Message.RecipientType.TO,
                                InternetAddress.parse("appcorreo2000@gmail.com"));
                        message.setContent(edittextMessage.getText().toString(),
                                "text/html; charset=utf-8");
                        Transport.send(message);
                    }
                }catch (Exception e){

                }
            }
        });

        //The action bar is defined in the layout file
        this.actionBar = (Toolbar)findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);

        //Get a support ActionBar corresponding to this toolbar
        this.ab = getSupportActionBar();

        //Enable the up button
        this.ab.setDisplayHomeAsUpEnabled(true);
    }
}
