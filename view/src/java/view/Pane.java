package view;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import viewVisitor.MouseDownEventVisitor;


public class Pane implements ViewEntry {

	private List<MouseDownListener> mouseDownListeners = new ArrayList<MouseDownListener>();
	private Rectangle bounds;

	public Pane(int x, int y, int width, int height) {
		this.bounds = new Rectangle(x, y, width, height);
	}

	public void addMouseDownListener(MouseDownListener mouseDownListener) {
		mouseDownListeners.add(mouseDownListener);
	}

	@Override
	public void onMouseDown(MouseDownEvent event) {
		for (MouseDownListener listener: mouseDownListeners) {
			listener.onMouseDown(event);
		}
	}

	@Override
	public boolean contains(Point point) {
		return bounds.contains(point);
	}

	@Override
	public void accept(MouseDownEventVisitor visitor) {
		visitor.visit(this);
	}
}
