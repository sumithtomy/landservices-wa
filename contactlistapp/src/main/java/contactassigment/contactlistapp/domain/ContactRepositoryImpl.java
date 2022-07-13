package contactassigment.contactlistapp.domain;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import contactassigment.contactlistapp.utils.CommonUtils;

public class ContactRepositoryImpl implements ContactRepositoryCustom {
  Logger logger = LoggerFactory.getLogger(ContactRepositoryImpl.class);

  @PersistenceContext
  EntityManager em;

  @Override
  public List<Contact> searchByNamesFetchOrganisation(
      String firstName,
      String lastName,
      String organisationName) {
    StringBuilder sbuilder = new StringBuilder("SELECT c FROM Contact c LEFT JOIN FETCH c.organisation o ");
    if (StringUtils.hasText(firstName)) {
      sbuilder.append("AND lower( c.firstName ) like :firstName ");
    }
    if (StringUtils.hasText(lastName)) {
      sbuilder.append("AND lower( c.lastName ) like :lastName ");
    }
    if (StringUtils.hasText(organisationName)) {
      sbuilder.append("AND lower( o.name ) like :organisationNamePattern ");
    }

    String queryHQL = sbuilder.toString()
                              .replaceFirst("AND", "WHERE")
                              .trim();
    logger.debug("Query HQL: " + queryHQL);
    TypedQuery<Contact> q = em.createQuery(queryHQL, Contact.class);

    if (StringUtils.hasText(firstName)) {
      q.setParameter("firstName", CommonUtils.convertWildCardToSqlPlaceHolder(firstName));
    }
    if (StringUtils.hasText(lastName)) {
      q.setParameter("lastName", CommonUtils.convertWildCardToSqlPlaceHolder(lastName));
    }
    if (StringUtils.hasText(organisationName)) {
      q.setParameter("organisationNamePattern", CommonUtils.convertWildCardToSqlPlaceHolder(organisationName));
    }

    return q.getResultList();
  }



}
