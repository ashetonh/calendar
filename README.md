# Running the Calendar RESTful web service
- clone the repo and cd into calendar
- ./mvnw clean spring-boot:run
- open a new bash window
- cd scripts/
- ./makeMultipleMeetings


### You can now run multiple different scripts! You can peek at the meetings by running: 
- ./getMeetings
### You can pass one of the unique identifiers (first id in each meeting) and use it as an argument to different scripts like: 
- ./getMeeting ($meetingId)
- ./updateMeeting ($meetingId)
- ./deleteMeeting ($meetingId)
If you would like to create a single event, run:
- ./createMeeting


### Update:
I didn't have a lot of time to get into the nitty gritty with a lot of personal issues coming up this past week. This is a really barebones attempt at this rest service. Ideally I would have liked to setup a quick angular app with a login page, separate forms for the different post methods, and a nice table interface to view the meetings. I thought about implementing this with the Google Calendar API but just didn't have enough time. I also would have liked to add pit and jacoco coverage to show line coverage, as well as finish the entire unit testing suite. I would also like to do some acceptance testing with Jest or some API testing framework. 
