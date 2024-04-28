package org.hse.template.controller

import org.hse.template.api.FooApi
import org.hse.template.client.rest.api.HolidayCountry
import org.hse.template.client.rest.model.Holidays
import org.hse.template.client.rest.model.HolidaysMore
import org.hse.template.client.rest.model.HolidaysMoreResponse
import org.hse.template.client.rest.model.HolidaysResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
class FooController(
    private val holidayCountry: HolidayCountry
) : FooApi {
    @GetMapping("/holidays")
    override fun foo(
        @RequestParam year: Int, @RequestParam country: String) = holidayCountry.getHolidays(
            country = country,
            year = year
        )

    @GetMapping("/holidays/{id}")
    override fun fooId(@RequestParam year: Int, @RequestParam country: String, @RequestParam urlid: String) = HolidaysMoreResponse(
        HolidaysMore(holidayCountry.getHolidaysByUrlid(
        country = country,
        year = year,
        urlid = urlid
    ).response.holidays.filter { it.urlid == urlid }))

    @GetMapping("/upcoming")
    override fun fooUpcoming(
        @RequestParam country: String) = HolidaysResponse(Holidays(holidayCountry.getHolidays(
        country = country,
        year = LocalDate.now().year
    ).response.holidays.filter {
        val date = it.date.iso.split('-')
        if ((date[1]).toInt() == LocalDate.now().monthValue) {
            date[2].toInt() > LocalDate.now().dayOfMonth
        } else {
            (date[1]).toInt() > LocalDate.now().monthValue
        }
    }))

    @GetMapping("/byDate")
    override fun fooDate(@RequestParam year: Int, @RequestParam country: String, @RequestParam date: String) = HolidaysResponse(Holidays(holidayCountry.getHolidays(
        country = country,
        year = year,
    ).response.holidays.filter { it.date.iso == date }))

    @GetMapping("/byType")
    override fun fooType(@RequestParam year: Int, @RequestParam country: String, @RequestParam type: String) = HolidaysResponse(Holidays(holidayCountry.getHolidays(
        country = country,
        year = year,
    ).response.holidays.filter { it.type.contains(type) }))
}
