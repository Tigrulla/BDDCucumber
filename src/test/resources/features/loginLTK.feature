@Login
Feature: Users should be able to login and see styles categories presented

  Scenario: verify categories page contains all styles
    Given user signed up
    When user selects the "Shop" navigation menu
    Then user should see the following categories present
      | Fall Trends  |
      | Sale Alert   |
      | Under $50    |
      | Under $100   |
      | Home         |
      | LTK-U        |
      | Style Tips   |
      | Curves       |
      | Beauty       |
      | Shoe Crushes |
      | Workwear     |
      | Weddings     |
      | It Bags      |
      | Fitness      |
      | Swim         |
      | Travel       |
      | Europe       |
      | Baby         |
      | Bump         |
      | Kids         |
      | Family       |
      | Mens         |
      | Brasil       |