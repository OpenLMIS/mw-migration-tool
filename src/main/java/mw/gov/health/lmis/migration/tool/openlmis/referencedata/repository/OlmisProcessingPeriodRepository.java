package mw.gov.health.lmis.migration.tool.openlmis.referencedata.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mw.gov.health.lmis.migration.tool.openlmis.referencedata.domain.ProcessingPeriod;
import mw.gov.health.lmis.migration.tool.openlmis.referencedata.domain.ProcessingSchedule;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface OlmisProcessingPeriodRepository extends CrudRepository<ProcessingPeriod, UUID> {

  @Query("SELECT p FROM ProcessingPeriod p WHERE :value BETWEEN p.startDate AND p.endDate")
  ProcessingPeriod findInPeriod(@Param("value") LocalDate date);

  List<ProcessingPeriod> findByProcessingScheduleAndStartDate(ProcessingSchedule processingSchedule,
                                                              LocalDate startDate);

}
