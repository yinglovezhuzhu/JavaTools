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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * File tools class.
 * 
 * @author Yunying.Zhang
 * 
 */
public class FileUtils {

	public static final int BUFFER_SIZE = 1024 * 1024 * 1;
	
	/**
	 * Get file size(include directory)
	 * @param file
	 * @return
	 */
	public static long getFileSize(File file) {
		long size = 0L;
		if(file.exists()) {
			if(file.isDirectory()) {
				File [] files = file.listFiles();
				for (File file2 : files) {
					size += getFileSize(file2);
				}
			} else {
				size += file.length();
			}
		}
		return size;
	}
	
	/**
	 * Change byte to KB/MB/GB...(Accurate to two decimal places)
	 * @param context
	 * @param size
	 * @return
	 */
	public static String formatSize(long size){
		if(size <= 0) {
			return "0B";
		}
		String [] units = new String [] {"B", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB", "NB", "DB", "CB",};
		int i = 0;
		float newSize = size;
		while(newSize >= 1024) {
			newSize /= 1024;
			i++;
		}
		if(i > units.length - 1) {
			return "Unknown";
		}
		return String.format("%.2f", newSize) + units[i];
	}
	
	/**
	 * Copy a file to destPath. only file.
	 * @param file
	 * @param destPath
	 * @throws IOException
	 */
	public static void copyFile(File file, File destPath) throws IOException {
		if(file.isDirectory()) {
			return;
		}
		if(!destPath.exists()) {
			destPath.mkdirs();
		}
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(new File(destPath, file.getName()));
		byte [] buf = new byte[BUFFER_SIZE];
		int length = -1;
		while((length = fis.read(buf)) != -1) {
			fos.write(buf, 0, length);
		}
		fos.flush();
		fos.close();
		fis.close();
	}

	/**
	 * Copy files to destPath, can be a folder.
	 * @param file
	 * @param destPath
	 * @throws IOException
	 */
	public static void copyFiles(File file, File destPath) throws IOException {
		if(file.isDirectory()) {
			File dest = new File(destPath, file.getName());
			File [] files = file.listFiles();
			for (File subFile : files) {
				copyFiles(subFile, dest);
			}
		} else {
			copyFile(file, destPath);
		}
	}
	
	/**
	 * Delete file(include not empty directory)
	 * @param file
	 */
	public static void deleteFile(File file) {
		if(file.exists()) {
			if(file.isDirectory()) {
				File [] files = file.listFiles();
				for (File file2 : files) {
					deleteFile(file2);
				}
			}
			file.delete();
		}
	}
	
}
