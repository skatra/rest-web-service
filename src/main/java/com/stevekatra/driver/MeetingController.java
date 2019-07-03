package com.stevekatra.driver;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.*;

@RestController
@RequestMapping(value="/meeting")
public class MeetingController {

    private long index = 0;
    private Map<Long, Meeting> meetings = new HashMap<>();

    @RequestMapping(method = RequestMethod.GET)
    public List<Meeting> getMeetings() {
        return new ArrayList<Meeting>(meetings.values());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Meeting getMeeting(@PathVariable Long id) {
        return meetings.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Meeting createMeeting(@RequestBody Meeting input) {
        Meeting meeting = new Meeting(index++,input.getName(),input.getPurpose());
        meetings.put(meeting.getId(),meeting);
        return meeting;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Meeting updateMeeting(@PathVariable Long id, @RequestBody Meeting input) {
        meetings.put(id, input);
        return input;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteMeeting(@PathVariable Long id) {
        meetings.remove(id);
    }
}
