package com.example.temiboardgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button; // MaterialButton도 Button으로 받을 수 있습니다.
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // XML에서 정의한 ID와 변수 이름을 일치시킵니다.
    private TextView tvDiceValue;
    private TextView tvPosition;
    private Button btnRollDice;

    // 현재 플레이어 위치 (기본값 1)
    private int currentPosition = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. UI 컴포넌트 연결 (보내주신 XML ID 사용)
        tvDiceValue = findViewById(R.id.tvDiceValue);
        tvPosition = findViewById(R.id.tvPosition);
        btnRollDice = findViewById(R.id.btnRollDice);

        // 2. 이전 화면(ResultActivity)에서 돌아왔을 때 위치 데이터 받기
        Intent receivedIntent = getIntent();
        if (receivedIntent != null && receivedIntent.hasExtra("position")) {
            currentPosition = receivedIntent.getIntExtra("position", 1);
        }

        // 3. 현재 위치 화면에 표시
        updateUI();

        // 4. 버튼 클릭 이벤트
        btnRollDice.setOnClickListener(v -> {
            rollDiceAndMove();
        });
    }

    private void rollDiceAndMove() {
        // 1~6 랜덤 숫자 생성
        Random random = new Random();
        int diceNumber = random.nextInt(6) + 1;

        // 주사위 숫자 화면에 업데이트 (String으로 변환 필요)
        tvDiceValue.setText(String.valueOf(diceNumber));

        // 위치 계산
        currentPosition += diceNumber;

        // 위치 텍스트 업데이트
        updateUI();

        // ★ TileActivity로 이동 (잠시 딜레이를 주고 싶다면 Handler를 쓸 수 있지만, 지금은 즉시 이동)
        Intent intent = new Intent(MainActivity.this, TileActivity.class);
        intent.putExtra("position", currentPosition);
        startActivity(intent);

        // ResultActivity에서 다시 MainActivity를 호출하므로, 현재 액티비티는 종료
        finish();
    }

    // 화면 글씨 업데이트용 헬퍼 메서드
    private void updateUI() {
        tvPosition.setText("현재 칸: " + currentPosition);
    }
}