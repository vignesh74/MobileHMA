Feature: To Test Android Settings Scenario Workflow for HID mobile access application

  Background:To launch the HID app and navigate
    Given Launch HID Access Mobile Application in android device
#    When  Swipe EULA screen to left in android device
#    And   Get Invitation Code using Rest API when credential are assigned
#    And   Enter invitation code on HID mobile Application in android device
#    Then  Mobile IDs screen is displayed in android device
#    And   Notification screen is displayed with message "New Mobile ID Issued" in android device
#    And   Tap on the Mobile ID to check back of the card details
#    And   Notification screen is displayed with message "New Mobile ID Issued" in android device

  @ANDR_Settings_12_WF1 @ANDR_Settings_12_WF @ANDR_SmokeRun
  Scenario Outline:ANDR_12_Settings_WF1<TC_ID>: Verify that BLE status is <BLE_Status>, NFC status is <NFC_Status> and NearBy Permission is <NearBy_Permission>
    When Navigate to Settings and App Preferences screen in android device
    Then Bluetooth status is displayed as "<BLE_Status>" in android device
    And  NFC status is displayed as "<NFC_Status>" in android device
    When Set "NearBy" permission status as "<NearBy_Permission>" in android device
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
      | _TC-10 | Foreground  |
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
    And  Legal Screen is displayed in android device
    And  About Screen is displayed in android device
    And  Show Activity State status is displayed as "<Show_Activity_State>" in android device
    Then Report issue by entering text "Testing the application in automation" in android device
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
    And   Set "Location" permission status as "<NearByOrLocation_permission>" in android device

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
      | _TC-10 | Foreground  |
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
    Then Report issue by entering text "Testing automation TC" in android device
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
      | _TC-10 | Foreground  |
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

  @ANDR_Settings_9_8_7_WF4 @ANDR_Settings_9_8_7_WF
  Scenario Outline: ANDR_9_8_7_Settings_WF4<TC_ID>: Verify the page of ReportIssue, Legal, About, and Toggle button of DebugLogs and ShowActivity as Enable/Disable
    When Navigate to settings page in android device
    And  Legal Screen is displayed in android device
    And  About Screen is displayed in android device
    And  Show Activity State status is displayed as "<Show_Activity_State>" in android device
    And  Debug Logs status is displayed as "<Debug_Logs>" in android device

    Examples:
      | TC_ID  | Show_Activity_State | Debug_Logs     |
      | _TC-13 | Enable/Disable      | Enable/Disable |

  @ANDR_11_10_Settings_DebugLog_ReportIssue
  Scenario Outline: ANDR_11_10_Settings_DebugLog_ReportIssue<TC_ID>: Verify the page of Debug log and Report Issue
    When Navigate to Settings and App Preferences screen in android device
    And  Debug Logs status displayed as "<Debug_Logs>" in android device
    Then Report issue by entering text "Application is not working" in android device
    And Share the access logs
    Then Attachment will be displayed based on "<Debug_Logs>" in android device

    Examples:
      | TC_ID  | Debug_Logs |
      | _TC-01 | Enable     |
      | _TC-02 | Disable    |

  @ANDR_11_10_Settings_Deregister
  Scenario Outline: ANDR_11_10_Settings_Deregister<TC_ID>: Verify the Deregister in android device
    When Navigate to settings page in android device
    And Turn "<action>" the wifi
    And Click on the tab Deregister this device "<action>" in android device
    Then Verify the confirm button when deregister is "OFF" in android device

    Examples:
      | TC_ID  | action |
      | _TC-01 | OFF    |
      | _TC-02 | ON     |

  @ANDR_Settings_AboutPage
  Scenario: Verify About Page and its functionalities
    When Navigate to settings page in android device
    Then Verify About menu is displayed in android device
    And  About Screen is displayed in android device
    And Verify application information are displayed in android device
    Then Verify About Page contents are copied in android device
    And Copy image should turned to tick mark symbol and copied to clipboard toast in android device

  @ANDR_Settings_Notification
  Scenario Outline:ANDR_Settings_Notification<TC_ID>:Verify Notification screen and its functionalities in android device
    When Navigate to notification page in android device
    Then Verify the title of notification page in android device
    And  Verify Notification of "<Action>" issues and "<Notification>" in android device
    And Verify Notification Date in android device

    Examples:
      | TC_ID | Action  | Notification      |
      | _TC-1 | Suspend | Mobile ID Updated |
      | _TC-2 | Resumed | Mobile ID Updated |
      | _TC-3 | Revoked | Mobile ID Revoked |

  @ANDR_Settings_DeleteDevice
  Scenario:ANDR_9_8_7_Settings_WF6<TC_ID>:Verify Notification screen and its functionalities in android device
    When Navigate to notification page in android device
    And Verify the Delete device alert

  @ANDR_Settings_ShowActivity
  Scenario Outline: ANDR_11_10_Settings_ShowActivity<TC_ID>: Verify the tab of Show activity
    When Navigate to Settings and App Preferences screen in android device
    And  Show Activity State is displayed as "<Show_Activity>" in android device
    And Click on mobile ID tab in android device
    Then Activity will display in mobileID screen based on "<Show_Activity>" in android device

    Examples:
      | TC_ID  | Show_Activity |
      | _TC-01 | Enable        |
      | _TC-02 | Disable       |

  @ANDR_Settings_NearbyReader
  Scenario Outline: ANDR_11_10_Settings_NearbyReader<TC_ID>: Verify the nearby Reader section
    When Navigate to Settings and App Preferences screen in android device
    And NearBy Reader Status is displayed as "<NearByReader_Status>" in android device

    Examples:
      | TC_ID  | NearByReader_Status |
      | _TC-01 | On                  |
      | _TC-02 | Off                 |

    #This feature can be run with the debug enabled apk.
  @ANDR_Settings_FAQ
  Scenario Outline: ANDR_11_10_Settings_FAQ<TC_ID>: Verify the FAQ section
    When Navigate to settings page in android device
    Then Verify the FAQ Menu is displayed in android device
    And FAQ screen is displayed in android device
    And Enter "<input>" type on the search box in android device
    And Verify the "<input>" present on the screen in android device

    Examples:
      | TC_ID  | input     |
      | _TC-01 | bluetooth |
      | _TC-02 | invalid   |

  @ANDR_Settings_uninstallation
  Scenario: ANDR_11_10_Settings_installation<TC_ID>: Verify the Uninstall of app
    Given Launch HID Access Mobile Application in android device
    And uninstall the app in android device


  @ANDR_Settings_upgrade_production
  Scenario: ANDR_11_10_Settings_upgrade<TC_ID>: Verify the Upgrade in PlayStore
    And Navigate to notification page in android device
    And Verify new version available text in the notification screen in android device

  @ANDR_upgrade
  Scenario: ANDR_11_10_upgrade: Verify the upgrade of app
    When Navigate to Settings and App Preferences screen in android device
    And Note down the settings of application before upgrade in android device
    And Verify mobile about page information are displayed in android device
    And upgrade the new apk provided
    Given Launch HID Access Mobile Application in android device
    When Navigate to Settings and App Preferences screen in android device
    And Note down the App Preference information are same after the upgrade in android device
    And compare the app preference values in android device
    And Note down the About page information are same after the upgrade in android device
    And compare the about info values in android device

  @ANDR_Bluetooth_Sensitivity
  Scenario Outline: ANDR_11_10_Bluetooth_Sensitivity: Verify the Bluetooth sensitivity is "<BLE_Sensitivity>"
    When Navigate to Settings and App Preferences screen in android device
    And Verify Bluetooth Sensitivity menu is displayed in android device
    And Bluetooth Sensitivity Screen is displayed in android device
    Then Bluetooth Sensitivity status is displayed as "<BLE_Sensitivity>" and its "<Content>" in android device
    Examples:
      | TC_ID  | BLE_Sensitivity | Content                                                                                       |
      | _TC-01 | High            | Enhances BLE communication with the HID reader over longer distances                          |
      | _TC-02 | Medium          | The default option for optimal performance                                                    |
      | _TC-03 | Low             | Lowers BLE sensitivity, requiring the mobile device to be closer to the HID reader for access |

  @ANDR_OIP
  Scenario Outline:@ANDR_OIP: Verify the Origo Identity Positioning is "<OIP_Status>"
    When Navigate to Settings and App Preferences screen in android device
    And Identity Positioning status is displayed as "<OIP_Status>" in android device
    Then "<Pass_Status>" status is displayed on the pass in android device
    Examples:
      | TC_ID  | OIP_Status | Pass_Status |
      | _TC-01 | Enable     | Active      |
      | _TC-02 | Disable    | Not Active  |

#    *********************************** Code of Surrender Sundarraj Begins **************************************

  @ANDR_12_13_Settings_NearbyReader_WF1 @ANDR_12_13_Settings_NearbyReader_WF
  Scenario Outline: ANDR_12_13_Settings_NearbyReader<TC_ID>: Verify the nearby Reader section
    When Navigate to Settings and App Preferences screen in android device
    And NearBy Reader Status is displayed as "<NearByReader_Status>" in android device

    Examples:
      | TC_ID  | NearByReader_Status |
      | _TC-01 | On                  |
      | _TC-02 | Off                 |

  @ANDR_12_13_Settings_NearbyReader_WF2 @ANDR_12_13_Settings_NearbyReader_WF
  Scenario Outline: ANDR_12_13_Settings_NearbyReader<TC_ID>: Verify Enable Nearby Reader toggle button is enabled and Verify SE Reader enabled by Default
    When Navigate to Settings and App Preferences screen in android device
    And NearBy Reader Status is displayed as "<NearByReader_Status>" in android device
    And click on the Nearby Readers tab
    And Verify Discover Nearby Reader Element is displayed as Discover Nearby Readers in android device
    And Signo Reader Text is displayed as Signo Reader in android device
    And Verify Signo Reader Status is displayed as "<Signo Reader>" in android device
    Examples:
      | TC_ID | NearByReader_Status | Discover Nearby Readers | Signo Reader |
      | TC_01 | On                  | Signo Reader            | On           |


  @ANDR_12_13_Settings_NearbyReader_WF3 @ANDR_12_13_Settings_NearbyReader_WF
  Scenario Outline: ANDR_12_13_Settings_NearbyReader<TC_ID>: Verify SE Reader can be enabled when "Enable Nearby Reader" toggle button is enabled
    When Navigate to Settings and App Preferences screen in android device
    And NearBy Reader Status is displayed as "<NearByReader_Status>" in android device
    And click on the Nearby Readers tab
    And Verify Discover Nearby Reader Element is displayed as Discover Nearby Readers in android device
    And Signo Reader Text is displayed as Signo Reader in android device
    And Click on the RevE Reader checkbox
    And Verify RevE Reader Status is displayed as "<RevE Reader>" in android device
    Examples:
      | TC_ID | NearByReader_Status | RevE Reader |
      | TC_01 | On                  | On          |

  @ANDR_12_13_Settings_NearbyReader_WF4 @ANDR_12_13_Settings_NearbyReader_WF
  Scenario Outline: ANDR_12_13_Settings_NearbyReader<TC_ID>: Verify both HID Signo and SE Reader can be selected when "Enable Nearby Reader" toggle button is enabled
    When Navigate to Settings and App Preferences screen in android device
    And NearBy Reader Status is displayed as "<NearByReader_Status>" in android device
    And click on the Nearby Readers tab
    And Verify Discover Nearby Reader Element is displayed as Discover Nearby Readers in android device
    And Signo Reader Text is displayed as Signo Reader in android device
    And Verify RevE Reader Status is displayed as "<RevE Reader>" in android device
    And Verify Signo Reader Status is displayed as "<Signo Reader>" in android device
    Examples:
      | TC_ID | NearByReader_Status | RevE Reader | Signo Reader |
      | TC_01 | On                  | On          | On           |

  @ANDR_12_13_Settings_NearbyReader_WF5 @ANDR_12_13_Settings_NearbyReader_WF
  Scenario Outline:ANDR_12_13_Settings_NearbyReader<TC_ID>:Verify if a pop up is displayed if a specific reader type is disabled
    When Navigate to Settings and App Preferences screen in android device
    And NearBy Reader Status is displayed as "<NearByReader_Status>" in android device
    And click on the Nearby Readers tab
    And Verify Discover Nearby Reader Element is displayed as Discover Nearby Readers in android device
    And Signo Reader Text is displayed as Signo Reader in android device
    And Verify RevE Reader Status is displayed as "<RevE Reader>" in android device
    And Verify Signo Reader Status is displayed as "<Signo Reader>" in android device
    And Disable the RevE Reader checkbox
    And Verify alertTitle pop up is displayed in android device
    Examples:
      | TC_ID | NearByReader_Status | RevE Reader | Signo Reader |
      | TC_01 | On                  | On          | On           |

  @ANDR_12_13_Settings_NearbyReader_WF6 @ANDR_12_13_Settings_NearbyReader_WF
  Scenario Outline:ANDR_12_13_Settings_NearbyReader<TC_ID>:Verify If a pop up is displayed when both reader types are unselected indicating that "Enable Nearby Reader" toggle button will be disabled.
    When Navigate to Settings and App Preferences screen in android device
    And NearBy Reader Status is displayed as "<NearByReader_Status>" in android device
    And click on the Nearby Readers tab
    And Verify Discover Nearby Reader Element is displayed as Discover Nearby Readers in android device
    And Signo Reader Text is displayed as Signo Reader in android device
    And Verify RevE Reader Status is displayed as "<RevE Reader>" in android device
    And Verify Signo Reader Status is displayed as "<Signo Reader>" in android device
    And Disable the RevE Reader checkbox
    And Verify alertTitle pop up is displayed in android device
    And click on AlertPositiveBtn in android device
    And Disable the Signo Reader checkbox
    And click on AlertPositiveBtn in android device
    And Verify Enable Nearby Reader toggle button status in android device
    Examples:
      | TC_ID | NearByReader_Status | RevE Reader | Signo Reader |
      | TC_01 | On                  | On          | On           |


  @ANDR_12_13_Settings_NearbyReader_WF7 @ANDR_12_13_Settings_NearbyReader_WF
  Scenario Outline: Verify if HID Signo is set as default when "Enable Nearby Reader" toggle button is enabled again after disablement
    When Navigate to Settings and App Preferences screen in android device
    And NearBy Reader Status is displayed as "<NearByReader_Status>" in android device
    And click on the Nearby Readers tab
    And Verify Enable Nearby Reader toggle button status in android device
    And click on the Nearby Readers switch
    And Verify Enable Nearby Reader toggle button status in android device
    And Verify Discover Nearby Reader Element is displayed as Discover Nearby Readers in android device
    And Signo Reader Text is displayed as Signo Reader in android device
    And Verify Signo Reader Status is displayed as "<Signo Reader>" in android device
    Examples:
      | TC_ID | NearByReader_Status | Signo Reader |
      | TC_01 | Off                 | On           |


# ************************************************** Code of Surrender Sundarraj Ends **********************************************



