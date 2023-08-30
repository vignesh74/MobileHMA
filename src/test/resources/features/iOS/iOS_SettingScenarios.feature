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

