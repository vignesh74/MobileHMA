Feature: To Test Android Add MobileID Scenario Workflow for HID mobile access application

  Background:To launch the HID app and navigate to Mobile ID Screen
    Given Launch HID Access Mobile Application in android device

  @ANDR_12_Google_Wallet
  Scenario: ANDR_12_Google_Wallet<TC_ID>: Verify the redemption of Google Wallet Pass
    And Click on plus icon view the mobile ID screen in android device
    And Click on Enter invitation code tab in android device
    And Get Google Wallet issuance token using Rest API when credential are assigned
    And Turn "OFF" the wifi in android device
    Then click on enter button in android device
    Then click on cancel button in android device
    And Turn "ON" the wifi in android device
    Then click on enter button in android device
    And Turn "OFF" the wifi in android device
    And click on Add to Google Wallet button
    And Turn "ON" the wifi in android device
    Then click on OK button in android device
    And Turn "OFF" the wifi in android device
    And click on Accept and Continue button in android device
    And Turn "ON" the wifi in android device
    Then click on OK button in android device
    Then verify the activated card in Google Wallet
    Then verify the Google wallet card in MobileID's
    And verify device added information below view in google wallet in android device

  @ANDR_12_Google_Wallet_Card_Status
  Scenario: ANDR_12_Google_Wallet_Card_Status: Verify the card status of Google Wallet Pass
    And Click on plus icon view the mobile ID screen in android device
    And Click on Enter invitation code tab in android device
    And Get Google Wallet issuance token using Rest API when credential are assigned
    Then click on enter button in android device
    And click on Add to Google Wallet button
    Then verify the activated card in Google Wallet
    Then verify the Google wallet card in MobileID's
    And suspend the card via Rest API and check the card status over the card
    And Resume the card via Rest API and check the card status over the card
    And Revoke the card via Rest API and check the card status over the card

  @ANDR_12_Wallet_SSO
  Scenario:  ANDR_12_Wallet_SSO<TC_ID>: Verify the redemption of Google Wallet Pass using SSO
    And Click on plus icon view the mobile ID screen in android device
    And click on the SSO button
    And enter the email address to sign in
    And click on Add to Google Wallet button
    Then verify the activated card in Google Wallet
    Then verify the Google wallet card in MobileID's
    Then navigate back
    And Click on plus icon view the mobile ID screen in android device
    Then click on the signout button

  @ANDR_12_Wallet_SSO_user
  Scenario Outline:ANDR_12_Wallet_SSO<TC_ID>: Verify the redemption of Google Wallet Pass using SSO
    And Click on plus icon view the mobile ID screen in android device
    And click on the SSO button
    And enter the email address to sign in "<user>" and "<password>" and respective "<error>"

    Examples:
      | TC_ID | user                 | password    | error                        |
      | _TC-1 | vigneshhid@gmail.com | Welcome@123 | The requested user not found |
      | _TC-2 |                      |             |                              |

  @ANDR_12_Wallet_Removal
  Scenario: ANDR_12_Wallet_Removal: Verify the removal of Google Wallet Pass
    And Click on plus icon view the mobile ID screen in android device
    And Click on Enter invitation code tab in android device
    And Get Google Wallet issuance token using Rest API when credential are assigned
    Then click on enter button in android device
    And click on Add to Google Wallet button
    And click on Accept and Continue button in android device
    Then verify the activated card in Google Wallet
    Then verify the Google wallet card in MobileID's
    Then remove the card from the wallet app
    Given Launch HID Access Mobile Application in android device
    Then verify the absence of view in Google Wallet button

    @ANDR_12_Wallet_more
    Scenario: ANDR_12_Wallet_more: verify if more than one pass is added
      And Click on plus icon view the mobile ID screen in android device
      And Click on Enter invitation code tab in android device
      And Get Google Wallet issuance token using Rest API when credential are assigned
      Then click on enter button in android device
      And click on Add to Google Wallet button
      And click on Accept and Continue button in android device
      Then verify the activated card in Google Wallet
      Then verify the Google wallet card in MobileID's
      Then navigate back
      And Click on plus icon view the mobile ID screen in android device
      And Click on Enter invitation code tab in android device
      And Get Google Wallet issuance token using Rest API when credential are assigned
      Then click on enter button in android device
      Then verify that it cannot add more than one pass

  @ANDR_12_Wallet_card_No_DeRegister
  Scenario: ANDR_12_Wallet_card_status: verify the different status of the pass in Google Wallet
    And Click on plus icon view the mobile ID screen in android device
    And Click on Enter invitation code tab in android device
    And Get Google Wallet issuance token using Rest API when credential are assigned
    Then click on enter button in android device
    And click on Add to Google Wallet button
    And click on Accept and Continue button in android device
    Then verify the activated card in Google Wallet
    Then verify the Google wallet card in MobileID's
    Then navigate back
    When Navigate to settings page in android device
    And verify the absence of tab Deregister the device








