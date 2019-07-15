package com.stevekatra.meeting;

import com.stevekatra.restexception.NoContentException;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
@Api(value = "Meeting API")
public class MeetingController {

    private long index = 0;
    private Map<Long, Meeting> meetings = new HashMap<>();

    @ApiOperation(value = "Retrieve a list of meetings.", consumes = "application/json", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of meetings."),
            @ApiResponse(code = 204, message = "No meetings were retrieved.", response = List.class)
    })
    @GetMapping("/meeting")
    public List<Meeting> getMeetings() {
        if(meetings.values().isEmpty())
            throw new NoContentException();
        else
            return new ArrayList<Meeting>(meetings.values());
    }

    @ApiOperation(value = "Retrieve a specific meeting by id.", consumes = "application/json", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved requested meeting."),
            @ApiResponse(code = 404, message = "No meetings exists with the provided id.")
    })
    @GetMapping("/meeting/{id}")
    public Meeting getMeeting(
            @ApiParam(value = "Meeting id to retrieve", required = true) @PathVariable Long id) {
        return meetings.get(id);
    }

    @ApiOperation(value = "Allows you to create a new meeting.", consumes = "application/json", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created meeting.")
    })
    @PostMapping("/meeting")
    public Meeting createMeeting(
            @ApiParam(value = "Meeting name and purpose are required fields.", required = true) @Valid @RequestBody Meeting input) {
        Meeting meeting = new Meeting(index++,input.getName(),input.getPurpose());
        meetings.put(meeting.getId(),meeting);
        return meeting;
    }

    @ApiOperation(value = "Allows you to update a specific meeting by id.", consumes = "application/json", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated requested meeting."),
            @ApiResponse(code = 404, message = "No meetings exists with the provided id.")
    })
    @PutMapping("/meeting/{id}")
    public Meeting updateMeeting(
            @ApiParam(value = "Meeting id to update.", required = true) @PathVariable Long id,
            @ApiParam(value = "Pass in the full meeting object with modifications.", required = true) @Valid @RequestBody Meeting input) {
        meetings.put(id, input);
        return input;
    }

    @ApiOperation(value = "Allows you to delete a specific meeting by id.", consumes = "application/json", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated requested meeting."),
            @ApiResponse(code = 404, message = "No meetings exists with the provided id.")
    })
    @DeleteMapping("/meeting/{id}")
    public void deleteMeeting(
            @ApiParam(value = "Meeting id to delete.", required = true) @PathVariable Long id) {
        meetings.remove(id);
    }
}
