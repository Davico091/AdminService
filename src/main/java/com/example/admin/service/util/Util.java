package com.example.admin.service.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;

public class Util {

	public static String getJson(Object object){
		Gson gson = new Gson();
		return gson.toJson(object);
	}

	public static String parseDate(String fecha_pedido) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
		Date date = null ;
		try {
			 date = sdf.parse(fecha_pedido);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sdf2.format(date);
	}
	public static void main(String[] args) {
		System.out.println(parseDate("02/08/1991"));
	}
}
