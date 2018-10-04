$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Test.feature");
formatter.feature({
  "line": 1,
  "name": "Calculadora de liquidacion de sueldo",
  "description": "",
  "id": "calculadora-de-liquidacion-de-sueldo",
  "keyword": "Feature"
});
formatter.before({
  "duration": 146774,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "01 - Calculare mi propio sueldo",
  "description": "",
  "id": "calculadora-de-liquidacion-de-sueldo;01---calculare-mi-propio-sueldo",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Abro el Navegador y me dirijo a \"http://www.calcular.cl/como-calcular-sueldo-liquido-chile.html\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Lleno el campo \"Sueldo Base\" con el siguiente valor \"1234567\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Lleno el campo \"Fonasa/Isapre\" con el siguiente valor \"3\"",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.calcular.cl/como-calcular-sueldo-liquido-chile.html",
      "offset": 33
    }
  ],
  "location": "StepDefinitions.OpenBrowser(String)"
});
formatter.result({
  "duration": 11587771733,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sueldo Base",
      "offset": 16
    },
    {
      "val": "1234567",
      "offset": 53
    }
  ],
  "location": "StepDefinitions.fillValue(String,String)"
});
formatter.result({
  "duration": 773923413,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Fonasa/Isapre",
      "offset": 16
    },
    {
      "val": "3",
      "offset": 55
    }
  ],
  "location": "StepDefinitions.fillValue(String,String)"
});
formatter.result({
  "duration": 312512854,
  "status": "passed"
});
formatter.after({
  "duration": 98987,
  "status": "passed"
});
});