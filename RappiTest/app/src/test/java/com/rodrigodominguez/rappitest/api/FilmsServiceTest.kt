package com.rodrigodominguez.rappitest.api

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.Okio
import org.hamcrest.CoreMatchers.`is`
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(JUnit4::class)
class FilmsServiceTest {
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var service: FilmsService

    private lateinit var mockWebServer: MockWebServer

    @Before
    fun createService() {
        mockWebServer = MockWebServer()
        service = Retrofit.Builder()
                .baseUrl(mockWebServer.url(""))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(FilmsService::class.java)
    }

    @After
    fun stopService() {
        mockWebServer.shutdown()
    }

    @Test
    fun requestGetFilm() {
        runBlocking {
            enqueueResponse("movie.json")
            val resultResponse = service.getFilm("550")

            val request = mockWebServer.takeRequest()
            assertNotNull(resultResponse)
            assertThat(request.path, `is`("/movie/550%7D?api_key=ac0719d1d31b0f444c5a62ddfcfea043"))
        }
    }

    @Test
    fun getGetFilmResponse() {
        runBlocking {
            enqueueResponse("movie.json")
            val resultResponse = service.getFilm("550")
            val id = resultResponse.id
            val adult = resultResponse.adult
            val language = resultResponse.original_language


            assertThat(id, `is`(550))
            assertThat(adult, `is`(false))
            assertThat(language, `is`("en"))
        }
    }


    @Test
    fun requestGetFilms() {
        runBlocking {
            enqueueResponse("films.json")
            val resultResponse = service.getFilms("2010")

            val request = mockWebServer.takeRequest()
            assertNotNull(resultResponse)
            assertThat(request.path, `is`("/discover/movie?sort_by=vote_average.desc&api_key=ac0719d1d31b0f444c5a62ddfcfea043&year=2010"))
        }
    }

    @Test
    fun getGetFilmsResponse() {
        runBlocking {
            enqueueResponse("films.json")
            val resultResponse = service.getFilms("2010")

            assertThat(resultResponse.result.size, `is`(20))
            assertThat(resultResponse.page, `is`(1))
            assertThat(resultResponse.totalPages, `is`(500))

            val itemOne = resultResponse.result[0]

            assertThat(itemOne.id, `is`(704348))
            assertThat(itemOne.adult, `is`(false))
            assertThat(itemOne.originalLanguage, `is`("en"))
            assertThat(itemOne.originalTitle, `is`("Agents of Secret Stuff"))
            assertThat(itemOne.title, `is`("Agents of Secret Stuff"))
            assertThat(itemOne.genreIds.size, `is`(2))
            assertThat(itemOne.popularity, `is`(0.6f))
            assertThat(itemOne.voteCount, `is`(1))
        }
    }

    private fun enqueueResponse(fileName: String, headers: Map<String, String> = emptyMap()) {
        val inputStream = javaClass.classLoader?.getResourceAsStream("api-response/$fileName")
        val source = Okio.buffer(Okio.source(inputStream))
        val mockResponse = MockResponse()
        for ((key, value) in headers) {
            mockResponse.addHeader(key, value)
        }
        mockWebServer.enqueue(mockResponse.setBody(
                source.readString(Charsets.UTF_8))
        )
    }
}
