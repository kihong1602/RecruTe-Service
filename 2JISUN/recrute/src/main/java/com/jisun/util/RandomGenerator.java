package com.jisun.util;

import java.util.Random;

public class RandomGenerator {
	
	/*랜덤 숫자 생성 메서드*/
	public static int RandomNum() {
		Random random = new Random();
		int minAptId = 1000; // 최소 수험번호
		int maxAptId = 9999; // 최대 수험번호
		return random.nextInt(maxAptId - minAptId + 1) + minAptId;
	}
}
