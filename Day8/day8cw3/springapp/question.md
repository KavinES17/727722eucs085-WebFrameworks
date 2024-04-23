# Overview:
Retrieve student details using JPQL with conditions for marks greater than or less than the specified mark.
# Functional Requirements:
Create folders named as model, repository, service and controller inside the WORKSPACE/springapp/src/main/java.com/examly/springapp.
Inside model folder, create a class named "Student" with the following attributes:
1. id - long
2. name - String
3. marks - int
Implement getters, setters and constructors for these attributes.
Inside repository folder, create an interface named "StudentRepo".
Inside service folder, create a class named "StudentService•.
Inside controller folder, create a class named 'StudentController".

# API ENDPOINTS
### POST 
 "/student" - Returns response status 201 with student object on successful creation or else 500.
### GET
 "student/marksGreaterThan/{mark}" - Returns status code 200 with a List<Student> object filtered by marks greater than the specified marks, or else returns
500.
### GET
 "/student/marksLessThan/{mark}" - Returns status code 200 with a List<Student> object filtered by marks lesser than the specified marks, or else returns 500.