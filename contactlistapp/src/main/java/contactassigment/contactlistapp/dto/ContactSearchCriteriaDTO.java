package contactassigment.contactlistapp.dto;

import contactassigment.contactlistapp.utils.UtilityContants;

public class ContactSearchCriteriaDTO {


  private String firstName = UtilityContants.EMPTY_STRING;
  private String lastName = UtilityContants.EMPTY_STRING;
  private String organisationName = UtilityContants.EMPTY_STRING;


  public String getOrganisationName() {
    return organisationName;
  }

  public void setOrganisationName(String organisationName) {
    this.organisationName = organisationName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
