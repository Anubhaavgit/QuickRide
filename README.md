# QuickRide
QuickRide cab booking application created using SpringBoot, Spring Jpa and Mysql.

Available APIs
Load Initial Data

Endpoint: GET /load
Description: Loads sample values for users and drivers to begin with for the first time.
Add User

Endpoint: POST /addUser
Description: Adds a new user.
Request Body: A User object.
Remove User

Endpoint: DELETE /removeUser
Description: Removes an existing user.
Request Body: A User object.
Add Driver

Endpoint: POST /addDriver
Description: Adds a new driver.
Request Body: A CabDriver object.
Remove Driver

Endpoint: DELETE /removeDriver
Description: Removes an existing driver.
Request Body: A CabDriver object.
Update User's Current Location

Endpoint: POST /updateUserCurrentLocation/{userId}
Description: Updates the current location of a user.
Path Variable: userId (User's ID)
Request Body: A Coordinate object representing the new location.
Get List of Drivers

Endpoint: GET /getDrivers
Description: Retrieves the list of all drivers.
Get List of Users

Endpoint: GET /getUsers
Description: Retrieves the list of all users.
Get Specific User

Endpoint: GET /getUser/{userId}
Description: Retrieves a specific user by their userId.
Path Variable: userId (User's ID)
Get Specific Driver

Endpoint: GET /getDriver/{driverId}
Description: Retrieves a specific driver by their driverId.
Path Variable: driverId (Driver's ID)
Find Ride for User

Endpoint: POST /findRide/{userId}
Description: Finds a ride for a specific user.
Path Variable: userId (User's ID)
Request Body: A Coordinate object representing the user's destination.
Validate Rides

Endpoint: GET /validateRide
Description: Validates if rides are possible for all users and drivers, and processes them accordingly.
Get Driver Earnings

Endpoint: GET /getEarnings
Description: Retrieves the earnings of a specific driver.
Request Body: A CabDriver object.
