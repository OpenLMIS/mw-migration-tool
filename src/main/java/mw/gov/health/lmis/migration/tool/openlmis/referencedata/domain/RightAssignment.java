/*
 * This program is part of the OpenLMIS logistics management information system platform software.
 * Copyright © 2017 VillageReach
 *
 * This program is free software: you can redistribute it and/or modify it under the terms
 * of the GNU Affero General Public License as published by the Free Software Foundation, either
 * version 3 of the License, or (at your option) any later version.
 *  
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU Affero General Public License for more details. You should have received a copy of
 * the GNU Affero General Public License along with this program. If not, see
 * http://www.gnu.org/licenses.  For additional information contact info@OpenLMIS.org. 
 */

package mw.gov.health.lmis.migration.tool.openlmis.referencedata.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import mw.gov.health.lmis.migration.tool.openlmis.BaseEntity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "right_assignments", schema = "referencedata")
@NoArgsConstructor
public class RightAssignment extends BaseEntity {

  @ManyToOne
  @JoinColumn(name = "userid", nullable = false)
  @Getter
  private User user;

  @Column(nullable = false)
  @Getter
  private String rightName;

  @Column
  @Getter
  private UUID facilityId;

  @Column
  @Getter
  private UUID programId;

  public RightAssignment(User user, String rightName) {
    this.user = user;
    this.rightName = rightName;
  }
  
  public RightAssignment(User user, String rightName, UUID facilityId) {
    this(user, rightName);
    this.facilityId = facilityId;
  }

  public RightAssignment(User user, String rightName, UUID facilityId, UUID programId) {
    this(user, rightName, facilityId);
    this.programId = programId;
  }

  @Override
  public String toString() {
    return rightName 
        + (null != facilityId ? "|" + facilityId : "")
        + (null != programId ? "|" + programId : "");
  }
}
