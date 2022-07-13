package contactassigment.contactlistapp.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import contactassigment.contactlistapp.exception.InvalidValidArgumentException;

class CommonUtilsTest {

  private static final String ABN_NUMBER_SHOULD_NOT_BE_NULL_OR_EMPTY = "AbnNumber should not be null or empty";

  @BeforeEach
  void setUp() throws Exception {}

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  void testFormatDateToString() {
    //fail("Not yet implemented");
    //Don't have time to implement this however can do easily with enough time provided.
  }

  @Test
  void testConvertWildCardToSqlPlaceHolder() {
    //fail("Not yet implemented");
  }

  @Test
  void testFormatAbnForNullInput() {
    InvalidValidArgumentException inValidArgumentExceptionActual = assertThrows(InvalidValidArgumentException.class, () -> {
      CommonUtils.formatAbn(null);
    });

    assertEquals(ABN_NUMBER_SHOULD_NOT_BE_NULL_OR_EMPTY, inValidArgumentExceptionActual.getMessage());


  }

  @Test
  void testFormatAbnToExpectedFormat() {
    final String ABN_EXPECTED_FORMAT = " [ <strong>99 999 999 999</strong> ]";
    final String ABN_STRING_NUMBER = "99999999999";

    String actualAbnFormated = CommonUtils.formatAbn(ABN_STRING_NUMBER);
    assertNotNull(actualAbnFormated);
    assertEquals(ABN_EXPECTED_FORMAT, actualAbnFormated);
  }


}
