Feature: To Test Android Onboarding Screens and Terms Of Use Screen Scenario Workflow for HID mobile access application

  Background:To launch the HID Mobile Access application and navigate
    Given Launch HID Mobile Access Application Onboarding Screen in Android Device

  Scenario Outline:ANDR_Onboarding_WF1<TC_ID>:Verify that <Button> in Convenient Screen is displayed
    When Header and Description is displayed for Convenient Screen
    Then Terms of Use Page is displayed when "<Button>" is clicked in Convenient Screen
    @ANDR_Onboard_TermsOfUse_WF1 @ANDR_Onboard_TermsOfUse_WF
    Examples:
      | TC_ID | Button |
      | TC_01 | Skip   |

  Scenario Outline:ANDR_Onboarding_WF2<TC_ID>:Verify that <Button> in Twist&Go Screen is displayed
    When Header and Description is displayed for Convenient Screen
    And  Header and Description  is displayed for Twist&Go
    Then Favorite Reader Page is displayed when "<Button>" is clicked in Twist&Go Screen
    @ANDR_Onboard_TermsOfUse_WF2 @ANDR_Onboard_TermsOfUse_WF
    Examples:
      | TC_ID | Button |
      | TC_01 | Skip   |

  Scenario Outline:ANDR_Onboarding_WF3<TC_ID>:Verify that <Button> in Favorite Reader Screen is displayed
    When Header and Description is displayed for Convenient Screen
    And  Header and Description  is displayed for Twist&Go
    And  Header and Description is displayed for Favorite Reader Screen
    Then Terms of Use Page is displayed when "<Button>" is clicked in Favorite Reader Screen
    @ANDR_Onboard_TermsOfUse_WF3 @ANDR_Onboard_TermsOfUse_WF
    Examples:
      | TC_ID | Button      |
      | TC_01 | Get Started |

  Scenario Outline:ANDR_Terms_Of_Use_WF4<TC_ID>:Verify that <Button> in Terms of Use Page is enabled
    When Header and Description is displayed for Convenient Screen
    And  Skip is clicked
    And  Terms of Use Page is displayed
    Then "<Button>" in Terms Of Use Screen is clicked
    @ANDR_Onboard_TermsOfUse_WF4 @ANDR_Onboard_TermsOfUse_WF
    Examples:
      | TC_ID | Button |
      | TC_01 | Cancel |

  Scenario Outline:ANDR_Terms_Of_Use_WF5<TC_ID>:Verify that <Link> in Terms of Use Page is enabled
    When Header and Description is displayed for Convenient Screen
    And  Skip is clicked
    And  Terms of Use Page is displayed
    Then "<Link>" in Terms Of Use Page is clicked
    @ANDR_Onboard_TermsOfUse_WF5 @ANDR_Onboard_TermsOfUse_WF
    Examples:
      | TC_ID | Link                       |
      | TC_01 | End User License Agreement |
      | TC_02 | Privacy Notice             |

  Scenario Outline:ANDR_Terms_Of_Use_WF6<TC_ID>:Verify that <Link> in Terms of Use Page is clicked
    When Header and Description is displayed for Convenient Screen
    And  Skip is clicked
    And  Terms of Use Page is displayed
    And  Terms of Use Page Checkbox is checked
    Then "<Link>" in Terms Of Use  is clicked
    @ANDR_Onboard_TermsOfUse_WF6 @ANDR_Onboard_TermsOfUse_WF
    Examples:
      | TC_ID | Link     |
      | TC_01 | Continue |

