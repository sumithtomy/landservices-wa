package contactassigment.contactlistapp.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import contactassigment.contactlistapp.domain.Contact;
import contactassigment.contactlistapp.domain.Organisation;
import contactassigment.contactlistapp.utils.CommonUtils;
import contactassigment.contactlistapp.utils.UtilityContants;

public class ContactDTO {

  private Integer id;

  private String firstName;

  private String lastName;

  private Date dateCreated;

  private OrganisationDTO organisation;



  public ContactDTO() {}

  public ContactDTO(Contact contact) {
    setId(contact.getId());
    setFirstName(contact.getFirstName());
    setLastName(contact.getLastName());
    setDateCreated(contact.getCreatedDate());

    Organisation org = contact.getOrganisation();
    if (org != null) {
      setOrganisation(new OrganisationDTO(contact.getOrganisation()));
    }
  }



  public static ContactDTO createBy(Contact contact) {
    return new ContactDTO(contact);
  }

  public static List<ContactDTO> createListBy(List<Contact> contacts) {
    List<ContactDTO> contactDTOs = new ArrayList<ContactDTO>(contacts.size());
    for (Contact c : contacts) {
      contactDTOs.add(ContactDTO.createBy(c));
    }
    return contactDTOs;
  }

  public String getCreatedDateTime() {


    return CommonUtils.formatDateToString(getDateCreated(), UtilityContants.GLOBAL_DATE_TIME_PATTERN);
  }

  public String getCreatedDate() {
    return CommonUtils.formatDateToString(getDateCreated(), UtilityContants.GLOBAL_DATE_PATTERN);
  }

  public Integer getId() {
    return id;
  }


  public OrganisationDTO getOrganisation() {
    return organisation;
  }

  public String getOrganisationInfo() {
    OrganisationDTO org = getOrganisation();
    if (org != null) {
      return formatOrganisationInfo(org);
    } else {
      return UtilityContants.EMPTY_STRING;
    }
  }

  /**
   * @param org
   * @return
   */
  private String formatOrganisationInfo(OrganisationDTO org) {
    StringBuilder orgInfoFormated = new StringBuilder();
    orgInfoFormated.append(UtilityContants.SPACE)
                   .append(org.getName())
                   .append(CommonUtils.formatAbn(org.getAbn()));
    return orgInfoFormated.toString();
  }

  public String getFullName() {
    StringBuilder fullname = new StringBuilder();
    return fullname.append(getFirstName())
                   .append(UtilityContants.SPACE)
                   .append(getLastName())
                   .toString();
  }

  public String getOrganisationName() {
    OrganisationDTO org = getOrganisation();
    if (org != null) {
      return org.getName();
    } else {
      return UtilityContants.EMPTY_STRING;
    }
  }

  public String getOrganisationAbn() {
    OrganisationDTO org = getOrganisation();
    if (org != null) {
      return CommonUtils.formatAbn(org.getAbn()).replace("[ <strong>", "").replace("</strong> ]", "");
    } else {
      return UtilityContants.EMPTY_STRING;
    }
  }


  public void setId(Integer id) {
    this.id = id;
  }

  public void setOrganisation(OrganisationDTO organisation) {
    this.organisation = organisation;
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

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }
}
