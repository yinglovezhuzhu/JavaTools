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
package com.xiaoying.opensource.test.coder;

import com.xiaoying.opensource.utils.PasswordCoder;

/**
 * CoderTest class.
 * 
 * @author Yunying.Zhang
 * 
 */
public class CoderTest {

	public static void main(String [] args) {
		String str = "I love java";
		String str2 = PasswordCoder.EncodePassword(str);
		System.out.println(str2);
		System.out.println(PasswordCoder.DecodePassword(str2));
	}
}
