# Suggesting Doctor Based On Symptoms :-
* Swagger
- http://localhost:8080/swagger-ui.html#/
## Frameworks and language used:
-     Java
-     Spring Boot
-     SQL database
-     Postman
-     Swagger
## Data Flow


*  **Model** :
  There are Four Models class in this application.
    * Doctor Model Class.
    * Patient Model Class.
    * Speciality Model Class.
    * Symptoms Model Class.


* **Controller** :

  There are Five Controller classse in this application.

    * DoctorController Class.
    * PatientController Class.
    * SpecialityController Class.
    * SymptomsController class.
    * StatusController class.





* **Service** :

  There are Frou Service class in this application.

    * DoctorService Class.
    * PatientService Class.
    * SpecialityService Class.
    * SymptomsService Class
    * StatusService Class



* **Repository** :

  There are Four Repository Interfaces in this application.

    * IDoctorRepository Interface.
    * IPatientRepository Interface.
    * IStatusRepository Interface.
    * ISymptomsRepository Interface


* **Helper/Validation** :
    * In this application I'm using annotations based validation with manual validations for more safety and to keep continuity in data .



* **GlobalExceptionHandler class** :
    * In this class I have handled the exceptions that generates in project inbuild as well as custom.



* **Database**

    * I have used SQL Database to store the data.
    * I have deployed this project on AWS EC2 machine.

## Project Summary






The proposed project involves the development of a web application that enables patients to find suitable doctors based on their specific symptoms and location. To achieve this, the system will allow patients to register and input their symptoms, after which they will be provided with relevant information about doctors who specialize in treating their specific condition and are available in their city.

To ensure that patients receive accurate and up-to-date information, the system will be designed with multiple validations to prevent data redundancy and maintain consistency in the data. Additionally, the system will be equipped with a feature that suggests doctors located in nearby cities if there are no suitable specialists available in the patient's city.

Overall, the application aims to provide patients with a user-friendly and efficient way to find the right doctors to treat their medical conditions, ultimately improving their healthcare outcomes.





  













  