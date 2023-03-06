# doctor-patienrtApp
* This project store the data of doctor and patient.
## Framwork and Language use in this Project
* Springboot 
* java
## Dependencies
* Spring Web
* h2 Database
* hibernate
* lombok
* validation
## validation
* In validation on doctorName ,specialization, experience.
## Flow of project
* Create three layers model , service , controller, repository and util.
* In model layer create two classes first one is doctor class and patient class.
* In util class validate the doctor attributes.
* In controller layer to performe CRUD operatiom by http request.
* In service layer write a business logic of CRUD operation.
* In repository layer exteds jpsRepositor.
## Constraints:
* doctor model will have-
* doctorId
* doctorname
* specialization
* experience
* patient model will have:-
* patientid
* gender
* patientDisease
* patientName
* patientNuber
## Endpoints to provided :
* Adddoctor and patient
* update doctor by doctorId
* delete doctor by doctorId
* Get all doctor
* Get doctor by id
