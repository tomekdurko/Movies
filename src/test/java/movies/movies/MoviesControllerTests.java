package movies.movies;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MoviesApplication.class)
@WebAppConfiguration
public class MoviesControllerTests {
    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;


    private HttpMessageConverter mappingJackson2HttpMessageConverter;


    private List<Movie> movieList = new ArrayList<>();

    @Autowired
    private MovieRepository repo;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

        this.repo.deleteAllInBatch();

        this.movieList.add(repo.save(new Movie("2010","film","Los","160","Paul")));
        this.movieList.add(repo.save(new Movie("2015","granie","Muzyka","120","Marcin")));
    }

    @Test
    public void readSingle() throws Exception {
        mockMvc.perform(get("/movie/" + this.movieList.get(0).getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(this.movieList.get(0).getId().intValue())))
                .andExpect(jsonPath("$.year", is("2010")))
                .andExpect(jsonPath("$.description", is("film")))
                .andExpect(jsonPath("$.name", is("Los")))
                .andExpect(jsonPath("$.duration", is("160")))
                .andExpect(jsonPath("$.director", is("Paul")));
    }

    @Test
    public void addMovie() throws Exception {
        String movieJson = json(new Movie(
                "2018", "opis","Film","90","Tomek"));

        this.mockMvc.perform(post("/movies")
                .contentType(contentType)
                .content(movieJson))
                .andExpect(status().isCreated());
    }
    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }
}
