package mw.gov.health.lmis.migration.tool.scm.repository;

import com.healthmarketscience.jackcess.Row;

import org.springframework.stereotype.Repository;

import mw.gov.health.lmis.migration.tool.scm.domain.AdjustmentType;

@Repository
public class AdjustmentTypeRepository extends BaseRepository<AdjustmentType> {

  @Override
  String getTableName() {
    return "Adj_Type";
  }

  @Override
  AdjustmentType mapRow(Row row) {
    return new AdjustmentType(row);
  }

  public AdjustmentType findByType(String type) {
    return find("Type_Code", type);
  }
}
