package seep_web_server;
/**
 * @author pg1712
 *
 */
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.server.Server;

public class Runner {

	public static void main(String[] args) {
		
		Map<String, RestAPIRegistryEntry> restAPIRegistry = new HashMap<String, RestAPIRegistryEntry>();
		
		restAPIRegistry.put("/queries", new QueriesHandler());
		// handler for source (with id=s0)
		restAPIRegistry.put("/metrics/src0", new MetricsHandler());
		// handler for first operator (with id=1)
		restAPIRegistry.put("/metrics/op1", new MetricsHandler());
		// handler for second operator (with id=2)
		restAPIRegistry.put("/metrics/op2", new MetricsHandler());
		// handler for sink (with id=3)
		restAPIRegistry.put("/metrics/snk3", new MetricsHandler());
		
		
		Server restServer = new Server(8081);
		restServer.setHandler(new RestAPIHandler(restAPIRegistry));
		try {
			restServer.start();
			restServer.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
