package com.winter.home.weather;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class WeatherDAO {

	// DTO : Data Transfer Object
	// DAO : Data Access Object

	// getWeathers
	// 파일에 날씨정보들을 ㅇ읽어와서 파싱 한 후에 DTO에 담아서 리턴

	// list
	public List<WeatherDTO> getWeathers() throws Exception {
		File file = new File("C:\\study\\weather.txt");

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		ArrayList<WeatherDTO> list = new ArrayList<WeatherDTO>();

		while (true) {
			String s = br.readLine();
			if (s == null) {
				break;
			}
			WeatherDTO weatherDTO = new WeatherDTO();
			s = s.replace(",", "-");
			String[] ar = s.split("-");
			weatherDTO.setNum(Long.parseLong(ar[0].trim()));
			weatherDTO.setCity(ar[1].trim());
			weatherDTO.setGion(Double.parseDouble(ar[2].trim()));
			weatherDTO.setHuminity(Integer.parseInt(ar[4].trim()));
			weatherDTO.setStatus(ar[3].trim());
			list.add(weatherDTO);
		}

		br.close();
		fr.close();

		return list;
	}

	// detail
	public WeatherDTO getDetail(WeatherDTO weatherDTO) throws Exception {
		List<WeatherDTO> ar = this.getWeathers();

		WeatherDTO result = null;

		for (WeatherDTO w : ar) {
			if (w.getNum() == weatherDTO.getNum()) {
				result = w;
				break;
			}
		}

		return result;

	}

	// add
	public void add(WeatherDTO weatherDTO) throws Exception {
		List<WeatherDTO> ar = this.getWeathers();

		// 도시명-기온-상태-습도
		StringBuffer stringBuffer = new StringBuffer();
		Calendar ca = Calendar.getInstance();
		stringBuffer.append(ca.getTimeInMillis());
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getCity());
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getGion());
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getStatus());
		stringBuffer.append("-");
		stringBuffer.append(weatherDTO.getHuminity());

		File file = new File("C:\\study\\weather.txt");

		FileWriter fileWriter = new FileWriter(file, true);

		fileWriter.write(stringBuffer.toString() + "\r\n");
		fileWriter.flush();

		fileWriter.close();

	}

	// delete
	public void delete(WeatherDTO weatherDTO) throws Exception {
		// list불러와서
		// 지울려고 하는 num과 일치하는 것을 리스트에서 삭제
		// list를 파일에 다시 저장
		FileWriter f = new FileWriter("C:\\study\\weather.txt", false);

		List<WeatherDTO> list = this.getWeathers();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getNum() == weatherDTO.getNum()) {
				list.remove(i);
				break;
			}
		}

		for (WeatherDTO dto : list) {
			if (dto.getNum() == weatherDTO.getNum()) {
				continue;
				// list.remove(dto);
				// break;
			}
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append(dto.getNum());
			stringBuffer.append("-");
			stringBuffer.append(dto.getCity());
			stringBuffer.append("-");
			stringBuffer.append(dto.getGion());
			stringBuffer.append("-");
			stringBuffer.append(dto.getStatus());
			stringBuffer.append("-");
			stringBuffer.append(dto.getHuminity());
			f.write(stringBuffer.toString() + "\r\n");
			f.flush();

		}

		// list 파일에 작성

		File file = new File("c:\\study\\weather.txt");

		FileWriter fw = new FileWriter(file, false);
		StringBuffer stringBuffer = new StringBuffer();
		for (WeatherDTO dto : list) {
			stringBuffer.append(dto.getNum());
			stringBuffer.append("-");
			stringBuffer.append(dto.getCity());
			stringBuffer.append("-");
			stringBuffer.append(dto.getGion());
			stringBuffer.append("-");
			stringBuffer.append(dto.getStatus());
			stringBuffer.append("-");
			stringBuffer.append(dto.getHuminity());
			stringBuffer.append("\r\n");
		}
		fw.write(stringBuffer.toString() + "\r\n");
		fw.flush();

	}

}
