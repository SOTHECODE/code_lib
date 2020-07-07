package com.noah.library.lib;

import java.util.Random;

public class Code_NoahRandomTextManager {

	public static final char[] capitalSmallChars;

	static {
		StringBuilder buffer = new StringBuilder();

		for (char ch = 'a'; ch <= 'z'; ++ch)
			buffer.append(ch);
		for (char ch = 'A'; ch <= 'Z'; ++ch)
			buffer.append(ch);

		capitalSmallChars = buffer.toString().toCharArray();
	}

	public static final char[] numCapitalSmallChars;

	static {
		StringBuilder buffer = new StringBuilder();
		for (char ch = '0'; ch <= '9'; ++ch)
			buffer.append(ch);
		for (char ch = 'a'; ch <= 'z'; ++ch)
			buffer.append(ch);
		for (char ch = 'A'; ch <= 'Z'; ++ch)
			buffer.append(ch);

		numCapitalSmallChars = buffer.toString().toCharArray();
	}

	public static final char[] numCapitalChars;

	static {
		StringBuilder buffer = new StringBuilder();
		for (char ch = '0'; ch <= '9'; ++ch)
			buffer.append(ch);
		for (char ch = 'A'; ch <= 'Z'; ++ch)
			buffer.append(ch);

		numCapitalChars = buffer.toString().toCharArray();
	}

	public static final char[] numSmallChars;

	static {
		StringBuilder buffer = new StringBuilder();
		for (char ch = '0'; ch <= '9'; ++ch)
			buffer.append(ch);
		for (char ch = 'a'; ch <= 'z'; ++ch)
			buffer.append(ch);

		numSmallChars = buffer.toString().toCharArray();
	}

	public static final char[] num;

	static {
		StringBuilder buffer = new StringBuilder();
		for (char ch = '0'; ch <= '9'; ++ch)
			buffer.append(ch);

		num = buffer.toString().toCharArray();
	}

	public static String random(int length, char[] chars) throws IllegalArgumentException {
		if (length < 1)
			throw new IllegalArgumentException("lengtg < 1:" + length);

		StringBuilder randomString = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			randomString.append(chars[random.nextInt(chars.length)]);
		}
		return randomString.toString();
	}
}
