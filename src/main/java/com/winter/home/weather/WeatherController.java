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

		// method 형식
		String method = request.getMethod().toUpperCase();

		if (uri.equals("list")) {
			//
			List<WeatherDTO> ar = ws.getWeathers();
			request.setAttribute("list", ar);
			action.setPath("/WEB-INF/views/weather/list.jsp");

		} else if (uri.equals("add")) {

			if (method.equals("POST")) {
				String city = request.getParameter("city");
				double gion = Double.parseDouble(request.getParameter("gion"));
				int humanity = Integer.parseInt(request.getParameter("huminity"));
				String status = request.getParameter("status");
				WeatherDTO weatherDTO = new WeatherDTO();
				weatherDTO.setCity(city);
				weatherDTO.setGion(gion);
				weatherDTO.setHuminity(humanity);
				weatherDTO.setStatus(status);

				ws.add(weatherDTO);

				// action.setPath("/weather/list");
				// action.setPath("list");
				action.setPath("./list");
				action.setFlag(false);
			} else {
				action.setPath("/WEB-INF/views/weather/add.jsp");
			}

		} else if (uri.equals("delete")) {

		} else if (uri.equals("detail")) {
			//
			String num = request.getParameter("num");
			WeatherDTO weatherDTO = new WeatherDTO();
			weatherDTO.setNum(Long.parseLong(num));
			weatherDTO = ws.getDetail(weatherDTO);

			if (weatherDTO != null) {
				request.setAttribute("dto", weatherDTO);
				action.setPath("/WEB-INF/views/weather/detail.jsp");
			} else {
				request.setAttribute("message", "정보가 없습니다");
				action.setPath("/WEB-INF/views/commons/message.jsp");
			}
		} else if (uri.equals("update")) {

			if (method.toUpperCase().equals("POST")) {
				WeatherDTO weatherDTO = new WeatherDTO();
				weatherDTO.setNum(Long.parseLong(request.getParameter("num")));
				String city = request.getParameter("city");
				double gion = Double.parseDouble(request.getParameter("gion"));
				int humanity = Integer.parseInt(request.getParameter("huminity"));
				String status = request.getParameter("status");
				weatherDTO.setCity(city);
				weatherDTO.setGion(gion);
				weatherDTO.setHuminity(humanity);
				weatherDTO.setStatus(status);

				ws.update(weatherDTO);

				action.setFlag(false);
				action.setPath("./list");

			} else {

				WeatherDTO weatherDTO = new WeatherDTO();
				weatherDTO.setNum(Long.parseLong(request.getParameter("num")));
				weatherDTO = ws.getDetail(weatherDTO);
				request.setAttribute("dto", weatherDTO);
				action.setPath("/WEB-INF/views/weather/update.jsp");
			}

		} else {

		}

		return action;

	}

}
