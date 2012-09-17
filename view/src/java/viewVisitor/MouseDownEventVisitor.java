package viewVisitor;

import view.MouseDownEvent;
import view.Pane;
import view.View;
import view.ViewEntry;

public class MouseDownEventVisitor {

	private MouseDownEvent event;

	public MouseDownEventVisitor(MouseDownEvent event) {
		this.event = event;
	}

	public void visit(View view) {
		if (view.contains(event.getLocation())) {
			MouseDownEvent orgEvent = event;
			event = event.translate(view.getLocation());
			for (ViewEntry entry : view.getChildren()) {
				entry.accept(this);
			}
			event = orgEvent;
		}
	}
	
	public void visit(Pane pane) {
		if (pane.contains(event.getLocation())) {
			pane.onMouseDown(event);
		}
	}

}
