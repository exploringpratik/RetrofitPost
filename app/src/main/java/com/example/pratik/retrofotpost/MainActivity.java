package com.example.pratik.retrofotpost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText_email = findViewById(R.id.editText_email);
        final EditText editText_name = findViewById(R.id.editText_name);
        Button button = findViewById(R.id.b_done);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              User user = new User(editText_name.getText().toString(),editText_email.getText().toString());

                sendNetworkRequest(user);
            }
        });
    }

    private void sendNetworkRequest(User user) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("") //Enter Your Base Url Here
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        UserClient client = retrofit.create(UserClient.class);
        HashMap<String, String> headerMap = new HashMap<String, String>();
        headerMap.put("Content-Type", "application/json");
        Call<User> call = client.createAccount(user,headerMap);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
               // Toast.makeText(MainActivity.this,"Yeah! it worked"+ response.body().toString(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Oops! it failed"+ t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
