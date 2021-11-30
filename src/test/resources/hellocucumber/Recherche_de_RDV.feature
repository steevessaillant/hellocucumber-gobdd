Feature: Recherche de RDV

  Background:
    Given Samiha se connect sur son espace du client

  Scenario: Samiha cherhe les veterinaire
    Given "Samiha" est sur son espace client
    When elle rentre "H1X4A2" comme adress
    And "29-09-2021" comme date
    And lance le recherche
    Then la list est affiche comme suivie

      | Name    | Address | Distance | Date       |
      | Dr John | H1X9I9  | 1.6km    | 29-09-2021 |
      | Dr Iny  | H1A1N9  | 1.8km    | 29-09-2021 |
