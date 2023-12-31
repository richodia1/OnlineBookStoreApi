# Online Book Store

This is a Java Spring Boot application for managing an online book store.

## Features

1. Book Inventory:
    - Manage a comprehensive inventory of books with attributes like title, genre, ISBN code, author, and year of publication.

2. Search Functionality:
    - Users can search for books by title, author, year of publication, or genre.

3. Shopping Cart:
    - Implement a shopping cart allowing users to add books.
    - Users can view the contents of the cart.

4. Checkout:
    - Provide options for checkout with Web and Transfer payment options.
    - Simulate the payment process (no actual payment gateway integration).

5. Purchase History:
    - Users can view their purchase history.

## Entities

1. Book Entity:
    - Title (alphanumeric)
    - Genre (Friction, Thriller, Mystery, Poetry, Horror, Satire)
    - ISBN code (numbers and dash)
    - Author
    - Year of publication

2. User Entity:
    - User details

3. CartItem Entity:
    - Represents items in the shopping cart
    - Book reference
    - User reference
    - Quantity

## Technologies Used

- Java Spring Boot
- Spring Data JPA
- H2 Database (for simplicity)
- Open Id connect


## Setup

1. Clone the repository: `git clone https://github.com/richodia1/OnlineBookStoreApi.git`
2. Navigate to the project directory: `cd onlinestore`
3. Build and run the application: `./mvnw spring-boot:run`
4. Access the application at http://localhost:8080/swagger-ui/index.html#/

## Note and assumption to used
- That a User with Id 1 is seeded on the application when the application is run.
- 10 records of book is created when the application is run. there is provision to create more Book to be used on the endpoints.
## major action
- Add to cart by User Id
- view cart by User Id
- Checkout by User Id. Payment Method is an enum which can only be TRANSFER, USSD, WEB
- Check transaction history 

