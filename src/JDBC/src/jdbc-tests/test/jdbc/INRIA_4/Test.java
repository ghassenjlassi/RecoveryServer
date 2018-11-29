package test.jdbc.INRIA_4;

import java.io.PrintWriter;

import org.inria.database.QEPng;
import org.inria.dmsp.tools.DMSP_QEP_IDs;

import test.jdbc.Tools;
import test.jdbc.schemaIndexInfo.DataGeneratorWithIds;
import test.jdbc.schemaIndexInfo.Tools_schemaIndexInfo;
import test.runner.ITest;

public class Test extends Tools implements ITest {

  @Override
  public void run(PrintWriter out, String dbmsHost) throws Exception {
    this.out = out;
    Tools_schemaIndexInfo t = new Tools_schemaIndexInfo(out);
    init();
    openConnection(dbmsHost, null);
    String schema = "schemaV4.rsc";
    byte[] schemaDesc = t.loadSchema(schema);
    int usedId = 404;
    Install_DBMS_MetaData(schemaDesc, usedId);
    schemaDesc = null;
    
	// load and install QEPs
	Class<?>[] executionPlans = new Class[] { test.jdbc.schemaIndexInfo.Execution_Plan.class };
	QEPng.loadExecutionPlans( org.inria.dmsp.tools.DMSP_QEP_IDs.class, executionPlans );
	QEPng.installExecutionPlans( db );

    DataGeneratorWithIds dgwi = new DataGeneratorWithIds(out);
	dgwi.INSERT_Data_Generated(
			5, // nbUser
			3, // nbRole
			4, // nbHab
			8, // nbForm
			0, // nbMatriceDMSP
			1, // nbEpisode
			4, // nbEvent
			7, // nbConcept
			3, // nbComment
			9,// nbInfo
			db,
			1); // MatPatGenerated
	Save_DBMS_on_disk();
    
    java.sql.Statement stmt = db.createStatement();
    out.println("\nSELECT * FROM EVENT :");
    lireResultSet(request(stmt, DMSP_QEP_IDs.Execution_Plan.EVENT_NOAC_SELECT_STAR), out);
    out.println("\nSELECT * FROM INFO :");
    lireResultSet(request(stmt, DMSP_QEP_IDs.Execution_Plan.INFO_NOAC_SELECT_STAR), out);

    out.println("Delete from info where IdEvent = " + "30");
    java.sql.PreparedStatement ps = ((org.inria.jdbc.Connection)db).prepareStatement(DMSP_QEP_IDs.Execution_Plan.INFO_NOAC_DELETE_BY_EVENT_ID);
    int res = Tools_schemaIndexInfo.Test_INFO_NOAC_DELETE_BY_EVENT_ID(30, ps);
    out.println("Number of deleted tuples : " + res);

    out.println("\nSELECT * FROM EVENT :");
    lireResultSet(request(stmt, DMSP_QEP_IDs.Execution_Plan.EVENT_NOAC_SELECT_STAR), out);
    out.println("\nSELECT * FROM INFO :");
    lireResultSet(request(stmt, DMSP_QEP_IDs.Execution_Plan.INFO_NOAC_SELECT_STAR), out);
    Shutdown_DBMS();

    openConnection(dbmsHost, null);
    Desinstall_DBMS_MetaData();
    Shutdown_DBMS();
  }
}

