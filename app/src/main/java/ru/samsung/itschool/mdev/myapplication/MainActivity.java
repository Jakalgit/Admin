package ru.samsung.itschool.mdev.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    private Button btn, btn2;
    private EditText editText2;
    public static final int ACTIVITY_RESULT_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ButterKnife - библиотека
        btn = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://google.com";
                // неявное намерение
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        editText2 = findViewById(R.id.editText2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // явное намерение
                Intent intent = new Intent(getApplicationContext(),MainActivity2.class);
                intent.putExtra("val",editText2.getText().toString());
               // startActivity(intent);
                startActivityForResult(intent,ACTIVITY_RESULT_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ACTIVITY_RESULT_CODE) {
            if(resultCode == RESULT_OK) {
                String text_from_activity2 = data.getStringExtra("ppp");
                Snackbar.make(findViewById(R.id.root),text_from_activity2,Snackbar.LENGTH_LONG).show();
            }
        }
    }
}