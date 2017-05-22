Clone the repository and import it as a gradle project on an IDE. Refersh dependencies and run the project as java application.

Implemented APIs for creating projector resources and allocating available  projectors to teams.
Assumption: Request can me made in slots of an hour.

REST APIs for Projector Resource
-------------------------------------

GET all projectors:  					/projectors

GET single projecor by ID:  			/projectors/{id}

POST single projector object:			/projectors

  -- pass the projector object 
     as request body

DELETE a projector:						/projectors/{id}

REST APIs for Projector Booking
-------------------------------------

GET all bookings for a date				/booking/{date}

GET all bookings for a team				/booking/{teamID}

POST request for a  new booking			/booking/{team}
-for a given team(path variable),
-date, start, end time(request Body)

DELETE Booking							/booking/{id}

PUT Booking								/booking
-- new booking in request Body