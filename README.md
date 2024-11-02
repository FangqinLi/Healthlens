## Healthlens

### Overview
Healthlens is a food recommendation platform designed to help elderly individuals make healthier food choices. The platform provides meal suggestions based on the meals they upload, offering advice tailored to their nutritional needs.

### How to Configure and Run this application.
1. Clone demo project to your local machine.
2. Replace tokens from application.yml and application.properties with yours.

  #### Use IDEA
  Open "web" project using IDEA.
  Click load maven button to load all the dependencies for the project.
  Run the application and use your browser to access localhost:8080.
  
  #### Use Docker
  Open terminal under /web and open Docker Desktop.
  Execute "docker compose up --build -d."
  Use your browser to access localhost:8080.
  Execute "docker compose down" to shut down the application.

### How to Use
Login: After logging in to the website, users can upload images or details of their meals.  

Meal Upload: Once the meal is uploaded, the system analyzes the nutritional content.  

Health Suggestions: Based on the analysis, Healthlens recommends healthier alternatives or adjustments to ensure better nutrition.

### Next Steps: Microservices Implementation
Given the different technology stacks in use for each component, we plan to adopt a microservices architecture. This approach will allow these services to align and collaborate effectively, despite the diverse technologies being employed.
