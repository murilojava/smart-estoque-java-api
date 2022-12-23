package com.murilojavasolucoes.smartestoque.common.util;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class SmartEstoqueDateUtil {

  public static LocalDateTime newDateTime() {
    return LocalDateTime.now(ZoneId.of("UTC"));
  }
}
