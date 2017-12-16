package touch.in.keep.sobin.loginapp;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText username,password;
    TextView create;

    PrefManager prefManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //layout linking
        username =findViewById(R.id.username);
        password = findViewById(R.id.password);

        create =findViewById(R.id.create);

        //textview click
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //start new activity
                Intent intent = new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        prefManager = new PrefManager(this);

    }

    //button click
    public void login(View view){

        String user = "lumier";
        String pass = "123";

        //getting values from edittext
        String str_username = username.getText().toString();
        String str_password = password.getText().toString();

        if(str_username.equals(user) && str_password.equals(pass)) {

            prefManager.createUser(1);

            //start new activity
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);

        }else{

            //create toast
            Toast.makeText(this,"Invalid Username or Passsword",Toast.LENGTH_SHORT).show();
        }
    }

    protected void onResume(){
        super.onResume();

        Boolean islogged = prefManager.isLoggedIn();

        if(islogged){
            Intent intent =new Intent(this,MainActivity.class);
            startActivity(intent);
        }else{
            
        }

    }
}
