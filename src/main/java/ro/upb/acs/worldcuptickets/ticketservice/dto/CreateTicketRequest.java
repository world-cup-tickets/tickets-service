package ro.upb.acs.worldcuptickets.ticketservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateTicketRequest(
    @JsonProperty("user_id") UUID userId,
    @JsonProperty("reservation_date") LocalDateTime reservationDate
) {}
