package view;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PaneTest {

	@Test
	public void testOnMouseDownListener() {
		final List<MouseDownEvent> received = new ArrayList<MouseDownEvent>();
		Pane pane = new Pane(1, 1, 3, 3);
		pane.addMouseDownListener(new MouseDownListener() {
			@Override
			public void onMouseDown(MouseDownEvent event) {
				received.add(event);
			}
		});
		assertEquals(0, received.size());
		pane.onMouseDown(new MouseDownEvent(31, 3));
		assertEquals(1, received.size());
	}

}
