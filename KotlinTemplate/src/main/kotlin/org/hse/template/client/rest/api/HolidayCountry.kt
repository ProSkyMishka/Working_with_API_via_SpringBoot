package org.hse.template.client.rest.api

import org.hse.template.client.rest.model.*
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "calendarific")
interface HolidayCountry {

    @GetMapping("holidays")
    fun getHolidays(
        @RequestParam("api_key")
        apiKey: String = "ofNWGZrnrgzlHRtYWP2FGZpY96E00Fyy",
        @RequestParam("country")
        country: String,
        @RequestParam("year")
        year: Int
    ): HolidaysResponse

    @GetMapping("holidays")
    fun getHolidaysByUrlid(
        @RequestParam("api_key")
        apiKey: String = "ofNWGZrnrgzlHRtYWP2FGZpY96E00Fyy",
        @RequestParam("country")
        country: String,
        @RequestParam("year")
        year: Int,
        @RequestParam("urlid")
        urlid: String
    ): HolidaysMoreResponse
}
