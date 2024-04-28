package org.hse.template.client.rest.model

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Праздник")
data class Holiday(
    @Schema(description = "name")
    var name: String,
    @Schema(description = "description")
    var description: String,
    @Schema(description = "date")
    var date: Date,
    @Schema(description = "type")
    var type: List<String>,
    @Schema(description = "urlid")
    var urlid: String,
)

@Schema(description = "Праздник")
data class HolidayMore(
    @Schema(description = "name")
    var name: String,
    @Schema(description = "description")
    var description: String,
    @Schema(description = "date")
    var date: Date,
    @Schema(description = "type")
    var type: List<String>,
    @Schema(description = "primary_type")
    var primary_type: String,
    @Schema(description = "canonical_url")
    var canonical_url: String,
    @Schema(description = "urlid")
    var urlid: String,
    @Schema(description = "locations")
    var locations: String,
    @Schema(description = "states")
    var states: String
)

@Schema(description = "Дата")
data class Date(
    @Schema(description = "iso")
    var iso: String
)

@Schema(description = "Праздники")
data class HolidaysMore(
    @Schema(description = "Праздники")
    var holidays: List<HolidayMore>
)

@Schema(description = "Праздники")
data class Holidays(
    @Schema(description = "Праздники")
    var holidays: List<Holiday>
)

data class HolidaysResponse(
    var response: Holidays
)

data class HolidaysMoreResponse(
    var response: HolidaysMore
)
