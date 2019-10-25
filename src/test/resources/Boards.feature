Feature: Trello create Board

  Sample feature file to tests boards happy paths.

  @CreateBoard @DeleteBoard
  Scenario: Get user Trello Boards
    Given the endpoint "/members/me/boards"
    When method GET
    Then status code 200

  @CreateBoard
  Scenario: Delete a Board
    Given the endpoint "/boards/{boardId}"
    When method DELETE
    Then status code 200

  @CreateBoard @DeleteBoard
  Scenario: Update a Board
    Given the endpoint "/boards/{boardId}"
    And body is
    """
    {
      "name": "Modified Example"
    }
    """
    When method PUT
    Then status code 200
