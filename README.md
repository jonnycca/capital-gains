# **Para testar**


Para que a entrada seja valida,o arquivo espera que cada case esteja em uma linha, por exemplo,
Caso de teste11, todas as operações na linha 1:


[{"operation":"buy", "unit-cost":10.00, "quantity": 100},{"operation":"sell", "unit-cost":15.00, "quantity": 50},{"operation":"sell", "unit-cost":15.00, "quantity": 50}]

Exemplo 2: caso de teste 1 e 2, o caso de teste com todas as operações na linha 1 e o caso de teste 2
com todas as operações na linha 2:


[{"operation":"buy", "unit-cost":10.00, "quantity": 100},{"operation":"sell", "unit-cost":15.00, "quantity": 50},{"operation":"sell", "unit-cost":15.00, "quantity": 50}]
[{"operation":"buy", "unit-cost":10.00, "quantity": 10000},{"operation":"sell", "unit-cost":20.00, "quantity": 5000},{"operation":"sell", "unit-cost":5.00, "quantity": 5000}]

Além disso, foi criado a classe de teste src/test/java/org/example/MainIntegrationTest.java
Essa classe, contem o teste parametrizado que testa todos os casos do pdf.






