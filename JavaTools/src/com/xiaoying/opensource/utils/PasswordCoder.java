/*
 * Copyright (C) 2013 The Open Source Project By Yunying.Zhang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * author:Yunying.Zhang
 * date:2013-09-27
 */
package com.xiaoying.opensource.utils;


/**
 * Encode and Decode password.
 * @author Yunying.Zhang
 *
 */
public class PasswordCoder {
	/**
	 * Encode password
	 * @param strPasswd
	 * @return
	 */
	public static String EncodePassword(String strPasswd) {

		String encodedPassword = "";
		
		if ((strPasswd == null) || strPasswd.length() == 0) {
			return encodedPassword;
		}
		String strKey = EncipherConst.m_strKey1 + EncipherConst.m_strKey2
				+ EncipherConst.m_strKey3 + EncipherConst.m_strKey4
				+ EncipherConst.m_strKey5 + EncipherConst.m_strKey6;
		while (strPasswd.length() < 8) {
			strPasswd = strPasswd + (char) 1;
		}
		for (int i = 0; i <= strPasswd.length() - 1; i++) {
			char code;
			while (true) {
				code = (char) Math.rint(Math.random() * 100);
				while ((code > 0) && (((code ^ strPasswd.charAt(i)) < 0) || ((code ^ strPasswd.charAt(i)) > 90))) {
					code = (char) ((int) code - 1);
				}
				char mid = 0;
				int flag = code ^ strPasswd.charAt(i);
				if (flag > 93) {
					mid = 0;
				} else {
					mid = strKey.charAt(flag); // Asc(Mid(strKey, (code Xor
												// Asc(Mid(strPasswd, n, 1))) +
												// 1, 1))
				}
				if ((code > 35) & (code < 122) & (code != 124) & (code != 39)
						& (code != 44) & (mid != 124) & (mid != 39)
						& (mid != 44)) {
					break;
				}
				//Ensures that the made character is visible characters and valid in SQL statements
			}
			char temp = strKey.charAt(code ^ strPasswd.charAt(i));
			encodedPassword = encodedPassword + (char) code + temp;
		}
		return encodedPassword;

	}

	/**
	 * Decode password.
	 * @param varCode
	 * @return
	 */
	public static String DecodePassword(String varCode) {
		String decodedPassword = "";
		if ((varCode == null) || (varCode.length() == 0)) {
			return decodedPassword;
		}
		String strKey = EncipherConst.m_strKey1 + EncipherConst.m_strKey2
				+ EncipherConst.m_strKey3 + EncipherConst.m_strKey4
				+ EncipherConst.m_strKey5 + EncipherConst.m_strKey6;
		if (varCode.length() % 2 == 1) {
			varCode = varCode + "?";
		}
		for (int i = 0; i <= varCode.length() / 2 - 1; i++) {
			char ch = varCode.charAt(i * 2);
			int a = (int) strKey.indexOf(varCode.charAt(i * 2 + 1));
			decodedPassword = decodedPassword + (char) ((int) ch ^ a);
		}
		int index = decodedPassword.indexOf(1);
		if (index > 0) {
			return decodedPassword.substring(0, index);
		} else {
			return decodedPassword;
		}
	}

	static class EncipherConst {

		public final static String m_strKey1 = "zxcvbnm,./asdfg";

		public final static String m_strKeya = "cjk;";

		public final static String m_strKey2 = "hjkl;'qwertyuiop";

		public final static String m_strKeyb = "cai2";

		public final static String m_strKey3 = "[]\\1234567890-";

		public final static String m_strKeyc = "%^@#";

		public final static String m_strKey4 = "=` ZXCVBNM<>?:LKJ";

		public final static String m_strKeyd = "*(N";

		public final static String m_strKey5 = "HGFDSAQWERTYUI";

		public final static String m_strKeye = "%^HJ";

		public final static String m_strKey6 = "OP{}|+_)(*&^%$#@!~";

	}
}
