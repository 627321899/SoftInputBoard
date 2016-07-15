package com.hr.nipuream.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.hr.nipurem.softinput.AutoPopLayout;
import com.hr.nipurem.softinput.BaseInputBoard;
import com.hr.nipurem.softinput.PasswordInputView;
import com.hr.nipurem.softinput.SoftInputBoard;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AutoPopLayout autoPopLayout;
    private EditText et1;
    private EditText et2;
    private PasswordInputView passwordInputView;
    private Button showBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoPopLayout = (AutoPopLayout)findViewById(R.id.autoPopLayout);
        et1 = (EditText)findViewById(R.id.auto_et1);
        et2 = (EditText)findViewById(R.id.auto_et2);
        passwordInputView = (PasswordInputView)findViewById(R.id.auto_et3);
        showBtn = (Button)findViewById(R.id.show_pwd);

        List<EditText> ets = new ArrayList<EditText>();
        ets.add(et1);
        ets.add(et2);
        ets.add(passwordInputView);

        BaseInputBoard baseInputBoard = new SoftInputBoard(this);

        autoPopLayout.hideSoftInputMethod(ets,new WeakReference<Activity>(this));
        autoPopLayout.initSoftInputBoard(baseInputBoard);
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,passwordInputView.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}
