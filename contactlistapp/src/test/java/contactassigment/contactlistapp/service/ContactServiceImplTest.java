package contactassigment.contactlistapp.service;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import contactassigment.contactlistapp.domain.Contact;
import contactassigment.contactlistapp.domain.ContactRepository;
import contactassigment.contactlistapp.domain.OrganisationRepository;
import contactassigment.contactlistapp.dto.ContactDTO;
import contactassigment.contactlistapp.dto.ContactSearchCriteriaDTO;


@Extensions(@ExtendWith(MockitoExtension.class))
class ContactServiceImplTest {


  private static final String KLEIN = "Klein";

  private static final String SOPHIE = "Sophie";

  ContactService contactactService;

  @Mock
  ContactRepository contactRepoMock;

  @Mock
  OrganisationRepository organisationRepoMock;

  @BeforeEach
  void setUp() throws Exception {
    contactactService = new ContactServiceImpl(contactRepoMock,
        organisationRepoMock);


  }

  @AfterEach
  void tearDown() throws Exception {
    reset(organisationRepoMock);
    reset(organisationRepoMock);
    contactactService = null;
  }

  @Test
  void testListByCriteriaFetchOrganisation() {

    // Arrange
    ContactSearchCriteriaDTO criteria = new ContactSearchCriteriaDTO();
    criteria.setFirstName(SOPHIE);
    criteria.setLastName(KLEIN);
    List<Contact> contactList = new ArrayList<Contact>();
    Contact sophieContact = new Contact();
    Date currentDate = new Date(System.currentTimeMillis());
    sophieContact.setCreatedDate(currentDate);
    sophieContact.setFirstName(SOPHIE);
    sophieContact.setLastName(KLEIN);
    sophieContact.setId(Integer.valueOf(1));
    contactList.add(sophieContact);


    when(contactRepoMock.searchByNamesFetchOrganisation(any(), any(), any())).thenReturn(contactList);

    // Act
    List<ContactDTO> actualSelectionOfContacts = contactactService.listByCriteriaFetchOrganisation(criteria);

    // Assert

    verify(contactRepoMock, times(1)).searchByNamesFetchOrganisation(any(), any(), any());
    assertNotNull(actualSelectionOfContacts);
    assertEquals(contactList.size(), actualSelectionOfContacts.size());
    assertEquals(actualSelectionOfContacts.get(0)
                                          .getFirstName(),
        SOPHIE);
    assertEquals(actualSelectionOfContacts.get(0)
                                          .getLastName(),
        KLEIN);

  }

}
