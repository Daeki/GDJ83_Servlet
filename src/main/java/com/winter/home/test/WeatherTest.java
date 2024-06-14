package com.winter.home.test;

import com.winter.home.weather.WeatherDAO;
import com.winter.home.weather.WeatherDTO;

public class WeatherTest {

	public static void main(String[] args) {
		WeatherDAO weatherDAO = new WeatherDAO();
		WeatherDTO weatherDTO = new WeatherDTO();
		weatherDTO.setNum(2);
		try {
			weatherDAO.delete(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
