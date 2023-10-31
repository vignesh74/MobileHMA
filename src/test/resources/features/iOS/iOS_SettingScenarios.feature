 Feature: To Test iOS Setting workflow for HID mobile access application


  Background:To launch the HID app and navigate
    Given Launch HID Access Mobile Application in iOS device
    When  Mobile IDs screen is displayed in iOS device
    Then  Notification screen is displayed with message "New Mobile ID issued" and "A new Mobile ID is now ready for use" in iOS device

  @iOS_Settings_WF1 @iOS_Settings_WF @iOS_SmokeRun 
  Scenario Outline: iOS_Settings_WF1<TC_ID>: Verify that BLE status is <BLE_Status> and location permission status is <location_permission>
    When  Navigate to Settings in iOS device
    Then  BLE status is displayed as "<BLE_status>" in iOS device
    And   Location permission is displayed as "<location_permission>" in iOS device

    Examples:
      | TC_ID  | BLE_status | location_permission |
      | _TC-01 | Allowed    | Always              |
      | _TC-02 | Allowed    | While using the app |
      | _TC-03 | Allowed    | Never               |
      | _TC-04 | Denied     | Always              |
      | _TC-05 | Denied     | While using the app |
      | _TC-06 | Denied     | Never               |

  @iOS_Settings_WF2 @iOS_Settings_WF @iOS_SmokeRun 
  Scenario Outline: iOS_Settings_WF2<TC_ID>: Verify Mode State status is <mode_state>
    When  Navigate to Settings in iOS device
    Then  Mode state is displayed as "<mode_state>" in iOS device

    Examples:
      | TC_ID  | mode_state |
      | _TC-07 | Always     |
      | _TC-08 | Foreground |
      | _TC-09 | Unlocked   |

  @iOS_Settings_WF3 @iOS_Settings_WF @iOS_SmokeRun 
  Scenario Outline: iOS_Settings_WF3<TC_ID>: Verify toggle button Enable/Disable for PlaySound <play_sound_state>, Vibrate <Vibrate_state> and TwistAndGo <twist_and_go>
    When  Navigate to Settings in iOS device
    Then  Play sound status is displayed as "<play_sound_state>" in iOS device
    And   Vibrate status is displayed as "<Vibrate_state>" in iOS device
    And   Twist&Go state is displayed as "<twist_and_go>" in iOS device

    Examples:
      | TC_ID  | play_sound_state | Vibrate_state | twist_and_go |
      | _TC-10 | Enable           | Enable        | Disable      |
      | _TC-11 | Disable          | Disable       | Enable       |

  @iOS_Settings_WF4 @iOS_Settings_WF @iOS_SmokeRun 
  Scenario Outline: iOS_Settings_WF4<TC_ID>: Verify the page of Support, activity, about, term of use, privacy notice and Verify toggle button Enable/Disable log file <log_file>
    When  Navigate to Settings in iOS device
    And   Navigate to Help center in iOS device
    Then  Support status is displayed with text "Application is not working" in iOS device
    And   Activity log status is displayed in iOS device
    And   About state is displayed in iOS device
    And   Term of use and privacy notice is displayed in iOS device
    And   Log file status is displayed as "<log_file>" in iOS device

    Examples:
      | TC_ID  | log_file |
      | _TC-12 | Enable   |
      | _TC-13 | Disable  |

  @iOS_Settings_WF5 @iOS_Settings_WF 
  Scenario Outline: iOS_Settings_WF5<TC_ID>: Verify the page of About and its details, Application Info, Endpoint Info and Device Info <Environment>
    When  Navigate to Settings in iOS device
    And   Select the mode state as "<mode_state>" in iOS device
    And   Navigate to Help center in iOS device
    Then  About screen is displayed "<mode_state>", "<Environment>", "<Bluetooth>" and "<LocationServices>" in iOS device

    Examples:
      | TC_ID  | mode_state | Environment | Bluetooth     | LocationServices              |
      | _TC-14 | Always     | Prod        | BLE Supported | Location Services are enabled |

  @iOS_Settings_WF6 @iOS_Settings_WF
  Scenario Outline: iOS_Settings_WF6<TC_ID>: Verify the page of Notification message in notification screen along with <mobileID>
    When  Mobile ID is "<mobileID>" and the Notification screen is displayed with message as "<Message1>" and "<Message2>" in iOS device
    And   Navigate back to Mobile ID screen in iOS device
    Then  Verify the Mobile ID screen "<mobileID>" in iOS device

    Examples:
      | TC_ID  | mobileID| Message1                | Message2         |
      | _TC-15 | Suspend | From Your Administrator |Mobile ID updated |
      | _TC-16 | Resume  | From Your Administrator |Mobile ID updated |
      | _TC-17 | Revoke  | From Your Administrator |Mobile ID revoked |

   @iOS_Settings_WF7 @iOS_Settings_WF 
   Scenario Outline: iOS_Settings_WF7<TC_ID>: Verify the warning banners for mode <mode_state>, BLE status as <BLE_status> and Location permission as <location_permission> combinations
     When  Navigate to Settings in iOS device
     And   Select the mode state as "<mode_state>" in iOS device
     And   Set BLE status as "<BLE_status>" in iOS device
     And   Set location permission as "<location_permission>" in iOS device
     Then  Verify the warning banners of "<mode_state>" BLE "<BLE_status>" and Location permission "<location_permission>" in iOS device

     Examples:
       | TC_ID  | mode_state | BLE_status | location_permission |
       | _TC-18 | Always     | Allowed    | Never               |
       | _TC-19 | Always     | Allowed    | While using the app |
       | _TC-20 | Always     | Allowed    | Always              |
       | _TC-21 | Foreground | Allowed    | Never               |
       | _TC-22 | Foreground | Allowed    | While using the app |
       | _TC-23 | Foreground | Allowed    | Always              |
       | _TC-24 | Unlocked   | Allowed    | Never               |
       | _TC-25 | Unlocked   | Allowed    | While using the app |
       | _TC-26 | Unlocked   | Allowed    | Always              |
       | _TC-27 | Always     | Denied     | Never               |
       | _TC-28 | Always     | Denied     | While using the app |
       | _TC-29 | Always     | Denied     | Always              |
       | _TC-30 | Foreground | Denied     | Never               |
       | _TC-31 | Foreground | Denied     | While using the app |
       | _TC-31 | Foreground | Denied     | Always              |
       | _TC-33 | Unlocked   | Denied     | Never               |
       | _TC-34 | Unlocked   | Denied     | While using the app |
       | _TC-35 | Unlocked   | Denied     | Always              |

   @iOS_Settings_WF8 @iOS_Settings_WF
   Scenario Outline: iOS_Settings_WF8<TC_ID>: Verify the Add Mobile ID screen with valid invitation code using Rest API
     When  Mobile IDs screen is displayed in iOS device
     And   Click on ADD button in iOS device
     And   Verify the Add Mobile ID screen in iOS device
     And   Get Invitation Code iOS using Rest API when credential are assigned
     Then  Enter invitation code on HID mobile Application in iOS device

     Examples:
       | TC_ID  |
       | _TC-36 |

   @iOS_Settings_WF9 @iOS_Settings_WF 
   Scenario Outline: iOS_Settings_WF9<TC_ID>: Verify the Add Mobile ID screen with invalid or expired invitation code
     When  Mobile IDs screen is displayed in iOS device
     And   Click on ADD button in iOS device
     And   Verify the Add Mobile ID screen in iOS device
     Then  Enter Invalid or Expired invitation code "<Expired_Code>" on HID mobile Application in iOS device

     Examples:
       | TC_ID  | Expired_Code         |
       | _TC-37 | AC57-R6ZF-AAD5-ZGVQ  |

   @iOS_Settings_WF10 @iOS_Settings_WF 
   Scenario Outline: iOS_Settings_WF10<TC_ID>: Verify the Add Mobile ID screen with Internet OFF scenario
     When  Navigate to Settings in iOS device
     And   Set WIFI status as "<Internet>" in iOS device
     When  Mobile IDs screen is displayed in iOS device
     And   Click on ADD button in iOS device
     And   Verify the Add Mobile ID screen in iOS device
     Then  Verify the No Internet Error "<Invitation_Code>" on HID mobile Application in iOS device
     And   Navigate to Settings in iOS device
     And   Set back the WIFI status as ON in iOS device

     Examples:
       | TC_ID  | Internet | Invitation_Code     |
       | _TC-38 | Off      | AC57-R6ZF-AAD5-ZGVQ |

   @iOS_Settings_WF11 @iOS_Settings_WF 
   Scenario Outline: iOS_Settings_WF11<TC_ID>: Verify the page of Support and log document using Enable/Disable log file <log_file>
     When  Navigate to Settings in iOS device
     And   Navigate to Help center in iOS device
     And   Log file status is displayed as "<log_file>" in iOS device
     Then  Verify Support status debug log file "<log_file>" in feedback page "<Feedback_Msg>" in iOS device

     Examples:
       | TC_ID  | log_file | Feedback_Msg |
       | _TC-39 | Enable   | Issue 1      |
       | _TC-40 | Disable  | Issue 2      |

   @iOS_Settings_WF12 @iOS_Settings_WF
   Scenario Outline: iOS_Settings_WF12<TC_ID>: Verify the Deregister option of Mobile IDs in setting page
     When  Navigate to Settings in iOS device
     Then  Deregister all the Mobile IDs from this phone in iOS device

     Examples:
       | TC_ID  |
       | _TC-41 |

   @iOS_Settings_WF13 @iOS_Settings_WF 
   Scenario Outline: iOS_Settings_WF13<TC_ID>: Verify the Deregister option of Mobile IDs in setting page with Internet <Internet>
     When  Navigate to Settings in iOS device
     And   Set WIFI status as "<Internet>" in iOS device
     Then  Verify No Internet pop up while deregister the Mobile IDs in iOS device
     And   Set back the WIFI status as ON in iOS device

     Examples:
       | TC_ID  | Internet |
       | _TC-42 | Off      |

   @iOS_Settings_WF14 @iOS_Settings_WF
   Scenario Outline: iOS_Settings_WF14<TC_ID>: Verify the delete device pop up in HID mobile access welcome page using Rest API
     When  Trigger the Rest API to delete device in iOS device
     And   Launch HID Access Mobile Application in iOS device
     Then  Verify Delete Mobile IDs pop up in welcome screen in iOS device

     Examples:
       | TC_ID  |
       | _TC-43 |

   @iOS_Settings_WF15 @iOS_Settings_WF
   Scenario Outline: iOS_Settings_WF15<TC_ID>: Verify the Internet <Internet> pop up while deleting the device from portal through Rest API
     When  Navigate to Settings in iOS device
     And   Set WIFI status as "<Internet>" in iOS device
     And   Trigger the Rest API to delete device in iOS device
     And   Launch HID Access Mobile Application in iOS device
     Then  Verify the No Internet pop up in home screen in iOS device
     And   Navigate to Settings in iOS device
     When  Set back the WIFI status as ON in iOS device
     Then  Verify Delete Mobile IDs pop up in welcome screen in iOS device

     Examples:
       | TC_ID  | Internet |
       | _TC-44 | Off      |

   @iOS_Settings_WF16 @iOS_Settings_WF
   Scenario Outline: iOS_Settings_WF16<TC_ID>: Verify the Onboarding screens, Welcome page along with About the App
     When  Verify Onboarding screen in iOS device
     And   Agree Terms of Use License and policy in iOS device
     And   Welcome to HID Mobile Access screen in iOS device
     #And  Get Invitation Code iOS using Rest API when credential are assigned
     #Then  Enter invitation code on HID mobile Application in iOS device

     Examples:
       | TC_ID  |
       | _TC-45 |

   @iOS_Settings_WF17 @iOS_Settings_WF
   Scenario Outline: iOS_Settings_WF17<TC_ID>: Verify the FAQ screen and search field in IOS APP
     When  Navigate to Settings in iOS device
     And   Navigate to Help center in iOS device
     And   Navigate to FAQ screen in iOS device
     Then  Search in FAQ screen in iOS device

     Examples:
       | TC_ID  |
       | _TC-46 |

   @iOS_Settings_WF18 @iOS_Settings_WF
   Scenario Outline: iOS_Settings_WF18<TC_ID>: Verify the Org specific contact information in the back of the card
     When  Mobile IDs screen is displayed in iOS device
     Then  Navigate to Org specific contact information in iOS device
     And   Add Nickname "<nickname>" to the card in iOS device

     Examples:
       | TC_ID  | nickname  |
       | _TC-47 | Auto Test |

   @iOS_Settings_WF19 @iOS_Settings_WF
   Scenario Outline: iOS_Settings_WF19<TC_ID>: Verify the Activity log Error scenarios with error message in the Activity log <activityLog>
     When  Navigate to Settings in iOS device
     And   Navigate to Help center in iOS device
     And   Navigate to Activity log screen in iOS device
     Then  Verify the log message "<activityLog>" and "<logMessage>" in Activity log screen in iOS device

     Examples:
       | TC_ID  | activityLog                   | logMessage                                                                            |
       | _TC-48 | Mobile ID mismatch            | Mobile ID incompatible with this reader. Please contact your administrator.           |
       | _TC-49 | Mobile ID Read                | Communication timeout. Please try again.                                              |
       | _TC-50 | Reader Range                  | Please move closer to the reader to gain access                                       |
       | _TC-51 | Anti-Passback Detected        | This reader is anti-passback enabled. Please make sure your Mobile ID is not misused. |                                                                            |
