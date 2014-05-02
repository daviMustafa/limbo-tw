package br.com.limbo.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

public class PreenchedorDeObjeto {

	
	public  <T> T preencher(Class<T> clazz , HttpServletRequest req){
		try {
			Constructor<T> constructor = clazz.getConstructor();
			T instance = constructor.newInstance();
			
			Field[] declaredFields = clazz.getDeclaredFields();
			for (Field field : declaredFields) {
				field.setAccessible(true);
				field.set( instance , getRightType( field.getType()  , req.getParameter( field.getName() ) ) );
				field.setAccessible(false);
			}
			
			return instance;
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private  <T> T getRightType(Class<T> fieldTypeClass , Object value ){
		if( value != null ){
			if( String.class.equals(fieldTypeClass) ){
				return (T) String.valueOf( value );
			}
			if( Long.class.equals(fieldTypeClass) ){
				try{
					Long parseLong = Long.parseLong( (String) value );
					return (T) parseLong;
				}catch(NumberFormatException nfe){
					nfe.printStackTrace();
				}
			}
		}
		return null;
	}
}
