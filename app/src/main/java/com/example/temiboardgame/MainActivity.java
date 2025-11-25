package com.example.temiboardgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvDiceValue;
    private TextView tvPosition;
    private Button btnRollDice;

    private int currentPosition = 1;
    private int lapCount = 0;
    private boolean skipTurn = false;      // 무인도 1턴 쉬기 여부
    private boolean justEscaped = false;   // 방금 무인도에서 탈출했는지 여부

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDiceValue = findViewById(R.id.tvDiceValue);
        tvPosition = findViewById(R.id.tvPosition);
        btnRollDice = findViewById(R.id.btnRollDice);

        Intent receivedIntent = getIntent();
        if (receivedIntent != null) {
            currentPosition = receivedIntent.getIntExtra("position", 1);
            lapCount = receivedIntent.getIntExtra("lapCount", 0);
            skipTurn = receivedIntent.getBooleanExtra("skipTurn", false);
        }

        updateUI();

        btnRollDice.setOnClickListener(v -> rollDiceAndMove());
    }

    private void rollDiceAndMove() {

        // ✅ 무인도였던 다음 턴 → 이번은 그냥 탈출 안내만 하고 끝
        if (skipTurn) {
            skipTurn = false;
            justEscaped = true;

            tvDiceValue.setText("-");
            tvPosition.setText("무인도에서 탈출했습니다! 주사위를 굴리세요!");
            return;
        }

        // ✅ 방금 탈출한 후 정상 진행
        if (justEscaped) {
            justEscaped = false;
        }

        // ✅ 주사위 굴리기
        Random random = new Random();
        int diceNumber = random.nextInt(6) + 1;
        tvDiceValue.setText(String.valueOf(diceNumber));

        currentPosition += diceNumber;

        // ✅ 12칸 보드 순환
        if (currentPosition > 12) {
            lapCount++;
            currentPosition = ((currentPosition - 1) % 12) + 1;
        }

        // ✅ 3번 칸 → 자동 2칸 뒤로 이동
        if (currentPosition == 3) {
            currentPosition -= 2;
            if (currentPosition < 1) currentPosition += 12;
        }

        // ✅ 4번 칸 → 다음 턴 쉬기 설정
        if (currentPosition == 4) {
            skipTurn = true;
        }

        updateUI();

        // ✅ 3바퀴 완주 → 게임 종료
        if (lapCount >= 3) {
            Intent finishIntent = new Intent(MainActivity.this, GameFinishActivity.class);
            sendGameState(finishIntent);
            startActivity(finishIntent);
            finish();
            return;
        }

        goToTile();
    }

    private void goToTile() {
        Intent intent = new Intent(MainActivity.this, TileActivity.class);
        sendGameState(intent);
        startActivity(intent);
        finish();
    }

    private void sendGameState(Intent intent) {
        intent.putExtra("position", currentPosition);
        intent.putExtra("lapCount", lapCount);
        intent.putExtra("skipTurn", skipTurn);
    }

    private void updateUI() {
        tvPosition.setText("현재 칸: " + currentPosition + " / " + lapCount + "바퀴 완료");
    }
}
