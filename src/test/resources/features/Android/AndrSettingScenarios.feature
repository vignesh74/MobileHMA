Feature: To Test Android Settings Scenario Workflow for HID mobile access application

  Background:To launch the HID app and navigate
    Given Launch HID Access Mobile Application in android device
#    When  Swipe EULA screen to left in android device
#    And   Get Invitation Code using Rest API when credential are assigned
#    And   Enter invitation code on HID mobile Application in android device
    Then  Mobile IDs screen is displayed in android device
#    And   Notification screen is displayed with message "New Mobile ID Issued" in android device

  @ANDR_Settings_12_WF1 @ANDR_Settings_12_WF @ANDR_SmokeRun
  Scenario Outline:ANDR_12_Settings_WF1<TC_ID>: Verify that BLE status is <BLE_Status>, NFC status is <NFC_Status> and NearBy Permission is <NearBy_Permission>
    When Navigate to Settings and App Preferences screen in android device
    Then Bluetooth status is displayed as "<BLE_Status>" in android device
    And  NFC status is displayed as "<NFC_Status>" in android device
    And  "NearBy" Permission status is displayed as "<NearBy_Permission>" in android device
    Examples:
      | TC_ID  | BLE_Status | NFC_Status | NearBy_Permission |
      | _TC-01 | On         | On         | Allow             |
      | _TC-02 | On         | Off        | Don't allow       |
      | _TC-03 | Off        | On         | Allow             |
      | _TC-04 | Off        | Off        | Don't allow       |
      | _TC-05 | On         | Off        | Allow             |
      | _TC-06 | On         | On         | Don't allow       |
      | _TC-07 | Off        | Off        | Allow             |
      | _TC-08 | Off        | On         | Don't allow       |

  @ANDR_Settings_12_WF2 @ANDR_Settings_12_WF @ANDR_SmokeRun
  Scenario Outline:ANDR_12_Settings_WF2<TC_ID>: Verify Usage State status is <Usage_State>
    When Navigate to Settings and App Preferences screen in android device
    Then Usage State status is displayed as "<Usage_State>" in android device
    Examples:
      | TC_ID  | Usage_State |
      | _TC-09 | Always      |
      | _TC-10 | Active      |
      | _TC-11 | Unlocked    |

  @ANDR_Settings_12_WF3 @ANDR_Settings_12_WF @ANDR_SmokeRun
  Scenario Outline:ANDR_12_Settings_WF3<TC_ID>: Verify toggle button Enable/Disable for PlaySound, Vibrate and TwistAndGo
    When Navigate to Settings and App Preferences screen in android device
    Then Play Sound status is displayed as "<Play_Sound_State>" in android device
    And  Vibrate status is displayed as "<Vibrate_State>" in android device
    And  Twist and Go status is displayed as "<Twist_And_Go>" in android device
    Examples:
      | TC_ID  | Play_Sound_State | Vibrate_State  | Twist_And_Go   |
      | _TC-12 | Disable/Enable   | Disable/Enable | Disable/Enable |

  @ANDR_Settings_12_WF4 @ANDR_Settings_12_WF @ANDR_SmokeRun
  Scenario Outline: ANDR_12_Settings_WF4<TC_ID>: Verify the page of ReportIssue, Legal, About, and Toggle button of DebugLogs and ShowActivity as Enable/Disable
    When Navigate to settings page in android device
    Then Report issue by entering text "Application is not working" in android device
    And  Legal Screen is displayed in android device
    And  About Screen is displayed in android device
    And  Show Activity State status is displayed as "<Show_Activity_State>" in android device
    And  Debug Logs status is displayed as "<Debug_Logs>" in android device

    Examples:
      | TC_ID  | Show_Activity_State | Debug_Logs     |
      | _TC-13 | Enable/Disable      | Enable/Disable |

  #android version 11 setting scenarios
  Scenario Outline:ANDR_11_10_Settings_WF1<TC_ID>: Verify that BLE status is <BLE_Status>, NFC status is <NFC_Status> and NearBy Permission is <NearBy_Permission>
    When Navigate to Settings and App Preferences screen in android device
    Then Bluetooth status is displayed as "<BLE_Status>" in android device
    And  NFC status is displayed as "<NFC_Status>" in android device
    And  Location Status is displayed as "<Location_Status>" in android device
    And  "Location" Permission status is displayed as "<Location_Permission>" in android device

    @ANDR_Settings_11_WF1 @ANDR_Settings_11_WF
    Examples:
      | TC_ID  | BLE_Status | NFC_Status | Location_Status | Location_Permission            |
      | _TC-01 | On         | On         | On              | Allow all the time             |
      | _TC-02 | On         | Off        | Off             | Allow only while using the app |
      | _TC-03 | Off        | On         | On              | Ask every time                 |
      | _TC-04 | Off        | Off        | Off             | Don't allow                    |
      | _TC-05 | On         | Off        | Off             | Allow all the time             |
      | _TC-06 | On         | On         | On              | Allow only while using the app |
      | _TC-07 | Off        | Off        | Off             | Ask every time                 |
      | _TC-08 | Off        | On         | On              | Don't allow                    |

    @ANDR_Settings_10_WF1 @ANDR_Settings_10_WF
    Examples:
      | TC_ID  | BLE_Status | NFC_Status | Location_Status | Location_Permission            |
      | _TC-01 | On         | On         | On              | Allow all the time             |
      | _TC-02 | On         | Off        | Off             | Allow only while using the app |
      | _TC-03 | Off        | On         | On              | Deny                           |
      | _TC-04 | Off        | Off        | Off             | Allow all the time             |
      | _TC-05 | On         | Off        | Off             | Allow only while using the app |
      | _TC-06 | On         | On         | On              | Deny                           |
      | _TC-07 | Off        | Off        | Off             | Allow all the time             |
      | _TC-08 | Off        | On         | On              | Allow only while using the app |


  Scenario Outline:ANDR_11_10_Settings_WF2<TC_ID>: Verify Usage State status is <Usage_State>
    When Navigate to Settings and App Preferences screen in android device
    Then Usage State status is displayed as "<Usage_State>" in android device

    @ANDR_Settings_11_WF2 @ANDR_Settings_11_WF @ANDR_Settings_10_WF2 @ANDR_Settings_10_WF
    Examples:
      | TC_ID  | Usage_State |
      | _TC-09 | Always      |
      | _TC-10 | Active      |
      | _TC-11 | Unlocked    |


  Scenario Outline:ANDR_11_10_Settings_WF3<TC_ID>: Verify toggle button Enable/Disable for PlaySound, Vibrate and TwistAndGo
    When Navigate to Settings and App Preferences screen in android device
    Then Play Sound status is displayed as "<Play_Sound_State>" in android device
    And  Vibrate status is displayed as "<Vibrate_State>" in android device
    And  Twist and Go status is displayed as "<Twist_And_Go>" in android device

    @ANDR_Settings_11_WF3 @ANDR_Settings_11_WF @ANDR_Settings_10_WF3 @ANDR_Settings_10_WF
    Examples:
      | TC_ID  | Play_Sound_State | Vibrate_State  | Twist_And_Go   |
      | _TC-12 | Disable/Enable   | Disable/Enable | Disable/Enable |


  Scenario Outline: ANDR_11_10_Settings_WF4<TC_ID>: Verify the page of ReportIssue, Legal, About, and Toggle button of DebugLogs and ShowActivity as Enable/Disable
    When Navigate to settings page in android device
    Then Report issue by entering text "Application is not working" in android device
    And  Legal Screen is displayed in android device
    And  About Screen is displayed in android device
    And  Show Activity State status is displayed as "<Show_Activity_State>" in android device
    And  Debug Logs status is displayed as "<Debug_Logs>" in android device

    @ANDR_Settings_11_WF4 @ANDR_Settings_11_WF @ANDR_Settings_10_WF2 @ANDR_Settings_10_WF
    Examples:
      | TC_ID  | Show_Activity_State | Debug_Logs     |
      | _TC-13 | Enable/Disable      | Enable/Disable |


  Scenario Outline:ANDR_9_8_7_Settings_WF1<TC_ID>: Verify that BLE status is <BLE_Status>, NFC status is <NFC_Status> and NearBy Permission is <NearBy_Permission>
    When Navigate to Settings and App Preferences screen in android device
    Then Bluetooth status is displayed as "<BLE_Status>" in android device
    And  NFC status is displayed as "<NFC_Status>" in android device
    And  Location Status is displayed as "<Location_Status>" in android device
    And  "Location" Permission status is displayed as "<Location_Permission>" in android device

    @ANDR_Settings_9_8_7_WF1 @ANDR_Settings_9_8_7_WF
    Examples:
      | TC_ID  | BLE_Status | NFC_Status | Location_Status | Location_Permission |
      | _TC-01 | On         | On         | On              | Always              |
      | _TC-02 | On         | Off        | Off             | Denied              |
      | _TC-03 | Off        | On         | On              | Always              |
      | _TC-04 | Off        | Off        | Off             | Denied              |
      | _TC-05 | On         | Off        | Off             | Always              |
      | _TC-06 | On         | On         | On              | Denied              |
      | _TC-07 | Off        | Off        | Off             | Always              |
      | _TC-08 | Off        | On         | On              | Denied              |

  Scenario Outline:ANDR_9_8_7_Settings_WF2<TC_ID>: Verify Usage State status is <Usage_State>
    When Navigate to Settings and App Preferences screen in android device
    Then Usage State status is displayed as "<Usage_State>" in android device
    @ANDR_Settings_9_8_7_WF2 @ANDR_Settings_9_8_7_WF
    Examples:
      | TC_ID  | Usage_State |
      | _TC-09 | Always      |
      | _TC-10 | Active      |
      | _TC-11 | Unlocked    |

  Scenario Outline:ANDR_9_8_7_Settings_WF3<TC_ID>: Verify toggle button Enable/Disable for PlaySound, Vibrate and TwistAndGo
    When Navigate to Settings and App Preferences screen in android device
    Then Play Sound status is displayed as "<Play_Sound_State>" in android device
    And  Vibrate status is displayed as "<Vibrate_State>" in android device
    And  Twist and Go status is displayed as "<Twist_And_Go>" in android device
    @ANDR_Settings_9_8_7_WF3 @ANDR_Settings_9_8_7_WF
    Examples:
      | TC_ID  | Play_Sound_State | Vibrate_State  | Twist_And_Go   |
      | _TC-12 | Disable/Enable   | Disable/Enable | Disable/Enable |


  Scenario Outline: ANDR_9_8_7_Settings_WF4<TC_ID>: Verify the page of ReportIssue, Legal, About, and Toggle button of DebugLogs and ShowActivity as Enable/Disable
    When Navigate to settings page in android device
    Then Report issue by entering text "Application is not working" in android device
    And  Legal Screen is displayed in android device
    And  About Screen is displayed in android device
    And  Show Activity State status is displayed as "<Show_Activity_State>" in android device
    And  Debug Logs status is displayed as "<Debug_Logs>" in android device

    @ANDR_Settings_9_8_7_WF4 @ANDR_Settings_9_8_7_WF
    Examples:
      | TC_ID  | Show_Activity_State | Debug_Logs     |
      | _TC-13 | Enable/Disable      | Enable/Disable |


