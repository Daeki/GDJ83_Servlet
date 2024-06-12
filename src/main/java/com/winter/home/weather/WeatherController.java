package com.winter.home.weather;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.home.Action;

public class WeatherController {

	private WeatherService ws;

	public WeatherController() {
		ws = new WeatherService();
	}

	public Action start(HttpServletRequest request) {
		// /weather/***
		// list
		// add
		// delete
		// detail

		// /weather/list
		String uri = request.getRequestURI();

		uri = uri.substring(uri.lastIndexOf("/") + 1);

		System.out.println(uri);

		Action action = new Action();
		action.setFlag(true);

		if (uri.equals("list")) {
			//
			List<WeatherDTO> ar = ws.getWeathers();
			request.setAttribute("list", ar);
			action.setPath("/WEB-INF/views/weather/list.jsp");

		} else if (uri.equals("add")) {
			action.setPath("/WEB-INF/views/weather/add.jsp");

		} else if (uri.equals("delete")) {

		} else if (uri.equals("detail")) {
			action.setPath("/WEB-INF/views/weather/detail.jsp");
		} else {

		}

		return action;

	}

}
