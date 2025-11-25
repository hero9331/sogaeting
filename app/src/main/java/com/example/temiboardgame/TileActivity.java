package com.example.temiboardgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TileActivity extends AppCompatActivity {

    private TextView tvTileTitle;
    private TextView tvTileDescription;
    private Button btnGoResult;

    private int position;
    private int lapCount;
    private boolean skipTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tile);

        tvTileTitle = findViewById(R.id.tvTileTitle);
        tvTileDescription = findViewById(R.id.tvTileDescription);
        btnGoResult = findViewById(R.id.btnGoResult);

        Intent receivedIntent = getIntent();
        position = receivedIntent.getIntExtra("position", 0);
        lapCount = receivedIntent.getIntExtra("lapCount", 0);
        skipTurn = receivedIntent.getBooleanExtra("skipTurn", false);

        String title = TileInfoProvider.getTitle(position);
        String desc = TileInfoProvider.getDescription(position);

        tvTileTitle.setText(title);
        tvTileDescription.setText(desc);

        TemiController.speakForTile(position, desc);

        // ✅ 무인도(4번 칸) 도착 시 — 성공/실패 화면 없이 자동 이동
        if (position == 4) {
            btnGoResult.setVisibility(View.GONE);

            tvTileDescription.postDelayed(() -> {
                Intent goMain = new Intent(TileActivity.this, MainActivity.class);
                goMain.putExtra("position", position);
                goMain.putExtra("lapCount", lapCount);
                goMain.putExtra("skipTurn", true); // ✅ 다음 턴 쉬기
                startActivity(goMain);
                finish();
            }, 2000);
            return;
        }

        btnGoResult.setOnClickListener(v -> {
            Intent goResult = new Intent(TileActivity.this, ResultActivity.class);
            goResult.putExtra("position", position);
            goResult.putExtra("lapCount", lapCount);
            goResult.putExtra("skipTurn", skipTurn);
            startActivity(goResult);
            finish();
        });
    }
}
