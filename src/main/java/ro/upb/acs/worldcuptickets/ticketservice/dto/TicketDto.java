package ro.upb.acs.worldcuptickets.ticketservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public record TicketDto(
    UUID id,
    @JsonProperty("user_id") UUID userId,
    @JsonProperty("match_id") UUID matchId,
    @JsonProperty("reservation_date") LocalDateTime reservationDate
) {}
