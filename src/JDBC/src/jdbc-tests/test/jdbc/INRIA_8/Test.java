package test.jdbc.INRIA_8;

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
				9, // nbForm
				0, // nbMatriceDMSP
				1, // nbEpisode
				4, // nbEvent
				28, // nbConcept
				10, // nbComment
				26,// nbInfo
				db,
				1); // MatPatGenerated
		Save_DBMS_on_disk();

		java.sql.Statement stmt = db.createStatement();
		out.println("\nSELECT * FROM INFO :");
		lireResultSet(request(stmt, DMSP_QEP_IDs.Execution_Plan.INFO_NOAC_SELECT_STAR), out);

		java.sql.PreparedStatement ps = ((org.inria.jdbc.Connection)db).prepareStatement(DMSP_QEP_IDs.Execution_Plan.INFO_NOAC_UPDATE_Valchar_BY_ID);

		String newValue = "new value";
		out.println("update Info set ValChar = " + newValue + " where Info.IdGlobal = " + 68);
		int res = Tools_schemaIndexInfo.Test_INFO_NOAC_UPDATE_Valchar_BY_ID(68, newValue, ps);
		out.println("Number of updated tuples : " + res);

		out.println("\nSELECT * FROM INFO :");
		lireResultSet(request(stmt, DMSP_QEP_IDs.Execution_Plan.INFO_NOAC_SELECT_STAR), out);

		Save_DBMS_on_disk();

		newValue = "new new value";
		out.println("update Info set ValChar = " + newValue + " where Info.IdGlobal = " + 68);
		res = Tools_schemaIndexInfo.Test_INFO_NOAC_UPDATE_Valchar_BY_ID(68, newValue, ps);
		out.println("Number of updated tuples : " + res);

		newValue = "new value 2";
		out.println("update Info set ValChar = " + newValue + " where Info.IdGlobal = " + 89);
		res = Tools_schemaIndexInfo.Test_INFO_NOAC_UPDATE_Valchar_BY_ID(89, newValue, ps);
		out.println("Number of updated tuples : " + res);

		newValue = "new value 3";
		out.println("update Info set ValChar = " + newValue + " where Info.IdGlobal = " + 90);
		res = Tools_schemaIndexInfo.Test_INFO_NOAC_UPDATE_Valchar_BY_ID(90, newValue, ps);
		out.println("Number of updated tuples : " + res);

		out.println("\nSELECT * FROM INFO :");
		lireResultSet(request(stmt, DMSP_QEP_IDs.Execution_Plan.INFO_NOAC_SELECT_STAR), out);

		Rollback_Transaction();

		out.println("\nSELECT * FROM INFO :");
		lireResultSet(request(stmt, DMSP_QEP_IDs.Execution_Plan.INFO_NOAC_SELECT_STAR), out);

		Desinstall_DBMS_MetaData();
		Shutdown_DBMS();
	}

}

