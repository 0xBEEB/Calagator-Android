package com.github.ubiquill.calagator.domain.api;

/**
 * Created by ubiquill on 7/20/15.
 */
public enum CalagatorSearchOrder {
  DATE,
  NAME,
  VENUE,
  SCORE;

  public String getTerm() {
    switch(this) {
      case DATE:
        return "date";
      case NAME:
        return "name";
      case VENUE:
        return "venue";
      case SCORE:
        return "score";
      default:
        return "";
    }
  }

  public boolean includeOrder() {
    switch(this) {
      case DATE:
      case NAME:
      case VENUE:
      case SCORE:
        return true;
      default:
        return false;
    }
  }
}
