# PersonAddressAPI
API related to Person and Address

This application is built using Spring Boot and H2 database.

For building the application from the root directory run below command
mvnw clean install

For executing from command line from the root directory run below command
mvnw spring-boot:run

Initially there are no records in the database. Using API calls we need to create data.

Please find the below end points for the application to access from Postman

1. Add Person (id, firstName, lastName)
End point -- http://localhost:8080/api/people
Request method POST
In request body please send the below json
{
    "id" : "1",
    "firstName" : "Parvez",
	"lastName" : "Farez"
	
}

Currently we are not generating the id for Person in database. User need to provide the id while creating the Person.

2. Edit Person (firstName, lastName)

End point -- http://localhost:8080/api/people/{id}
Request method PUT
id = person id.
Request body
{
    "firstName" : "Jhon",
	"lastName" : "Frank"
	
}

3. Delete Person (id)

Delete will also delete the addresses associated with the person
End point -- http://localhost:8080/api/people/{id}
Request method Delete
id= person id

4. Add Address to person [multiple required] (id, street, city, state,
postalCode)

End point -- http://localhost:8080/api/people/{id}/addresses
Request method POST
Accepts multiple address json objects
id = person id.
Request body
[
{
    "id" : 1,
    "street" : "Test Street",
	"city" : "Hyd",
	"state" : "Tel",
	"postalCode" : "1234563"
},
{
    "id" : 2,
    "street" : "Test Street1",
	"city" : "Hyd1",
	"state" : "Tel2",
	"postalCode" : "1234564"
},

]

5. Edit Address (street, city, state, postalCode)

End point -- http://localhost:8080/api/people/{id}/addresses/{addressId}
Request method PUT

id = person id.
addressId = Address id to update
Request body

{
    "street" : "Test Street3",
	"city" : "Hyd3",
	"state" : "Tel3",
	"postalCode" : "1234565"
}

6. Delete Address (id)

End point -- http://localhost:8080/api/people/{id}/addresses/{addressId}
Request method DELETE

id = person id.
addressId = Address id to delete.

7. Count Number of Persons

End point -- http://localhost:8080/api/people/count
Request method GET


8. List Persons

End point -- http://localhost:8080/api/people
Request method GET


To search data using UI below url can be accessed to open h2 console

http://localhost:8080/h2-console/

username=sa
password=password