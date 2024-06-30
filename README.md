# Bootcamp Santander 2024 - Backend com Java.
Java RESTful API criada para o Bootcamp Santander 2024 - Backend com Java.


## Diagrama de Classes

```mermaid 
classDiagram
    direction LR
    class User {
        Long id
        String name
        String email
        List~Post~ posts
    }
    class Post {
        Long id
        String title
        String content
        User user
        List~Comment~ comments
    }
    class Comment {
        Long id
        String content
        Post post
    }

    User "1" *--> "*" Post : Posts
    Post "1" *--> "1" User : User
    Post "1" *--> "*" Comment : Comments
    Comment "1" *--> "1" Post : Post
```

## Link
[Acesse aqui](https://dio-challenge-java-production.up.railway.app/swagger-ui/index.html#/)
