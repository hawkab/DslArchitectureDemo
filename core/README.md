# Module core
EN | [RU](README_ru.md)

This is where the pure business logic resides — the entities and rules that define how the system operates.
It uses nothing but the standard Java library, is universal, and can be utilized in any environment.

## Analysis of compliance with design principles

| Class                   |	KISS (%)| 	DRY (%) |	YAGNI (%)|	BDUF (%)|	SOLID (%)|	APO (%)|	Occam's Razor (%)|
|-------------------------|---|----------|---|---|---|---|---|
| RuleDefinition          |	90% | 	80%     |	100% |	80% |	80% |	90% |	85% |
| RuleDefinition.Condition |	95%| 	80%	    | 100%	|85%	|80%	|90%	|90%|
| RuleAction              |	95%	| 100%	    |100%	|90%	| 100%	|100%	|95%|
| Decision	               |100%	| 100%	    |100%	|100%	| 100%	|100%	|100%|
| Context	                |90%	| 85%	     |100%	|80%	| 85%	|85%	|90%|
| RuleExpression	         |100%	| 100%	    |100%	| 100%	|100%	|100%	|100%|
| ConditionalOperator     |	90%	| 100%	    |100%	| 90%	|100%	|90%	|95%|
| Condition	              |95%	| 100%	    |100%	| 100%	|100%	|100%	|100%|
| BaseRuleEngine          |	80%	| 85%	     |85%	|80%	|70%	|75%	|75%|


<< [Back](../README.md)