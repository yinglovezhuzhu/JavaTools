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
package com.xiaoying.opensource.test.reflect;

import java.util.HashMap;
import java.util.Map;

import com.xiaoying.opensource.utils.BeanRefUtils;

/**
 * TestReflect class.
 * 
 * @author Yunying.Zhang
 *
 */
public class TestReflect {

	public static void main(String [] args) {
		ClassA a = new ClassA();
		a.setName("AAAA");
		a.setAge(20);
		//Get values
		System.out.println(BeanRefUtils.getFieldValueMap(a));
		
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("name", "AAAA2");
		values.put("sex", "BBBBB"); //ClassA has no field named "sex", so it won't be set to.
		//Set values
		BeanRefUtils.setFieldValues(a, values);
		System.out.println(BeanRefUtils.getFieldValueMap(a));
		
		
		ClassB b = new ClassB();
		b.setName("BBBB");
		b.setAge(22);
		//Get values
		System.out.println(BeanRefUtils.getFieldValueMap(b));
		
		values.clear();
		values.put("weight", 75);
		values.put("height", 175);
		values.put("job", "Programer");
		values.put("addr", "Guangdong China");
		values.put("sex", "male"); //ClassB and it's superclass has no field named "sex", so it won't be set to.
		BeanRefUtils.setFieldValues(b, values);
		System.out.println(BeanRefUtils.getFieldValueMap(b));
	}
}
