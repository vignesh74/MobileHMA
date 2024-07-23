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
    And   Set display screen as "<display_status>" with "<device_state>" in android device
    And   Perform robotic arm action as "<action_name>" for android device "<device_state>" in android device
    And   Set device state as force unlock "<device_state>" with "<app_state>" in android device
    And   Set Application status as "Foreground" in android device
    And   Activity log is displayed in android device and "<date>", "<message>", "<reader_name>", "<action_name>", "<device_state>","<app_state>","<mobile_read>" are verified
    Then  Robotic arms log "<robotic_arm_log>" is displayed for android device

    @Android12_RevE_Tap_WF_1 @Android12_RevE_Tap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8810206   | Always      | On         | Off        | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285067   | Always      | On         | Off        | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285068   | Always      | On         | Off        | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285069   | Always      | On         | Off        | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285070   | Always      | On         | Off        | Allow                       | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285071   | Always      | On         | Off        | Allow                       | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285072   | Always      | On         | Off        | Allow                       | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285073   | Always      | On         | Off        | Allow                       | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android12_RevE_Tap_WF_2 @Android12_RevE_Tap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8810207   | Foreground  | On         | Off        | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285085   | Foreground  | On         | Off        | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285086   | Foreground  | On         | Off        | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285087   | Foreground  | On         | Off        | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285088   | Foreground  | On         | Off        | Allow                       | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285089   | Foreground  | On         | Off        | Allow                       | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285090   | Foreground  | On         | Off        | Allow                       | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285091   | Foreground  | On         | Off        | Allow                       | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_RevE_Tap_WF_3 @Android12_RevE_Tap @Android12_RevE @Android12_RevE_TapRun @ANDR_SmokeRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8816329   | Unlocked    | On         | Off        | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285093   | Unlocked    | On         | Off        | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285094   | Unlocked    | On         | Off        | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285095   | Unlocked    | On         | Off        | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285096   | Unlocked    | On         | Off        | Allow                       | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285097   | Unlocked    | On         | Off        | Allow                       | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285099   | Unlocked    | On         | Off        | Allow                       | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7285100   | Unlocked    | On         | Off        | Allow                       | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_RevE_Tap_WF_4 @Android12_RevE_Tap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8816331   | Always      | Off        | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293156   | Always      | Off        | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293157   | Always      | Off        | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293158   | Always      | Off        | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293159   | Always      | Off        | Off        | Don't allow                 | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293160   | Always      | Off        | Off        | Don't allow                 | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293161   | Always      | Off        | Off        | Don't allow                 | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293162   | Always      | Off        | Off        | Don't allow                 | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_RevE_Tap_WF_5 @Android12_RevE_Tap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8816332   | Foreground  | Off        | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293163   | Foreground  | Off        | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293164   | Foreground  | Off        | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293165   | Foreground  | Off        | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293166   | Foreground  | Off        | Off        | Don't allow                 | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293167   | Foreground  | Off        | Off        | Don't allow                 | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293168   | Foreground  | Off        | Off        | Don't allow                 | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293169   | Foreground  | Off        | Off        | Don't allow                 | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_RevE_Tap_WF_6 @Android12_RevE_Tap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8816333   | Unlocked    | Off        | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293170   | Unlocked    | Off        | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293171   | Unlocked    | Off        | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293172   | Unlocked    | Off        | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293173   | Unlocked    | Off        | Off        | Don't allow                 | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293174   | Unlocked    | Off        | Off        | Don't allow                 | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293175   | Unlocked    | Off        | Off        | Don't allow                 | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293176   | Unlocked    | Off        | Off        | Don't allow                 | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_RevE_Tap_WF_7 @Android12_RevE_Tap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8816334   | Always      | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293178   | Always      | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293179   | Always      | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293180   | Always      | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293181   | Always      | On         | Off        | Don't allow                 | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293182   | Always      | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293183   | Always      | On         | Off        | Don't allow                 | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293184   | Always      | On         | Off        | Don't allow                 | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_RevE_Tap_WF_8 @Android12_RevE_Tap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8816335   | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293185   | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293186   | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293187   | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293188   | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293189   | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293190   | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293191   | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_RevE_Tap_WF_9 @Android12_RevE_Tap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8816336   | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293192   | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293193   | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293194   | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293195   | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293196   | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293197   | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293198   | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_RevE_Tap_WF_10 @Android12_RevE_Tap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8816337   | Always      | Off        | Off        | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293199   | Always      | Off        | Off        | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293200   | Always      | Off        | Off        | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293201   | Always      | Off        | Off        | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293202   | Always      | Off        | Off        | Allow                       | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293203   | Always      | Off        | Off        | Allow                       | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293204   | Always      | Off        | Off        | Allow                       | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293205   | Always      | Off        | Off        | Allow                       | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_RevE_Tap_WF_11 @Android12_RevE_Tap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8816338   | Foreground  | Off        | Off        | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293206   | Foreground  | Off        | Off        | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293207   | Foreground  | Off        | Off        | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293208   | Foreground  | Off        | Off        | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293209   | Foreground  | Off        | Off        | Allow                       | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293210   | Foreground  | Off        | Off        | Allow                       | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293211   | Foreground  | Off        | Off        | Allow                       | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293212   | Foreground  | Off        | Off        | Allow                       | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_RevE_Tap_WF_12 @Android12_RevE_Tap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8816339   | Unlocked    | Off        | Off        | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293213   | Unlocked    | Off        | Off        | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293214   | Unlocked    | Off        | Off        | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293215   | Unlocked    | Off        | Off        | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293216   | Unlocked    | Off        | Off        | Allow                       | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293217   | Unlocked    | Off        | Off        | Allow                       | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293218   | Unlocked    | Off        | Off        | Allow                       | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293219   | Unlocked    | Off        | Off        | Allow                       | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |


## NFC

    @Android12_RevE_Tap_WF_13 @Android12_RevE_NFCTap @Android12_RevE @Android12_RevE_TapRun @ANDR_SmokeRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8816340   | Always      | On         | On         | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293527   | Always      | On         | On         | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293528   | Always      | On         | On         | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293529   | Always      | On         | On         | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293530   | Always      | On         | On         | Allow                       | On              | Locked       | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293531   | Always      | On         | On         | Allow                       | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293532   | Always      | On         | On         | Allow                       | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293533   | Always      | On         | On         | Allow                       | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android12_RevE_Tap_WF_14 @Android12_RevE_NFCTap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8816341   | Foreground  | On         | On         | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293534   | Foreground  | On         | On         | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293535   | Foreground  | On         | On         | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293536   | Foreground  | On         | On         | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293537   | Foreground  | On         | On         | Allow                       | On              | Locked       | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293538   | Foreground  | On         | On         | Allow                       | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293539   | Foreground  | On         | On         | Allow                       | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293540   | Foreground  | On         | On         | Allow                       | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_RevE_Tap_WF_15 @Android12_RevE_NFCTap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8816343   | Unlocked    | On         | On         | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293541   | Unlocked    | On         | On         | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293542   | Unlocked    | On         | On         | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293543   | Unlocked    | On         | On         | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293544   | Unlocked    | On         | On         | Allow                       | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293545   | Unlocked    | On         | On         | Allow                       | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293546   | Unlocked    | On         | On         | Allow                       | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293547   | Unlocked    | On         | On         | Allow                       | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_RevE_Tap_WF_16 @Android12_RevE_NFCTap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8816350   | Always      | Off        | On         | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293617   | Always      | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293618   | Always      | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293619   | Always      | Off        | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293620   | Always      | Off        | On         | Don't allow                 | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293621   | Always      | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293622   | Always      | Off        | On         | Don't allow                 | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293623   | Always      | Off        | On         | Don't allow                 | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android12_RevE_Tap_WF_17 @Android12_RevE_NFCTap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8816351   | Foreground  | Off        | On         | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293624   | Foreground  | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293625   | Foreground  | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293626   | Foreground  | Off        | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293627   | Foreground  | Off        | On         | Don't allow                 | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293628   | Foreground  | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293629   | Foreground  | Off        | On         | Don't allow                 | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293630   | Foreground  | Off        | On         | Don't allow                 | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_RevE_Tap_WF_18 @Android12_RevE_NFCTap @Android12_RevE @Android12_RevE_TapRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8816352   | Unlocked    | Off        | On         | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293631   | Unlocked    | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293632   | Unlocked    | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293633   | Unlocked    | Off        | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293634   | Unlocked    | Off        | On         | Don't allow                 | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293635   | Unlocked    | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293636   | Unlocked    | Off        | On         | Don't allow                 | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293637   | Unlocked    | Off        | On         | Don't allow                 | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |


# Twist & Go

    @Android12_RevE_TwistGo_WF_1 @Android12_RevE_TwistGo @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-8816355   | Always      | On         | On         | Allow                       | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293233   | Always      | On         | On         | Allow                       | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293234   | Always      | On         | On         | Allow                       | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293235   | Always      | On         | On         | Allow                       | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293236   | Always      | On         | On         | Allow                       | On              | Locked       | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293237   | Always      | On         | On         | Allow                       | On              | Unlocked     | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293238   | Always      | On         | On         | Allow                       | On              | Locked       | Off            | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293239   | Always      | On         | On         | Allow                       | On              | Locked       | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |

    @Android12_RevE_TwistGo_WF_2 @Android12_RevE_TwistGo @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-8816356   | Foreground  | On         | On         | Allow                       | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293243   | Foreground  | On         | On         | Allow                       | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293244   | Foreground  | On         | On         | Allow                       | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293245   | Foreground  | On         | On         | Allow                       | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293246   | Foreground  | On         | On         | Allow                       | On              | Locked       | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293247   | Foreground  | On         | On         | Allow                       | On              | Unlocked     | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293248   | Foreground  | On         | On         | Allow                       | On              | Locked       | Off            | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293249   | Foreground  | On         | On         | Allow                       | On              | Locked       | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android12_RevE_TwistGo_WF_3 @Android12_RevE_TwistGo @Android12_RevE @ANDR_SmokeRun
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-8816357   | Unlocked    | On         | On         | Allow                       | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293250   | Unlocked    | On         | On         | Allow                       | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293251   | Unlocked    | On         | On         | Allow                       | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293252   | Unlocked    | On         | On         | Allow                       | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293253   | Unlocked    | On         | On         | Allow                       | On              | Locked       | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293254   | Unlocked    | On         | On         | Allow                       | On              | Unlocked     | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293255   | Unlocked    | On         | On         | Allow                       | On              | Locked       | Off            | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293256   | Unlocked    | On         | On         | Allow                       | On              | Locked       | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android12_RevE_TwistGo_WF_4 @Android12_RevE_TwistGo @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-8816358   | Always      | Off        | On         | Don't allow                 | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293260   | Always      | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293261   | Always      | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293262   | Always      | Off        | On         | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293263   | Always      | Off        | On         | Don't allow                 | On              | Locked       | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293264   | Always      | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293265   | Always      | Off        | On         | Don't allow                 | On              | Locked       | Off            | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293266   | Always      | Off        | On         | Don't allow                 | On              | Locked       | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android12_RevE_TwistGo_WF_5 @Android12_RevE_TwistGo @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-8816360   | Foreground  | Off        | On         | Don't allow                 | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293267   | Foreground  | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293268   | Foreground  | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293269   | Foreground  | Off        | On         | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293270   | Foreground  | Off        | On         | Don't allow                 | On              | Locked       | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293271   | Foreground  | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293272   | Foreground  | Off        | On         | Don't allow                 | On              | Locked       | Off            | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293273   | Foreground  | Off        | On         | Don't allow                 | On              | Locked       | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android12_RevE_TwistGo_WF_6 @Android12_RevE_TwistGo @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-8816361   | Unlocked    | Off        | On         | Don't allow                 | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293274   | Unlocked    | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293275   | Unlocked    | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293276   | Unlocked    | Off        | On         | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293277   | Unlocked    | Off        | On         | Don't allow                 | On              | Locked       | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293278   | Unlocked    | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293279   | Unlocked    | Off        | On         | Don't allow                 | On              | Locked       | Off            | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293280   | Unlocked    | Off        | On         | Don't allow                 | On              | Locked       | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android12_RevE_TwistGo_WF_7 @Android12_RevE_TwistGo @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-8816362   | Always      | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293281   | Always      | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293282   | Always      | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293283   | Always      | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293284   | Always      | On         | On         | Don't allow                 | On              | Locked       | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293285   | Always      | On         | On         | Don't allow                 | On              | Unlocked     | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293286   | Always      | On         | On         | Don't allow                 | On              | Locked       | Off            | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293287   | Always      | On         | On         | Don't allow                 | On              | Locked       | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android12_RevE_TwistGo_WF_8 @Android12_RevE_TwistGo @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-8816363   | Foreground  | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293288   | Foreground  | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293289   | Foreground  | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293290   | Foreground  | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293291   | Foreground  | On         | On         | Don't allow                 | On              | Locked       | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293292   | Foreground  | On         | On         | Don't allow                 | On              | Unlocked     | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293293   | Foreground  | On         | On         | Don't allow                 | On              | Locked       | Off            | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293294   | Foreground  | On         | On         | Don't allow                 | On              | Locked       | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android12_RevE_TwistGo_WF_9 @Android12_RevE_TwistGo @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-8816364   | Unlocked    | On         | On         | Don't allow                 | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293295   | Unlocked    | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293296   | Unlocked    | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293297   | Unlocked    | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293298   | Unlocked    | On         | On         | Don't allow                 | On              | Locked       | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293299   | Unlocked    | On         | On         | Don't allow                 | On              | Unlocked     | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293300   | Unlocked    | On         | On         | Don't allow                 | On              | Locked       | Off            | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293301   | Unlocked    | On         | On         | Don't allow                 | On              | Locked       | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android12_RevE_TwistGo_WF_10 @Android12_RevE_TwistGo @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-8816365   | Always      | Off        | On         | Allow                       | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293302   | Always      | Off        | On         | Allow                       | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293303   | Always      | Off        | On         | Allow                       | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293304   | Always      | Off        | On         | Allow                       | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293305   | Always      | Off        | On         | Allow                       | On              | Locked       | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293306   | Always      | Off        | On         | Allow                       | On              | Unlocked     | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293307   | Always      | Off        | On         | Allow                       | On              | Locked       | Off            | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293308   | Always      | Off        | On         | Allow                       | On              | Locked       | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android12_RevE_TwistGo_WF_11 @Android12_RevE_TwistGo @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-8816366   | Foreground  | Off        | On         | Allow                       | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293309   | Foreground  | Off        | On         | Allow                       | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293310   | Foreground  | Off        | On         | Allow                       | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293311   | Foreground  | Off        | On         | Allow                       | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293312   | Foreground  | Off        | On         | Allow                       | On              | Locked       | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293313   | Foreground  | Off        | On         | Allow                       | On              | Unlocked     | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293314   | Foreground  | Off        | On         | Allow                       | On              | Locked       | Off            | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293315   | Foreground  | Off        | On         | Allow                       | On              | Locked       | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android12_RevE_TwistGo_WF_12 @Android12_RevE_TwistGo @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-8816367   | Unlocked    | Off        | On         | Allow                       | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293316   | Unlocked    | Off        | On         | Allow                       | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293317   | Unlocked    | Off        | On         | Allow                       | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293318   | Unlocked    | Off        | On         | Allow                       | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293319   | Unlocked    | Off        | On         | Allow                       | On              | Locked       | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293320   | Unlocked    | Off        | On         | Allow                       | On              | Unlocked     | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293321   | Unlocked    | Off        | On         | Allow                       | On              | Locked       | Off            | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293322   | Unlocked    | Off        | On         | Allow                       | On              | Locked       | On             | Killed     | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |


#Enhanced Tap

    @Android12_Signo_EnhancedTap_WF_1 @Android12_Signo_EnhancedTap @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8846813   | Always      | On         | Off        | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293329   | Always      | On         | Off        | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293330   | Always      | On         | Off        | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293331   | Always      | On         | Off        | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293332   | Always      | On         | Off        | Allow                       | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293333   | Always      | On         | Off        | Allow                       | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293334   | Always      | On         | Off        | Allow                       | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293335   | Always      | On         | Off        | Allow                       | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android12_Signo_EnhancedTap_WF_2  @Android12_Signo_EnhancedTap @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8846814   | Foreground  | On         | Off        | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293339   | Foreground  | On         | Off        | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293340   | Foreground  | On         | Off        | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293341   | Foreground  | On         | Off        | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293342   | Foreground  | On         | Off        | Allow                       | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293343   | Foreground  | On         | Off        | Allow                       | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293344   | Foreground  | On         | Off        | Allow                       | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293345   | Foreground  | On         | Off        | Allow                       | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_Signo_EnhancedTap_WF_3  @Android12_Signo_EnhancedTap @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8846815   | Unlocked    | On         | Off        | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293346   | Unlocked    | On         | Off        | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293347   | Unlocked    | On         | Off        | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293348   | Unlocked    | On         | Off        | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293349   | Unlocked    | On         | Off        | Allow                       | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293350   | Unlocked    | On         | Off        | Allow                       | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293351   | Unlocked    | On         | Off        | Allow                       | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293352   | Unlocked    | On         | Off        | Allow                       | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_Signo_EnhancedTap_WF_4  @Android12_Signo_EnhancedTap @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8846816   | Always      | Off        | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293355   | Always      | Off        | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293356   | Always      | Off        | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293357   | Always      | Off        | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293358   | Always      | Off        | Off        | Don't allow                 | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293359   | Always      | Off        | Off        | Don't allow                 | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293360   | Always      | Off        | Off        | Don't allow                 | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293361   | Always      | Off        | Off        | Don't allow                 | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_Signo_EnhancedTap_WF_5  @Android12_Signo_EnhancedTap @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8846817   | Foreground  | Off        | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293362   | Foreground  | Off        | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293363   | Foreground  | Off        | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293364   | Foreground  | Off        | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293365   | Foreground  | Off        | Off        | Don't allow                 | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293366   | Foreground  | Off        | Off        | Don't allow                 | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293367   | Foreground  | Off        | Off        | Don't allow                 | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293368   | Foreground  | Off        | Off        | Don't allow                 | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_Signo_EnhancedTap_WF_6  @Android12_Signo_EnhancedTap @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8846818   | Unlocked    | Off        | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293369   | Unlocked    | Off        | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293370   | Unlocked    | Off        | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293371   | Unlocked    | Off        | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293372   | Unlocked    | Off        | Off        | Don't allow                 | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293373   | Unlocked    | Off        | Off        | Don't allow                 | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293374   | Unlocked    | Off        | Off        | Don't allow                 | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293375   | Unlocked    | Off        | Off        | Don't allow                 | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_Signo_EnhancedTap_WF_7  @Android12_Signo_EnhancedTap @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8846819   | Always      | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293378   | Always      | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293379   | Always      | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293380   | Always      | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293381   | Always      | On         | Off        | Don't allow                 | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293382   | Always      | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293383   | Always      | On         | Off        | Don't allow                 | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293384   | Always      | On         | Off        | Don't allow                 | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_Signo_EnhancedTap_WF_8  @Android12_Signo_EnhancedTap @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8846820   | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293385   | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293386   | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293387   | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293388   | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293389   | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293390   | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293391   | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_Signo_EnhancedTap_WF_9  @Android12_Signo_EnhancedTap @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8846821   | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293392   | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293393   | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293394   | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293395   | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293396   | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293397   | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293398   | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_Signo_EnhancedTap_WF_10  @Android12_Signo_EnhancedTap @Android12_RevE

    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8846822   | Always      | Off        | Off        | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293399   | Always      | Off        | Off        | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293400   | Always      | Off        | Off        | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293401   | Always      | Off        | Off        | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293402   | Always      | Off        | Off        | Allow                       | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293403   | Always      | Off        | Off        | Allow                       | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293404   | Always      | Off        | Off        | Allow                       | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293405   | Always      | Off        | Off        | Allow                       | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_Signo_EnhancedTap_WF_11  @Android12_Signo_EnhancedTap @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8846823   | Foreground  | Off        | Off        | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293406   | Foreground  | Off        | Off        | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293407   | Foreground  | Off        | Off        | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293408   | Foreground  | Off        | Off        | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293409   | Foreground  | Off        | Off        | Allow                       | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293410   | Foreground  | Off        | Off        | Allow                       | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293411   | Foreground  | Off        | Off        | Allow                       | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293412   | Foreground  | Off        | Off        | Allow                       | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android12_Signo_EnhancedTap_WF_12  @Android12_Signo_EnhancedTap @Android12_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-8846824   | Unlocked    | Off        | Off        | Allow                       | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293413   | Unlocked    | Off        | Off        | Allow                       | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293414   | Unlocked    | Off        | Off        | Allow                       | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293415   | Unlocked    | Off        | Off        | Allow                       | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293416   | Unlocked    | Off        | Off        | Allow                       | On              | Locked       | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293417   | Unlocked    | Off        | Off        | Allow                       | On              | Unlocked     | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293418   | Unlocked    | Off        | Off        | Allow                       | On              | Locked       | Off            | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-7293419   | Unlocked    | Off        | Off        | Allow                       | On              | Locked       | On             | Killed     | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |


  Scenario Outline:ANDR_11_10_<Reader_Name><Gesture_TC_ID>: Verify Robotic Arm Action and logs when BLE is <BLE_status>, NFC is <NFC_status>, Nearby is <NearByOrLocation_permission>, Location is <location_status>, App State set is <app_state>, device state is <device_state> and display status is <display_status>
    When  Navigate to Settings and App Preferences screen in android device
    And   Set BLE status as "<BLE_status>" in android device
    And   Set NFC status as "<NFC_status>" in android device
    And   Set "Location" permission status as "<NearByOrLocation_permission>" in android device
    And   Set location as "<location_status>" in android device
    And   Select the usage state as "<usage_state>" in android device
    And   Set Application status as "<app_state>" in android device
    And   Set device state as "<device_state>" in android device.
    And   Set display screen as "<display_status>" with "<device_state>" in android device
    And   Perform robotic arm action as "<action_name>" for android device "<device_state>" in android device
    And   Set device state as force unlock "<device_state>" with "<app_state>" in android device
    And   Set Application status as "Foreground" in android device
    And   Activity log is displayed in android device and "<date>", "<message>", "<reader_name>", "<action_name>", "<device_state>","<app_state>","<mobile_read>" are verified
    Then  Robotic arms log "<robotic_arm_log>" is displayed for android device

    @Android11_10_RevE_Tap_WF_1 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838472   | Always      | On         | Off        | Allow all the time          | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838470   | Always      | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838471   | Always      | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android11_10_RevE_Tap_WF_2 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838475   | Foreground  | On         | Off        | Allow all the time          | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838473   | Foreground  | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838474   | Foreground  | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_RevE_Tap_WF_3 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838478   | Unlocked    | On         | Off        | Allow all the time          | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838476   | Unlocked    | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838477   | Unlocked    | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android11_10_RevE_Tap_WF_4 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838481   | Always      | On         | On         | Allow only while using the app | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838479   | Always      | On         | On         | Allow only while using the app | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838480   | Always      | On         | On         | Allow only while using the app | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android11_10_RevE_Tap_WF_5 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838484   | Foreground  | On         | Off        | Allow only while using the app | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838482   | Foreground  | On         | Off        | Allow only while using the app | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838483   | Foreground  | On         | Off        | Allow only while using the app | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_RevE_Tap_WF_6 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838487   | Unlocked    | On         | On         | Allow only while using the app | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838485   | Unlocked    | On         | On         | Allow only while using the app | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838486   | Unlocked    | On         | On         | Allow only while using the app | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_RevE_Tap_WF_7 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838488   | Always      | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838490   | Always      | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838489   | Always      | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_RevE_Tap_WF_8 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838492   | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838494   | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838493   | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_RevE_Tap_WF_9 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838499   | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838497   | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838498   | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_RevE_Tap_WF_10 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838502   | Always      | Off        | On         | Allow all the time          | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838500   | Always      | Off        | On         | Allow all the time          | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838501   | Always      | Off        | On         | Allow all the time          | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android11_10_RevE_Tap_WF_11 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838505   | Foreground  | Off        | On         | Allow all the time          | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838503   | Foreground  | Off        | On         | Allow all the time          | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838504   | Foreground  | Off        | On         | Allow all the time          | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_RevE_Tap_WF_12 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838508   | Unlocked    | Off        | On         | Allow all the time          | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838506   | Unlocked    | Off        | On         | Allow all the time          | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838507   | Unlocked    | Off        | On         | Allow all the time          | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android11_10_RevE_Tap_WF_13 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838511   | Always      | Off        | On         | Allow only while using the app | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838509   | Always      | Off        | On         | Allow only while using the app | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838510   | Always      | Off        | On         | Allow only while using the app | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_RevE_Tap_WF_14 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838514   | Foreground  | Off        | On         | Allow only while using the app | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838512   | Foreground  | Off        | On         | Allow only while using the app | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838513   | Foreground  | Off        | On         | Allow only while using the app | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_RevE_Tap_WF_15 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838517   | Unlocked    | Off        | On         | Allow only while using the app | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838515   | Unlocked    | Off        | On         | Allow only while using the app | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838516   | Unlocked    | Off        | On         | Allow only while using the app | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android11_10_RevE_Tap_WF_16 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838520   | Always      | Off        | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838518   | Always      | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838519   | Always      | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_RevE_Tap_WF_17 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838523   | Foreground  | Off        | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838521   | Foreground  | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838522   | Foreground  | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_RevE_Tap_WF_18 @Android11_10_RevE_Tap @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838526   | Unlocked    | Off        | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838524   | Unlocked    | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838525   | Unlocked    | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |



    ##############################


    @Android11_10_RevE_TwistGo_WF_1 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839350   | Always      | On         | Off        | Allow all the time          | On              | Locked       | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839352   | Always      | On         | Off        | Allow all the time          | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839351   | Always      | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |

    @Android11_10_RevE_TwistGo_WF_2 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839355   | Foreground  | On         | Off        | Allow all the time          | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839353   | Foreground  | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839354   | Foreground  | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android11_10_RevE_TwistGo_WF_3 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839358   | Unlocked    | On         | Off        | Allow all the time          | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839356   | Unlocked    | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839357   | Unlocked    | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |

    @Android11_10_RevE_TwistGo_WF_4 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839361   | Always      | On         | Off        | Allow only while using the app | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839359   | Always      | On         | Off        | Allow only while using the app | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839360   | Always      | On         | Off        | Allow only while using the app | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android11_10_RevE_TwistGo_WF_5 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839364   | Foreground  | On         | Off        | Allow only while using the app | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839362   | Foreground  | On         | Off        | Allow only while using the app | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839363   | Foreground  | On         | Off        | Allow only while using the app | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android11_10_RevE_TwistGo_WF_6 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839367   | Unlocked    | On         | Off        | Allow only while using the app | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839365   | Unlocked    | On         | Off        | Allow only while using the app | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839366   | Unlocked    | On         | Off        | Allow only while using the app | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android11_10_RevE_TwistGo_WF_7 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839370   | Always      | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839368   | Always      | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839369   | Always      | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android11_10_RevE_TwistGo_WF_8 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839373   | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839371   | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839372   | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android11_10_RevE_TwistGo_WF_9 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839376   | Unlocked    | On         | On         | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839374   | Unlocked    | On         | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839375   | Unlocked    | On         | On         | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android11_10_RevE_TwistGo_WF_10 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839379   | Always      | Off        | On         | Allow all the time          | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839377   | Always      | Off        | On         | Allow all the time          | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839378   | Always      | Off        | On         | Allow all the time          | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |

    @Android11_10_RevE_TwistGo_WF_11 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839382   | Foreground  | Off        | On         | Allow all the time          | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839380   | Foreground  | Off        | On         | Allow all the time          | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839381   | Foreground  | Off        | On         | Allow all the time          | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android11_10_RevE_TwistGo_WF_12 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839385   | Unlocked    | Off        | On         | Allow all the time          | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839383   | Unlocked    | Off        | On         | Allow all the time          | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839384   | Unlocked    | Off        | On         | Allow all the time          | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |

    @Android11_10_RevE_TwistGo_WF_13 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839388   | Always      | Off        | Off        | Allow only while using the app | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839386   | Always      | Off        | Off        | Allow only while using the app | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839387   | Always      | Off        | Off        | Allow only while using the app | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android11_10_RevE_TwistGo_WF_14 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839391   | Foreground  | Off        | On         | Allow only while using the app | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839389   | Foreground  | Off        | On         | Allow only while using the app | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839390   | Foreground  | Off        | On         | Allow only while using the app | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android11_10_RevE_TwistGo_WF_15 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839394   | Unlocked    | Off        | Off        | Allow only while using the app | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839392   | Unlocked    | Off        | Off        | Allow only while using the app | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839393   | Unlocked    | Off        | Off        | Allow only while using the app | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android11_10_RevE_TwistGo_WF_16 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839397   | Always      | Off        | On         | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839395   | Always      | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839396   | Always      | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android11_10_RevE_TwistGo_WF_17 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839400   | Foreground  | Off        | Off        | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839398   | Foreground  | Off        | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839399   | Foreground  | Off        | Off        | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android11_10_RevE_TwistGo_WF_18 @Android11_10_RevE_TwistGo @Android11_10_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839403   | Unlocked    | Off        | On         | Don't allow                 | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839401   | Unlocked    | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839402   | Unlocked    | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    ######################################


    #Enhanced Tap

    @Android11_10_Signo_EnhancedTap_WF_1 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _TC-6838721   | Always      | On         | Off        | Allow all the time          | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838719   | Always      | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838720   | Always      | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android11_10_Signo_EnhancedTap_WF_2 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _TC-6838724   | Foreground  | On         | Off        | Allow all the time          | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838722   | Foreground  | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838723   | Foreground  | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android11_10_Signo_EnhancedTap_WF_3 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838727   | Unlocked    | On         | Off        | Allow all the time          | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838725   | Unlocked    | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838726   | Unlocked    | On         | Off        | Allow all the time          | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_Signo_EnhancedTap_WF_4 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838730   | Always      | On         | On         | Allow only while using the app | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838728   | Always      | On         | On         | Allow only while using the app | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838729   | Always      | On         | On         | Allow only while using the app | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android11_10_Signo_EnhancedTap_WF_5 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838733   | Foreground  | On         | Off        | Allow only while using the app | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838731   | Foreground  | On         | Off        | Allow only while using the app | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838732   | Foreground  | On         | Off        | Allow only while using the app | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_Signo_EnhancedTap_WF_6 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838736   | Unlocked    | On         | On         | Allow only while using the app | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838734   | Unlocked    | On         | On         | Allow only while using the app | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838735   | Unlocked    | On         | On         | Allow only while using the app | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_Signo_EnhancedTap_WF_7 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838739   | Always      | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838737   | Always      | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838738   | Always      | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_Signo_EnhancedTap_WF_8 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838742   | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838740   | Foreground  | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838741   | Foreground  | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_Signo_EnhancedTap_WF_9 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838745   | Unlocked    | On         | Off        | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838743   | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838744   | Unlocked    | On         | Off        | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_Signo_EnhancedTap_WF_10 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838748   | Always      | Off        | On         | Allow all the time          | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838746   | Always      | Off        | On         | Allow all the time          | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838747   | Always      | Off        | On         | Allow all the time          | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android11_10_Signo_EnhancedTap_WF_11 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838751   | Foreground  | Off        | On         | Allow all the time          | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838749   | Foreground  | Off        | On         | Allow all the time          | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838750   | Foreground  | Off        | On         | Allow all the time          | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_Signo_EnhancedTap_WF_12 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838754   | Unlocked    | Off        | On         | Allow all the time          | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838752   | Unlocked    | Off        | On         | Allow all the time          | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838753   | Unlocked    | Off        | On         | Allow all the time          | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android11_10_Signo_EnhancedTap_WF_13 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838757   | Always      | Off        | On         | Allow only while using the app | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838755   | Always      | Off        | On         | Allow only while using the app | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838756   | Always      | Off        | On         | Allow only while using the app | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_Signo_EnhancedTap_WF_14 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838760   | Foreground  | Off        | On         | Allow only while using the app | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838758   | Foreground  | Off        | On         | Allow only while using the app | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838759   | Foreground  | Off        | On         | Allow only while using the app | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android11_10_Signo_EnhancedTap_WF_15 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission    | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838763   | Unlocked    | Off        | On         | Allow only while using the app | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838761   | Unlocked    | Off        | On         | Allow only while using the app | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838762   | Unlocked    | Off        | On         | Allow only while using the app | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android11_10_Signo_EnhancedTap_WF_16 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838766   | Always      | Off        | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838764   | Always      | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838765   | Always      | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_Signo_EnhancedTap_WF_17 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838769   | Foreground  | Off        | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838767   | Foreground  | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838768   | Foreground  | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android11_10_Signo_EnhancedTap_WF_18 @Android11_10_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838772   | Unlocked    | Off        | On         | Don't allow                 | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838770   | Unlocked    | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838771   | Unlocked    | Off        | On         | Don't allow                 | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |


#unlock scenario of the version 7 8 9
  Scenario Outline:ANDR_9_8_7_<Reader_Name><Gesture_TC_ID>: Verify Robotic Arm Action and logs when BLE is <BLE_status>, NFC is <NFC_status>, Nearby is <NearByOrLocation_permission>, Location is <location_status>, App State set is <app_state>, device state is <device_state> and display status is <display_status>
    When  Navigate to Settings and App Preferences screen in android device
    And   Set BLE status as "<BLE_status>" in android device
    And   Set NFC status as "<NFC_status>" in android device
    And   Set "Location" permission status as "<NearByOrLocation_permission>" in android device
    And   Set location as "<location_status>" in android device
    And   Select the usage state as "<usage_state>" in android device
    And   Set Application status as "<app_state>" in android device
    And   Set device state as "<device_state>" in android device.
    And   Set display screen as "<display_status>" with "<device_state>" in android device
    And   Perform robotic arm action as "<action_name>" for android device "<device_state>" in android device
    And   Set device state as "ForcedUnlock" in android device.
    And   Set Application status as "Foreground" in android device
    And   Activity log is displayed in android device and "<date>", "<message>", "<reader_name>", "<action_name>", "<device_state>","<app_state>","<mobile_read>" are verified
    Then  Robotic arms log "<robotic_arm_log>" is displayed for android device

    @Android9_8_7_RevE_Tap_WF_1 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838414   | Always      | On         | Off        | Always                      | On              | Locked       | OFF            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838410   | Always      | On         | Off        | Always                      | On              | Unlocked     | ON             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838413   | Always      | On         | Off        | Always                      | On              | Unlocked     | ON             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_Tap_WF_2 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838417   | Foreground  | On         | Off        | Always                      | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838415   | Foreground  | On         | Off        | Always                      | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838416   | Foreground  | On         | Off        | Always                      | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_Tap_WF_3 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838420   | Unlocked    | On         | Off        | Always                      | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838418   | Unlocked    | On         | Off        | Always                      | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838419   | Unlocked    | On         | Off        | Always                      | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_Tap_WF_4 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838423   | Unlocked    | Off        | Off        | Always                      | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838421   | Unlocked    | Off        | Off        | Always                      | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838422   | Unlocked    | Off        | Off        | Always                      | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_Tap_WF_5 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838427   | Foreground  | Off        | Off        | Always                      | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838425   | Foreground  | Off        | Off        | Always                      | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838426   | Foreground  | Off        | Off        | Always                      | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_Tap_WF_6 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838430   | Unlocked    | Off        | Off        | Always                      | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838428   | Unlocked    | Off        | Off        | Always                      | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838429   | Unlocked    | Off        | Off        | Always                      | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_Tap_WF_7 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838435   | Always      | On         | On         | Denied                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838431   | Always      | On         | On         | Denied                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838432   | Always      | On         | On         | Denied                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_Tap_WF_8 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838438   | Foreground  | On         | On         | Denied                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838436   | Foreground  | On         | On         | Denied                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838437   | Foreground  | On         | On         | Denied                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_Tap_WF_9 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838441   | Unlocked    | On         | On         | Denied                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838439   | Unlocked    | On         | On         | Denied                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838440   | Unlocked    | On         | On         | Denied                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_Tap_WF_10 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838444   | Always      | Off        | On         | Denied                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838442   | Always      | Off        | On         | Denied                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838443   | Always      | Off        | On         | Denied                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_Tap_WF_11 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838447   | Foreground  | Off        | On         | Denied                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838445   | Foreground  | Off        | On         | Denied                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838446   | Foreground  | Off        | On         | Denied                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_Tap_WF_12 @Android9_8_7_RevE_Tap @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | RevE        | _TC-6838450   | Unlocked    | Off        | On         | Denied                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838448   | Unlocked    | Off        | On         | Denied                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | RevE        | _TC-6838449   | Unlocked    | Off        | On         | Denied                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |


#Twist and Go flow
    @Android9_8_7_RevE_TwistGo_WF_1 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839213   | Always      | On         | Off        | Always                      | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839211   | Always      | On         | Off        | Always                      | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839212   | Always      | On         | Off        | Always                      | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_TwistGo_WF_2 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839216   | Foreground  | On         | Off        | Always                      | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839214   | Foreground  | On         | Off        | Always                      | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839215   | Foreground  | On         | Off        | Always                      | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_TwistGo_WF_3 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839219   | Unlocked    | On         | Off        | Always                      | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839217   | Unlocked    | On         | Off        | Always                      | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839218   | Unlocked    | On         | Off        | Always                      | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_TwistGo_WF_4 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839222   | Always      | Off        | Off        | Denied                      | Off             | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839220   | Always      | Off        | Off        | Denied                      | Off             | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839221   | Always      | Off        | Off        | Denied                      | Off             | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_TwistGo_WF_5 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839225   | Foreground  | Off        | Off        | Denied                      | Off             | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839223   | Foreground  | Off        | Off        | Denied                      | Off             | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839224   | Foreground  | Off        | Off        | Denied                      | Off             | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_TwistGo_WF_6 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839228   | Unlocked    | Off        | Off        | Denied                      | Off             | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839226   | Unlocked    | Off        | Off        | Denied                      | Off             | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839227   | Unlocked    | Off        | Off        | Denied                      | Off             | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_TwistGo_WF_7 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839231   | Always      | On         | On         | Denied                      | Off             | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839229   | Always      | On         | On         | Denied                      | Off             | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839230   | Always      | On         | On         | Denied                      | Off             | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_TwistGo_WF_8 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839234   | Foreground  | On         | On         | Denied                      | Off             | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839232   | Foreground  | On         | On         | Denied                      | Off             | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839233   | Foreground  | On         | On         | Denied                      | Off             | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_TwistGo_WF_9 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839237   | Unlocked    | On         | On         | Denied                      | Off             | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839235   | Unlocked    | On         | On         | Denied                      | Off             | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839236   | Unlocked    | On         | On         | Denied                      | Off             | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_TwistGo_WF_10 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839240   | Always      | Off        | On         | Always                      | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839238   | Always      | Off        | On         | Always                      | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839239   | Always      | Off        | On         | Always                      | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_TwistGo_WF_11 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839243   | Foreground  | Off        | On         | Always                      | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839241   | Foreground  | Off        | On         | Always                      | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839242   | Foreground  | Off        | On         | Always                      | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_TwistGo_WF_12 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839246   | Unlocked    | Off        | On         | Always                      | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839244   | Unlocked    | Off        | On         | Always                      | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839245   | Unlocked    | Off        | On         | Always                      | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_TwistGo_WF_13 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839249   | Always      | Off        | On         | Always                      | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839247   | Always      | Off        | On         | Always                      | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839248   | Always      | Off        | On         | Always                      | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_TwistGo_WF_14 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839252   | Foreground  | Off        | On         | Always                      | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839250   | Foreground  | Off        | On         | Always                      | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839251   | Foreground  | Off        | On         | Always                      | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

    @Android9_8_7_RevE_TwistGo_WF_15 @Android9_8_7_RevE_TwistGo @Android9_8_7_RevE
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log      | mobile_read    | reader_name |
      | RevE        | _TC-6839255   | Unlocked    | Off        | On         | Always                      | On              | Locked       | Off            | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839253   | Unlocked    | Off        | On         | Always                      | On              | Unlocked     | On             | Foreground | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO=:ENABLE | Mobile ID Read | FavR2       |
      | RevE        | _TC-6839254   | Unlocked    | Off        | On         | Always                      | On              | Unlocked     | On             | Background | Twist & Go  | TODAY | Successful Bluetooth transaction. | TWIST_AND_GO:DISABLE | Mobile ID Read | FavR2       |

  #Enhanced tap flow
    @Android9_8_7_Signo_EnhancedTap_WF_1 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _TC-6838775   | Always      | On         | Off        | Always                      | On              | Locked       | OFF            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838773   | Always      | On         | Off        | Always                      | On              | Unlocked     | ON             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838774   | Always      | On         | Off        | Always                      | On              | Unlocked     | ON             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android9_8_7_Signo_EnhancedTap_WF_2 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _TC-6838778   | Foreground  | On         | Off        | Always                      | On              | Locked       | OFF            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838776   | Foreground  | On         | Off        | Always                      | On              | Unlocked     | ON             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838777   | Foreground  | On         | Off        | Always                      | On              | Unlocked     | ON             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android9_8_7_Signo_EnhancedTap_WF_3 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _TC-6838781   | Unlocked    | On         | Off        | Always                      | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838779   | Unlocked    | On         | Off        | Always                      | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838780   | Unlocked    | On         | Off        | Always                      | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android9_8_7_Signo_EnhancedTap_WF_4 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _TC-6838784   | Always      | Off        | Off        | Always                      | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838782   | Always      | Off        | Off        | Always                      | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838783   | Always      | Off        | Off        | Always                      | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android9_8_7_Signo_EnhancedTap_WF_5 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _TC-6838787   | Foreground  | Off        | Off        | Always                      | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838785   | Foreground  | Off        | Off        | Always                      | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838786   | Foreground  | Off        | Off        | Always                      | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android9_8_7_Signo_EnhancedTap_WF_6 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                           | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _TC-6838790   | Unlocked    | Off        | Off        | Always                      | On              | Locked       | Off            | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838788   | Unlocked    | Off        | Off        | Always                      | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838789   | Unlocked    | Off        | Off        | Always                      | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful Bluetooth transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android9_8_7_Signo_EnhancedTap_WF_7 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _TC-6838793   | Always      | On         | On         | Denied                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838791   | Always      | On         | On         | Denied                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838792   | Always      | On         | On         | Denied                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |


    @Android9_8_7_Signo_EnhancedTap_WF_8 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _TC-6838796   | Foreground  | On         | On         | Denied                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838794   | Foreground  | On         | On         | Denied                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838795   | Foreground  | On         | On         | Denied                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android9_8_7_Signo_EnhancedTap_WF_9 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _TC-6838799   | Unlocked    | On         | On         | Denied                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838797   | Unlocked    | On         | On         | Denied                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838798   | Unlocked    | On         | On         | Denied                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android9_8_7_Signo_EnhancedTap_WF_10 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _TC-6838802   | Always      | Off        | On         | Always                      | On              | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838800   | Always      | Off        | On         | Always                      | On              | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838801   | Always      | Off        | On         | Always                      | On              | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |

    @Android9_8_7_Signo_EnhancedTap_WF_11 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _TC-6838805   | Foreground  | Off        | On         | Denied                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838803   | Foreground  | Off        | On         | Denied                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838804   | Foreground  | Off        | On         | Denied                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

    @Android9_8_7_Signo_EnhancedTap_WF_12 @Android9_8_7_Signo_EnhancedTap
    Examples:
      | Reader_Name | Gesture_TC_ID | usage_state | BLE_status | NFC_status | NearByOrLocation_permission | location_status | device_state | display_status | app_state  | action_name | date  | message                     | robotic_arm_log | mobile_read    | reader_name |
      | Signo       | _TC-6838808   | Unlocked    | Off        | On         | Denied                      | Off             | Locked       | Off            | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838806   | Unlocked    | Off        | On         | Denied                      | Off             | Unlocked     | On             | Foreground | TAP         | TODAY | Successful NFC transaction. | TAP:ENABLE      | Mobile ID Read | FavR2       |
      | Signo       | _TC-6838807   | Unlocked    | Off        | On         | Denied                      | Off             | Unlocked     | On             | Background | TAP         | TODAY | Successful NFC transaction. | TAP:DISABLE     | Mobile ID Read | FavR2       |

