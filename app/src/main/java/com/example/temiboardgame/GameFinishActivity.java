package com.example.temiboardgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class GameFinishActivity extends AppCompatActivity {

    private int position;
    private int lapCount;
    private boolean skipTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        TextView tvFinishMessage = findViewById(R.id.tvFinishMessage);
        Button btnRestart = findViewById(R.id.btnRestart);

        Intent receivedIntent = getIntent();
        position = receivedIntent.getIntExtra("position", 1);
        lapCount = receivedIntent.getIntExtra("lapCount", 0);
        skipTurn = receivedIntent.getBooleanExtra("skipTurn", false);

        tvFinishMessage.setText("🎉 3바퀴 완주! 게임 종료! 🎉");

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
