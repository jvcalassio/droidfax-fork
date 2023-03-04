package apiTracker;

public class Monitor {

    private static boolean active = false;

    public synchronized static void apiCall (String methodSignature, Object... params) {
		if (active) return;
		active = true;
		try { apiCall_impl(methodSignature, params); }
		finally { active = false; }
	}
	private synchronized static void apiCall_impl(String methodSignature, Object... params) {
		try {
			String args = "";
			for (Object param : params) {
				args += param + ", ";
			}

			android.util.Log.i("apicall-monitor", "[API-TRACK]: ((" + methodSignature + ")) => " + args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
}