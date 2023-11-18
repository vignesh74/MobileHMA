Feature: To Test Android Unlock workflow for HID mobile access application

  Background:To launch the HID app and navigate to Mobile ID Screen
    Given Launch HID Access Mobile Application in android device
#    When  Swipe EULA screen to left in android device
#    And   Get Invitation Code using Rest API when credential are assigned
#    And   Enter invitation code on HID mobile Application in android device
#    Then  Mobile IDs screen is displayed in android device
#    And   Notification screen is displayed with message "New Mobile ID Issued" in android device

  Scenario Outline:ANDR_12_<Reader_Name><Gesture_TC_ID>: Verify Robotic Arm Action and logs when BLE is <BLE_status>, NFC is <NFC_status>, Nearby is <NearByOrLocation_permission>, Location is <location_status>, App State set is <app_state>, device state is <device_state> and display status is <display_status>
    When  Navigate to Settings and App Preferences screen in android device
    And   Set BLE status as "<BLE_status>" in android device
    And   Set NFC status as "<NFC_status>" in android device
    And   Set "NearBy" permission status as "<NearByOrLocation_permission>" in android device
    And   Select the usage state as "<usage_state>" in android device
    And   Set Application status as "<app_state>" in android device
    And   Set device state as "<device_state>" in android device.
#    And   Set display screen as "<display_status>" in android device
    And   Perform robotic arm action as "<action_name>" for android device
#    And   Set device state as "Forced Unlock" in android device "<device_state>"
#    And   Set Application status as "Foreground" in android device
#    Then  Robotic arms log "<robotic_arm_log>" is displayed for android device
#    And   Activity log is displayed in android device and "<date>", "<message>" are verified

    @Android12_RevE_Tap_WF_1 @Android12_RevE_Tap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF1_TC-01 | Always      | On         | Off        | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF1_TC-02 | Always      | On         | Off        | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF1_TC-03 | Always      | On         | Off        | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF1_TC-04 | Always      | On         | Off        | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android12_RevE_Tap_WF_2 @Android12_RevE_Tap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF2_TC-05 | Always      | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF2_TC-06 | Always      | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF2_TC-07 | Always      | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF2_TC-08 | Always      | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android12_RevE_Tap_WF_3 @Android12_RevE_Tap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF3_TC-09 | Unlocked    | On         | Off        | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF3_TC-10 | Unlocked    | On         | Off        | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF3_TC-11 | Unlocked    | On         | Off        | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF3_TC-12 | Unlocked    | On         | Off        | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android12_RevE_Tap_WF_4 @Android12_RevE_Tap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF4_TC-13 | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF4_TC-14 | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF4_TC-15 | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF4_TC-16 | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android12_RevE_Tap_WF_5 @Android12_RevE_Tap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF5_TC-17 | Foreground  | On         | Off        | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF5_TC-18 | Foreground  | On         | Off        | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF5_TC-19 | Foreground  | On         | Off        | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF5_TC-20 | Foreground  | On         | Off        | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android12_RevE_Tap_WF_6 @Android12_RevE_Tap @Android12_RevE @Android12_RevE_TapRun

    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF6_TC-21 | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF6_TC-22 | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF6_TC-23 | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF6_TC-24 | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android12_RevE_Tap_WF_7 @Android12_RevE_Tap @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF7_TC-25 | Always      | On         | On         | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF7_TC-26 | Always      | On         | On         | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF7_TC-27 | Always      | On         | On         | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF7_TC-28 | Always      | On         | On         | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android12_RevE_Tap_WF_8 @Android12_RevE_Tap @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | device_state | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF8_TC-29 | Always      | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | Unlocked     | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF8_TC-30 | Always      | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | Unlocked     | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF8_TC-31 | Always      | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | Unlocked     | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF8_TC-32 | Always      | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | Unlocked     | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android12_RevE_Tap_WF_9 @Android12_RevE_Tap @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF9_TC-33 | Unlocked    | On         | On         | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF9_TC-34 | Unlocked    | On         | On         | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF9_TC-35 | Unlocked    | On         | On         | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF9_TC-36 | Unlocked    | On         | On         | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android12_RevE_Tap_WF_10 @Android12_RevE_Tap @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID   | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF10_TC-37 | Unlocked    | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF10_TC-38 | Unlocked    | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF10_TC-39 | Unlocked    | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF10_TC-40 | Unlocked    | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android12_RevE_Tap_WF_11 @Android12_RevE_Tap @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID   | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF11_TC-41 | Foreground  | On         | On         | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF11_TC-42 | Foreground  | On         | On         | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF11_TC-43 | Foreground  | On         | On         | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF11_TC-44 | Foreground  | On         | On         | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android12_RevE_Tap_WF_12 @Android12_RevE_Tap @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID   | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF12_TC-45 | Foreground  | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF12_TC-46 | Foreground  | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF12_TC-47 | Foreground  | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF12_TC-48 | Foreground  | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android12_RevE_Tap_WF_13 @Android12_RevE_Tap @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID   | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF13_TC-49 | Always      | Off        | On         | Don't allow                 | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF13_TC-50 | Always      | Off        | On         | Don't allow                 | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF13_TC-51 | Always      | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF13_TC-52 | Always      | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android12_RevE_Tap_WF_14 @Android12_RevE_Tap @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID   | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF14_TC-53 | Unlocked    | Off        | On         | Don't allow                 | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF14_TC-54 | Unlocked    | Off        | On         | Don't allow                 | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF14_TC-55 | Unlocked    | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF14_TC-56 | Unlocked    | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE     | Mobile ID Read | Seos        |

    @Android12_RevE_Tap_WF_15 @Android12_RevE_Tap @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID   | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF15_TC-57 | Foreground  | Off        | On         | Don't allow                 | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF15_TC-58 | Foreground  | Off        | On         | Don't allow                 | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF15_TC-59 | Foreground  | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF15_TC-60 | Foreground  | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android12_RevE_TwistGo_WF_1 @Android12_RevE_TwistGo @Android12_RevE @Android12_RevE_TwistGo
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF1_TC-01 | Always      | On         | Off        | Allow                       | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
#      | RevE        | _TG_WF1_TC-02 | Always      | On         | Off        | Allow                       | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
#      | RevE        | _TG_WF1_TC-03 | Always      | On         | Off        | Allow                       | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
#      | RevE        | _TG_WF1_TC-04 | Always      | On         | Off        | Allow                       | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |

    @Android12_RevE_TwistGo_WF_2 @Android12_RevE_TwistGo @Android12_RevE @Android12_RevE_TwistGo
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF2_TC-05 | Always      | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF2_TC-06 | Always      | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF2_TC-07 | Always      | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF2_TC-08 | Always      | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android12_RevE_TwistGo_WF_3 @Android12_RevE_TwistGo @Android12_RevE @Android12_RevE_TwistGo
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF3_TC-09 | Unlocked    | On         | Off        | Allow                       | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF3_TC-10 | Unlocked    | On         | Off        | Allow                       | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF3_TC-11 | Unlocked    | On         | Off        | Allow                       | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF3_TC-12 | Unlocked    | On         | Off        | Allow                       | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |

    @Android12_RevE_TwistGo_WF_4 @Android12_RevE_TwistGo @Android12_RevE @Android12_RevE_TwistGo
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF4_TC-13 | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF4_TC-14 | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF4_TC-15 | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF4_TC-16 | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android12_RevE_TwistGo_WF_5 @Android12_RevE_TwistGo @Android12_RevE @Android12_RevE_TwistGo
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF5_TC-17 | Foreground  | On         | Off        | Allow                       | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF5_TC-18 | Foreground  | On         | Off        | Allow                       | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF5_TC-19 | Foreground  | On         | Off        | Allow                       | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF5_TC-20 | Foreground  | On         | Off        | Allow                       | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android12_RevE_TwistGo_WF_6 @Android12_RevE_TwistGo @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF6_TC-21 | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF6_TC-22 | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF6_TC-23 | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF6_TC-24 | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android12_RevE_TwistGo_WF_7 @Android12_RevE_TwistGo @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF7_TC-25 | Always      | On         | On         | Allow                       | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF7_TC-26 | Always      | On         | On         | Allow                       | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF7_TC-27 | Always      | On         | On         | Allow                       | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF7_TC-28 | Always      | On         | On         | Allow                       | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |

    @Android12_RevE_TwistGo_WF_8 @Android12_RevE_TwistGo @Android12_RevE

    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF8_TC-29 | Always      | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF8_TC-30 | Always      | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF8_TC-31 | Always      | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF8_TC-32 | Always      | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |

    @Android12_RevE_TwistGo_WF_9 @Android12_RevE_TwistGo @Android12_RevE @ANDR_SmokeRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF9_TC-33 | Unlocked    | On         | On         | Allow                       | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF9_TC-34 | Unlocked    | On         | On         | Allow                       | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF9_TC-35 | Unlocked    | On         | On         | Allow                       | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF9_TC-36 | Unlocked    | On         | On         | Allow                       | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |

    @Android12_RevE_TwistGo_WF_10 @Android12_RevE_TwistGo @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF10_TC-37 | Unlocked    | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF10_TC-38 | Unlocked    | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF10_TC-39 | Unlocked    | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF10_TC-40 | Unlocked    | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |

    @Android12_RevE_TwistGo_WF_11 @Android12_RevE_TwistGo @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF11_TC-41 | Foreground  | On         | On         | Allow                       | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF11_TC-42 | Foreground  | On         | On         | Allow                       | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF11_TC-43 | Foreground  | On         | On         | Allow                       | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF11_TC-44 | Foreground  | On         | On         | Allow                       | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android12_RevE_TwistGo_WF_12 @Android12_RevE_TwistGo @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF12_TC-45 | Foreground  | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF12_TC-46 | Foreground  | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF12_TC-47 | Foreground  | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF12_TC-48 | Foreground  | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android12_Signo_EnhancedTap_WF_1   @Android12_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF1_TC-01 | Always      | On         | Off        | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF1_TC-02 | Always      | On         | Off        | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF1_TC-03 | Always      | On         | Off        | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF1_TC-04 | Always      | On         | Off        | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android12_Signo_EnhancedTap_WF_2   @Android12_Signo_EnhancedTap

    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF2_TC-05 | Always      | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF2_TC-06 | Always      | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF2_TC-07 | Always      | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF2_TC-08 | Always      | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android12_Signo_EnhancedTap_WF_3   @Android12_Signo_EnhancedTap @ANDR_SmokeRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF3_TC-09 | Unlocked    | On         | Off        | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF3_TC-10 | Unlocked    | On         | Off        | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF3_TC-11 | Unlocked    | On         | Off        | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF3_TC-12 | Unlocked    | On         | Off        | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android12_Signo_EnhancedTap_WF_4   @Android12_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF4_TC-13 | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF4_TC-14 | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF4_TC-15 | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF4_TC-16 | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android12_Signo_EnhancedTap_WF_5   @Android12_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF5_TC-17 | Foreground  | On         | Off        | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF5_TC-18 | Foreground  | On         | Off        | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF5_TC-19 | Foreground  | On         | Off        | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF5_TC-20 | Foreground  | On         | Off        | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android12_Signo_EnhancedTap_WF_6   @Android12_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF6_TC-21 | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF6_TC-22 | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF6_TC-23 | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF6_TC-24 | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android12_Signo_EnhancedTap_WF_7   @Android12_Signo_EnhancedTap @ANDR_SmokeRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF7_TC-25 | Always      | On         | On         | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF7_TC-26 | Always      | On         | On         | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF7_TC-27 | Always      | On         | On         | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF7_TC-28 | Always      | On         | On         | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android12_Signo_EnhancedTap_WF_8   @Android12_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF8_TC-29 | Always      | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF8_TC-30 | Always      | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF8_TC-31 | Always      | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF8_TC-32 | Always      | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android12_Signo_EnhancedTap_WF_9   @Android12_Signo_EnhancedTap

    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF9_TC-33 | Unlocked    | On         | On         | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF9_TC-34 | Unlocked    | On         | On         | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF9_TC-35 | Unlocked    | On         | On         | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF9_TC-36 | Unlocked    | On         | On         | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android12_Signo_EnhancedTap_WF_10   @Android12_Signo_EnhancedTap

    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF10_TC-37 | Unlocked    | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF10_TC-38 | Unlocked    | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF10_TC-39 | Unlocked    | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF10_TC-40 | Unlocked    | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android12_Signo_EnhancedTap_WF_11   @Android12_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF11_TC-41 | Foreground  | On         | On         | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF11_TC-42 | Foreground  | On         | On         | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF11_TC-43 | Foreground  | On         | On         | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF11_TC-44 | Foreground  | On         | On         | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android12_Signo_EnhancedTap_WF_12   @Android12_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF12_TC-45 | Foreground  | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF12_TC-46 | Foreground  | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF12_TC-47 | Foreground  | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF12_TC-48 | Foreground  | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android12_Signo_EnhancedTap_WF_13   @Android12_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF13_TC-49 | Always      | Off        | On         | Don't allow                 | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF13_TC-50 | Always      | Off        | On         | Don't allow                 | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF13_TC-51 | Always      | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF13_TC-52 | Always      | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android12_Signo_EnhancedTap_WF_14   @Android12_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF14_TC-53 | Unlocked    | Off        | On         | Don't allow                 | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF14_TC-54 | Unlocked    | Off        | On         | Don't allow                 | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF14_TC-55 | Unlocked    | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF14_TC-56 | Unlocked    | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android12_Signo_EnhancedTap_WF_15   @Android12_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF15_TC-57 | Foreground  | Off        | On         | Don't allow                 | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF15_TC-58 | Foreground  | Off        | On         | Don't allow                 | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF15_TC-59 | Foreground  | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF15_TC-60 | Foreground  | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

  Scenario Outline:ANDR_11_10_<Reader_Name><Gesture_TC_ID>: Verify Robotic Arm Action and logs when BLE is <BLE_status>, NFC is <NFC_status>, Nearby is <NearByOrLocation_permission>, Location is <location_status>, App State set is <app_state>, device state is <device_state> and display status is <display_status>
    When  Navigate to Settings and App Preferences screen in android device
    And   Set BLE status as "<BLE_status>" in android device
    And   Set NFC status as "<NFC_status>" in android device
    And   Set "Location" permission status as "<NearByOrLocation_permission>" in android device
    And   Set location as "<location_status>" in android device
    And   Select the usage state as "<usage_state>" in android device
    And   Set Application status as "<app_state>" in android device
    And   Set device state as "<device_state>" in android device.
    And   Set display screen as "<display_status>" in android device
#    And   Perform robotic arm action as "<action_name>" for android device
    And   Set device state as "ForcedUnlock" in android device.
    And   Set Application status as "Foreground" in android device
#    Then  Robotic arms log "<robotic_arm_log>" is displayed for android device
#    And   Activity log is displayed in android device and "<date>", "<message>" are verified
#    Then  Activity log is displayed in android device and "<date>", "<mobile_read>", "<message>", "<action_name>", "<reader_name>" are verified in android device


    @Android11_10_RevE_Tap_WF_1 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF1_TC-01 | Always      | On         | Off        | Allow all the time          | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF1_TC-02 | Always      | On         | Off        | Allow all the time          | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF1_TC-03 | Always      | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF1_TC-04 | Always      | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android11_10_RevE_Tap_WF_2 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF2_TC-05 | Always      | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF2_TC-06 | Always      | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF2_TC-07 | Always      | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF2_TC-08 | Always      | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android11_10_RevE_Tap_WF_3 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF3_TC-09 | Unlocked    | On         | Off        | Allow all the time          | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF3_TC-10 | Unlocked    | On         | Off        | Allow all the time          | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF3_TC-11 | Unlocked    | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF3_TC-12 | Unlocked    | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android11_10_RevE_Tap_WF_4 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF4_TC-13 | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF4_TC-14 | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF4_TC-15 | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF4_TC-16 | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android11_10_RevE_Tap_WF_5 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF5_TC-17 | Foreground  | On         | Off        | Allow all the time          | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF5_TC-18 | Foreground  | On         | Off        | Allow all the time          | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF5_TC-19 | Foreground  | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF5_TC-20 | Foreground  | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android11_10_RevE_Tap_WF_6 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF6_TC-21 | Foreground  | On         | Off        | Allow only while using the app | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF6_TC-22 | Foreground  | On         | Off        | Allow only while using the app | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF6_TC-23 | Foreground  | On         | Off        | Allow only while using the app | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF6_TC-24 | Foreground  | On         | Off        | Allow only while using the app | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android11_10_RevE_Tap_WF_7 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF7_TC-25 | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF7_TC-26 | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF7_TC-27 | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF7_TC-28 | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android11_10_RevE_Tap_WF_8 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF8_TC-29 | Always      | On         | On         | Allow all the time          | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF8_TC-30 | Always      | On         | On         | Allow all the time          | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF8_TC-31 | Always      | On         | On         | Allow all the time          | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF8_TC-32 | Always      | On         | On         | Allow all the time          | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android11_10_RevE_Tap_WF_9 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF9_TC-33 | Always      | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF9_TC-34 | Always      | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF9_TC-35 | Always      | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF9_TC-36 | Always      | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android11_10_RevE_Tap_WF_10 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID   | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF10_TC-37 | Unlocked    | On         | On         | Allow all the time          | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF10_TC-38 | Unlocked    | On         | On         | Allow all the time          | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF10_TC-39 | Unlocked    | On         | On         | Allow all the time          | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF10_TC-40 | Unlocked    | On         | On         | Allow all the time          | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android11_10_RevE_Tap_WF_11 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID   | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF11_TC-41 | Unlocked    | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF11_TC-42 | Unlocked    | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF11_TC-43 | Unlocked    | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF11_TC-44 | Unlocked    | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android11_10_RevE_Tap_WF_12 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID   | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF12_TC-45 | Foreground  | On         | On         | Allow all the time          | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF12_TC-46 | Foreground  | On         | On         | Allow all the time          | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF12_TC-47 | Foreground  | On         | On         | Allow all the time          | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF12_TC-48 | Foreground  | On         | On         | Allow all the time          | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android11_10_RevE_Tap_WF_13 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID   | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF13_TC-49 | Foreground  | On         | On         | Allow only while using the app | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF13_TC-50 | Foreground  | On         | On         | Allow only while using the app | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF13_TC-51 | Foreground  | On         | On         | Allow only while using the app | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF13_TC-52 | Foreground  | On         | On         | Allow only while using the app | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android11_10_RevE_Tap_WF_14 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID   | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF14_TC-53 | Foreground  | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF14_TC-54 | Foreground  | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF14_TC-55 | Foreground  | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF14_TC-56 | Foreground  | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android11_10_RevE_Tap_WF_15 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID   | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF15_TC-57 | Always      | Off        | On         | Don't allow                 | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF15_TC-58 | Always      | Off        | On         | Don't allow                 | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF15_TC-59 | Always      | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF15_TC-60 | Always      | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android11_10_RevE_Tap_WF_16 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID   | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF16_TC-61 | Unlocked    | Off        | On         | Don't allow                 | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF16_TC-62 | Unlocked    | Off        | On         | Don't allow                 | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF16_TC-63 | Unlocked    | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF16_TC-64 | Unlocked    | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android11_10_RevE_Tap_WF_17 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID   | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF17_TC-65 | Foreground  | Off        | On         | Don't allow                 | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF17_TC-66 | Foreground  | Off        | On         | Don't allow                 | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF17_TC-67 | Foreground  | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF17_TC-68 | Foreground  | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android11_10_RevE_TwistGo_WF_1 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF1_TC-01 | Always      | On         | Off        | Allow all the time          | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF1_TC-02 | Always      | On         | Off        | Allow all the time          | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF1_TC-03 | Always      | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF1_TC-04 | Always      | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |

    @Android11_10_RevE_TwistGo_WF_2 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF2_TC-05 | Always      | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF2_TC-06 | Always      | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF2_TC-07 | Always      | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF2_TC-08 | Always      | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android11_10_RevE_TwistGo_WF_3 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF3_TC-09 | Unlocked    | On         | Off        | Allow all the time          | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF3_TC-10 | Unlocked    | On         | Off        | Allow all the time          | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF3_TC-11 | Unlocked    | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF3_TC-12 | Unlocked    | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |

    @Android11_10_RevE_TwistGo_WF_4 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF4_TC-13 | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF4_TC-14 | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF4_TC-15 | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF4_TC-16 | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android11_10_RevE_TwistGo_WF_5 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF5_TC-17 | Foreground  | On         | Off        | Allow all the time          | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF5_TC-18 | Foreground  | On         | Off        | Allow all the time          | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF5_TC-19 | Foreground  | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF5_TC-20 | Foreground  | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android11_10_RevE_TwistGo_WF_6 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF6_TC-21 | Foreground  | On         | Off        | Allow only while using the app | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF6_TC-22 | Foreground  | On         | Off        | Allow only while using the app | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF6_TC-23 | Foreground  | On         | Off        | Allow only while using the app | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF6_TC-24 | Foreground  | On         | Off        | Allow only while using the app | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android11_10_RevE_TwistGo_WF_7 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF7_TC-25 | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF7_TC-26 | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF7_TC-27 | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF7_TC-28 | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android11_10_RevE_TwistGo_WF_8 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF8_TC-29 | Always      | On         | On         | Allow all the time          | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF8_TC-30 | Always      | On         | On         | Allow all the time          | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF8_TC-31 | Always      | On         | On         | Allow all the time          | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF8_TC-32 | Always      | On         | On         | Allow all the time          | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |

    @Android11_10_RevE_TwistGo_WF_9 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF9_TC-33 | Always      | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF9_TC-34 | Always      | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF9_TC-35 | Always      | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF9_TC-36 | Always      | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android11_10_RevE_TwistGo_WF_10 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF10_TC-37 | Unlocked    | On         | On         | Allow all the time          | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF10_TC-38 | Unlocked    | On         | On         | Allow all the time          | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF10_TC-39 | Unlocked    | On         | On         | Allow all the time          | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF10_TC-40 | Unlocked    | On         | On         | Allow all the time          | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |

    @Android11_10_RevE_TwistGo_WF_11 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF11_TC-41 | Unlocked    | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF11_TC-42 | Unlocked    | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF11_TC-43 | Unlocked    | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF11_TC-44 | Unlocked    | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android11_10_RevE_TwistGo_WF_12 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF12_TC-45 | Foreground  | On         | On         | Allow all the time          | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF12_TC-46 | Foreground  | On         | On         | Allow all the time          | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF12_TC-47 | Foreground  | On         | On         | Allow all the time          | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF12_TC-48 | Foreground  | On         | On         | Allow all the time          | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android11_10_RevE_TwistGo_WF_13 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF13_TC-49 | Foreground  | On         | On         | Allow only while using the app | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF13_TC-50 | Foreground  | On         | On         | Allow only while using the app | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF13_TC-51 | Foreground  | On         | On         | Allow only while using the app | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF13_TC-52 | Foreground  | On         | On         | Allow only while using the app | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android11_10_RevE_TwistGo_WF_14 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF14_TC-53 | Foreground  | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF14_TC-54 | Foreground  | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF14_TC-55 | Foreground  | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF14_TC-56 | Foreground  | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android11_10_Signo_EnhancedTap_WF_1 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF1_TC-01 | Always      | On         | Off        | Allow all the time          | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF1_TC-02 | Always      | On         | Off        | Allow all the time          | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF1_TC-03 | Always      | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF1_TC-04 | Always      | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android11_10_Signo_EnhancedTap_WF_2 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF2_TC-05 | Always      | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF2_TC-06 | Always      | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF2_TC-07 | Always      | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF2_TC-08 | Always      | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android11_10_Signo_EnhancedTap_WF_3 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF3_TC-09 | Unlocked    | On         | Off        | Allow all the time          | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF3_TC-10 | Unlocked    | On         | Off        | Allow all the time          | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF3_TC-11 | Unlocked    | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF3_TC-12 | Unlocked    | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android11_10_Signo_EnhancedTap_WF_4 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF4_TC-13 | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF4_TC-14 | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF4_TC-15 | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF4_TC-16 | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android11_10_Signo_EnhancedTap_WF_5 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF5_TC-17 | Foreground  | On         | Off        | Allow all the time          | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF5_TC-18 | Foreground  | On         | Off        | Allow all the time          | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF5_TC-19 | Foreground  | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF5_TC-20 | Foreground  | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android11_10_Signo_EnhancedTap_WF_6 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF6_TC-21 | Foreground  | On         | Off        | Allow only while using the app | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF6_TC-22 | Foreground  | On         | Off        | Allow only while using the app | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF6_TC-23 | Foreground  | On         | Off        | Allow only while using the app | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF6_TC-24 | Foreground  | On         | Off        | Allow only while using the app | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android11_10_Signo_EnhancedTap_WF_7 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF7_TC-25 | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF7_TC-26 | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF7_TC-27 | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF7_TC-28 | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android11_10_Signo_EnhancedTap_WF_8 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF8_TC-29 | Always      | On         | On         | Allow all the time          | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF8_TC-30 | Always      | On         | On         | Allow all the time          | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF8_TC-31 | Always      | On         | On         | Allow all the time          | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF8_TC-32 | Always      | On         | On         | Allow all the time          | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android11_10_Signo_EnhancedTap_WF_9 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF9_TC-33 | Always      | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF9_TC-34 | Always      | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF9_TC-35 | Always      | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF9_TC-36 | Always      | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android11_10_Signo_EnhancedTap_WF_10 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF10_TC-37 | Unlocked    | On         | On         | Allow all the time          | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF10_TC-38 | Unlocked    | On         | On         | Allow all the time          | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF10_TC-39 | Unlocked    | On         | On         | Allow all the time          | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF10_TC-40 | Unlocked    | On         | On         | Allow all the time          | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android11_10_Signo_EnhancedTap_WF_11 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF11_TC-41 | Unlocked    | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF11_TC-42 | Unlocked    | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF11_TC-43 | Unlocked    | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF11_TC-44 | Unlocked    | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android11_10_Signo_EnhancedTap_WF_12 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF12_TC-45 | Foreground  | On         | On         | Allow all the time          | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF12_TC-46 | Foreground  | On         | On         | Allow all the time          | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF12_TC-47 | Foreground  | On         | On         | Allow all the time          | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF12_TC-48 | Foreground  | On         | On         | Allow all the time          | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android11_10_Signo_EnhancedTap_WF_13 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF13_TC-49 | Foreground  | On         | On         | Allow only while using the app | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF13_TC-50 | Foreground  | On         | On         | Allow only while using the app | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF13_TC-51 | Foreground  | On         | On         | Allow only while using the app | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF13_TC-52 | Foreground  | On         | On         | Allow only while using the app | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android11_10_Signo_EnhancedTap_WF_14 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF14_TC-53 | Foreground  | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF14_TC-54 | Foreground  | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF14_TC-55 | Foreground  | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF14_TC-56 | Foreground  | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android11_10_Signo_EnhancedTap_WF_15 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF15_TC-57 | Always      | Off        | On         | Don't allow                 | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF15_TC-58 | Always      | Off        | On         | Don't allow                 | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF15_TC-59 | Always      | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF15_TC-60 | Always      | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android11_10_Signo_EnhancedTap_WF_16 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF16_TC-61 | Unlocked    | Off        | On         | Don't allow                 | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF16_TC-62 | Unlocked    | Off        | On         | Don't allow                 | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF16_TC-63 | Unlocked    | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF16_TC-64 | Unlocked    | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android11_10_Signo_EnhancedTap_WF_17 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF17_TC-65 | Foreground  | Off        | On         | Don't allow                 | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF17_TC-66 | Foreground  | Off        | On         | Don't allow                 | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF17_TC-67 | Foreground  | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF17_TC-68 | Foreground  | Off        | On         | Don't allow                 | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

#unlock scenario of the version 7 8 9
  Scenario Outline:ANDR_9_8_7_<Reader_Name><Gesture_TC_ID>: Verify Robotic Arm Action and logs when BLE is <BLE_status>, NFC is <NFC_status>, Nearby is <NearByOrLocation_permission>, Location is <location_status>, App State set is <app_state>, device state is <device_state> and display status is <display_status>
    When  Navigate to Settings and App Preferences screen in android device
    And   Set BLE status as "<BLE_status>" in android device
    And   Set NFC status as "<NFC_status>" in android device
    And   Set "Location" permission status as "<NearByOrLocation_permission>" in android device
    And   Set location as "<location_status>" in android device
    And   Select the usage state as "<usage_state>" in android device
    And   Set Application status as "<app_state>" in android device
    And   Set display screen as "<display_status>" in android device
    And   Set device state as "<device_state>" in android device.
    And   Perform robotic arm action as "<action_name>" for android device
    And   Set device state as "ForcedUnlock" in android device.
    And   Set Application status as "Foreground" in android device
    Then  Robotic arms log "<robotic_arm_log>" is displayed for android device
    And   Activity log is displayed in android device and "<date>", "<message>" are verified

    @Android9_8_7_RevE_Tap_WF_1 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF1_TC-01 | Always      | On         | Off        | Always                      | On              | Locked       | ON             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF1_TC-02 | Always      | On         | Off        | Always                      | On              | Locked       | OFF            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF1_TC-03 | Always      | On         | Off        | Always                      | On              | Unlocked     | ON             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF1_TC-04 | Always      | On         | Off        | Always                      | On              | Unlocked     | ON             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_Tap_WF_2 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF2_TC-05 | Always      | On         | Off        | Always                      | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF2_TC-06 | Always      | On         | Off        | Always                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF2_TC-07 | Always      | On         | Off        | Always                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF2_TC-08 | Always      | On         | Off        | Always                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_Tap_WF_3 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF3_TC-09 | Unlocked    | On         | Off        | Always                      | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF3_TC-10 | Unlocked    | On         | Off        | Always                      | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF3_TC-11 | Unlocked    | On         | Off        | Always                      | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF3_TC-12 | Unlocked    | On         | Off        | Always                      | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_Tap_WF_4 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF4_TC-13 | Unlocked    | On         | Off        | Always                      | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF4_TC-14 | Unlocked    | On         | Off        | Always                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF4_TC-15 | Unlocked    | On         | Off        | Always                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF4_TC-16 | Unlocked    | On         | Off        | Always                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_Tap_WF_5 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF5_TC-17 | Foreground  | On         | Off        | Always                      | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF5_TC-18 | Foreground  | On         | Off        | Always                      | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF5_TC-19 | Foreground  | On         | Off        | Always                      | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF5_TC-20 | Foreground  | On         | Off        | Always                      | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_Tap_WF_6 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF6_TC-21 | Foreground  | On         | Off        | Always                      | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF6_TC-22 | Foreground  | On         | Off        | Always                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF6_TC-23 | Foreground  | On         | Off        | Always                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF6_TC-24 | Foreground  | On         | Off        | Always                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_Tap_WF_7 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF7_TC-25 | Always      | On         | On         | Always                      | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF7_TC-26 | Always      | On         | On         | Always                      | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF7_TC-27 | Always      | On         | On         | Always                      | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF7_TC-28 | Always      | On         | On         | Always                      | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_Tap_WF_8 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF8_TC-29 | Always      | On         | On         | Always                      | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF8_TC-30 | Always      | On         | On         | Always                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF8_TC-31 | Always      | On         | On         | Always                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF8_TC-32 | Always      | On         | On         | Always                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_Tap_WF_9 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF9_TC-33 | Unlocked    | On         | On         | Always                      | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF9_TC-34 | Unlocked    | On         | On         | Always                      | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF9_TC-35 | Unlocked    | On         | On         | Always                      | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF9_TC-36 | Unlocked    | On         | On         | Always                      | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_Tap_WF_10 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID   | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF10_TC-37 | Unlocked    | On         | On         | Always                      | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF10_TC-38 | Unlocked    | On         | On         | Always                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF10_TC-39 | Unlocked    | On         | On         | Always                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF10_TC-40 | Unlocked    | On         | On         | Always                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_Tap_WF_11 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID   | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF11_TC-41 | Foreground  | On         | On         | Always                      | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF11_TC-42 | Foreground  | On         | On         | Always                      | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF11_TC-43 | Foreground  | On         | On         | Always                      | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF11_TC-44 | Foreground  | On         | On         | Always                      | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_Tap_WF_12 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID   | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF12_TC-45 | Foreground  | On         | On         | Always                      | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF12_TC-46 | Foreground  | On         | On         | Always                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF12_TC-47 | Foreground  | On         | On         | Always                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF12_TC-48 | Foreground  | On         | On         | Always                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_Tap_WF_13 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID   | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF13_TC-49 | Always      | Off        | On         | Denied                      | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF13_TC-50 | Always      | Off        | On         | Denied                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF13_TC-51 | Always      | Off        | On         | Denied                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF13_TC-52 | Always      | Off        | On         | Denied                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_Tap_WF_14 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID   | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF14_TC-53 | Unlocked    | Off        | On         | Denied                      | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF14_TC-54 | Unlocked    | Off        | On         | Denied                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF14_TC-55 | Unlocked    | Off        | On         | Denied                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF14_TC-56 | Unlocked    | Off        | On         | Denied                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_Tap_WF_15 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID   | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _Tap_WF15_TC-57 | Foreground  | Off        | On         | Denied                      | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF15_TC-58 | Foreground  | Off        | On         | Denied                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF15_TC-59 | Foreground  | Off        | On         | Denied                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | RevE        | _Tap_WF15_TC-60 | Foreground  | Off        | On         | Denied                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
#Twist and Go flow
    @Android9_8_7_RevE_TwistGo_WF_1 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF1_TC-01 | Always      | On         | Off        | Always                      | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF1_TC-02 | Always      | On         | Off        | Always                      | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF1_TC-03 | Always      | On         | Off        | Always                      | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF1_TC-04 | Always      | On         | Off        | Always                      | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_TwistGo_WF_2 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF2_TC-05 | Always      | On         | Off        | Always                      | Off             | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF2_TC-06 | Always      | On         | Off        | Always                      | Off             | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF2_TC-07 | Always      | On         | Off        | Always                      | Off             | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF2_TC-08 | Always      | On         | Off        | Always                      | Off             | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_TwistGo_WF_3 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF3_TC-09 | Unlocked    | On         | Off        | Always                      | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF3_TC-10 | Unlocked    | On         | Off        | Always                      | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF3_TC-11 | Unlocked    | On         | Off        | Always                      | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF3_TC-12 | Unlocked    | On         | Off        | Always                      | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_TwistGo_WF_4 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF4_TC-13 | Unlocked    | On         | Off        | Always                      | Off             | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF4_TC-14 | Unlocked    | On         | Off        | Always                      | Off             | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF4_TC-15 | Unlocked    | On         | Off        | Always                      | Off             | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF4_TC-16 | Unlocked    | On         | Off        | Always                      | Off             | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_TwistGo_WF_5 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF5_TC-17 | Foreground  | On         | Off        | Always                      | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF5_TC-18 | Foreground  | On         | Off        | Always                      | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF5_TC-19 | Foreground  | On         | Off        | Always                      | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF5_TC-20 | Foreground  | On         | Off        | Always                      | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_TwistGo_WF_6 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF6_TC-21 | Foreground  | On         | Off        | Always                      | Off             | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF6_TC-22 | Foreground  | On         | Off        | Always                      | Off             | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF6_TC-23 | Foreground  | On         | Off        | Always                      | Off             | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF6_TC-24 | Foreground  | On         | Off        | Always                      | Off             | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_TwistGo_WF_7 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF7_TC-25 | Always      | On         | On         | Always                      | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF7_TC-26 | Always      | On         | On         | Always                      | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF7_TC-27 | Always      | On         | On         | Always                      | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF7_TC-28 | Always      | On         | On         | Always                      | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_TwistGo_WF_8 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF8_TC-29 | Always      | On         | On         | Always                      | Off             | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF8_TC-30 | Always      | On         | On         | Always                      | Off             | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF8_TC-31 | Always      | On         | On         | Always                      | Off             | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF8_TC-32 | Always      | On         | On         | Always                      | Off             | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_TwistGo_WF_9 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF9_TC-33 | Unlocked    | On         | On         | Always                      | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF9_TC-34 | Unlocked    | On         | On         | Always                      | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF9_TC-35 | Unlocked    | On         | On         | Always                      | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF9_TC-36 | Unlocked    | On         | On         | Always                      | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_TwistGo_WF_10 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF10_TC-37 | Unlocked    | On         | On         | Always                      | Off             | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF10_TC-38 | Unlocked    | On         | On         | Always                      | Off             | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF10_TC-39 | Unlocked    | On         | On         | Always                      | Off             | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF10_TC-40 | Unlocked    | On         | On         | Always                      | Off             | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_TwistGo_WF_11 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF11_TC-41 | Foreground  | On         | On         | Always                      | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF11_TC-42 | Foreground  | On         | On         | Always                      | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF11_TC-43 | Foreground  | On         | On         | Always                      | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF11_TC-44 | Foreground  | On         | On         | Always                      | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |

    @Android9_8_7_RevE_TwistGo_WF_12 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TG_WF12_TC-45 | Foreground  | On         | On         | Denied                      | Off             | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF12_TC-46 | Foreground  | On         | On         | Denied                      | Off             | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF12_TC-47 | Foreground  | On         | On         | Denied                      | Off             | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | Seos        |
      | RevE        | _TG_WF12_TC-48 | Foreground  | On         | On         | Denied                      | Off             | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | Seos        |
#Enhanced tap flow
    @Android9_8_7_Signo_EnhancedTap_WF_1 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF1_TC-01 | Always      | ON         | OFF        | Always                      | ON              | Locked       | ON             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF1_TC-02 | Always      | ON         | OFF        | Always                      | ON              | Locked       | OFF            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF1_TC-03 | Always      | ON         | OFF        | Always                      | ON              | Unlocked     | ON             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF1_TC-04 | Always      | ON         | OFF        | Always                      | ON              | Unlocked     | ON             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android9_8_7_Signo_EnhancedTap_WF_2 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF2_TC-05 | Always      | ON         | OFF        | Always                      | OFF             | Locked       | ON             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF2_TC-06 | Always      | ON         | OFF        | Always                      | OFF             | Locked       | OFF            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF2_TC-07 | Always      | ON         | OFF        | Always                      | OFF             | Unlocked     | ON             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF2_TC-08 | Always      | ON         | OFF        | Always                      | OFF             | Unlocked     | ON             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android9_8_7_Signo_EnhancedTap_WF_3 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF3_TC-09 | Unlocked    | On         | Off        | Always                      | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF3_TC-10 | Unlocked    | On         | Off        | Always                      | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF3_TC-11 | Unlocked    | On         | Off        | Always                      | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF3_TC-12 | Unlocked    | On         | Off        | Always                      | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android9_8_7_Signo_EnhancedTap_WF_4 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF4_TC-13 | Unlocked    | On         | Off        | Always                      | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF4_TC-14 | Unlocked    | On         | Off        | Always                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF4_TC-15 | Unlocked    | On         | Off        | Always                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF4_TC-16 | Unlocked    | On         | Off        | Always                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android9_8_7_Signo_EnhancedTap_WF_5 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF5_TC-17 | Foreground  | On         | Off        | Always                      | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF5_TC-18 | Foreground  | On         | Off        | Always                      | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF5_TC-19 | Foreground  | On         | Off        | Always                      | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF5_TC-20 | Foreground  | On         | Off        | Always                      | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android9_8_7_Signo_EnhancedTap_WF_6 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF6_TC-21 | Foreground  | On         | Off        | Always                      | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF6_TC-22 | Foreground  | On         | Off        | Always                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF6_TC-23 | Foreground  | On         | Off        | Always                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF6_TC-24 | Foreground  | On         | Off        | Always                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android9_8_7_Signo_EnhancedTap_WF_7 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF7_TC-25 | Always      | On         | On         | Always                      | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF7_TC-26 | Always      | On         | On         | Always                      | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF7_TC-27 | Always      | On         | On         | Always                      | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF7_TC-28 | Always      | On         | On         | Always                      | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |


    @Android9_8_7_Signo_EnhancedTap_WF_8 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF8_TC-29 | Always      | On         | On         | Always                      | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF8_TC-30 | Always      | On         | On         | Always                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF8_TC-31 | Always      | On         | On         | Always                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF8_TC-32 | Always      | On         | On         | Always                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android9_8_7_Signo_EnhancedTap_WF_9 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF9_TC-33 | Unlocked    | On         | On         | Always                      | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF9_TC-34 | Unlocked    | On         | On         | Always                      | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF9_TC-35 | Unlocked    | On         | On         | Always                      | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF9_TC-36 | Unlocked    | On         | On         | Always                      | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android9_8_7_Signo_EnhancedTap_WF_10 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF10_TC-37 | Unlocked    | On         | On         | Always                      | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF10_TC-38 | Unlocked    | On         | On         | Always                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF10_TC-39 | Unlocked    | On         | On         | Always                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF10_TC-40 | Unlocked    | On         | On         | Always                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android9_8_7_Signo_EnhancedTap_WF_11 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF11_TC-41 | Foreground  | On         | On         | Always                      | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF11_TC-42 | Foreground  | On         | On         | Always                      | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF11_TC-43 | Foreground  | On         | On         | Always                      | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF11_TC-44 | Foreground  | On         | On         | Always                      | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |

    @Android9_8_7_Signo_EnhancedTap_WF_12 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF12_TC-45 | Foreground  | On         | On         | Always                      | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF12_TC-46 | Foreground  | On         | On         | Always                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF12_TC-47 | Foreground  | On         | On         | Always                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF12_TC-48 | Foreground  | On         | On         | Always                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |


    @Android9_8_7_Signo_EnhancedTap_WF_13 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF13_TC-49 | Always      | Off        | On         | Denied                      | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF13_TC-50 | Always      | Off        | On         | Denied                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF13_TC-51 | Always      | Off        | On         | Denied                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF13_TC-52 | Always      | Off        | On         | Denied                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android9_8_7_Signo_EnhancedTap_WF_14 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF14_TC-53 | Unlocked    | Off        | On         | Denied                      | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF14_TC-54 | Unlocked    | Off        | On         | Denied                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF14_TC-55 | Unlocked    | Off        | On         | Denied                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF14_TC-56 | Unlocked    | Off        | On         | Denied                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |

    @Android9_8_7_Signo_EnhancedTap_WF_15 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID  | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _ET_WF15_TC-57 | Foreground  | Off        | On         | Denied                      | Off             | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC  transaction | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF15_TC-58 | Foreground  | Off        | On         | Denied                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |
      | Signo       | _ET_WF15_TC-59 | Foreground  | Off        | On         | Denied                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | Seos        |
      | Signo       | _ET_WF15_TC-60 | Foreground  | Off        | On         | Denied                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | Seos        |


