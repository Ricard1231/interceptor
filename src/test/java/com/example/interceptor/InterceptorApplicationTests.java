package com.example.interceptor;

import com.example.interceptor.controllers.CDPlayerControllerImpl;
import com.example.interceptor.dtos.ChangeSongDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebMvcTest(CDPlayerControllerImpl.class)
class InterceptorApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() {
	}

	@SneakyThrows
	@Test
	void changeSong() {
		final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);
		final String baseURL = "http://localhost:8080/cdplayer";

		LocalDate currentDate = LocalDate.now();
		String fileName = "PlayerLogs" + currentDate.getDayOfMonth() + currentDate.getMonthValue() + currentDate.getYear() + ".txt";

		File file = new File(fileName);
		file.delete();

		ChangeSongDTO dto = new ChangeSongDTO();
		dto.setSong("samplesong");

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(dto);

		RequestBuilder request = MockMvcRequestBuilders.post(baseURL + "/song")
				.contentType(APPLICATION_JSON_UTF8)
				.content(requestJson);
		mvc.perform(request).andExpect(status().isOk());

		if (!file.exists()) {
			fail("File not found");
		}

		List<String> expectedFileLines = new ArrayList<>();
		String firstLine = "URL: http://localhost:8080/cdplayer/song";
		expectedFileLines.add(firstLine);
		String secondLine = "Player song before call: null";
		expectedFileLines.add(secondLine);

		int i = 0;
		Scanner myReader = new Scanner(file);
		while (myReader.hasNextLine() && i < expectedFileLines.size()) {
			String data = myReader.nextLine();
			assertEquals(expectedFileLines.get(i), data);
			i++;
		}
		myReader.close();
	}

}
