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
package com.xiaoying.opensource.test.file;

import java.io.File;
import java.io.IOException;

import com.xiaoying.opensource.utils.FileUtils;

/**
 * FileTest class.
 * 
 * @author Yunying.Zhang
 * 
 */
public class FileTest {

	public static void main(String [] args) {
		try {
			FileUtils.copyFiles(new File("/home/xiaoying/IQQ"), new File("/home/xiaoying/new"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
