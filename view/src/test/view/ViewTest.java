package view;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import viewVisitor.MouseDownEventVisitor;

public class ViewTest {

	@Test
	public void testBuild() {
		assertEquals(2, view(20, 20, 60, 60, pane(10, 10, 5, 5), pane(20, 10, 5, 5)).getChildCount());
		assertEquals(2, view(20, 20, 60, 60, pane(10, 10, 5, 5), view(20, 10, 5, 5, pane(1, 1, 1, 1), pane(3, 1, 1, 1))).getChildCount());
	}

	@Test
	public void testHandleMouseDown() {
		Pane pane1 = pane(10, 10, 5, 5);
		final List<MouseDownEvent> received = new ArrayList<MouseDownEvent>();
		pane1.addMouseDownListener(new MouseDownListener() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				received.add(event);
			}
		});
		Pane pane2 = pane(20, 10, 5, 5);
		View view = view(20, 20, 60, 60, pane1, pane2);
		assertEquals(0, received.size());
		view.accept(new MouseDownEventVisitor(new MouseDownEvent(31, 31)));
		assertEquals(1, received.size());
//		view.handleMouseDown(new MouseDownEvent(41, 31));
		view.accept(new MouseDownEventVisitor(new MouseDownEvent(41, 31)));
		assertEquals(1, received.size());
	}

	public static View view(int x, int y, int width, int height, ViewEntry ... children) {
		return new View(x, y, width, height, children);
	}

	public static Pane pane(int x, int y, int width, int height) {
		return new Pane(x, y, width, height);
	}
}
