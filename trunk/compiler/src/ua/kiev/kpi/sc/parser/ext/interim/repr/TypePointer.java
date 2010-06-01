package ua.kiev.kpi.sc.parser.ext.interim.repr;
import ua.kiev.kpi.sc.parser.ext.interim.Translation;
import ua.kiev.kpi.sc.parser.node.Node;

public class TypePointer implements Translation {
	private String repr;

	public TypePointer(Node node) {
		super();
		this.repr = node.toString().trim();
	}

	@Override
	public String toString() {
		return repr+"*";
	}
}