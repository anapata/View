package view;

import java.awt.Point;

public class MouseDownEvent {

	private Point location;

	public MouseDownEvent(int x, int y) {
		this.location = new Point(x, y);
	}

	public Point getLocation() {
		return location;
	}

	public MouseDownEvent translate(Point delta) {
		return new MouseDownEvent(location.x - delta.x, location.y - delta.y);
	}

}
