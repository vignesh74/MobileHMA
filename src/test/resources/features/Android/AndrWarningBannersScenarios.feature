Feature: To Test Android Warning Banners Scenario Workflow for HID mobile access application

  Background:To launch the HID Mobile Access application and navigate
    Given Launch HID Access Mobile Application in android device
#    When  Swipe EULA screen to left in android device
#    And   Get Invitation Code using Rest API when credential are assigned
#    And   Enter invitation code on HID mobile Application in android device
#    Then  Mobile IDs screen is displayed in android device with card and popup
#    And   Notification screen is displayed with message "New Mobile ID Issued" in android device


  Scenario Outline:ANDR_11_10_WarningBanners_WF1<TC_ID>: Verify that BLE status is <BLE_Status>, Location is <Location_Status>,Location Permission is <Location_Permission>
    When Navigate to Settings and App Preferences screen in android device
    Then Bluetooth status is displayed as "<BLE_Status>" in android device
    And  Location Status is displayed as "<Location_Status>" in android device
    And  "Location" Permission status is displayed as "<Location_Permission>" in android device
    Then Warning Banners are displayed  in android device
#    Then Warning Banners are displayed  in android device "<BLE_Status>" "<Location_Status>" "<Location_Permission>"
    @ANDR_WarningBanners_11_WF1 @ANDR_WarningBanners_11_WF
    Examples:
      | TC_ID  | BLE_Status | Location_Status | Location_Permission | Warning_Banners1                       |
      | _TC-01 | Off        | Off             | Don't Allow         | Location Permission_Bluetooth Disabled |
#      | _TC-02 | Off           | Off                | Ask every time                    | Location Permission_Bluetooth Disabled|
#      | _TC-03 | Off           | Off                | While Using the App               | GPS Disabled_Bluetooth Disabled       |
#      | _TC-04 | Off           | Off                | Allow all the time                | GPS Disabled_Bluetooth Disabled       |
#      | _TC-05 | Off           | On                 | Don't Allow                       | Location Permission_Bluetooth Disabled|
#      | _TC-06 | Off           | On                 | Ask every time                    | Location Permission_Bluetooth Disabled|
#      | _TC-07 | Off           | On                 | While Using the App               | Bluetooth Disabled                    |
#      | _TC-08 | Off           | On                 | Allow all the time                | Bluetooth Disabled                    |
#      | _TC-09 | On            | Off                | Don't Allow                       | Location Permission                   |
#      | _TC-10 | On            | Off                | Ask every time                    | Location Permission                   |
#      | _TC-11 | On            | Off                | While Using the App               | GPS Disabled                          |
#      | _TC-12 | On            | Off                | Allow all the time                | GPS Disabled                          |
#      | _TC-13 | On            | On                 | Don't Allow                       | Location Permission                   |
#      | _TC-14 | On            | On                 | Ask every time                    | Location Permission                   |
#      | _TC-15 | On            | On                 | While Using the App               |                                       |
#      | _TC-16 | On            | On                 | Allow all the time                |                                       |


  Scenario Outline:ANDR_11_10_WarningBanners_WF2<TC_ID>: Verify that BLE status is <BLE_Status_Wb>, Location is <Location_Status_Wb>,Location Permission is <LocationPermOrNearbyPerm_Status_Wb>
    When Navigate to Settings and App Preferences screen in android device
    Then Bluetooth status for Warning Banners is displayed as "<BLE_Status_Wb>" in android device
    And  Location Status for Warning Banners is displayed as "<Location_Status_Wb>" in android device
    And  "Location" Permission status for Warning Banners is displayed as "<LocationPermOrNearbyPerm_Status_Wb>" in android device
    Then Warning Banners are displayed  in android device
    @ANDR_WarningBanners_11_WF2 @ANDR_WarningBanners_11_WF
    Examples:
      | TC_ID  | BLE_Status_Wb | Location_Status_Wb | LocationPermOrNearbyPerm_Status_Wb | Warning_Banners1                       |
      | _TC-01 | Off           | Off                | Don't Allow                        | Location Permission_Bluetooth Disabled |
      | _TC-02 | Off           | Off                | Ask every time                     | Location Permission_Bluetooth Disabled |
      | _TC-03 | Off           | Off                | While Using the App                | GPS Disabled_Bluetooth Disabled        |
      | _TC-04 | Off           | Off                | Allow all the time                 | GPS Disabled_Bluetooth Disabled        |
      | _TC-05 | Off           | On                 | Don't Allow                        | Location Permission_Bluetooth Disabled |
      | _TC-06 | Off           | On                 | Ask every time                     | Location Permission_Bluetooth Disabled |
      | _TC-07 | Off           | On                 | While Using the App                | Bluetooth Disabled                     |
      | _TC-08 | Off           | On                 | Allow all the time                 | Bluetooth Disabled                     |
      | _TC-09 | On            | Off                | Don't Allow                        | Location Permission                    |
      | _TC-10 | On            | Off                | Ask every time                     | Location Permission                    |
      | _TC-11 | On            | Off                | While Using the App                | GPS Disabled                           |
      | _TC-12 | On            | Off                | Allow all the time                 | GPS Disabled                           |
      | _TC-13 | On            | On                 | Don't Allow                        | Location Permission                    |
      | _TC-14 | On            | On                 | Ask every time                     | Location Permission                    |
      | _TC-15 | On            | On                 | While Using the App                |                                        |
      | _TC-16 | On            | On                 | Allow all the time                 |                                        |

  Scenario Outline:ANDR_11_10_WarningBanners_WF3<TC_ID>: Verify that BLE status is <BLE_Status_Wb_Wf3>,Location is <Location_Status_Wb_Wf3>,Location Permission is <LocationPermOrNearbyPerm_Status_Wf3>
    When Navigate to Settings and App Preferences screen in android device
    Then Bluetooth status for Warning Banners in Wf3 is displayed as "<BLE_Status_Wb_Wf3>" in android device
    And  Location status for Warning Banners is displayed as "<Location_Status_Wb_Wf3>" in android device
    And  "Location" Permission status for Warning Banners in Wf3 is displayed as "<LocationPermOrNearbyPerm_Status_Wb_Wf3>" in android device
    Then Warning Banners in Wf3 are displayed  in android device
    @ANDR_WarningBanners_11_WF3 @ANDR_WarningBanners_11_WF
    Examples:
      | TC_ID  | BLE_Status_Wb_Wf3 | Location_Status_Wb_Wf3 | LocationPermOrNearbyPerm_Status_Wb_Wf3 | Warning_Banners1                       |
      | _TC-01 | Off               | Off                    | Don't Allow                            | Location Permission_Bluetooth Disabled |
      | _TC-02 | Off               | Off                    | Ask every time                         | Location Permission_Bluetooth Disabled |
      | _TC-03 | Off               | Off                    | While Using the App                    | GPS Disabled_Bluetooth Disabled        |
      | _TC-04 | Off               | Off                    | Allow all the time                     | GPS Disabled_Bluetooth Disabled        |
      | _TC-05 | Off               | On                     | Don't Allow                            | Location Permission_Bluetooth Disabled |
      | _TC-06 | Off               | On                     | Ask every time                         | Location Permission_Bluetooth Disabled |
      | _TC-07 | Off               | On                     | While Using the App                    | Bluetooth Disabled                     |
      | _TC-08 | Off               | On                     | Allow all the time                     | Bluetooth Disabled                     |
      | _TC-09 | On                | Off                    | Don't Allow                            | Location Permission                    |
      | _TC-10 | On                | Off                    | Ask every time                         | Location Permission                    |
      | _TC-11 | On                | Off                    | While Using the App                    | GPS Disabled                           |
      | _TC-12 | On                | Off                    | Allow all the time                     | GPS Disabled                           |
      | _TC-13 | On                | On                     | Don't Allow                            | Location Permission                    |
      | _TC-14 | On                | On                     | Ask every time                         | Location Permission                    |
      | _TC-15 | On                | On                     | While Using the App                    |                                        |
      | _TC-16 | On                | On                     | Allow all the time                     |                                        |

  @ANDR_WarningBanners_12_WF1 @ANDR_WarningBanners_12_WF
  Scenario Outline:ANDR_12_WarningBanners_WF1<TC_ID>: Verify that BLE status is <BLE_Status>, NFC status is <NFC_Status>,Location Permission is <LocationPermOrNearbyPerm_Status>
    When Navigate to Settings and App Preferences screen in android device
    Then Bluetooth status is displayed as "<BLE_Status>" in android device
    And  NFC status is displayed as "<NFC_Status>" in android device
    And  Set "NearBy" permission status as "<LocationPermOrNearbyPerm_Status>" in android device
    Then Warning Banners are displayed  in android device

    Examples:
      | TC_ID  | BLE_Status | NFC_Status | LocationPermOrNearbyPerm_Status | Warning_Banners1                                           |
      | _TC-01 | Off        | Off        | Allow                           | NFC Disabled_Bluetooth Disabled                            |
      | _TC-02 | Off        | Off        | Don't allow                     | NFC Disabled_Bluetooth Disabled_Nearby Permission Disabled |
      | _TC-03 | Off        | On         | Allow                           | Bluetooth Disabled                                         |
      | _TC-04 | On         | Off        | Don't Allow                     | Nearby Permission Disabled,NFC Disabled                    |
      | _TC-05 | On         | On         | Don't allow                     | Nearby Permission Disabled                                 |
      | _TC-06 | On         | On         | Allow                           |                                                            |


  Scenario Outline:ANDR_12_WarningBanners_WF2<TC_ID>: Verify that BLE status is <BLE_Status_Wb>, NFC status is <NFC_Status_Wb>,NearBy Permission is <LocationPermOrNearbyPerm_Status>
    When Navigate to Settings and App Preferences screen in android device
    Then Bluetooth status for Warning Banners is displayed as "<BLE_Status_Wb>" in android device
    And  NFC status for Warning Banners is displayed as "<NFC_Status_Wb>" in android device
    And  "NearBy" Permission status for Warning Banners is displayed as "<LocationPermOrNearbyPerm_Status_Wb>" in android device
    Then Warning Banners are displayed  in android device

    @ANDR_WarningBanners_12_WF2 @ANDR_WarningBanners_12_WF
    Examples:
      | TC_ID  | BLE_Status_Wb | NFC_Status_Wb | LocationPermOrNearbyPerm_Status_Wb | Warning_Banners2                                           |
      | _TC-01 | Off           | Off           | Allow                              | Bluetooth Disabled,NFC Disabled                            |
      | _TC-02 | Off           | Off           | Don't allow                        | Bluetooth Disabled,NFC Disabled,Nearby Permission Disabled |
      | _TC-03 | On            | Off           | Don't Allow                        | Nearby Permission Disabled,NFC Disabled                    |
      | _TC-04 | Off           | On            | Don't Allow                        | Nearby Permission Disabled,Bluetooth Disabled              |
      | _TC-05 | On            | On            | Don't Allow                        | Nearby Permission Disabled                                 |
      | _TC-06 | On            | On            | Allow                              |                                                            |

  Scenario Outline:ANDR_12_WarningBanners_WF3<TC_ID>: Verify that BLE status is <BLE_Status_Wb_Wf3>, NFC status is <NFC_Status_Wb_Wf3>,NearBy Permission is <LocationPermOrNearbyPerm_Status_Wf3>
    When Navigate to Settings and App Preferences screen in android device
    Then Bluetooth status for Warning Banners in Wf3 is displayed as "<BLE_Status_Wb_Wf3>" in android device
    And  NFC status for Warning Banners in Wf3 is displayed as "<NFC_Status_Wb_Wf3>" in android device
    And  "NearBy" Permission status for Warning Banners in Wf3 is displayed as "<LocationPermOrNearbyPerm_Status_Wb_Wf3>" in android device
    Then Warning Banners in Wf3 are displayed  in android device
    @ANDR_WarningBanners_12_WF3 @ANDR_WarningBanners_12_WF
    Examples:
      | TC_ID  | BLE_Status_Wb_Wf3 | NFC_Status_Wb_Wf3 | LocationPermOrNearbyPerm_Status_Wb_Wf3 | Warning_Banners3                                           |
      | _TC-01 | Off               | Off               | Allow                                  | Bluetooth Disabled,NFC Disabled                            |
      | _TC-02 | Off               | Off               | Don't allow                            | Bluetooth Disabled,NFC Disabled,Nearby Permission Disabled |
      | _TC-03 | On                | Off               | Don't Allow                            | Nearby Permission Disabled,NFC Disabled                    |
      | _TC-04 | Off               | On                | Don't Allow                            | Nearby Permission Disabled,Bluetooth Disabled              |
      | _TC-05 | On                | On                | Don't Allow                            | Nearby Permission Disabled                                 |
      | _TC-06 | On                | On                | Allow                                  |                                                            |

  @ANDR_11_10_WarningBanners @ANDR_WarningBanners_11_WF
  Scenario Outline:ANDR_11_10_WarningBanners<TC_ID>: Verify that BLE status is <BLE_Status>, Location is <Location_Status>,Location Permission is <Location_Permission>
    When Navigate to Settings and App Preferences screen in android device
    Then Bluetooth status is displayed as "<BLE_Status>" in android device
    And  NFC status is displayed as "<NFC_Status>" in android device
    And  Location Status is displayed as "<Location_Status>" in android device
    And  "Location" Permission status is displayed as "<Location_Permission>" in android device
    Then Warning Banners are displayed "<Warning_Banners>" in android device with "<BLE_Status>" "<NFC_Status>" "<Location_Status>" "<Location_Permission>"

    Examples:
      | TC_ID  | BLE_Status | NFC_Status | Location_Status | Location_Permission            | Warning_Banners                                      |
      | _TC-01 | Off        | Off        | Off             | Don't allow                    | NFC Disabled&Location Permission&Bluetooth Disabled  |
      | _TC-02 | Off        | Off        | Off             | Ask every time                 | NFC Disabled&Location Permission&Bluetooth Disabled  |
      | _TC-03 | Off        | Off        | Off             | Allow only while using the app | NFC Disabled&Location Permission&Bluetooth Disabled  |
      | _TC-04 | Off        | Off        | Off             | Allow all the time             | NFC Disabled&Location Permission&Bluetooth Disabled  |
      | _TC-05 | On         | Off        | Off             | Don't allow                    | NFC Disabled	 Location Permission                    |
      | _TC-06 | On         | Off        | Off             | Ask every time                 | NFC Disabled  Location Permission                    |
      | _TC-07 | On         | Off        | Off             | Allow only while using the app | NFC Disabled	 Location Permission                    |
      | _TC-08 | On         | Off        | Off             | Allow all the time             | NFC Disabled	 GPS Disabled                           |
      | _TC-09 | Off        | On         | Off             | Don't allow                    | Location Permission Bluetooth Disabled               |
      | _TC-10 | Off        | On         | Off             | Ask every time                 | Location Permission Bluetooth Disabled               |
      | _TC-11 | Off        | On         | Off             | Allow only while using the app | Location Permission Bluetooth Disabled               |
      | _TC-12 | Off        | On         | Off             | Allow all the time             | Location Permission Bluetooth Disabled               |
      | _TC-13 | Off        | On         | On              | Don't allow                    | Location Permission Bluetooth Disabled               |
      | _TC-14 | Off        | On         | On              | Ask every time                 | Location Permission Bluetooth Disabled               |
      | _TC-15 | Off        | On         | On              | Allow only while using the app | Bluetooth Disabled                                   |
      | _TC-16 | Off        | On         | On              | Allow all the time             | Bluetooth Disabled                                   |
      | _TC-17 | Off        | Off        | On              | Don't allow                    | NFC Disabled	 Location Permission Bluetooth Disabled |
      | _TC-18 | Off        | Off        | On              | Ask every time                 | NFC Disabled	 Location Permission Bluetooth Disabled |
      | _TC-19 | Off        | Off        | On              | Allow only while using the app | NFC Disabled	 Bluetooth Disabled                     |
      | _TC-20 | Off        | Off        | On              | Allow all the time             | NFC Disabled	 Bluetooth Disabled                     |
      | _TC-21 | On         | Off        | On              | Don't allow                    | NFC Disabled                                         |
      | _TC-22 | On         | Off        | On              | Ask every time                 | NFC Disabled                                         |
      | _TC-23 | On         | Off        | On              | Allow only while using the app | NFC Disabled                                         |
      | _TC-24 | On         | Off        | On              | Allow all the time             | NFC Disabled                                         |
      | _TC-25 | On         | On         | Off             | Don't allow                    | GPS Disabled                                         |
      | _TC-26 | On         | On         | Off             | Ask every time                 | GPS Disabled                                         |
      | _TC-27 | On         | On         | Off             | Allow only while using the app | GPS Disabled                                         |
      | _TC-28 | On         | On         | Off             | Allow all the time             | GPS Disabled                                         |
      | _TC-29 | On         | On         | On              | Don't allow                    |                                                      |
      | _TC-30 | On         | On         | On              | Ask every time                 |                                                      |
      | _TC-31 | On         | On         | On              | Allow only while using the app |                                                      |
      | _TC-32 | On         | On         | On              | Allow all the time             |                                                      |

  @ANDR_12_WarningBanners @ANDR_WarningBanners_12
  Scenario Outline:ANDR_12_WarningBanners_WF5<TC_ID>: Verify that BLE status is <BLE_Status>and nearBy location <Location_Permission>
    When Navigate to Settings and App Preferences screen in android device
    Then Bluetooth status is displayed as "<BLE_Status>" in android device
    And  "NearBy" Permission status is displayed as "<NearBy_Permission>" in android device
    Then Warning Banners are displayed "<Warning_Banners>" in android device with "<BLE_Status>" "<Nearby_Permission>"
    Examples:
      | TC_ID  | BLE_Status | NearBy_Permission | Warning_Banners                               |
      | _TC-01 | Off        | Allow             | Bluetooth Disabled                            |
      | _TC-02 | Off        | Don't Allow       | Bluetooth Disabled&Nearby permission Disabled |
      | _TC-05 | On         | Allow             | ccc                                           |
      | _TC-06 | On         | Don't Allow       | Nearby permission Disabled                    |

  @ANDR_7_8_9_WarningBanners @ANDR_WarningBanners
  Scenario Outline:@ANDR_7_8_9_WarningBanners<TC_ID>: Verify that BLE status is <BLE_Status>, Location is <Location_Status>,Location Permission is <Location_Permission>
    When Navigate to Settings and App Preferences screen in android device
#    Then Bluetooth status is displayed as "<BLE_Status>" in android device
#    And  Location Status is displayed as "<Location_Status>" in android device
    And  "Location" Permission status is displayed as "<Location_Permission>" in android device
#    Then Warning Banners are displayed "<Warning_Banners>" in android device with "<BLE_Status>" "<Location_Status>" "<Location_Permission>"

    Examples:
      | TC_ID  | BLE_Status | Location_Status | Location_Permission | Warning_Banners     |
      | _TC-01 | Off        | Off             | Always              | GPS Disabled&Bluetooth Disabled |
      | _TC-02 | Off        | Off             | Denied              | Location Permission&Bluetooth Disabled |
      | _TC-05 | On         | Off             | Always              | GPS Disabled                   |
      | _TC-06 | On         | Off             | Denied              | Location Permission |
      | _TC-09 | Off        | On              | Always              | Bluetooth Disabled              |
      | _TC-10 | Off        | On              | Denied              | Location Permission&Bluetooth Disabled              |
      | _TC-25 | On         | On              | Always              | GPS Disabled                                        |
      | _TC-26 | On         | On              | Denied              | No                                        |

  @ANDR_13_WarningBanners
  Scenario Outline:ANDR_13_WarningBanners<TC_ID>: Verify that BLE status is <BLE_Status>, NFC status is <NFC_Status>,NearBy Permission is <NearBy_Permission>
    When Navigate to Settings and App Preferences screen in android device
    Then Bluetooth status is displayed as "<BLE_Status>" in android device
    And  NFC status is displayed as "<NFC_Status>" in android device
    And  "NearBy" Permission status is displayed as "<NearBy_Permission>" in android device
    Then Warning Banners are displayed as "<Warning_Banners>" in android device with "<BLE_Status>" "<NFC_Status>" "<NearBy_Permission>"

    Examples:
      | TC_ID  | BLE_Status | NFC_Status | NearBy_Permission | Warning_Banners                                            |
      | _TC-01 | Off        | Off        | Allow             | Bluetooth Disabled,NFC Disabled                            |
      | _TC-02 | Off        | Off        | Don't allow       | Bluetooth Disabled,NFC Disabled,Nearby Permission Disabled |
      | _TC-03 | On         | Off        | Allow             | NFC Disabled                                               |
      | _TC-04 | On         | Off        | Don't Allow       | Nearby Permission Disabled,NFC Disabled                    |
      | _TC-05 | Off        | On         | Allow             | Bluetooth Disabled                                         |
      | _TC-06 | Off        | On         | Don't Allow       | Nearby Permission Disabled,Bluetooth Disabled              |
      | _TC-07 | On         | On         | Allow             |                                                            |
      | _TC-08 | On         | On         | Don't Allow       | Nearby Permission Disabled                                 |

