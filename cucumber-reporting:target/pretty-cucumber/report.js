$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("EtsySearchFunctionality.feature");
formatter.feature({
  "line": 3,
  "name": "Etsy Search Functionality",
  "description": "",
  "id": "etsy-search-functionality",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@TEC-103"
    }
  ]
});
formatter.before({
  "duration": 2724760349,
  "status": "passed"
});
formatter.scenario({
  "line": 40,
  "name": "Validating over price functionality",
  "description": "",
  "id": "etsy-search-functionality;validating-over-price-functionality",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 39,
      "name": "@TECTC-1014"
    }
  ]
});
formatter.step({
  "line": 41,
  "name": "Navigate Etsy Homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 42,
  "name": "User searches for \"carpet\"",
  "keyword": "When "
});
formatter.step({
  "line": 43,
  "name": "User clicks on Over Price checkbox",
  "keyword": "And "
});
formatter.step({
  "line": 44,
  "name": "User verifies all items prices are over",
  "keyword": "Then "
});
formatter.match({
  "location": "EtsySteps.navigate_Etsy_Homepage()"
});
formatter.result({
  "duration": 4487306331,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "carpet",
      "offset": 19
    }
  ],
  "location": "EtsySteps.user_searches_for(String)"
});
formatter.result({
  "duration": 3731275575,
  "status": "passed"
});
formatter.match({
  "location": "EtsySteps.user_clicks_on_Over_Price_checkbox()"
});
formatter.result({
  "duration": 3787418418,
  "status": "passed"
});
formatter.match({
  "location": "EtsySteps.user_verifies_all_items_prices_are_over()"
});
formatter.result({
  "duration": 1809762971,
  "error_message": "java.lang.AssertionError\n\tat org.junit.Assert.fail(Assert.java:86)\n\tat org.junit.Assert.assertTrue(Assert.java:41)\n\tat org.junit.Assert.assertTrue(Assert.java:52)\n\tat stepDefs.EtsySteps.user_verifies_all_items_prices_are_over(EtsySteps.java:94)\n\tat ✽.Then User verifies all items prices are over(EtsySearchFunctionality.feature:44)\n",
  "status": "failed"
});
formatter.after({
  "duration": 1259815314,
  "status": "passed"
});
});