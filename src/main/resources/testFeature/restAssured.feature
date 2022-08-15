Feature: Rest Assured

  @test1
  Scenario: Running scenario for Rest Assured
    Given launch the targeted endpoint

  @test2
  Scenario Outline: Running parameterized scenario for Rest Assured
    Given launch the targeted baseurl <baseurl> and endpoint <endpoint>
    Examples:
      | baseurl             | endpoint       |
      | "https://reqres.in" | "/api/users/2" |

  @test3
  Scenario Outline: Running complete parameterized scenario for Rest Assured using RequestSpecification and Response
    Given launch the GET request with baseurl <baseurl> and endpoint <endpoint>
    Then validate the status code <statusCode> firstName "<firstName>"
    And validate server "<server>" in the header response
    And validate the Schema "<schemaPath>" of the response
    Examples:
      | baseurl             | endpoint       | statusCode | firstName | server     | schemaPath            |
      | "https://reqres.in" | "/api/users/2" | 200        | Janet     | cloudflare | Input/SchemaUser.json |