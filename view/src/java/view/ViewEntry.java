package view;

import java.awt.Point;

import viewVisitor.MouseDownEventVisitor;

public interface ViewEntry {
	boolean contains(Point point);
	void accept(MouseDownEventVisitor visitor);
	void onMouseDown(MouseDownEvent event);
}
