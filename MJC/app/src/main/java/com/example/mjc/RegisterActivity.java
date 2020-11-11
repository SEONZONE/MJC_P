package com.example.mjc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText reg_ID, reg_Password, reg_Address,reg_Name;
    private Button btn_reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) { //액티비티 시작시 처음으로 실행되는 생명주기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        //아이디 값 찾아주기
        reg_ID = findViewById(R.id.reg_ID);
        reg_Address = findViewById(R.id.reg_Address);
        reg_Password = findViewById(R.id.reg_Password);
        reg_Name = findViewById(R.id.reg_Name);



        // 회원가입 버튼 클릭시 수행
        btn_reg = findViewById(R.id.btn_reg);
        btn_reg.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                // EditText 에 현재 입력되어있는 값을 get(가져온다).
                String userID = reg_ID.getText().toString();
                String userPassword = reg_Password.getText().toString();
                String userName = reg_Name.getText().toString();
                String userAddress = reg_Address.getText().toString();


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success) { //회원가입에 성공한 경우
                                Toast.makeText(getApplicationContext(),"회원가입에 성공했습니다.",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"회원가입에 실패했습니다.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                };
                // 서버로 Volley를 이용해서 요청을 한다.
                RegisterRequest registerRequest = new RegisterRequest(userID,userPassword,userName,userAddress,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);


            }
        });
    }
}