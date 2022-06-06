package com.student.kppc.preference_report03;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 0, "Setting");
        return super.onCreateOptionsMenu(menu);
    }

    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);
        TextView nameStr = findViewById(R.id.nameStr);
        linearLayout = findViewById(R.id.layout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                if (!(intent.getExtras() == null)) {
                    nameStr.setText(intent.getStringExtra("strName"));
                    nameStr.setTextColor(onTextColor(intent.getStringExtra("valColor")));
                    nameStr.setTypeface(null, onTextBold(intent.getStringExtra("valBold")));
                    linearLayout.setBackgroundColor(onBackColor(intent.getStringExtra("valScreen")));

                }

            }
        });
    }

    private int onTextColor(String valText) {
        int textColor = 0;
        switch (valText) {
            case "0":
                textColor = Color.RED;
                break;
            case "1":
                textColor = Color.BLUE;
                break;
            case "2":
                textColor = Color.GREEN;
                break;
            case "3":
                textColor = Color.BLACK;
                break;
        }
        return textColor;
    }

    private int onTextBold(String textBold) {
        int exception = 0;
        switch (textBold) {
            case "true":
                exception = Typeface.BOLD;
                break;
            case "false":
                exception = Typeface.NORMAL;
                break;
        }

        return exception;
    }

    int onBackColor(String value) {
        int screenColor = 0;
        switch (value) {
            case "0":
                screenColor = Color.RED;
                break;
            case "1":
                screenColor = Color.BLUE;
                break;
            case "2":
                screenColor = Color.GREEN;
                break;
            case "3":
                screenColor = Color.WHITE;
                break;
        }
        return screenColor;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Intent intent = new Intent(MainActivity.this, SettingPreference.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}