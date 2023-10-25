Feature: To Test iOS Unlock workflow for HID mobile access application from Device Enforcement org

  Background:To launch the HID app and navigate
    Given Launch HID Access Mobile Application in iOS device
    When  Mobile IDs screen is displayed in iOS device
    Then  Notification screen is displayed with message "New Mobile ID issued" and "A new Mobile ID is now ready for use" in iOS device

  Scenario Outline: iOS_<Reader_Name><Gesture_TC_ID>: Verify Robotic Arm Action and check the Robotic Arm logs when BLE is <BLE_status>, location is <location_permission>, Application State is <app_state>, device state is <device_state>
    When  Navigate to Settings in iOS device
    And   Select the mode state as "<mode_state>" in iOS device
    And   Set BLE status as "<BLE_status>" in iOS device
    And   Set location permission as "<location_permission>" in iOS device
    And   Set Application status as "<app_state>" in iOS device
    And   Set display screen as "<display_status>" in iOS device
    Then  Verify "<mode_state>" is disabled and other modes are enabled
    And   Set Application status as "<app_state>" in iOS device
    And   Perform robotic arm action as "<action_name>" for iOS device
    And   Set device state as "ForcedUnlock" in iOS device
    And   Set Application status as "AlwaysForeground" in iOS device
    Then  Robotic arms log "<robotic_arm_log>" is displayed for iOS device
    And   Activity log is displayed in iOS device and "<date>", "<mobile_read>", "<message>", "<arm_action_name>" and "<reader_name>" are verified

    @iOS_DE_Tap_WF1 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID  | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TAP_WF1_TC-01 | Foreground | Allowed    | Always              | Foreground | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF1_TC-02 | Foreground | Allowed    | Always              | Background | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF1_TC-03 | Foreground | Allowed    | Always              | Background | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF1_TC-04 | Foreground | Allowed    | Always              | Foreground | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF1_TC-05 | Foreground | Allowed    | Always              | Foreground | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF1_TC-06 | Foreground | Allowed    | Always              | Background | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF1_TC-07 | Foreground | Allowed    | Always              | Killed     | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF1_TC-08 | Foreground | Allowed    | Always              | Killed     | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF1_TC-09 | Foreground | Allowed    | Always              | Killed     | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |

    @iOS_DE_Tap_WF2 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID  | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TAP_WF2_TC-10 | Unlocked   | Allowed    | Always              | Foreground | Locked*      | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF2_TC-11 | Unlocked   | Allowed    | Always              | Background | Locked*      | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF2_TC-12 | Unlocked   | Allowed    | Always              | Background | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF2_TC-13 | Unlocked   | Allowed    | Always              | Foreground | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF2_TC-14 | Unlocked   | Allowed    | Always              | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF2_TC-15 | Unlocked   | Allowed    | Always              | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF2_TC-16 | Unlocked   | Allowed    | Always              | Killed     | Locked*      | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF2_TC-17 | Unlocked   | Allowed    | Always              | Killed     | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF2_TC-18 | Unlocked   | Allowed    | Always              | Killed     | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |

    @iOS_DE_Tap_WF3 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID  | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TAP_WF3_TC-19 | Foreground | Denied     | Always              | Foreground | Locked*      | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF3_TC-20 | Foreground | Denied     | Always              | Background | Locked*      | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF3_TC-21 | Foreground | Denied     | Always              | Background | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF3_TC-22 | Foreground | Denied     | Always              | Foreground | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF3_TC-23 | Foreground | Denied     | Always              | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF3_TC-24 | Foreground | Denied     | Always              | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF3_TC-25 | Foreground | Denied     | Always              | Killed     | Locked*      | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF3_TC-26 | Foreground | Denied     | Always              | Killed     | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF3_TC-27 | Foreground | Denied     | Always              | Killed     | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |

    @iOS_DE_Tap_WF4 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID  | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TAP_WF4_TC-28 | Foreground | Allowed    | While using the app | Foreground | Locked*      | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF4_TC-29 | Foreground | Allowed    | While using the app | Background | Locked*      | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF4_TC-30 | Foreground | Allowed    | While using the app | Background | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF4_TC-31 | Foreground | Allowed    | While using the app | Foreground | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF4_TC-32 | Foreground | Allowed    | While using the app | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF4_TC-33 | Foreground | Allowed    | While using the app | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF4_TC-34 | Foreground | Allowed    | While using the app | Killed     | Locked*      | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF4_TC-35 | Foreground | Allowed    | While using the app | Killed     | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF4_TC-36 | Foreground | Allowed    | While using the app | Killed     | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |

    @iOS_DE_Tap_WF5 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID  | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TAP_WF5_TC-37 | Unlocked   | Allowed    | While using the app | Foreground | Locked*      | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF5_TC-38 | Unlocked   | Allowed    | While using the app | Background | Locked*      | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF5_TC-39 | Unlocked   | Allowed    | While using the app | Background | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF5_TC-40 | Unlocked   | Allowed    | While using the app | Foreground | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF5_TC-41 | Unlocked   | Allowed    | While using the app | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF5_TC-42 | Unlocked   | Allowed    | While using the app | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF5_TC-43 | Unlocked   | Allowed    | While using the app | Killed     | Locked*      | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF5_TC-44 | Unlocked   | Allowed    | While using the app | Killed     | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF5_TC-45 | Unlocked   | Allowed    | While using the app | Killed     | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |

    @iOS_DE_Tap_WF6 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID  | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TAP_WF6_TC-46 | Unlocked   | Denied     | While using the app | Foreground | Locked*      | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF6_TC-47 | Unlocked   | Denied     | While using the app | Background | Locked*      | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF6_TC-48 | Unlocked   | Denied     | While using the app | Background | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF6_TC-49 | Unlocked   | Denied     | While using the app | Foreground | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF6_TC-50 | Unlocked   | Denied     | While using the app | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF6_TC-51 | Unlocked   | Denied     | While using the app | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF6_TC-52 | Unlocked   | Denied     | While using the app | Killed     | Locked*      | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF6_TC-53 | Unlocked   | Denied     | While using the app | Killed     | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF6_TC-54 | Unlocked   | Denied     | While using the app | Killed     | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |

    @iOS_DE_Tap_WF7 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID  | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TAP_WF7_TC-55 | Foreground | Allowed    | Never               | Foreground | Locked*      | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF7_TC-56 | Foreground | Allowed    | Never               | Background | Locked*      | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF7_TC-57 | Foreground | Allowed    | Never               | Background | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF7_TC-58 | Foreground | Allowed    | Never               | Foreground | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF7_TC-59 | Foreground | Allowed    | Never               | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF7_TC-60 | Foreground | Allowed    | Never               | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF7_TC-61 | Foreground | Allowed    | Never               | Killed     | Locked*      | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF7_TC-62 | Foreground | Allowed    | Never               | Killed     | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF7_TC-63 | Foreground | Allowed    | Never               | Killed     | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |

    @iOS_DE_Tap_WF8 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID  | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TAP_WF8_TC-64 | Unlocked   | Allowed    | Never               | Foreground | Locked*      | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF8_TC-65 | Unlocked   | Allowed    | Never               | Background | Locked*      | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF8_TC-66 | Unlocked   | Allowed    | Never               | Background | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF8_TC-67 | Unlocked   | Allowed    | Never               | Foreground | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF8_TC-68 | Unlocked   | Allowed    | Never               | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF8_TC-69 | Unlocked   | Allowed    | Never               | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF8_TC-70 | Unlocked   | Allowed    | Never               | Killed     | Locked*      | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF8_TC-71 | Unlocked   | Allowed    | Never               | Killed     | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF8_TC-72 | Unlocked   | Allowed    | Never               | Killed     | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |

    @iOS_DE_Tap_WF9 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID  | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TAP_WF9_TC-73 | Unlocked   | Denied     | Never               | Foreground | Locked*      | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF9_TC-74 | Unlocked   | Denied     | Never               | Background | Locked*      | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF9_TC-75 | Unlocked   | Denied     | Never               | Background | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF9_TC-76 | Unlocked   | Denied     | Never               | Foreground | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF9_TC-77 | Unlocked   | Denied     | Never               | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF9_TC-78 | Unlocked   | Denied     | Never               | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF9_TC-79 | Unlocked   | Denied     | Never               | Killed     | Locked*      | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF9_TC-80 | Unlocked   | Denied     | Never               | Killed     | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |
      | RevE        | _TAP_WF9_TC-81 | Unlocked   | Denied     | Never               | Killed     | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | Seos        |

    @iOS_DE_EnhancedTap_WF1 @iOS_DE @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _ET_WF1_TC-01 | Unlocked   | Denied     | Never               | Foreground | Locked*      | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF1_TC-02 | Unlocked   | Denied     | Never               | Background | Locked*      | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF1_TC-03 | Unlocked   | Denied     | Never               | Background | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF1_TC-04 | Unlocked   | Denied     | Never               | Foreground | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF1_TC-05 | Unlocked   | Denied     | Never               | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF1_TC-06 | Unlocked   | Denied     | Never               | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF1_TC-07 | Unlocked   | Denied     | Never               | Killed     | Locked*      | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF1_TC-08 | Unlocked   | Denied     | Never               | Killed     | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF1_TC-09 | Unlocked   | Denied     | Never               | Killed     | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |

    @iOS_DE_EnhancedTap_WF2 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _ET_WF2_TC-10 | Unlocked   | Allowed    | Always              | Foreground | Locked*      | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF2_TC-11 | Unlocked   | Allowed    | Always              | Background | Locked*      | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF2_TC-12 | Unlocked   | Allowed    | Always              | Background | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF2_TC-13 | Unlocked   | Allowed    | Always              | Background | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF2_TC-14 | Unlocked   | Allowed    | Always              | Foreground | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF2_TC-15 | Unlocked   | Allowed    | Always              | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF2_TC-16 | Unlocked   | Allowed    | Always              | Killed     | Locked*      | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF2_TC-17 | Unlocked   | Allowed    | Always              | Killed     | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF2_TC-18 | Unlocked   | Allowed    | Always              | Killed     | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |

    @iOS_DE_EnhancedTap_WF3 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _ET_WF3_TC-19 | Foreground | Denied     | Always              | Foreground | Locked*      | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF3_TC-20 | Foreground | Denied     | Always              | Background | Locked*      | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF3_TC-21 | Foreground | Denied     | Always              | Background | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF3_TC-22 | Foreground | Denied     | Always              | Background | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF3_TC-23 | Foreground | Denied     | Always              | Foreground | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF3_TC-24 | Foreground | Denied     | Always              | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF3_TC-25 | Foreground | Denied     | Always              | Killed     | Locked*      | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF3_TC-26 | Foreground | Denied     | Always              | Killed     | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF3_TC-27 | Foreground | Denied     | Always              | Killed     | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |

    @iOS_DE_EnhancedTap_WF4 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _ET_WF4_TC-28 | Foreground | Allowed    | While using the app | Foreground | Locked*      | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF4_TC-29 | Foreground | Allowed    | While using the app | Background | Locked*      | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF4_TC-30 | Foreground | Allowed    | While using the app | Background | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF4_TC-31 | Foreground | Allowed    | While using the app | Background | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF4_TC-32 | Foreground | Allowed    | While using the app | Foreground | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF4_TC-33 | Foreground | Allowed    | While using the app | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF4_TC-34 | Foreground | Allowed    | While using the app | Killed     | Locked*      | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF4_TC-35 | Foreground | Allowed    | While using the app | Killed     | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF4_TC-36 | Foreground | Allowed    | While using the app | Killed     | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |

    @iOS_DE_EnhancedTap_WF5 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _ET_WF5_TC-37 | Unlocked   | Allowed    | While using the app | Foreground | Locked*      | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF5_TC-38 | Unlocked   | Allowed    | While using the app | Background | Locked*      | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF5_TC-39 | Unlocked   | Allowed    | While using the app | Background | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF5_TC-40 | Unlocked   | Allowed    | While using the app | Background | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF5_TC-41 | Unlocked   | Allowed    | While using the app | Foreground | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF5_TC-42 | Unlocked   | Allowed    | While using the app | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF5_TC-43 | Unlocked   | Allowed    | While using the app | Killed     | Locked*      | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF5_TC-44 | Unlocked   | Allowed    | While using the app | Killed     | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF5_TC-45 | Unlocked   | Allowed    | While using the app | Killed     | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |

    @iOS_DE_EnhancedTap_WF6 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _ET_WF6_TC-46 | Unlocked   | Denied     | While using the app | Foreground | Locked*      | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF6_TC-47 | Unlocked   | Denied     | While using the app | Background | Locked*      | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF6_TC-48 | Unlocked   | Denied     | While using the app | Background | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF6_TC-49 | Unlocked   | Denied     | While using the app | Background | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF6_TC-50 | Unlocked   | Denied     | While using the app | Foreground | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF6_TC-51 | Unlocked   | Denied     | While using the app | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF6_TC-52 | Unlocked   | Denied     | While using the app | Killed     | Locked*      | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF6_TC-53 | Unlocked   | Denied     | While using the app | Killed     | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF6_TC-54 | Unlocked   | Denied     | While using the app | Killed     | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |

    @iOS_DE_EnhancedTap_WF7 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _ET_WF7_TC-55 | Foreground | Allowed    | Never               | Foreground | Locked*      | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-56 | Foreground | Allowed    | Never               | Background | Locked*      | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-57 | Foreground | Allowed    | Never               | Background | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-58 | Foreground | Allowed    | Never               | Background | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-59 | Foreground | Allowed    | Never               | Foreground | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-60 | Foreground | Allowed    | Never               | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-61 | Foreground | Allowed    | Never               | Killed     | Locked*      | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-62 | Foreground | Allowed    | Never               | Killed     | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-63 | Foreground | Allowed    | Never               | Killed     | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |

    @iOS_DE_EnhancedTap_WF8 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _ET_WF7_TC-64 | Unlocked   | Allowed    | Never               | Foreground | Locked*      | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-65 | Unlocked   | Allowed    | Never               | Background | Locked*      | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-66 | Unlocked   | Allowed    | Never               | Background | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-67 | Unlocked   | Allowed    | Never               | Background | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-68 | Unlocked   | Allowed    | Never               | Foreground | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-69 | Unlocked   | Allowed    | Never               | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-70 | Unlocked   | Allowed    | Never               | Killed     | Locked*      | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-71 | Unlocked   | Allowed    | Never               | Killed     | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-72 | Unlocked   | Allowed    | Never               | Killed     | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |

    @iOS_DE_EnhancedTap_WF9 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _ET_WF7_TC-73 | Unlocked   | Denied     | Never               | Foreground | Locked*      | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-74 | Unlocked   | Denied     | Never               | Background | Locked*      | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-75 | Unlocked   | Denied     | Never               | Background | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-76 | Unlocked   | Denied     | Never               | Background | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-77 | Unlocked   | Denied     | Never               | Foreground | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-78 | Unlocked   | Denied     | Never               | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-79 | Unlocked   | Denied     | Never               | Killed     | Locked*      | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-80 | Unlocked   | Denied     | Never               | Killed     | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |
      | RevE        | _ET_WF7_TC-81 | Unlocked   | Denied     | Never               | Killed     | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | Seos        |

    @iOS_DE_TwistGo_WF1 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log      | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF1_TC-01 | Foreground | Allowed    | Always              | Foreground | Unlocked*    | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF1_TC-02 | Foreground | Allowed    | Always              | Background | Unlocked*    | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF1_TC-03 | Foreground | Allowed    | Always              | Background | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF1_TC-04 | Foreground | Allowed    | Always              | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF1_TC-05 | Foreground | Allowed    | Always              | Foreground | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF1_TC-06 | Foreground | Allowed    | Always              | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF1_TC-07 | Foreground | Allowed    | Always              | Killed     | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF1_TC-08 | Foreground | Allowed    | Always              | Killed     | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF1_TC-09 | Foreground | Allowed    | Always              | Killed     | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |

    @iOS_DE_TwistGo_WF2 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log      | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF2_TC-10 | Unlocked   | Allowed    | Always              | Foreground | Locked*      | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF2_TC-11 | Unlocked   | Allowed    | Always              | Background | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF2_TC-12 | Unlocked   | Allowed    | Always              | Background | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF2_TC-13 | Unlocked   | Allowed    | Always              | Foreground | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF2_TC-14 | Unlocked   | Allowed    | Always              | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF2_TC-15 | Unlocked   | Allowed    | Always              | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF2_TC-16 | Unlocked   | Allowed    | Always              | Killed     | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF2_TC-17 | Unlocked   | Allowed    | Always              | Killed     | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF2_TC-18 | Unlocked   | Allowed    | Always              | Killed     | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |

    @iOS_DE_TwistGo_WF3 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log       | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF3_TC-19 | Foreground | Allowed    | Always              | Foreground | Locked*      | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF3_TC-20 | Foreground | Allowed    | Always              | Background | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF3_TC-21 | Foreground | Allowed    | Always              | Background | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF3_TC-22 | Foreground | Allowed    | Always              | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF3_TC-23 | Foreground | Allowed    | Always              | Foreground | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF3_TC-24 | Foreground | Allowed    | Always              | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF3_TC-25 | Foreground | Allowed    | Always              | Killed     | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF3_TC-26 | Foreground | Allowed    | Always              | Killed     | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF3_TC-27 | Foreground | Allowed    | Always              | Killed     | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |

    @iOS_DE_TwistGo_WF4 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log      | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF4_TC-28 | Foreground | Denied     | Always              | Foreground | Locked*      | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF4_TC-29 | Foreground | Denied     | Always              | Background | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF4_TC-30 | Foreground | Denied     | Always              | Background | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF4_TC-31 | Foreground | Denied     | Always              | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF4_TC-32 | Foreground | Denied     | Always              | Foreground | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF4_TC-33 | Foreground | Denied     | Always              | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF4_TC-34 | Foreground | Denied     | Always              | Killed     | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF4_TC-35 | Foreground | Denied     | Always              | Killed     | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF4_TC-36 | Foreground | Denied     | Always              | Killed     | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |

    @iOS_DE_TwistGo_WF5 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log       | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF5_TC-37 | Unlocked   | Denied     | Always              | Foreground | Locked*      | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF5_TC-38 | Unlocked   | Denied     | Always              | Background | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF5_TC-39 | Unlocked   | Denied     | Always              | Background | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF5_TC-40 | Unlocked   | Denied     | Always              | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF5_TC-41 | Unlocked   | Denied     | Always              | Foreground | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF5_TC-42 | Unlocked   | Denied     | Always              | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF5_TC-43 | Unlocked   | Denied     | Always              | Killed     | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF5_TC-44 | Unlocked   | Denied     | Always              | Killed     | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF5_TC-45 | Unlocked   | Denied     | Always              | Killed     | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |

    @iOS_DE_TwistGo_WF6 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log      | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF6_TC-46 | Foreground | Allowed    | While using the app | Foreground | Locked*      | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF6_TC-47 | Foreground | Allowed    | While using the app | Background | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF6_TC-48 | Foreground | Allowed    | While using the app | Background | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF6_TC-49 | Foreground | Allowed    | While using the app | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF6_TC-50 | Foreground | Allowed    | While using the app | Foreground | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF6_TC-51 | Foreground | Allowed    | While using the app | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF6_TC-52 | Foreground | Allowed    | While using the app | Killed     | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF6_TC-53 | Foreground | Allowed    | While using the app | Killed     | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF6_TC-54 | Foreground | Allowed    | While using the app | Killed     | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |

    @iOS_DE_TwistGo_WF7 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log      | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF7_TC-55 | Unlocked   | Allowed    | While using the app | Foreground | Locked*      | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF7_TC-56 | Unlocked   | Allowed    | While using the app | Background | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF7_TC-57 | Unlocked   | Allowed    | While using the app | Background | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF7_TC-58 | Unlocked   | Allowed    | While using the app | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF7_TC-59 | Unlocked   | Allowed    | While using the app | Foreground | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF7_TC-60 | Unlocked   | Allowed    | While using the app | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF7_TC-61 | Unlocked   | Allowed    | While using the app | Killed     | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF7_TC-62 | Unlocked   | Allowed    | While using the app | Killed     | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF7_TC-63 | Unlocked   | Allowed    | While using the app | Killed     | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |

    @iOS_DE_TwistGo_WF8 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log       | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF8_TC-64 | Unlocked   | Allowed    | While using the app | Foreground | Locked*      | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF8_TC-65 | Unlocked   | Allowed    | While using the app | Background | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF8_TC-66 | Unlocked   | Allowed    | While using the app | Background | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF8_TC-67 | Unlocked   | Allowed    | While using the app | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF8_TC-68 | Unlocked   | Allowed    | While using the app | Foreground | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF8_TC-69 | Unlocked   | Allowed    | While using the app | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF8_TC-70 | Unlocked   | Allowed    | While using the app | Killed     | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF8_TC-71 | Unlocked   | Allowed    | While using the app | Killed     | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF8_TC-72 | Unlocked   | Allowed    | While using the app | Killed     | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |

    @iOS_DE_TwistGo_WF9 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log      | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF9_TC-73 | Unlocked   | Denied     | While using the app | Foreground | Locked*      | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF9_TC-74 | Unlocked   | Denied     | While using the app | Background | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF9_TC-75 | Unlocked   | Denied     | While using the app | Background | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF9_TC-76 | Unlocked   | Denied     | While using the app | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF9_TC-77 | Unlocked   | Denied     | While using the app | Foreground | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF9_TC-78 | Unlocked   | Denied     | While using the app | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF9_TC-79 | Unlocked   | Denied     | While using the app | Killed     | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF9_TC-80 | Unlocked   | Denied     | While using the app | Killed     | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF9_TC-81 | Unlocked   | Denied     | While using the app | Killed     | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |

    @iOS_DE_TwistGo_WF10 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID  | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log       | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF10_TC-82 | Unlocked   | Denied     | While using the app | Foreground | Locked*      | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF10_TC-83 | Unlocked   | Denied     | While using the app | Background | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF10_TC-84 | Unlocked   | Denied     | While using the app | Background | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF10_TC-85 | Unlocked   | Denied     | While using the app | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF10_TC-86 | Unlocked   | Denied     | While using the app | Foreground | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF10_TC-87 | Unlocked   | Denied     | While using the app | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF10_TC-88 | Unlocked   | Denied     | While using the app | Killed     | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF10_TC-89 | Unlocked   | Denied     | While using the app | Killed     | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF10_TC-90 | Unlocked   | Denied     | While using the app | Killed     | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |

    @iOS_DE_TwistGo_WF11 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID  | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log      | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF11_TC-91 | Foreground | Allowed    | Never               | Foreground | Locked*      | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF11_TC-92 | Foreground | Allowed    | Never               | Background | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF11_TC-93 | Foreground | Allowed    | Never               | Background | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF11_TC-94 | Foreground | Allowed    | Never               | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF11_TC-95 | Foreground | Allowed    | Never               | Foreground | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF11_TC-96 | Foreground | Allowed    | Never               | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF11_TC-97 | Foreground | Allowed    | Never               | Killed     | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF11_TC-98 | Foreground | Allowed    | Never               | Killed     | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF11_TC-99 | Foreground | Allowed    | Never               | Killed     | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |

    @iOS_DE_TwistGo_WF12 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID   | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log      | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF12_TC-100 | Unlocked   | Allowed    | Never               | Foreground | Locked*      | ON*            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF12_TC-101 | Unlocked   | Allowed    | Never               | Background | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF12_TC-102 | Unlocked   | Allowed    | Never               | Background | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF12_TC-103 | Unlocked   | Allowed    | Never               | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF12_TC-104 | Unlocked   | Allowed    | Never               | Foreground | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF12_TC-105 | Unlocked   | Allowed    | Never               | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF12_TC-106 | Unlocked   | Allowed    | Never               | Killed     | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF12_TC-107 | Unlocked   | Allowed    | Never               | Killed     | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF12_TC-108 | Unlocked   | Allowed    | Never               | Killed     | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |

    @iOS_DE_TwistGo_WF13 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID   | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log       | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF13_TC-109 | Unlocked   | Allowed    | Never               | Foreground | Locked*      | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF13_TC-110 | Unlocked   | Allowed    | Never               | Background | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF13_TC-111 | Unlocked   | Allowed    | Never               | Background | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF13_TC-112 | Unlocked   | Allowed    | Never               | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF13_TC-113 | Unlocked   | Allowed    | Never               | Foreground | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF13_TC-114 | Unlocked   | Allowed    | Never               | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF13_TC-115 | Unlocked   | Allowed    | Never               | Killed     | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF13_TC-116 | Unlocked   | Allowed    | Never               | Killed     | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF13_TC-117 | Unlocked   | Allowed    | Never               | Killed     | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |

    @iOS_DE_TwistGo_WF14 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID   | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log      | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF14_TC-118 | Unlocked   | Denied     | Never               | Foreground | Locked*      | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF14_TC-119 | Unlocked   | Denied     | Never               | Background | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF14_TC-120 | Unlocked   | Denied     | Never               | Background | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF14_TC-121 | Unlocked   | Denied     | Never               | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF14_TC-122 | Unlocked   | Denied     | Never               | Foreground | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF14_TC-123 | Unlocked   | Denied     | Never               | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF14_TC-124 | Unlocked   | Denied     | Never               | Killed     | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF14_TC-125 | Unlocked   | Denied     | Never               | Killed     | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF14_TC-126 | Unlocked   | Denied     | Never               | Killed     | Locked       | ON             | Twist & Go  | TWIST_AND_GO:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |

    @iOS_DE_TwistGo_WF15 @iOS_DE
    Examples:
      | Reader_Name | Gesture_TC_ID   | mode_state | BLE_status | location_permission | app_state   | device_state | display_status | action_name | robotic_arm_log       | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF15_TC-127 | Unlocked   | Denied     | Never               | Foreground  | Locked*      | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF15_TC-128 | Unlocked   | Denied     | Never               | Background* | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF15_TC-129 | Unlocked   | Denied     | Never               | Background  | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF15_TC-130 | Unlocked   | Denied     | Never               | Background  | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF15_TC-131 | Unlocked   | Denied     | Never               | Foreground  | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF15_TC-132 | Unlocked   | Denied     | Never               | Foreground  | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF15_TC-133 | Unlocked   | Denied     | Never               | Killed      | Locked*      | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF15_TC-134 | Unlocked   | Denied     | Never               | Killed      | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |
      | RevE        | _TG_WF15_TC-135 | Unlocked   | Denied     | WNever              | Killed      | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | Seos        |