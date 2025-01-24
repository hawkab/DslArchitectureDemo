<< [Back](README.md)
# Testing
#1 Request:
```http request
POST http://localhost:8080/rules/apply
Content-Type: application/json

{
  "customerType": "VIP",
  "orderAmount": 2500
}
```
Response #1:
```json
[
  {
    "action": "applyDiscount",
    "target": "orderAmount",
    "context": {
      "variables": {
        "discountedAmount": 2125.0,
        "discount": 15,
        "customerType": "VIP",
        "orderAmount": 2500
      }
    },
    "ruleName": "VIP Discount Rule"
  },
  {
    "action": "applyDiscount",
    "target": "orderAmount",
    "context": {
      "variables": {
        "discountedAmount": 2250.0,
        "discount": 10,
        "customerType": "VIP",
        "orderAmount": 2500
      }
    },
    "ruleName": "Regular Discount Rule"
  }
]
```
---
#2 Request:
```http request
POST http://localhost:8080/rules/apply
Content-Type: application/json

{
  "customerType": "VIP",
  "orderAmount": 1500
}
```
Response #2:
```json
[
  {
    "action": "applyDiscount",
    "target": "orderAmount",
    "context": {
      "variables": {
        "discountedAmount": 1275.0,
        "orderAmount": 1500,
        "customerType": "VIP",
        "discount": 15
      }
    },
    "ruleName": "VIP Discount Rule"
  }
]
```
---
#3 Request:
```http request
POST http://localhost:8080/rules/apply
Content-Type: application/json

{
  "customerType": "Regular",
  "orderAmount": 2500
}
```
Response #3:
```json
[
  {
    "action": "applyDiscount",
    "target": "orderAmount",
    "context": {
      "variables": {
        "discountedAmount": 2250.0,
        "discount": 10,
        "customerType": "Regular",
        "orderAmount": 2500
      }
    },
    "ruleName": "Regular Discount Rule"
  }
]
```
<< [Back](README.md)