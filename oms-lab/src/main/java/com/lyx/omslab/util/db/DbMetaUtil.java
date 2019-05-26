package com.lyx.omslab.util.db;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

/**
 * Created by liyuxing on 2019-05-26.
 */
@Component
@Slf4j
public class DbMetaUtil {


    @Autowired
    DataSource dataSource;

    public void analyTableMetaData() throws Exception {
        DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
        log.info("{} {}", metaData.getDriverName(), metaData.getDriverVersion());

        ResultSet tables = metaData.getTables(null, "OMS", "OMS%", new String[]{"TABLE"});
        printResultSet(tables);
    }

    public void analyColumnMetaData() throws Exception {
        DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
        ResultSet columns = metaData.getColumns(null, "OMS", "OMS_SSE_BOND_EXECUTION", null);
        printResultSet(columns);
    }

    public void analyPrimaryKeyMetaData() throws Exception {
        DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
        ResultSet primaryKeys = metaData.getPrimaryKeys(null, "OMS", "OMS_SSE_BOND_EXECUTION");
        printResultSet(primaryKeys);
    }

    private void printResultSet(ResultSet rs) throws Exception {
        int rowCount = 0;
        while (rs.next()) {
            int colCount = rs.getMetaData().getColumnCount();
            log.info("rowCnt: {},  colNum: {}; ", ++rowCount, colCount);

            for (int i = 1; i <= colCount; i++) {
                log.info("row[{}]: {}({}) -- {}", i,
                        rs.getMetaData().getColumnName(i),
                        rs.getMetaData().getColumnClassName(i),
                        rs.getObject(i));
            }
            log.info("---------");
        }
    }
}
