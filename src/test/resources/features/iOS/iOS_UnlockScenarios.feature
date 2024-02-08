Feature: To Test iOS Unlock workflow for HID mobile access application


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
    And   Set device state as "<device_state>" in iOS device
    And   Set display screen as "<display_status>" in iOS device
    And   Perform robotic arm action as "<action_name>" for iOS device
    And   Set device state as "ForcedUnlock" in iOS device
    And   Set Application status as "AlwaysForeground" in iOS device
    And   Activity log is displayed in iOS device and "<date>", "<mobile_read>", "<message>", "<arm_action_name>", "<reader_name>" and "<action_name>" are verified
    Then  Robotic arms log "<robotic_arm_log>" is displayed for iOS device


    @iOS_RevE_Tap_WF1 @iOS_RevE_Tap @iOS_RevE   #Commented Killed state TC coz in iOS killing the app not working
    Examples:
      | Reader_Name | Gesture_TC_ID  | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TAP_WF1_TC-01 | Always     | Allowed    | Always              | Foreground | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF1_TC-02 | Always     | Allowed    | Always              | Background | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF1_TC-03 | Always     | Allowed    | Always              | Foreground | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF1_TC-04 | Always     | Allowed    | Always              | Background | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
#      | RevE        | _TAP_WF1_TC-05 | Always     | Allowed    | Always              | Killed     | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |


    @iOS_RevE_Tap_WF2 @iOS_RevE_Tap @iOS_RevE

    Examples:
      | Reader_Name | Gesture_TC_ID  | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TAP_WF2_TC-06 | Always     | Allowed    | While using the app | Foreground | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF2_TC-07 | Always     | Allowed    | While using the app | Background | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF2_TC-08 | Always     | Allowed    | While using the app | Foreground | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF2_TC-09 | Always     | Allowed    | While using the app | Background | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF2_TC-10 | Always     | Allowed    | While using the app | Killed     | Unlocked     | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |

    @iOS_RevE_Tap_WF3 @iOS_RevE_Tap @iOS_RevE

    Examples:
      | Reader_Name | Gesture_TC_ID  | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TAP_WF3_TC-11 | Always     | Allowed    | Never               | Foreground | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF3_TC-12 | Always     | Allowed    | Never               | Background | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF3_TC-13 | Always     | Allowed    | Never               | Foreground | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF3_TC-14 | Always     | Allowed    | Never               | Background | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF3_TC-15 | Always     | Allowed    | Never               | Killed     | Unlocked     | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |

    @iOS_RevE_Tap_WF4 @iOS_RevE_Tap @iOS_RevE

    Examples:
      | Reader_Name | Gesture_TC_ID  | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TAP_WF4_TC-16 | Unlocked   | Allowed    | Always              | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF4_TC-17 | Unlocked   | Allowed    | Always              | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF4_TC-18 | Unlocked   | Allowed    | Always              | Foreground | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF4_TC-19 | Unlocked   | Allowed    | Always              | Background | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF4_TC-20 | Unlocked   | Allowed    | Always              | Killed     | Unlocked     | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |

    @iOS_RevE_Tap_WF5 @iOS_RevE_Tap @iOS_RevE

    Examples:
      | Reader_Name | Gesture_TC_ID  | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TAP_WF5_TC-21 | Unlocked   | Allowed    | While using the app | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF5_TC-22 | Unlocked   | Allowed    | While using the app | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF5_TC-23 | Unlocked   | Allowed    | While using the app | Foreground | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF5_TC-24 | Unlocked   | Allowed    | While using the app | Background | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF5_TC-25 | Unlocked   | Allowed    | While using the app | Killed     | Unlocked     | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |

    @iOS_RevE_Tap_WF6 @iOS_RevE_Tap @iOS_RevE

    Examples:
      | Reader_Name | Gesture_TC_ID  | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TAP_WF6_TC-26 | Unlocked   | Allowed    | Never               | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF6_TC-27 | Unlocked   | Allowed    | Never               | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF6_TC-28 | Unlocked   | Allowed    | Never               | Foreground | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF6_TC-29 | Unlocked   | Allowed    | Never               | Background | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF6_TC-30 | Unlocked   | Allowed    | Never               | Killed     | Unlocked     | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |

    @iOS_RevE_Tap_WF7 @iOS_RevE_Tap @iOS_RevE

    Examples:
      | Reader_Name | Gesture_TC_ID  | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TAP_WF7_TC-31 | Foreground | Allowed    | Always              | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF7_TC-32 | Foreground | Allowed    | Always              | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF7_TC-33 | Foreground | Allowed    | Always              | Foreground | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF7_TC-34 | Foreground | Allowed    | Always              | Background | Unlocked     | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF7_TC-35 | Foreground | Allowed    | Always              | Killed     | Unlocked     | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |

    @iOS_RevE_Tap_WF8 @iOS_RevE_Tap @iOS_RevE

    Examples:
      | Reader_Name | Gesture_TC_ID  | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TAP_WF8_TC-36 | Foreground | Allowed    | While using the app | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF8_TC-37 | Foreground | Allowed    | While using the app | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF8_TC-38 | Foreground | Allowed    | While using the app | Foreground | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF8_TC-39 | Foreground | Allowed    | While using the app | Background | Unlocked     | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF8_TC-40 | Foreground | Allowed    | While using the app | Killed     | Unlocked     | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |

    @iOS_RevE_Tap_WF9 @iOS_RevE_Tap @iOS_RevE

    Examples:
      | Reader_Name | Gesture_TC_ID  | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TAP_WF9_TC-41 | Foreground | Allowed    | Never               | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF9_TC-42 | Foreground | Allowed    | Never               | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF9_TC-43 | Foreground | Allowed    | Never               | Foreground | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF9_TC-44 | Foreground | Allowed    | Never               | Background | Unlocked     | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |
      | RevE        | _TAP_WF9_TC-45 | Foreground | Allowed    | Never               | Killed     | Unlocked     | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Tap             | FavR5 |

    @iOS_RevE_TwistGo_WF1 @iOS_RevE_TwistGo @iOS_RevE @DemoIOS @iOS_All   #Commented Killed state TC coz in iOS killing the app not working

    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log      | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF1_TC-01 | Always     | Allowed    | Always              | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF1_TC-02 | Always     | Allowed    | Always              | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF1_TC-03 | Always     | Allowed    | Always              | Foreground | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF1_TC-04 | Always     | Allowed    | Always              | Background | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
#      | RevE        | _TG_WF1_TC-05 | Always     | Allowed    | Always              | Killed     | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |

    @iOS_RevE_TwistGo_WF2 @iOS_RevE_TwistGo @iOS_RevE @iOS_All


    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log      | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF2_TC-06 | Always     | Allowed    | While using the app | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF2_TC-07 | Always     | Allowed    | While using the app | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF2_TC-08 | Always     | Allowed    | While using the app | Foreground | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF2_TC-09 | Always     | Allowed    | While using the app | Background | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF2_TC-10 | Always     | Allowed    | While using the app | Killed     | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |

    @iOS_RevE_TwistGo_WF3 @iOS_RevE_TwistGo @iOS_RevE @iOS_All

    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log      | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF3_TC-11 | Always     | Allowed    | Never               | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF3_TC-12 | Always     | Allowed    | Never               | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF3_TC-13 | Always     | Allowed    | Never               | Foreground | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF3_TC-14 | Always     | Allowed    | Never               | Background | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF3_TC-15 | Always     | Allowed    | Never               | Killed     | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |

    @iOS_RevE_TwistGo_WF4 @iOS_RevE_TwistGo @iOS_RevE @iOS_All   #Currently exculded Locked scenarios, as pattern lock not supporting to Unlock

    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log      | date  | mobile_read    | message                          | arm_action_name | reader_name |
      #| RevE        | _TG_WF4_TC-16 | Unlocked   | Allowed    | Always              | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      #| RevE        | _TG_WF4_TC-17 | Unlocked   | Allowed    | Always              | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF4_TC-18 | Unlocked   | Allowed    | Always              | Foreground | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF4_TC-19 | Unlocked   | Allowed    | Always              | Background | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF4_TC-20 | Unlocked   | Allowed    | Always              | Killed     | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |

    @iOS_RevE_TwistGo_WF5 @iOS_RevE_TwistGo @iOS_RevE @iOS_All  #Currently exculded Locked scenarios, as pattern lock not supporting to Unlock

    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log      | date  | mobile_read    | message                          | arm_action_name | reader_name |
#      | RevE        | _TG_WF5_TC-21 | Unlocked   | Allowed    | While using the app | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
#      | RevE        | _TG_WF5_TC-22 | Unlocked   | Allowed    | While using the app | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF5_TC-23 | Unlocked   | Allowed    | While using the app | Foreground | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF5_TC-24 | Unlocked   | Allowed    | While using the app | Background | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
#      | RevE        | _TG_WF5_TC-25 | Unlocked   | Allowed    | While using the app | Killed     | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |

    @iOS_RevE_TwistGo_WF6 @iOS_RevE_TwistGo @iOS_RevE @iOS_All  #Currently exculded Locked scenarios, as pattern lock not supporting to Unlock

    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log      | date  | mobile_read    | message                          | arm_action_name | reader_name |
#      | RevE        | _TG_WF6_TC-26 | Unlocked   | Allowed    | Never               | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
#      | RevE        | _TG_WF6_TC-27 | Unlocked   | Allowed    | Never               | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF6_TC-28 | Unlocked   | Allowed    | Never               | Foreground | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF6_TC-29 | Unlocked   | Allowed    | Never               | Background | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF6_TC-30 | Unlocked   | Allowed    | Never               | Killed     | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |

    @iOS_RevE_TwistGo_WF7 @iOS_RevE_TwistGo @iOS_RevE @iOS_SmokeRun @iOS_All

    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log      | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF7_TC-31 | Foreground | Allowed    | Always              | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF7_TC-32 | Foreground | Allowed    | Always              | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF7_TC-33 | Foreground | Allowed    | Always              | Foreground | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF7_TC-34 | Foreground | Allowed    | Always              | Background | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF7_TC-35 | Foreground | Allowed    | Always              | Killed     | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |

    @iOS_RevE_TwistGo_WF8 @iOS_RevE_TwistGo @iOS_RevE @iOS_All

    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log      | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF8_TC-36 | Foreground | Allowed    | While using the app | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF8_TC-37 | Foreground | Allowed    | While using the app | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF8_TC-38 | Foreground | Allowed    | While using the app | Foreground | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF8_TC-39 | Foreground | Allowed    | While using the app | Background | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF8_TC-40 | Foreground | Allowed    | While using the app | Killed     | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |

    @iOS_RevE_TwistGo_WF9 @iOS_RevE_TwistGo @iOS_RevE @iOS_All

    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log      | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | RevE        | _TG_WF9_TC-41 | Foreground | Allowed    | Never               | Foreground | Locked       | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF9_TC-42 | Foreground | Allowed    | Never               | Background | Locked       | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF9_TC-43 | Foreground | Allowed    | Never               | Foreground | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO=:ENABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF9_TC-44 | Foreground | Allowed    | Never               | Background | Unlocked     | ON             | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |
      | RevE        | _TG_WF9_TC-45 | Foreground | Allowed    | Never               | Killed     | Unlocked     | OFF            | Twist & Go  | TWIST_AND_GO:DISABLE | TODAY | Mobile ID Read | Successful Bluetooth transaction | Twist & Go      | FavR5 |

    @iOS_Signo_EnhancedTap_WF1 @iOS_Signo_EnhancedTap @iOS_SmokeRun @iOS_All     #Commented Killed state TC coz in iOS killing the app not working

    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | Signo       | _ET_WF1_TC-01 | Always     | Allowed    | Always              | Foreground | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF1_TC-02 | Always     | Allowed    | Always              | Background | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF1_TC-03 | Always     | Allowed    | Always              | Foreground | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF1_TC-04 | Always     | Allowed    | Always              | Background | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      #| Signo       | _ET_WF1_TC-05 | Always     | Allowed    | Always              | Killed     | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |


    @iOS_Signo_EnhancedTap_WF2 @iOS_Signo_EnhancedTap @iOS_All

    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | Signo       | _ET_WF2_TC-06 | Always     | Allowed    | While using the app | Foreground | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF2_TC-07 | Always     | Allowed    | While using the app | Background | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF2_TC-08 | Always     | Allowed    | While using the app | Foreground | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF2_TC-09 | Always     | Allowed    | While using the app | Background | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF2_TC-10 | Always     | Allowed    | While using the app | Killed     | Unlocked     | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |

    @iOS_Signo_EnhancedTap_WF3 @iOS_Signo_EnhancedTap @iOS_All

    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | Signo       | _ET_WF3_TC-11 | Always     | Allowed    | Never               | Foreground | Locked       | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF3_TC-12 | Always     | Allowed    | Never               | Background | Locked       | OFF            | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF3_TC-13 | Always     | Allowed    | Never               | Foreground | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF3_TC-14 | Always     | Allowed    | Never               | Background | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF3_TC-15 | Always     | Allowed    | Never               | Killed     | Unlocked     | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |

    @iOS_Signo_EnhancedTap_WF4 @iOS_Signo_EnhancedTap @iOS_All    #Currently exculded Locked scenarios, as pattern lock not supporting to Unlock - Looking for alternatives

    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      #| Signo       | _ET_WF4_TC-16 | Unlocked   | Allowed    | Always              | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      #| Signo       | _ET_WF4_TC-17 | Unlocked   | Allowed    | Always              | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF4_TC-18 | Unlocked   | Allowed    | Always              | Foreground | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF4_TC-19 | Unlocked   | Allowed    | Always              | Background | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF4_TC-20 | Unlocked   | Allowed    | Always              | Killed     | Unlocked     | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |

    @iOS_Signo_EnhancedTap_WF5 @iOS_Signo_EnhancedTap @iOS_All    #Currently exculded Locked scenarios, as pattern lock not supporting to Unlock

    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      #| Signo       | _ET_WF5_TC-21 | Unlocked   | Allowed    | While using the app | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      #| Signo       | _ET_WF5_TC-22 | Unlocked   | Allowed    | While using the app | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF5_TC-23 | Unlocked   | Allowed    | While using the app | Foreground | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF5_TC-24 | Unlocked   | Allowed    | While using the app | Background | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      #| Signo       | _ET_WF5_TC-25 | Unlocked   | Allowed    | While using the app | Killed     | Unlocked     | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |

    @iOS_Signo_EnhancedTap_WF6 @iOS_Signo_EnhancedTap @iOS_SmokeRun @iOS_All   #Currently exculded Locked scenarios, as pattern lock not supporting to Unlock

    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      #| Signo       | _ET_WF6_TC-26 | Unlocked   | Allowed    | Never               | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      #| Signo       | _ET_WF6_TC-27 | Unlocked   | Allowed    | Never               | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF6_TC-28 | Unlocked   | Allowed    | Never               | Foreground | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF6_TC-29 | Unlocked   | Allowed    | Never               | Background | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF6_TC-30 | Unlocked   | Allowed    | Never               | Killed     | Unlocked     | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |

    @iOS_Signo_EnhancedTap_WF7 @iOS_Signo_EnhancedTap @iOS_All

    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | Signo       | _ET_WF7_TC-31 | Foreground | Allowed    | Always              | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF7_TC-32 | Foreground | Allowed    | Always              | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF7_TC-33 | Foreground | Allowed    | Always              | Foreground | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF7_TC-34 | Foreground | Allowed    | Always              | Background | Unlocked     | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF7_TC-35 | Foreground | Allowed    | Always              | Killed     | Unlocked     | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |

    @iOS_Signo_EnhancedTap_WF8 @iOS_Signo_EnhancedTap @iOS_All

    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | Signo       | _ET_WF8_TC-36 | Foreground | Allowed    | While using the app | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF8_TC-37 | Foreground | Allowed    | While using the app | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF8_TC-38 | Foreground | Allowed    | While using the app | Foreground | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF8_TC-39 | Foreground | Allowed    | While using the app | Background | Unlocked     | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF8_TC-40 | Foreground | Allowed    | While using the app | Killed     | Unlocked     | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |

    @iOS_Signo_EnhancedTap_WF9 @iOS_Signo_EnhancedTap @iOS_All

    Examples:
      | Reader_Name | Gesture_TC_ID | mode_state | BLE_status | location_permission | app_state  | device_state | display_status | action_name | robotic_arm_log | date  | mobile_read    | message                          | arm_action_name | reader_name |
      | Signo       | _ET_WF9_TC-41 | Foreground | Allowed    | Never               | Foreground | Locked       | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF9_TC-42 | Foreground | Allowed    | Never               | Background | Locked       | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF9_TC-43 | Foreground | Allowed    | Never               | Foreground | Unlocked     | ON             | TAP         | TAP:ENABLE      | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF9_TC-44 | Foreground | Allowed    | Never               | Background | Unlocked     | ON             | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
      | Signo       | _ET_WF9_TC-45 | Foreground | Allowed    | Never               | Killed     | Unlocked     | OFF            | TAP         | TAP:DISABLE     | TODAY | Mobile ID Read | Successful Bluetooth transaction | Enhanced Tap    | FavR5     |
