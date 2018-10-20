package com.util;

public class DebugUtil {
	public static void debugInfo(Object object) {
		System.out.println("debug->" + object);
	}

	public static void useTime(long time) {
		debugInfo("time:" + (System.currentTimeMillis() - time) + "ms.");
	}
}
