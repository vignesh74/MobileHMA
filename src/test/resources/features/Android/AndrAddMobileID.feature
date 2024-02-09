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
    And Verify nearby readers section in android device "<nearByReader>" in android device
    And Verify the Manage Readers section in android device "<nearByReader>" in android device

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

  @ANDR_11_10_Activity_Log
  Scenario Outline: ANDR_11_10_Activity_Log<TC_ID>: Verify the Activity log Error scenarios with error message in the Activity log <activityLog>
    When Navigate to settings page in android device
    And  Show Activity State status is displayed as "<Show_Activity_State>" in android device
    Then  Verify the log message "<activityLog>" and "<logMessage>" in Activity log screen in android device

    Examples:
      | TC_ID  | activityLog            | logMessage                                                                            | Show_Activity_State |
      | _TC-48 | Mobile ID Mismatch     | Mobile ID incompatible with this reader. Please contact your administrator.           | Enable              |
#      | _TC-49 | Mobile ID Read         | Communication timeout. Please try again.                                              | Enable              |
#      | _TC-50 | Reader Range           | Please move closer to the reader to gain access                                       | Enable              |
#      | _TC-51 | Anti-Passback Detected | This reader is anti-passback enabled. Please make sure your Mobile ID is not misused. | Enable              |

# **************************code of surrender sundarraj begins  ************************

  @ANDR_AddMobileID_31 @ANDR_AddMobileID
  Scenario Outline:ANDR_AddMobileID_3<TC_ID>: Verify Nearby readers onboarding screens are displayed on clicking information icon
    When Verify Mobile ID screen when Mobile ID is present in android device
    And Verify nearby readers section in android device "<nearByReader>" in android device
    And Verify nearby readers information icon is visible in android device
    And Verify onboarding screen one is Visible

    Examples:
      | TC_ID | nearByReader |
      | _TC-1 | 0            |

  @ANDR_AddMobileID_41 @ANDR_AddMobileID
  Scenario Outline:ANDR_AddMobileID_4<TC_ID>: Verify Get Started navigates to Nearby readers screen in android device
    When Verify Mobile ID screen when Mobile ID is present in android device
    And Verify nearby readers section in android device "<nearByReader>" in android device
    And Verify nearby readers information icon is visible in android device
    And Verify onboarding screen one is Visible
    And Verify onboarding screen is navigable
    Examples:
      | TC_ID | nearByReader |
      | _TC-1 | 0            |


  @ANDR_AddMobileID_5 @ANDR_AddMobileID
  Scenario Outline:ANDR_AddMobileID_5<TC_ID>:Verify if both reader types are discovered in home screen when both are enabled.
#    When Verify Mobile ID screen when Mobile ID is present in android device
#    And Verify nearby readers section in android device "<nearByReader>"
    When Navigate to Settings and App Preferences screen in android device
    And NearBy Reader Status is displayed as "<NearByReader_Status>" in android device
    And click on the Nearby Readers tab
    And Verify Enable Nearby Reader toggle button status in android device
#    And click on the Nearby Readers switch
    And Verify Enable Nearby Reader toggle button status in android device
    And Verify Discover Nearby Reader Element is displayed as Discover Nearby Readers in android device
#    And Signo Reader Text is displayed as Signo Reader in android device
    And Verify Signo Reader Status is displayed as "<Signo Reader>" in android device
    And Verify RevE Reader Status is displayed as "<RevE Reader>" in android device
    And Click on Image back button in Nearby Readers page
    And Click on Image back in AppPreferences page in android device
    And Click on the Mobile IDs in Settings page for navigating to home screen
    And Verify Nearby Readers are visible in android device
    And Verify nearby readers section in android device "<nearByReader>" in android device
    Examples:
      | TC_ID | nearByReader | NearByReader_Status | RevE Reader | Signo Reader |
      | _TC-1 | 1            | On                  | On          | On           |

  @ANDR_AddMobileID_6 @ANDR_AddMobileID
  Scenario Outline:ANDR_AddMobileID_6<TC_ID>: Verify if the Manage screen has all UI with appropriate texts.
    When Verify Mobile ID screen when Mobile ID is present in android device
    And Verify nearby readers section in android device "<nearByReader>" in android device
    And Verify Manage button is displayed in android device
    And Verify Manage Reader Screen in android device
    And Verify if the list of Favourite readers are listed above successful transaction logs in android device
    Examples:
      | TC_ID | nearByReader | nearbyReaderCount |
      | _TC-1 | 1            | 0                 |

  @ANDR_AddMobileID_7 @ANDR_AddMobileID
  Scenario Outline:ANDR_AddMobileID_7<TC_ID>:Verify if back button helps to navigate back to Mobile IDs screen.
    When Verify Mobile ID screen when Mobile ID is present in android device
    And Verify nearby readers section in android device "<nearByReader>" in android device
    And Verify Manage button is displayed in android device
    And Verify Manage Reader Screen in android device
    And Click on Image back button in ManageReaders Screen navigate to Mobile ids Screen in android device
    Examples:
      | TC_ID | nearByReader |
      | _TC-1 | 1            |

  @ANDR_AddMobileID_8 @ANDR_AddMobileID
  Scenario Outline: Verify if the favourite reader can be removed and it gets reflected in successful transaction logs
    When Verify Mobile ID screen when Mobile ID is present in android device
    And Verify nearby readers section in android device "<nearByReader>" in android device
    And Verify Nearby Readers are visible in android device
    And Click on heart icon on Reader in android device in android device
    And Verify Manage button is displayed in android device
    And Verify Manage Reader Screen in android device
    And Verify unfavorite reader stored in successful transactions log in android device

    Examples:
      | TC_ID | nearByReader |
      | _TC-1 | 1            |

  @ANDR_AddMobileID_9 @ANDR_AddMobileID
  Scenario Outline: Verify if the reader under successful transaction logs can be added as favourite and it gets reflected in favourite readers.
    When Verify Mobile ID screen when Mobile ID is present in android device
    And Verify nearby readers section in android device "<nearByReader>" in android device
    And Verify Nearby Readers are visible in android device
    And Verify Manage button is displayed in android device
    And Verify Manage Reader Screen in android device
    And Verify added reader reflected in Favorite Readers in android device
    Examples:
      | TC_ID | nearByReader |
      | _TC-1 | 1            |

    #******************************************************* code of surrender sundarraj ends ***************************************************


