package com.example.temiboardgame;

import android.util.Log;
// 테미 SDK가 설치되어 있다면 아래 주석을 해제하세요.
// import com.robotemi.sdk.Robot;
// import com.robotemi.sdk.TtsRequest;

public class TemiController {

    /**
     * 테미에게 말을 시키는 함수
     * @param position 현재 칸 번호 (필요시 사용)
     * @param text 테미가 말할 내용
     */
    public static void speakForTile(int position, String text) {
        // 1. 로그창(Logcat)에 출력 (앱이 죽지 않게 확인용)
        Log.d("TemiController", "테미가 말합니다: " + text);

        // 2. 실제 테미 로봇에게 말을 시키려면 아래 주석을 해제하고 SDK를 연동해야 합니다.
        /*
        try {
            Robot robot = Robot.getInstance();
            TtsRequest ttsRequest = TtsRequest.create(text, true);
            robot.speak(ttsRequest);
        } catch (Exception e) {
            Log.e("TemiController", "테미 연결 안됨", e);
        }
        */
    }
}