package com.example.alumno.myapplication.activities;

import android.content.Intent;
import android.renderscript.Sampler;
import android.service.autofill.Validators;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alumno.myapplication.Main2Activity;
import com.example.alumno.myapplication.R;
import com.example.alumno.myapplication.models.DetalleActivity;
import com.example.alumno.myapplication.models.User;

import java.util.ArrayList;

import javax.xml.validation.Validator;


public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText txtPassword;
    EditText txtUsuario;
    ArrayList<User> listaUsuarios = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        User user1 = new User();
        user1.setUsername("petshop");
        user1.setPassword("123456");
        User user2 = new User();
        user2.setUsername("luiscastro");
        user2.setPassword("qwerty");
        listaUsuarios.add(user1);
        listaUsuarios.add(user2);

    btnLogin =(Button)findViewById(R.id.btnStart);
    //capturando cajitas
        txtUsuario=(EditText)findViewById(R.id.txtUsername);
        txtPassword=(EditText)findViewById(R.id.txtPassword);
    btnLogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            User userCurrent = User.findUserByUsername(listaUsuarios,txtUsuario.getText().toString());

            if (userCurrent.isValid(txtPassword.getText().toString())){
                Toast.makeText(LoginActivity.this,"autentificaion valida",
                        Toast.LENGTH_LONG).show();
            }



        }
    });
        btnLogin = (Button) findViewById(R.id.btnStart);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x = new Intent(LoginActivity.this, Main2Activity.class);
                LoginActivity.this.startActivity(x);

            }
        });
    }
}
