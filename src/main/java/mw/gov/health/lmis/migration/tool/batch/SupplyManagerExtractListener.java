package mw.gov.health.lmis.migration.tool.batch;

import mw.gov.health.lmis.migration.tool.scm.domain.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;

public class SupplyManagerExtractListener implements ItemReadListener<Main> {
  private static final Logger LOGGER = LoggerFactory.getLogger(SupplyManagerExtractListener.class);

  @Override
  public void beforeRead() {
    LOGGER.info("Read row from CTF_Main table");
  }

  @Override
  public void afterRead(Main item) {
    LOGGER.info(
        "Retrieved row from CTF_Main table with facility code {} and processing date {}",
        item.getId().getFacility().getCode(), item.getId().getProcessingDate()
    );
  }

  @Override
  public void onReadError(Exception exp) {
    LOGGER.error("There was a problem with reading row from CTF_Main table", exp);
  }
  
}