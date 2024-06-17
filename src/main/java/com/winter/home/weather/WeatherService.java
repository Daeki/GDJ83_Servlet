package com.winter.home.weather;

import java.util.List;

public class WeatherService {

	private WeatherDAO weatherDAO;

	public WeatherService() {
		weatherDAO = new WeatherDAO();
	}

	// list
	public List<WeatherDTO> getWeathers() {
		List<WeatherDTO> ar = null;
		try {
			ar = weatherDAO.getWeathers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;

	}

	// detail
	public WeatherDTO getDetail(WeatherDTO weatherDTO) {
		try {
			weatherDTO = weatherDAO.getDetail(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			weatherDTO = null;
		}

		return weatherDTO;
	}

	// add
	public void add(WeatherDTO weatherDTO) {
		try {
			weatherDAO.add(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// delete

	// update
	public void update(WeatherDTO weatherDTO) {
		try {
			weatherDAO.update(weatherDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
