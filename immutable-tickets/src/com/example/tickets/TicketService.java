package com.example.tickets;

import java.util.ArrayList;
import java.util.List;

/**
 * Service layer that creates tickets.
 *
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - creates partially valid objects
 * - mutates after creation (bad for auditability)
 * - validation is scattered & incomplete
 *
 * TODO (student):
 * - After introducing immutable IncidentTicket + Builder, refactor this to stop mutating.
 */
public class TicketService {

    public IncidentTicket createTicket(String id, String reporterEmail, String title) {
        // scattered validation (incomplete on purpose)
        // if (id == null || id.trim().isEmpty()) throw new IllegalArgumentException("id required");
        // if (reporterEmail == null || !reporterEmail.contains("@")) throw new IllegalArgumentException("email invalid");
        // if (title == null || title.trim().isEmpty()) throw new IllegalArgumentException("title required");

        IncidentTicket.builder b = new IncidentTicket.builder();
        // BAD: mutating after creation
        b.setId(id).setReporterEmail(reporterEmail).setTitle(title)
                .setPriority("MEDIUM")
                .setCustomerVisible(true).setSource("CLI");
        IncidentTicket t = b.build();
        return t;
    }

    public IncidentTicket  escalateToCritical(IncidentTicket t) {
        // BAD: mutating ticket after it has been "created"
        return t.toBuilder().setPriority("CRITICAL").addTag("ESCALATED").build();
    }

    public IncidentTicket assign(IncidentTicket t, String assigneeEmail) {
        // scattered validation
        return t.toBuilder().setAssigneeEmail(assigneeEmail).build();
    }
}
