# Module service
EN | [RU](README_ru.md)

Uses the Spring Framework to implement the business logic described in core by leveraging the defined rules and executing the actions prescribed by the core

## Analysis of compliance with design principles
|Class |KISS (%)| DRY (%) |YAGNI (%)|BDUF (%)|SOLID (%)|APO (%)|Occam's Razor (%)|
|---|---|---|---|---|---|---|---|
| RuleConfiguration| 90% | 90%| 100%| 85%| 85% | 90%| 90%|
| RuleController| 85% | 90%| 100% | 80%| 80% | 85%| 85%|
| ApplyDiscount| 85% | 90% | 100%| 80%| 85% | 90%| 85%|
| SendNotification| 90% | 90%| 100%| 85% | 85%| 90%| 90%|
| Equal | 100%|100%| 100%| 100%| 100% | 100%| 100%|
| GreaterThan| 95%|95%| 100%| 100%| 100% | 100% | 95%|
| RuleService| 85%|85%| 100%| 80%| 80%| 85%| 85%|
| RulesLoader| 90%|90%| 100%| 85%| 85%| 85%| 90%|
| DslArchitectureDemoApplication | 100% | 100%| 100%| 100% | 100% | 100%| 100%|


<< [Back](../README.md)