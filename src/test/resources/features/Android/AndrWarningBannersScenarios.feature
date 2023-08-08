Feature: To Test Android Warning Banners Scenario Workflow for HID mobile access application
  Background:To launch the HID Mobile Access application and navigate
    Given Launch HID Access Mobile Application in android device
    When  Swipe EULA screen to left in android device
    And   Get Invitation Code using Rest API when credential are assigned
    And   Enter invitation code on HID mobile Application in android device
    Then  Mobile IDs screen is displayed in android device with card and popup
    And   Notification screen is displayed with message "New Mobile ID Issued" in android device

#PLEASE DON'T RUN THE BELOW TESTCASES AS THEY ARE STILL IN DEVELOPMENTAL STAGE========================================================================================
  Scenario Outline:ANDR_11_10_WarningBanners_WF1<TC_ID>: Verify that BLE status is <BLE_Status>, NFC status is <NFC_Status>, Location is <Location_Status>,Location Permission is <Location_Permission>
    When Navigate to Settings and App Preferences screen in android device
    Then Bluetooth status is displayed as "<BLE_Status>" in android device
    And  NFC status is displayed as "<NFC_Status>" in android device
    And  Location Status is displayed as "<Location_Status>" in android device
    And  "Location" Permission status is displayed as "<Location_Permission>" in android device
    Then Warning BannersWF1 are displayed  in android device as "<BLE_Status>","<NFC_Status>","<Location_Status>","<Location_Permission>","<Warning_Banners1>"
    @ANDR_WarningBanners_11_WF1 @ANDR_WarningBanners_11_WF
    Examples:
      | TC_ID  | BLE_Status    | NFC_Status    | Location_Status    | Location_Permission               | Warning_Banners1                                    |
      | _TC-01 | Off           | Off           | Off                | Don't Allow                       | NFC Disabled_Location Permission_Bluetooth Disabled|
      | _TC-02 | Off           | Off           | Off                | Ask every time                    | NFC Disabled_Location Permission_Bluetooth Disabled|
      | _TC-03 | Off           | Off           | Off                | While Using the App               | NFC Disabled_GPS Disabled_Bluetooth Disabled       |
      | _TC-04 | Off           | Off           | Off                | Allow all the time                | NFC Disabled_GPS Disabled_Bluetooth Disabled       |


  Scenario Outline:ANDR_11_10_WarningBanners_WF2<TC_ID>: Verify that BLE status is <BLE_Status_Wb>, NFC status is <NFC_Status>, Location is <Location_Status>,Location Permission is <Location_Permission>
    When Navigate to Settings and App Preferences screen in android device
    Then Bluetooth status for Warning Banners is displayed as "<BLE_Status_Wb>" in android device
    And  NFC status for Warning Banners is displayed as "<NFC_Status_Wb>" in android device
    And  Location Status for Warning Banners is displayed as "<Location_Status_Wb>" in android device
    And  "Location" Permission status for Warning Banners is displayed as "<Location_Permission_Wb>" in android device
    Then Warning BannersWF2 are displayed in android device
    @ANDR_WarningBanners_11_WF2 @ANDR_WarningBanners_11_WF
    Examples:
       | TC_ID  | BLE_Status_Wb | NFC_Status_Wb | Location_Status_Wb | Location_Permission_Wb            | Warning_Banners2                                    |
       | _TC-01 | Off           | Off           | Off                | Don't Allow                       | NFC Disabled,Location Permission,Bluetooth Disabled|
       | _TC-02 | Off           | Off           | Off                | Ask every time                    | NFC Disabled,Location Permission,Bluetooth Disabled|
       | _TC-03 | Off           | Off           | Off                | While Using the App               | NFC Disabled,GPS Disabled,Bluetooth Disabled       |
       | _TC-04 | Off           | Off           | Off                | Allow all the time                | NFC Disabled,GPS Disabled,Bluetooth Disabled       |
       | _TC-05 | Off           | On            | Off                | Don't Allow                       | Location Permission,Bluetooth Disabled             |
       | _TC-06 | Off           | On            | Off                | Ask every time                    | Location Permission,Bluetooth Disabled             |
       | _TC-07 | Off           | On            | Off                | While Using the App               | GPS Disabled,Bluetooth Disabled                    |
       | _TC-08 | Off           | On            | Off                | Allow all the time                | GPS Disabled,Bluetooth Disabled                    |
       | _TC-09 | On            | On            | Off                | Don't Allow                       | Location Permission                                |
       | _TC-10 | On            | On            | Off                | Ask every time                    | Location Permission                                |
       | _TC-11 | On            | On            | Off                | While Using the App               | GPS Disabled                                       |
       | _TC-12 | On            | On            | Off                | Allow all the time                | GPS Disabled                                       |
       | _TC-13 | On            | On            | On                 | Don't Allow                       | Location Permission                                |
       | _TC-14 | On            | On            | On                 | Ask every time                    | Location Permission                                |

#PLEASE DON'T RUN THE ABOVE TESTCASES AS THEY ARE STILL IN DEVELOPMENTAL STAGE=======================================================================================

  Scenario Outline:ANDR_12_WarningBanners_WF1<TC_ID>: Verify that BLE status is <BLE_Status>, NFC status is <NFC_Status>,Location Permission is <LocationPermOrNearbyPerm_Status>
    When Navigate to Settings and App Preferences screen in android device
    Then Bluetooth status is displayed as "<BLE_Status>" in android device
    And  NFC status is displayed as "<NFC_Status>" in android device
    And  Set "NearBy" permission status as "<LocationPermOrNearbyPerm_Status>" in android device
    Then Warning Banners are displayed  in android device
    @ANDR_WarningBanners_12_WF1 @ANDR_WarningBanners_12_WF
    Examples:
      | TC_ID  | BLE_Status    | NFC_Status     |   LocationPermOrNearbyPerm_Status     | Warning_Banners1                                          |
      | _TC-01 | Off           | Off            |    Allow                              | NFC Disabled_Bluetooth Disabled                           |
      | _TC-02 | Off           | Off            |    Don't allow                        | NFC Disabled_Bluetooth Disabled_Nearby Permission Disabled|
      | _TC-03 | Off           | On             |    Allow                              | Bluetooth Disabled                                        |
      | _TC-04 | On            | Off            |    Don't Allow                        | Nearby Permission Disabled,NFC Disabled                   |
      | _TC-05 | On            | On             |    Don't allow                        | Nearby Permission Disabled                                |
      | _TC-06 | On            | On             |    Allow                              |                                                           |


  Scenario Outline:ANDR_12_WarningBanners_WF2<TC_ID>: Verify that BLE status is <BLE_Status_Wb>, NFC status is <NFC_Status_Wb>,NearBy Permission is <LocationPermOrNearbyPerm_Status>
    When Navigate to Settings and App Preferences screen in android device
    Then Bluetooth status for Warning Banners is displayed as "<BLE_Status_Wb>" in android device
    And  NFC status for Warning Banners is displayed as "<NFC_Status_Wb>" in android device
    And  "NearBy" Permission status for Warning Banners is displayed as "<LocationPermOrNearbyPerm_Status_Wb>" in android device
    Then Warning Banners are displayed  in android device
    @ANDR_WarningBanners_12_WF2 @ANDR_WarningBanners_12_WF
    Examples:
      | TC_ID  | BLE_Status_Wb | NFC_Status_Wb | LocationPermOrNearbyPerm_Status_Wb      | Warning_Banners2                                               |
      | _TC-01 |Off            |Off            | Allow                                   |Bluetooth Disabled,NFC Disabled                                 |
      | _TC-02 |Off            |Off            | Don't allow                             |Bluetooth Disabled,NFC Disabled,Nearby Permission Disabled      |
      | _TC-03 |On             |Off            | Don't Allow                             |Nearby Permission Disabled,NFC Disabled                         |
      | _TC-04 |Off            |On             | Don't Allow                             |Nearby Permission Disabled,Bluetooth Disabled                   |
      | _TC-05 |On             |On             | Don't Allow                             |Nearby Permission Disabled                                      |
      | _TC-06 |On             |On             | Allow                                   |                                                                |

  Scenario Outline:ANDR_12_WarningBanners_WF3<TC_ID>: Verify that BLE status is <BLE_Status_Wb_Wf3>, NFC status is <NFC_Status_Wb_Wf3>,NearBy Permission is <LocationPermOrNearbyPerm_Status_Wf3>
    When Navigate to Settings and App Preferences screen in android device
    Then Bluetooth status for Warning Banners in Wf3 is displayed as "<BLE_Status_Wb_Wf3>" in android device
    And  NFC status for Warning Banners in Wf3 is displayed as "<NFC_Status_Wb_Wf3>" in android device
    And  "NearBy" Permission status for Warning Banners in Wf3 is displayed as "<LocationPermOrNearbyPerm_Status_Wb_Wf3>" in android device
    Then Warning Banners in Wf3 are displayed  in android device
    @ANDR_WarningBanners_12_WF3 @ANDR_WarningBanners_12_WF
    Examples:
      | TC_ID  | BLE_Status_Wb_Wf3 | NFC_Status_Wb_Wf3 | LocationPermOrNearbyPerm_Status_Wb_Wf3          | Warning_Banners3                                               |
      | _TC-01 |Off                |Off                | Allow                                           |Bluetooth Disabled,NFC Disabled                                 |
      | _TC-02 |Off                |Off                | Don't allow                                     |Bluetooth Disabled,NFC Disabled,Nearby Permission Disabled      |
      | _TC-03 |On                 |Off                | Don't Allow                                     |Nearby Permission Disabled,NFC Disabled                         |
      | _TC-04 |Off                |On                 | Don't Allow                                     |Nearby Permission Disabled,Bluetooth Disabled                   |
      | _TC-05 |On                 |On                 | Don't Allow                                     |Nearby Permission Disabled                                      |
      | _TC-06 |On                 |On                 | Allow                                           |                                                                |
