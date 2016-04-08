package seep_web_server;

/**
 * @author pg1712
 *
 */
public enum Metric_Mode {

	CPU("cpu"),
	MEMORY("memory"),
	THROUGHPUT("throughput");

	private final String mode;

	Metric_Mode(String mode) {
		this.mode = mode;
	}

	public boolean equalsName(String otherMode) {
		return (otherMode == null) ? false : mode.equals(otherMode);
	}

	public String toString() {
		return this.mode;
	}

	public String ofMode() {
		return this.mode;
	}

	public static Metric_Mode toMode(String name) {
		if (name.compareToIgnoreCase("cpu") == 0)
			return CPU;
		if (name.compareToIgnoreCase("memory") ==0 )
			return MEMORY;
		if (name.compareToIgnoreCase("throughput") == 0 )
			return THROUGHPUT;
		return null;
	}

}
