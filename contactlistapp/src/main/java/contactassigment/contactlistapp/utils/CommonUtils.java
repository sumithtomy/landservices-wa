package contactassigment.contactlistapp.utils;

import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang3.Streams;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.util.StringUtils;
import contactassigment.contactlistapp.exception.InvalidValidArgumentException;

/**
 * Common global utility class to handle all the format/transition requirement.
 * 
 * @author sumith
 *
 */
public final class CommonUtils {

  /**
   * Utility method to convert a Date a formated String.
   * 
   * @param date
   * @param format
   * @return formated date as String.
   */
  public static String formatDateToString(Date date, String format) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
    return simpleDateFormat.format(date);
  }



  /**
   * @param inputPattern
   * @return
   */
  public static String convertWildCardToSqlPlaceHolder(String inputPattern) {
    if (inputPattern.contains(UtilityContants.WILD_CARD_MATCHER)) {
      return inputPattern.replace(UtilityContants.SPACE, UtilityContants.EMPTY_STRING)
                         .replace(UtilityContants.WILD_CARD_MATCHER, UtilityContants.SQL_WILD_CARD_MATCHER)
                         .toLowerCase();
    } else {
      return inputPattern.toLowerCase();
    }
  }

  public static String formatAbn(String abnInput) {
    StringBuilder abnFormated = new StringBuilder(UtilityContants.SPACE);
    if (StringUtils.isEmpty(abnInput)) {
      throw new InvalidValidArgumentException("AbnNumber should not be null or empty");
    }

    abnFormated.append("[ <strong>").
    append(abnInput.subSequence(0, 2))
               .append(UtilityContants.SPACE)
               .append(abnInput.subSequence(2, 5))
               .append(UtilityContants.SPACE)
               .append(abnInput.subSequence(5, 8))
               .append(UtilityContants.SPACE)
               .append(abnInput.subSequence(8, 11)).append("</strong> ]");

    return abnFormated.toString();

  }


}
