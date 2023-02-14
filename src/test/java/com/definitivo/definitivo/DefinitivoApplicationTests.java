package com.definitivo.definitivo;

import com.definitivo.definitivo.models.Course;
import com.definitivo.definitivo.repository.AuthorRepository;
import com.definitivo.definitivo.services.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockHttpServletRequestDsl;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class DefinitivoApplicationTests {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private CourseService courseService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testPostCourse() throws Exception{
		Course course = Course.builder()
				.title("rapid spring boot")
				.category("java")

				.rating(5).build();

		ObjectMapper objectMapper = new ObjectMapper();


	}

	@Test
	public void WhenCountCourseExpectTwo(){

		assertThat(authorRepository.getAuthorCourseInfo(1)).hasSize(2);
	}


	@Test
	void contextLoads() {
	}

}
