##Makersharks Search API

##Overview
Makersharks is building a search page where buyers can search for manufacturers based on customized requirements. This project is a proof of concept for the search API using Spring Boot. 
The API retrieves a list of manufacturers based on location, nature of business, and manufacturing processes.

API Endpoints
1. Search Suppliers
Endpoint: /supplier/query
Method: POST
Description: Retrieves a list of all manufacturers

 Filter by Nature of Business (small_scale)
POST http://localhost:8080/supplier/query?nature_of_business=small_scale&page=0&size=10

Filter by Manufacturing Process (moulding)
POST http://localhost:8080/supplier/query?manufacturing_process=moulding&page=0&size=10

 Filter by Company Name (Intel)
GET http://localhost:8080/supplier/query?company_name=Intel&page=0&size=10

2. Add suppliers
Endpoint:/supplier/add
Method: POST
Description: Add a record the MySQL database

3. View all Suppliers
Endpoint:/supplier/getAll
Method: GET
Description: Gets all the data from the database


Query Parameters:

location (optional): City where the manufacturer is located.
nature_of_business (optional): Type of business (e.g., small_scale, medium_scale, large_scale).
manufacturing_process (optional): Manufacturing process (e.g., moulding, 3d_printing, casting, coating).
page (optional): Page number for pagination (default is 0).
size (optional): Number of results per page (default is 10).


Setup and Installation
1. Clone the Repository
2. Build the Project
3. Run the Application
   
The application will start on http://localhost:8080.

Testing the API
You can use Postman or curl to test the API.

1- Searching based on criterions

Filter by Nature of Business (small_scale)
curl -X POST "http://localhost:8080/supplier/query?nature_of_business=small_scale&page=0&size=10" \
-H "Content-Type: application/json"

Filter by Manufacturing Process (moulding)
curl -X POST "http://localhost:8080/supplier/query?manufacturing_process=moulding&page=0&size=10" \
-H "Content-Type: application/json"

2- Adding suppliers
 url - http://localhost:8080/api/supplier/add
{
  "company_name": "FutureTech",
  "website": "futuretech.com",
  "location": "San Francisco",
  "nature_of_business": "small_scale",
  "manufacturing_process": "three_d_printing"
}

         
Contribution
Feel free to fork the repository and create a pull request with your changes. For any issues or questions, open an issue in the repository.
