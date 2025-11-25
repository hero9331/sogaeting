package com.example.temiboardgame;

public class TileInfoProvider {

    // 칸 번호에 따른 제목 반환
    public static String getTitle(int position) {
        switch (position) {
            case 1: return "시작 지점";
            case 2: return "가위바위보 대결";
            case 3: return "잠시 휴식";
            case 4: return "퀴즈 타임";
            case 5: return "보물 발견";
            case 10: return "보스 몬스터";
            default: return position + "번 칸"; // 등록되지 않은 칸
        }
    }

    // 칸 번호에 따른 설명(미션) 반환
    public static String getDescription(int position) {
        switch (position) {
            case 1: return "모험을 시작합니다! 주사위를 굴려주세요.";
            case 2: return "테미와 가위바위보를 해서 이기세요!";
            case 3: return "이번 턴은 아무것도 하지 않고 쉽니다.";
            case 4: return "테미가 내는 퀴즈를 맞히세요.";
            case 5: return "보물상자를 열었습니다. 성공을 누르세요!";
            case 10: return "무시무시한 보스가 나타났습니다!";
            default: return "새로운 모험이 기다리고 있는 칸입니다.";
        }
    }
}