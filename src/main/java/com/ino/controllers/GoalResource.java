package com.ino.controllers;

import com.ino.model.Goal;
import com.ino.service.GoalService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.logging.Logger;

@Path("/goals")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GoalResource {

    private static final Logger LOGGER = Logger.getLogger(GoalResource.class.getName());

    private final GoalService goalService;

    @Inject
    public GoalResource(GoalService goalService) {
        this.goalService = goalService;
    }

    @Deprecated
    GoalResource() {
        this(null);
    }

    @GET
    public List<Goal> goals(@QueryParam("page") @DefaultValue("1") int page,
                            @QueryParam("size") @DefaultValue("10") int size) {
        LOGGER.info("Listing goals, page: " + page + ", size: " + size);
        return goalService.findGoals(page, size);
    }

    @POST
    public Goal create(Goal goal) {
        return  goalService.save(goal);
    }

    @GET
    @Path("{id}")
    public Goal findById(@PathParam("id") String id) {
        return goalService.findById(id).orElseThrow(() -> new WebApplicationException("Goal not found", 404));
    }
}

