package com.example.step03view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //필드
    private EditText inputMsg;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // res/layout/activity_main.xml 문서를 전개해서 화면 구성하기
        setContentView(R.layout.activity_main);

        /*
            위의 xml 문서를 전개하면
            ConstraintLayout, EditText, Button 객체가 생성된다.
            만일 java code에서 해당 UI를 가지고 어떤 동작을 하려면 그 객체의 참조값이 필요하다
            그 객체의 참조값을 어떻게 얻어오는지를 학습하기
         */

        //id를 이용해서 EditText 객체의 참조값 얻어오기
        this.inputMsg=findViewById(R.id.inputMsg);

        //id를 이용해서 Button 객체의 참조값 얻어오기
        Button sendBtn = findViewById(R.id.sendBtn);

        //버튼을 클릭했을 때 호출될 메소드를 가지고 있는 View.OnClickListener type의 참조값 전달하기
        sendBtn.setOnClickListener(this);

        //id를 이용해서 TextView 객체의 참조값 얻어오기
        this.textView = findViewById(R.id.textView);

    }

    //버튼을 클릭하면 호출되는 메소드
    @Override
    public void onClick(View view) {
        //EditText에 입력한 문자열을 읽어와서 지역변수에 담기
        String msg = this.inputMsg.getText().toString();

        textView.setText(msg);
        //만약 숫자를 출력하고 싶으면 아래와 같은 형태로 출력을 해야한다(문자열 타입으로 변환시켜야함)
        // 그냥 숫자를 넣을경우(setText(100)), 아이디값으로 알아듣기 때문이다 .
        // this.textView.setText(Integer.toString(100));
        
        //빈 문자열을 입력해서 입럭창 지우기
        inputMsg.setText("");

        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}