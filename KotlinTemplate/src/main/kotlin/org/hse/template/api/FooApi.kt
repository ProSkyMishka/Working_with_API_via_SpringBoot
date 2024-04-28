package org.hse.template.api

import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.hse.template.client.rest.api.HolidayCountry
import org.hse.template.client.rest.model.Holiday
import org.hse.template.client.rest.model.HolidaysMoreResponse
import org.hse.template.client.rest.model.Holidays
import org.hse.template.client.rest.model.HolidaysResponse
import org.springframework.web.bind.annotation.GetMapping

interface FooApi {

    @Tag(name = "Тестовый запрос на получение праздников")
    @ApiResponses(
        ApiResponse(
            description = "Тестовый успешный ответ",
            responseCode = "200"
        )
    )
    fun foo(
        @Schema(
            description = "Год",
            defaultValue = "2024"
        )
        year: Int = 2024,
        @Schema(
            description = "Страна",
            defaultValue = "RU"
        )
        country: String = "RU"
    ): HolidaysResponse

    @Tag(name = "Тестовый запрос на получение праздников по ID")
    @ApiResponses(
        ApiResponse(
            description = "Тестовый успешный ответ",
            responseCode = "200"
        )
    )
    fun fooId(
        @Schema(
            description = "Год",
            defaultValue = "2024"
        )
        year: Int = 2024,
        @Schema(
            description = "Страна",
            defaultValue = "RU"
        )
        country: String = "RU",
        @Schema(
            description = "urlId",
            defaultValue = "russia/new-year-day"
        )
        urlid: String = "russia/new-year-day",
    ): HolidaysMoreResponse

    @Tag(name = "Тестовый запрос на получение праздников по дате")
    @ApiResponses(
        ApiResponse(
            description = "Тестовый успешный ответ",
            responseCode = "200"
        )
    )
    fun fooDate(
        @Schema(
            description = "Год",
            defaultValue = "2024"
        )
        year: Int = 2024,
        @Schema(
            description = "Страна",
            defaultValue = "RU"
        )
        country: String = "RU",
        @Schema(
            description = "дата",
            defaultValue = "2024-04-28"
        )
        date: String = "2024-04-28"
    ): HolidaysResponse

    @Tag(name = "Тестовый запрос на получение предстоящих праздников")
    @ApiResponses(
        ApiResponse(
            description = "Тестовый успешный ответ",
            responseCode = "200"
        )
    )
    fun fooUpcoming(
        @Schema(
            description = "Страна",
            defaultValue = "RU"
        )
        country: String = "RU",
    ): HolidaysResponse

    @Tag(name = "Тестовый запрос на получение праздников по типу")
    @ApiResponses(
        ApiResponse(
            description = "Тестовый успешный ответ",
            responseCode = "200"
        )
    )
    fun fooType(
        @Schema(
            description = "Год",
            defaultValue = "2024"
        )
        year: Int = 2024,
        @Schema(
            description = "Страна",
            defaultValue = "RU"
        )
        country: String = "RU",
        @Schema(
            description = "Тип",
            defaultValue = "National holiday"
        )
        type: String = "National holiday",
    ): HolidaysResponse
}