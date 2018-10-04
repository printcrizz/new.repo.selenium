Feature: Calculadora de liquidacion de sueldo

  Scenario: 01 - Calculare mi propio sueldo
    Given Abro el Navegador y me dirijo a "http://www.calcular.cl/como-calcular-sueldo-liquido-chile.html"
    When Lleno el campo "Sueldo Base" con el siguiente valor "1234567"
    And Lleno el campo "Fonasa/Isapre" con el siguiente valor "3"