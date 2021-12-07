# Rest Assure Test Demo

>**API:**  https://reqres.in/api

https://user-images.githubusercontent.com/37184598/144761209-5d0b66be-6f08-44ac-a69c-f7fead79fefa.mp4

## singleUserTest

● Set GET method url https://reqres.in/api/users/2

Verify the below requested in the response:

○ Status code should be 200

○ Response email should be janet.weaver@reqres.in

○ Response time should be less than 2 sec


## allUsersTest

● Set GET method url https://reqres.in/api/users?page=2

Verify the below requested in the response:

○ Status code should be 200

○ Response page should be 2

○ Response time should be less than 2 sec


## userDelayedTest

● Set GET method url https://reqres.in/api/users?delay=3

Verify the below requested in the response:

○ Status code should be 200

○ Response page should be 1

○ Response per_page should be 6

○ Response time should be less than 5 sec


## deleteUserTest

● Set DELETE method url https://reqres.in/api/users/2

Verify the below requested in the response:

○ Status code should be 204

○ Response time should be less than 5 sec


## createUserTest

Set the Content-type=application/json

● Set POST method url https://reqres.in/api/users

● Create a user with the following JSON model

```json
{

"name": "morpheus",
"job": "leader"

}
```
Verify the below requested in the response:

○ Status code should be 201

○ Response name should be morpheus

○ Response job should be leader

