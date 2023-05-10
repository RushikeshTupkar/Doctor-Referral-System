# Suggesting ⚕️Doctor Based On 💉Symptoms API :-
* Swagger
- http://localhost:8080/swagger-ui.html#/
## Frameworks and language used:
-     Java 
-     Spring Boot
-     SQL database
-     Postman 
-     Swagger

## Steps to follow to use project

   * Create two status Active, Inactive
    ![StatusEndpoints](https://user-images.githubusercontent.com/112196925/233860211-8c4b2e8b-1b1c-44a6-a906-a4945597b7e8.png)
   * Create Specialities like Orthopedic, Gynecology, ENT, Dermatology.
    ![SpecialityEndpoints](https://user-images.githubusercontent.com/112196925/233860130-cc60449b-95f6-448c-ae67-40ca108b386b.png)
   * Create Symptoms like Skin burn, Skin injuries and associate with appropriate speciality like Dermatologist.
    ![SymptomsEndpoints](https://user-images.githubusercontent.com/112196925/233860206-46670ea7-c87f-4fe6-828f-d1d17a82d5f3.png)
   * Create 👩‍⚕️Doctor and associate belonging speciality to doctor.
    ![DoctorEndpoints](https://user-images.githubusercontent.com/112196925/233860041-0b714c78-bdcb-4eec-ba06-bf8483f4a675.png)
   * Create 🤕Patient and assign symptoms to him.
    ![PatientEndpoints](https://user-images.githubusercontent.com/112196925/233860088-9aac1fdd-7d3d-4582-a190-1d87c14d288c.png)
   * Now you are good to go 🚀



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

  There are Four Service class in this application.

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

To ensure that patients receive accurate and up-to-date information, the system is designed with multiple validations to prevent data redundancy and maintain consistency in the data. Additionally, the system is  equipped with a feature that suggests doctors located in nearby cities if there are no suitable specialists available in the patient's city.

Overall, the application aims to provide patients with a user-friendly and efficient way to find the right doctors to treat their medical conditions, ultimately improving their healthcare outcomes.





  













  
