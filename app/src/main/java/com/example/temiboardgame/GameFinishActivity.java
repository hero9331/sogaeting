package com.example.temiboardgame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class GameFinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        TextView tv = findViewById(R.id.tvFinishMessage);
        Button btnRestart = findViewById(R.id.btnRestart);

        tv.setText("🎉 3바퀴 완주! 게임을 종료합니다 🎉");

        btnRestart.setOnClickListener(v -> {
            Intent restart = new Intent(GameFinishActivity.this, MainActivity.class);
            restart.putExtra("position", 1);
            restart.putExtra("lapCount", 0);
            restart.putExtra("skipTurn", false);
            startActivity(restart);
            finish();
        });
    }
}
