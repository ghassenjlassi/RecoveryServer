package org.inria.dmsp.test.TEST_Tearing.Deletes.NandSrCommUncomm.Recover_122;

/////////////////////////////////////////////////////
//IMPORTS THAT CAN BE CHANGED TO TEST OTHER PLANS //
/////////////////////////////////////////////////////

///////////////////////////////
//DO NOT CHANGE AFTER HERE  //
///////////////////////////////

import java.io.PrintWriter;
import java.sql.Connection;

import org.inria.dmsp.test.TEST_Tearing.TearingTestFramework;
import org.inria.dmsp.test.TEST_Tearing.TearingTools;
import org.inria.jdbc.Macro;

/**
 * We test here the ability of the DBMS to recover after a user
 * wildly gets the token off the machine after some uncommitted
 * deletes.
 *
 * @author TA
 */
public class Test extends TearingTestFramework
{
	@Override
	public void prepareBeforeTearingPoint(Connection db, PrintWriter out, int perf) throws Exception
	{
		// Do some deletes to avoid being in the peculiar case of the first delete
		TearingTools.deleteSome(db, out, perf, 2);
	}

	@Override
	public void placeAndReachTearingPoint(Connection db, PrintWriter out, int perf) throws Exception
	{
		TearingTools.Insert_Tearing_Point(db, out, perf, Macro.TPOINT_DELETE_NANDSRCOMMUNCOMM);
		TearingTools.deleteStar(db);
	}
}
