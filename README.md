# Krinti Backend
This is the backend for the Krinti project.

# Requirements
1.Node.js version 16.13.2<br />
2.npm version 8.19.2<br />
3.Spring version 6.0.8<br />
4.Java version 1.8.0_321

# Setup
Clone this repository.<br />
Install  node.js<br />
Install npm<br />
Install spring<br />
Install java<br />
Install any data base
#usage
1.Open the project in your IDE.<br />
2.Connect your database at /Krinati-Backend/src/main/resources/application.properties file<br />
3.Run the project<br />
4.use the below postMan URL to add the data into dataBase<br />

  URL:http://localhost:8080/api/v1/jobs/roles/companyName<br />
  Structure of the data:<br />
  {<br />
    "role": " Developer ",<br />
    "jobType": "Full-time",<br />
    "startDate": "2020-08-01",<br />
    "endDate": "2021-07-01",<br />
    "city": "Hyderabad",<br />
    "state": "Telangana" <br />
  }<br />
5.Use the company names already given in the /Krinati-Backend/src/main/java/com/kr/url/Urls.java file to get image logos.<br />
6.Access the server at http://localhost:8080.
