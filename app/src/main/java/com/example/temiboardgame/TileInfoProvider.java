package com.example.temiboardgame;

public class TileInfoProvider {

    public static String getTitle(int position) {
        switch (position) {
            case 1: return "시작 - 눈싸움게임";
            case 2: return "압력 맞추기";
            case 3: return "2칸 뒤로";
            case 4: return "무인도(감옥)";
            case 5: return "인간 빼빼로 게임";
            case 6: return "황금 열쇠";
            case 7: return "시간 맞추기";
            case 8: return "올림픽";
            case 9: return "불빛 반응 속도";
            case 10: return "물 양 맞추기";
            case 11: return "황금 열쇠";
            case 12: return "손잡고 온도 올리기";
            default: return position + "번 칸";
        }
    }

    public static String getDescription(int position) {
        switch (position) {
            case 1: return "눈싸움 게임! 먼저 눈 깜빡이면 패배!";
            case 2: return "압력을 정확하게 맞춰보세요!";
            case 3: return "앗! 함정입니다. 자동으로 2칸 뒤로 이동!";
            case 4: return "무인도입니다! 다음 턴은 쉽니다.";
            case 5: return "인간 빼빼로 게임 도전!";
            case 6: return "황금 열쇠! 어떤 일이 벌어질까요?";
            case 7: return "정해진 시간을 정확하게 맞춰보세요!";
            case 8: return "올림픽 종목을 선택해 도전!";
            case 9: return "불빛 반응 테스트! 가장 빠르게 움직이세요!";
            case 10: return "물의 양을 최대한 정확히 맞춰보세요!";
            case 11: return "황금 열쇠입니다! 행운 또는 위기!";
            case 12: return "손을 잡고 체온을 올려보세요!";
            default: return "새로운 모험이 기다립니다!";
        }
    }
}
