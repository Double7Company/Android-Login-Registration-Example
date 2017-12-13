package touch.in.keep.sobin.loginapp;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    TextInputEditText username,password,email,confirmpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        username =findViewById(R.id.username);
        password = findViewById(R.id.password);
        email    = findViewById(R.id.email);
        confirmpass = findViewById(R.id.confirmpass);
    }

    public void signup(View view){

        String user = username.getText().toString();
        String pass = password.getText().toString();
        String ema  = email.getText().toString();
        String con_pass = confirmpass.getText().toString();

        if(user.isEmpty()){

            username.setError("Invalid Data");
        }else if (pass.isEmpty()){
            password.setError("Invalid data");
        }else if (ema.isEmpty()){
            email.setError("Invalid data");
        }else if ( con_pass.isEmpty() && !pass.equals(con_pass)){
            confirmpass.setError("Invalid data");
        }else {

            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            Toast.makeText(this,"Registration success",Toast.LENGTH_SHORT).show();
        }


    }
}
