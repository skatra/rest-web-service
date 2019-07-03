# Example Spring Boot REST Web Service

Feel free to connect:<br>
[stevekatra.com](https://www.stevekatra.com/) <br>
[@stevekatra](https://twitter.com/stevekatra)


## Setup for Intellij
gradle cleanIdea idea

## Build
```
gradle clean build
```

## Run
```
gradle bootRun
```

## Endpoints
GET /meeting


```javascript
Request:  GET /meeting
Response HTTP Status Code: 200
Response HTTP Body:
[
    {
        "id": 1,
        "name": "1:1 with Steve",
        "purpose": "Talk about the work week"
    }
]
```

GET /meeting/{id}

```javascript
Request:  GET /meeting/1
Response HTTP Status Code: 200
Response HTTP Body:
{
    "id": 1,
    "name": "1:1 with Steve",
    "purpose": "Talk about the work week"
}
```


POST /meeting
```javascript
Request:  GET /meeting
Request HTTP Body:
{
    "name": "1:1 with Steve",
    "purpose": "Talk about the work week"
}
Response HTTP Status Code: 200
Response HTTP Body:
{
    "id": 1,
    "name": "1:1 with Steve",
    "purpose": "Talk about the work week"
}
```

PUT /meeting/{id}
```javascript
Request:  PUT /meeting/1
Request HTTP Body:
{
    "id": 1,
    "name": "1:1 with Steve",
    "purpose": "Talk about the work week and hack-a-thon"
}

Response HTTP Status Code: 200
Response HTTP Body:
{
    "id": 1,
    "name": "1:1 with Steve",
    "purpose": "Talk about the work week and hack-a-thon"
}
```

DELETE /meeting/{id}
```javascript
HTTP Status Code: 200
```