package view;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.List;

import viewVisitor.MouseDownEventVisitor;

public class View implements ViewEntry {

	private Rectangle bounds;
	private List<ViewEntry> children;

	public View(int x, int y, int width, int height, ViewEntry[] children) {
		this.bounds = new Rectangle(x, y, width, height);
		this.children = Arrays.asList(children);
	}

	public int getChildCount() {
		return children.size();
	}

	@Override
	public boolean contains(Point point) {
		return bounds.contains(point);
	}

	@Override
	public void accept(MouseDownEventVisitor visitor) {
		visitor.visit(this);
	}

	public List<ViewEntry> getChildren() {
		return children;
	}

	@Override
	public void onMouseDown(MouseDownEvent event) {
	}
	
	public Point getLocation() {
		return bounds.getLocation();
	}

}
