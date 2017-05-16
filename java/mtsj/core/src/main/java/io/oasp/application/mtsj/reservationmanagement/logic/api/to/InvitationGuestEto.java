package io.oasp.application.mtsj.reservationmanagement.logic.api.to;

import java.sql.Timestamp;

import io.oasp.application.mtsj.general.common.api.to.AbstractEto;
import io.oasp.application.mtsj.reservationmanagement.common.api.InvitationGuest;

/**
 * Entity transport object of InvitationGuest
 */
public class InvitationGuestEto extends AbstractEto implements InvitationGuest {

  private static final long serialVersionUID = 1L;

  private Long reservationId;

  private String guestToken;

  private String email;

  private boolean accepted;

  private Timestamp modificationDate;

  @Override
  public Long getReservationId() {

    return this.reservationId;
  }

  @Override
  public void setReservationId(Long reservationId) {

    this.reservationId = this.reservationId;
  }

  @Override
  public String getGuestToken() {

    return this.guestToken;
  }

  @Override
  public void setGuestToken(String guestToken) {

    this.guestToken = guestToken;
  }

  @Override
  public String getEmail() {

    return this.email;
  }

  @Override
  public void setEmail(String email) {

    this.email = email;
  }

  @Override
  public boolean isAccepted() {

    return this.accepted;
  }

  @Override
  public void setAccepted(boolean accepted) {

    this.accepted = accepted;
  }

  @Override
  public Timestamp getModificationDate() {

    return this.modificationDate;
  }

  @Override
  public void setModificationDate(Timestamp modificationDate) {

    this.modificationDate = modificationDate;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();

    result = prime * result + ((this.reservationId == null) ? 0 : this.reservationId.hashCode());
    result = prime * result + ((this.guestToken == null) ? 0 : this.guestToken.hashCode());
    result = prime * result + ((this.email == null) ? 0 : this.email.hashCode());
    result = prime * result + ((Boolean) this.accepted).hashCode();
    result = prime * result + ((this.modificationDate == null) ? 0 : this.modificationDate.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    InvitationGuestEto other = (InvitationGuestEto) obj;

    if (this.reservationId == null) {
      if (other.reservationId != null) {
        return false;
      }
    } else if (!this.reservationId.equals(other.reservationId)) {
      return false;
    }
    if (this.guestToken == null) {
      if (other.guestToken != null) {
        return false;
      }
    } else if (!this.guestToken.equals(other.guestToken)) {
      return false;
    }
    if (this.email == null) {
      if (other.email != null) {
        return false;
      }
    } else if (!this.email.equals(other.email)) {
      return false;
    }
    if (this.accepted != other.accepted) {
      return false;
    }
    if (this.modificationDate == null) {
      if (other.modificationDate != null) {
        return false;
      }
    } else if (!this.modificationDate.equals(other.modificationDate)) {
      return false;
    }
    return true;
  }
}
