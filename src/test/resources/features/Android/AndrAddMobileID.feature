Feature: To Test Android Add MobileID Scenario Workflow for HID mobile access application

  Background:To launch the HID app and navigate to Mobile ID Screen
    Given Launch HID Access Mobile Application in android device

  @ANDR_AddMobileID_1 @ANDR_AddMobileID
  Scenario Outline:ANDR_AddMobileID_1<TC_ID>: Verify the ADD mobileID in different cases
    When Verify Mobile ID screen is displayed in android device
    And Click on plus icon view the mobile ID screen in android device
    And Click on Enter invitation code tab in android device
    And Verify the invitation code entering screen in android device
    And Verify after entering the "<Action>" invitation code "<Invitation_code>" and check the enter button in android device
    And Verify the alert message after entered the "<Action>" wrong "<Invitation_code>" in android device

    Examples:
      | TC_ID | Action  | Invitation_code     |
      | _TC-1 | valid   | AAAA-BBBB-CC10-1112 |
      | _TC-2 | invalid | AAAA-@#$%-CCCC-1112 |

  @ANDR_AddMobileID_2 @ANDR_AddMobileID
  Scenario Outline:ANDR_AddMobileID_2<TC_ID>: Verify the mobile ID screen when Mobile ID is present
    When Verify Mobile ID screen when Mobile ID is present in android device
    And Verify nearby readers section in android device "<nearByReader>"
    And Verify the Manage Readers section in android device "<nearByReader>"

    Examples:
      | TC_ID | nearByReader |
      | _TC-1 | 0            |

  @ANDR_AddMobileID_3 @ANDR_AddMobileID
  Scenario: ANDR_AddMobileID_3<TC_ID>:Verify the back of the card details
    When Verify Mobile ID screen when Mobile ID is present in android device
    And   Tap on the Mobile ID to check back of the card details

  @ANDR_AddMobileID_4 @ANDR_AddMobileID
  Scenario Outline: Verify the app rating
#    When Relaunch the app in android device
    And Verify the rating popup UI in android device
    And select the rating as "<Star>" in android device
    And Click on the submit button should close the popup in android device
    Then Verify the content on the improve popup in android device
    Then send the improve content "<improve>" in android device
    Then Verify the thank you popup in android device

    Examples:
      | TC_ID | Star | improve              |
      | _TC-1 | 3    | Testing from chennai |





