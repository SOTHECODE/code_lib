package com.noah.library.lib;

import java.lang.reflect.Field;

public class Code_NoahDataCopyManager<T> {

	
	/**
	 * t2 값중 null이 아닌 필드 값을 t1으로 옮김
	 * @param t1 이쪽에 카피됩니다.
	 * @param t2 카피 당하는쪽
	 */
	public void copy(T t1, T t2) {
		Object obj1 = t1;
		Object obj2 = t2;
        // 반복문을 이용하여 해당 클래스에 정의된 필드를 가져옵니다.
		 try {
			 for (int i = 0; i < obj1.getClass().getDeclaredFields().length; i++) {
				
	        	Field[] fields1 = obj1.getClass().getDeclaredFields();
	        	Field[] fields2 = obj2.getClass().getDeclaredFields();
	        	fields1[i].setAccessible(true);
	        	fields2[i].setAccessible(true);
	        	if(fields1[i].getName().equals("serialVersionUID"))
	        		continue;
	        	
				Object value1 = fields1[i].get(obj1); // 필드에 해당하는 값을 가져옵니다.
				Object value2 = fields2[i].get(obj2); // 필드에 해당하는 값을 가져옵니다.
				// 값이 null 이 아니면 세팅
				if(value2 != null && !value2.toString().equals(""))		
					fields1[i].set(obj1,value2);
	        }
		 }catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}


	}
}
